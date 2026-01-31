package nl.novi.matthieu.permuda.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true,  nullable = false,  length = 50)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "rolename", referencedColumnName = "rolename")
    private Role role;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Profile profile;


    // getters
    public String getUsername() {return this.username;}
    public String getPassword() {return this.password;}
    public Role getRole() {return this.role;}
    public Profile getProfile() {return this.profile;}

    // setters
    public void setUsername(String username) {this.username = username;}
    public void setPassword(String password) {this.password = password;}
    public void setRole(Role role) {this.role = role;}
    public void setProfile(Profile profile) {this.profile = profile;}
}
