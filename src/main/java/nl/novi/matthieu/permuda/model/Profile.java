package nl.novi.matthieu.permuda.model;


import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "username")
    private User user;

    private String firstname;
    private String lastname;
    private String email;
    private String picture;
    private String bio;

    @ManyToMany
    @JoinTable(
            name = "profiles_achievements",
            joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "title")
    )
    private Set<Achievement> achievements;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private Set<Room> rooms;

    // TODO : use this. in all getters and setters
    // getters
    public Long getId() {return this.id;}
    public User getUser() {return this.user;}
    public String getUsername() {return this.user.getUsername();}
    public String getFirstname() {return this.firstname;}
    public String getLastname() {return this.lastname;}
    public String getEmail() {return this.email;}
    public String getPicture() {return this.picture;}
    public String getBio() {return this.bio;}
    public Set<Room> getRooms() {return this.rooms;}

    // setters
    public void setId(Long userId) {this.id = userId;}
    public void setUser(User user) {this.user = user;}
    public void setFirstname(String firstname) {this.firstname = firstname;}
    public void setLastname(String lastname) {this.lastname = lastname;}
    public void setEmail(String email) {this.email = email;}
    public void setPicture(String picture) {this.picture = picture;}
    public void setBio(String bio) {this.bio = bio;}
    public void setRooms(Set<Room> rooms) {this.rooms = rooms;}
}
