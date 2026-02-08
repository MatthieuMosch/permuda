package nl.novi.matthieu.permuda.model;

import jakarta.persistence.*;

@Entity
@Table(name = "actions")
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String command;

    private String succes;
    private String fail;

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "requirement", referencedColumnName = "title")
    private Achievement requirement;

    @ManyToOne
    @JoinColumn(name = "reward", referencedColumnName = "title")
    private Achievement reward;

    @ManyToOne
    @JoinColumn(name = "destination", referencedColumnName = "id")
    private Room destination;
}
