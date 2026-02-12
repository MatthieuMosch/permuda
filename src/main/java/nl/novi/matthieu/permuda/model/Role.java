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

    // getters
    public String getRolename() {return this.rolename;}
    public Set<User> getUsers() {return this.users;}

    // setters
    public void setRolename(String rolename) {this.rolename = rolename;}
    public void setUsers(Set<User> users) {this.users = users;}
}
