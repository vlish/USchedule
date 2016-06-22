package com.softserveinc.uschedule.entity;

import com.softserveinc.uschedule.entity.util.LocalDatePersistenceConverter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "password")
    private String password;
    @Column(name = "login_attempt_count")
    private Integer loginAttemptCount;
    @Column(name = "locked")
    private Boolean locked;
    @Column(name = "birthday")
    @Convert(converter = LocalDatePersistenceConverter.class)
    private LocalDate birthday;
    @Column(name = "email")
    private String email;
    @Column(name = "prhone")
    private String prhone;
    @Enumerated(EnumType.STRING)
    private ScheduleViewType scheduleViewType;
    @Enumerated(EnumType.STRING)
    private NotificationType notificationType;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id")
    private Image image;
    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
    private Set<Event> events;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<UserToGroup> students;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getLoginAttemptCount() {
        return loginAttemptCount;
    }

    public void setLoginAttemptCount(Integer loginAttemptCount) {
        this.loginAttemptCount = loginAttemptCount;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrhone() {
        return prhone;
    }

    public void setPrhone(String prhone) {
        this.prhone = prhone;
    }

    public ScheduleViewType getScheduleViewType() {
        return scheduleViewType;
    }

    public void setScheduleViewType(ScheduleViewType scheduleViewType) {
        this.scheduleViewType = scheduleViewType;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public Set<UserToGroup> getStudents() {
        return students;
    }

    public void setStudents(Set<UserToGroup> students) {
        this.students = students;
    }
}
