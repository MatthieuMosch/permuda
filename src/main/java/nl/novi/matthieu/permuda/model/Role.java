package nl.novi.matthieu.permuda.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    private String rolename;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<User> users;

    // remove "ROLE_" from the rolename
    public String getRolename() {return this.rolename.substring(5);}
    // add "ROLE_" to the rolename
    public void setRolename(String rolename) {this.rolename = "ROLE_" + rolename;}
}
