package com.softserveinc.uschedule.entity;

import javax.persistence.*;

@Entity
@Table(name = "application_role")
public class ApplicationRole {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "role")
    private String role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
