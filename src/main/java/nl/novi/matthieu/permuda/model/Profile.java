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
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;

    private String firstname;
    private String lastname;
    private String email;
    private String bio;
    private String picture;

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;

    @ManyToMany(mappedBy = "profiles", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Achievement> achievements;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Room> ownedRooms;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Action> ownedActions;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Achievement> ownedAchievements;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Creature> ownedCreatures;

    // getters
    public Long getId() {return this.id;}
    public User getUser() {return this.user;}
    public String getUsername() {return this.user.getUsername();}
    public String getFirstname() {return this.firstname;}
    public String getLastname() {return this.lastname;}
    public String getEmail() {return this.email;}
    public String getBio() {return this.bio;}
    public String getPicture() {return this.picture;}
    public Room getRoom() {return this.room;}
    public Set<Achievement> getAchievements() {return this.achievements;}
    public Set<Room> getOwnedRooms() {return this.ownedRooms;}
    public Set<Action> getOwnedActions() {return this.ownedActions;}
    public Set<Achievement> getOwnedAchievements() {return this.ownedAchievements;}
    public Set<Creature> getOwnedCreatures() {return this.ownedCreatures;}


    // setters
    public void setId(long id) {this.id = id;}
    public void setUser(User user) {this.user = user;}
    public void setFirstname(String firstname) {this.firstname = firstname;}
    public void setLastname(String lastname) {this.lastname = lastname;}
    public void setEmail(String email) {this.email = email;}
    public void setBio(String bio) {this.bio = bio;}
    public void setPicture(String picture) {this.picture = picture;}
    public void setRoom(Room room) {this.room = room;}
    public void setAchievements(Set<Achievement> achievements) {this.achievements = achievements;}
    public void setOwnedRooms(Set<Room> ownedRooms) {this.ownedRooms = ownedRooms;}
    public void setOwnedActions(Set<Action> ownedActions) {this.ownedActions = ownedActions;}
    public void setOwnedAchievements(Set<Achievement> ownedAchievements) {this.ownedAchievements = ownedAchievements;}
    public void setOwnedCreatures(Set<Creature> ownedCreatures) {this.ownedCreatures = ownedCreatures;}
}
