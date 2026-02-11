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
    private String bio;
    private String picture;

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;

    @ManyToMany
    @JoinTable(
            name = "profiles_achievements",
            joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "title")
    )
    private Set<Achievement> achievements;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Achievement> ownedAchievements;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Room> ownedRooms;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Action> ownedActions;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Creature> ownedCreatures;

    // TODO : add current room the profile/player is in

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
    public Set<Room> getOwnedRooms() {return this.ownedRooms;}

    // setters
    public void setId(Long userId) {this.id = userId;}
    public void setUser(User user) {this.user = user;}
    public void setFirstname(String firstname) {this.firstname = firstname;}
    public void setLastname(String lastname) {this.lastname = lastname;}
    public void setEmail(String email) {this.email = email;}
    public void setPicture(String picture) {this.picture = picture;}
    public void setBio(String bio) {this.bio = bio;}
    public void setOwnedAchievements(Set<Room> rooms) {this.ownedRooms = rooms;}
}
