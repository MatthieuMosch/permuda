package nl.novi.matthieu.permuda.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "achievements")
public class Achievement {
    @Id
    private String title;

    @ManyToMany(mappedBy = "achievements", fetch = FetchType.LAZY)
    private Set<Profile> profiles;

    @OneToMany(mappedBy = "requirement", fetch = FetchType.LAZY)
    private Set<Action> requirements;

    @OneToMany(mappedBy = "reward", fetch = FetchType.LAZY)
    private Set<Action> rewards;

    @ManyToOne
    @JoinColumn(name = "owner_name", referencedColumnName = "username")
    private Profile owner;

    // getters
    public String getTitle() {return this.title;}
    public Set<Profile> getProfiles() {return this.profiles;}
    public Set<Action> getRequirements() {return this.requirements;}
    public Set<Action> getRewards() {return this.rewards;}
    public Profile getOwner() {return this.owner;}

    // setters
    public void setTitle(String title) {this.title = title;}
    public void setProfiles(Set<Profile> profiles) {this.profiles = profiles;}
    public void setRequirements(Set<Action> requirements) {this.requirements = requirements;}
    public void setRewards(Set<Action> rewards) {this.rewards = rewards;}
    public void setOwner(Profile owner) {this.owner = owner;}
}
