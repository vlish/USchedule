package com.softserveinc.uschedule.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created by ostash on 21.06.2016.
 */
public class Schedule {

    @Id
    @Column(name = "schedule")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "startDate")
    private LocalDate startDate;
    @Column(name = "endDate")
    private LocalDate endDate;
    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
    private Set<Event> events;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;




}
