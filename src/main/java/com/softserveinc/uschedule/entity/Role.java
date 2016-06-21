package com.softserveinc.uschedule.entity;

import javax.persistence.*;

/**
 * Created by ostash on 21.06.2016.
 */
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Integer id;
    @Column(name = "name")
    private String name;

}
