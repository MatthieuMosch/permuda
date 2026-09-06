package nl.novi.matthieu.permuda.model;

import jakarta.persistence.*;

@Entity
@Table(name = "actions")
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;

    @Column(nullable = false)
    private String command;

    @ManyToOne
    @JoinColumn(name = "requirement_title", referencedColumnName = "title")
    private Achievement requirement;

    private String succes;
    private String fail;

    @ManyToOne
    @JoinColumn(name = "reward_title", referencedColumnName = "title")
    private Achievement reward;

    @ManyToOne
    @JoinColumn(name = "destination_id", referencedColumnName = "id")
    private Room destination;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Profile owner;

    public long getId() {return this.id;}
    public Room getRoom() {return this.room;}
    public String getCommand() {return this.command;}
    public Achievement getRequirement() {return this.requirement;}
    public String getSucces() {return this.succes;}
    public String getFail() {return this.fail;}
    public Achievement getReward() {return this.reward;}
    public Room getDestination() {return this.destination;}
    public Profile getOwner() {return this.owner;}

    public void setId(long id) {this.id = id;}
    public void setRoom(Room room) {this.room = room;}
    public void setCommand(String command) {this.command = command;}
    public void setRequirement(Achievement requirement) {this.requirement = requirement;}
    public void setSucces(String succes) {this.succes = succes;}
    public void setFail(String fail) {this.fail = fail;}
    public void setReward(Achievement reward) {this.reward = reward;}
    public void setDestination(Room destination) {this.destination = destination;}
    public void setOwner(Profile owner) {this.owner = owner;}
}
