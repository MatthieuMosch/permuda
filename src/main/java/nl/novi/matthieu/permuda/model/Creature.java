package nl.novi.matthieu.permuda.model;

import jakarta.persistence.*;

@Entity
@Table(name = "creatures")
public class Creature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "owner", referencedColumnName = "username")
    private Profile owner;

    // getters
    public long getId() {return this.id;}
    public String getDescription() {return this.description;}
    public Room getRoom() {return this.room;}
    public Profile getOwner() {return this.owner;}

    // setters
    public void setId(long id) {this.id = id;}
    public void setDescription(String description) {this.description = description;}
    public void setRoom(Room room) {this.room = room;}
    public void setOwner(Profile owner) {this.owner = owner;}
}
