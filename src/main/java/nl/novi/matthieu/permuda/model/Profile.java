package nl.novi.matthieu.permuda.model;


import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    // https://stackoverflow.com/questions/77129076/entity-does-not-define-an-idclass
    // https://thorben-janssen.com/hibernate-tips-same-primary-key-one-to-one-association/
    @OneToOne
    @MapsId("userID")
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;

    private String firstname;
    private String lastname;
    private String email;
    private String bio;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private Set<Room> rooms;

    // getters
    public Long getUserId() {return userId;}
    public User getUser() {return user;}
    public String getFirstname() {return firstname;}
    public String getLastname() {return lastname;}
    public String getEmail() {return email;}
    public String getBio() {return bio;}
    public Set<Room> getRooms() {return rooms;}
}
