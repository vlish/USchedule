package com.softserveinc.uschedule.entity;

import org.hibernate.annotations.Columns;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "application_role")
public class ApplicationRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "applicationRole", fetch = FetchType.LAZY)
    private Set<User> users;

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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
