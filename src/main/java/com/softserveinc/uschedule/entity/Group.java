package com.softserveinc.uschedule.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "group")
public class Group {
    @Id
    @Column(name = "group_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "key")
    private String key;
    @Column(name = "group_owner")
    private Integer groupOwner;
    @Column(name = "capacity")
    private Integer capacity;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id")
    private Image image;
    @OneToMany(mappedBy = "schedule", fetch = FetchType.LAZY)
    private Set<Schedule> schedules;
    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private Set<UserToGroup> userToGroups;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getGroupOwner() {
        return groupOwner;
    }

    public void setGroupOwner(Integer groupOwner) {
        this.groupOwner = groupOwner;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }

    public Set<UserToGroup> getUserToGroups() {
        return userToGroups;
    }

    public void setUserToGroups(Set<UserToGroup> userToGroups) {
        this.userToGroups = userToGroups;
    }
}
