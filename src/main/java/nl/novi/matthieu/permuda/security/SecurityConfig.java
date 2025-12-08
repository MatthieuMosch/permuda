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
                        // user management
                        .requestMatchers(HttpMethod.GET, "/roles").permitAll()
                        .requestMatchers(HttpMethod.POST, "/users").permitAll()
                        .requestMatchers(HttpMethod.POST, "/profiles").authenticated()
                        .requestMatchers(HttpMethod.GET, "/users").hasRole("GOD")
                        // mud creation
                        .requestMatchers(HttpMethod.POST,
                                "/achievements",
                                "/actions",
                                "/creatures",
                                "/rooms").hasAnyRole("GOD","WIZARD")
                        // mud use by everyone who is logged in: PLAYER or WIZARD or GOD
                        .requestMatchers(HttpMethod.GET,
                                "/achievements",
                                "/actions",
                                "creatures",
                                "/rooms").authenticated()
                        .anyRequest().denyAll());
        return http.build();
    }
}

//                        .anyRequest().permitAll()) // TODO : remove, for testing purposes only
//                        .requestMatchers("/users").permitAll()
//                        .requestMatchers(HttpMethod.GET, "/users").authenticated()
