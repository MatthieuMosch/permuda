package nl.novi.matthieu.permuda.security;

import nl.novi.matthieu.permuda.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtService jwtService;
    private final UserRepository userRepository;

    public SecurityConfig(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    @Bean
    public AuthenticationManager authenticationManager(
            UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        var auth = new DaoAuthenticationProvider();
        auth.setPasswordEncoder(passwordEncoder);
        auth.setUserDetailsService(userDetailsService);
        return new ProviderManager(auth);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}

    @Bean
    public UserDetailsService userDetailsService() {return new MyUserDetailsService(this.userRepository);}

    // Authorization
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .sessionManagement( session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(csrf -> csrf.disable())
                .addFilterBefore(
                        new JwtRequestFilter(jwtService, userDetailsService()), UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(auth -> auth
                        // login
                        .requestMatchers(HttpMethod.POST, "/login").permitAll()
                        .requestMatchers(HttpMethod.GET, "/roles").permitAll()
                        // users and profiles
                        .requestMatchers(HttpMethod.POST, "/users").permitAll()
                        .requestMatchers(HttpMethod.POST, "/profiles").authenticated()
                        .requestMatchers(HttpMethod.PATCH, "/profiles/**").permitAll() //.authenticated()
                        // GOD is almighty
                        .requestMatchers("/**").hasRole("GOD")
                        // everyone who is authenticated can view the mud entities
                        .requestMatchers(HttpMethod.GET,
                                "/users/*",
                                "/profiles/*",
                                "/achievements/*",
                                "/actions/*",
                                "/creatures/*",
                                "/rooms/*").authenticated()
                        // mud creation can only be done by a WIZARD (and the almighty GOD)
                        .requestMatchers(HttpMethod.POST,
                                "/achievements",
                                "/actions",
                                "/creatures",
                                "/rooms").hasRole("WIZARD")
                        // deletion can only be done by a WIZARD (and the almighty GOD)
                        .requestMatchers(HttpMethod.DELETE,
                                "/users/*",
                                "/profiles/*",
                                "/achievements/*",
                                "/actions/*",
                                "/creatures/*",
                                "/rooms/*").hasRole("WIZARD")
                        // deny any other unresolved request
                        .anyRequest().denyAll());
        return http.build();
    }
}