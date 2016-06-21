package com.softserveinc.uschedule.entity;

import javax.persistence.*;

@Entity
@Table(name = "repetitionCriteria")
public class RepetitionCriteria {
    @Id
    @Column(name = "repetition_criteria_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name")
    private String name;

    public RepetitionCriteria() {
    }

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
}
