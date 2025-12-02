package nl.novi.matthieu.permuda.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
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
    public String getUsername() {return username;}
    public String getPassword() {return password;}
    public Role getRole() {return role;}

    // setters
    public void setUsername(String username) {this.username = username;}
    public void setPassword(String password) {this.password = password;}
    public void setRole(Role role) {this.role = role;}
}
