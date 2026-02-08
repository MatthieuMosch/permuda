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
}
