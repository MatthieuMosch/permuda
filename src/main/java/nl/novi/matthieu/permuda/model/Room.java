package nl.novi.matthieu.permuda.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int x;
    private int y;
    private int z;
    private String description;

    @ManyToOne
    @JoinColumn(name = "owner", referencedColumnName = "username")
    private Profile profile;
}
