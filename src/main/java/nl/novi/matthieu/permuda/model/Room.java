package nl.novi.matthieu.permuda.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private Set<Profile> profiles;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private Set<Creature> creatures;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private Set<Action> actions;

    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL)
    private Set<Action> origins;

    @ManyToOne
    @JoinColumn(name = "owner_id") //, referencedColumnName = "user_id")
    private Profile owner;

    // getters
    public long getId() {return this.id;}
    public String getDescription() {return this.description;}
    public Set<Profile> getProfiles() {return this.profiles;}
    public Set<Creature> getCreatures() {return this.creatures;}
    public Set<Action> getActions() {return this.actions;}
    public Set<Action> getOrigins() {return this.origins;}
    public Profile getOwner() {return this.owner;}

    // setters
    public void setId(long id) {this.id = id;}
    public void setDescription(String description) {this.description = description;}
    public void setProfiles(Set<Profile> profiles) {this.profiles = profiles;}
    public void setCreatures(Set<Creature> creatures) {this.creatures = creatures;}
    public void setActions(Set<Action> actions) {this.actions = actions;}
    public void setOrigins(Set<Action> origins) {this.origins = origins;}
    public void setOwner(Profile owner) {this.owner = owner;}
}
