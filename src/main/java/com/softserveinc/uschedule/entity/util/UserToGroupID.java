package com.softserveinc.uschedule.entity.util;

import com.softserveinc.uschedule.entity.Group;
import com.softserveinc.uschedule.entity.User;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class UserToGroupID implements Serializable {

    @ManyToOne
    private User user;

    @ManyToOne
    private Group group;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }


}
