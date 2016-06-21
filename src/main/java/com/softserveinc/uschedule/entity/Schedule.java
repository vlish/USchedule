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




}
