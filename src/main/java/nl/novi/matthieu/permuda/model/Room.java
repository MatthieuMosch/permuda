package nl.novi.matthieu.permuda.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private Set<Action> actions;

    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL)
    private Set<Action> origins;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private Set<Creature> creatures;

    // getters
    public long getId() {return id;}
    public String getDescription() {return description;}
    public Profile getProfile() {return profile;}

    // setters
    public void setDescription(String description) {this.description = description;}
    public void setProfile(Profile profile) {this.profile = profile;}

}
