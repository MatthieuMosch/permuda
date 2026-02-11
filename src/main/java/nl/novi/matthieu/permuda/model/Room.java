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

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private Set<Profile> profiles;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private Set<Creature> creatures;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private Set<Action> actions;

    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL)
    private Set<Action> origins;

    @ManyToOne
    @JoinColumn(name = "owner", referencedColumnName = "username")
    private Profile owner;

    // getters
    public long getId() {return id;}
    public String getDescription() {return description;}
    public Profile getOwner() {return owner;}

    // setters
    public void setDescription(String description) {this.description = description;}
    public void setOwner(Profile owner) {this.owner = owner;}

}
