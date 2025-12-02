package nl.novi.matthieu.permuda.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @Column(unique = true, nullable = false)
    private String rolename;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<User> users;

    // TODO : test wether all getters and setters ar required and used
    public String getRolename() {return this.rolename;}
    public void setRolename(String rolename) {this.rolename = rolename;}
}
