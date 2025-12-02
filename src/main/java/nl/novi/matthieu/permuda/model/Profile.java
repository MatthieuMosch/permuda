package nl.novi.matthieu.permuda.model;


import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;

    private String firstname;
    private String lastname;
    private String email;
    private String bio;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private Set<Room> rooms;
}
