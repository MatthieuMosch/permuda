package nl.novi.matthieu.permuda.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "achievements")
public class Achievement {
    // TODO : check all @Id : this includes nullable=false and unique=true already
    @Id
    private String title;

    @ManyToMany(mappedBy = "achievements")
    private Set<Profile> profiles;

    // TODO : test this by adding data with various actions and requirements and rewards
    @OneToMany(mappedBy = "requirement", cascade = CascadeType.ALL)
    private Set<Action> requirements;

    // TODO : test this by adding data with various actions and requirements and rewards
    @OneToMany(mappedBy = "reward", cascade = CascadeType.ALL)
    private Set<Action> rewards;

    // getters
    public String getTitle() {return this.title;}
    public void setProfiles(Set<Profile> profiles) {this.profiles = profiles;}

    // setters
    public void setTitle(String title) {this.title = title;}
    public Set<Profile> getProfiles() {return this.profiles;}


}
