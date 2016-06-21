package com.softserveinc.uschedule.entity;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class Image {
    @Id
    @Column(name = "image_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "path")
    private String path;

    public Image() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
