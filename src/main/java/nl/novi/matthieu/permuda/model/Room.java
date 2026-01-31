package nl.novi.matthieu.permuda.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long x;
    private long y;
    private long z;
    private String description;

    @ManyToOne
    @JoinColumn(name = "owner", referencedColumnName = "username")
    private Profile profile;

    // getters
    public long getId() {return id;}
    public long getX() {return x;}
    public long getY() {return y;}
    public long getZ() {return z;}
    public String getDescription() {return description;}
    public Profile getProfile() {return profile;}

    // setters
    public void setX(long x) {this.x = x;}
    public void setY(long y) {this.y = y;}
    public void setZ(long z) {this.z = z;}
    public void setDescription(String description) {this.description = description;}
    public void setProfile(Profile profile) {this.profile = profile;}

}
