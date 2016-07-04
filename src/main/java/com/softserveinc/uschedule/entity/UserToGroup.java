package com.softserveinc.uschedule.entity;

import com.softserveinc.uschedule.entity.util.UserToGroupID;

import javax.persistence.*;

@Entity
@Table(name = "user_to_group")
@AssociationOverrides({
        @AssociationOverride(name = "pk.user",
                joinColumns = @JoinColumn(name = "user_id")),
        @AssociationOverride(name = "pk.group",
                joinColumns = @JoinColumn(name = "group_id"))
})
public class UserToGroup {

    @EmbeddedId
    private UserToGroupID pk = new UserToGroupID();

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private GroupRole groupRole;

    @Transient
    public User getUser() {
        return getPk().getUser();
    }

    public void setUser(User user) {
        getPk().setUser(user);
    }

    @Transient
    public Group getGroup() {
        return getPk().getGroup();
    }

    public void setGroup(Group group) {
        getPk().setGroup(group);
    }

    public UserToGroupID getPk() {
        return pk;
    }

    public void setPk(UserToGroupID pk) {
        this.pk = pk;
    }

    public GroupRole getGroupRole() {
        return groupRole;
    }

    public void setGroupRole(GroupRole groupRole) {
        this.groupRole = groupRole;
    }

}
