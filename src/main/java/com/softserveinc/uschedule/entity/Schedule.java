package com.softserveinc.uschedule.entity;

import com.softserveinc.uschedule.entity.util.LocalDatePersistenceConverter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @Column(name = "schedule")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "startDate")
    @Convert(converter = LocalDatePersistenceConverter.class)
    private LocalDate startDate;
    @Column(name = "endDate")
    @Convert(converter = LocalDatePersistenceConverter.class)
    private LocalDate endDate;
    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
    private Set<Event> events;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
