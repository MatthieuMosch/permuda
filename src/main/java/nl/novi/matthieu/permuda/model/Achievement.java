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

    @OneToMany(mappedBy = "requirement", cascade = CascadeType.ALL)
    private Set<Action> requirements;

    @OneToMany(mappedBy = "reward", cascade = CascadeType.ALL)
    private Set<Action> rewards;

    @ManyToOne
    @JoinColumn(name = "owner", referencedColumnName = "username")
    private Profile owner;

    // getters
    public String getTitle() {return this.title;}
    public void setProfiles(Set<Profile> profiles) {this.profiles = profiles;}
    public Set<Action> getRequirements() {return this.requirements;}
    public Set<Action> getRewards() {return this.rewards;}
    public Profile getOwner() {return this.owner;}

    // setters
    public void setTitle(String title) {this.title = title;}
    public Set<Profile> getProfiles() {return this.profiles;}
    public void setRequirements(Set<Action> requirements) {this.requirements = requirements;}
    public void setRewards(Set<Action> rewards) {this.rewards = rewards;}
    public void setOwner(Profile owner) {this.owner = owner;}
}
