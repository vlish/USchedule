package com.softserveinc.uschedule.crud;

import com.softserveinc.uschedule.UscheduleApplicationTests;
import com.softserveinc.uschedule.entity.*;
import com.softserveinc.uschedule.repository.ApplicationRoleRepository;
import com.softserveinc.uschedule.service.GroupService;
import com.softserveinc.uschedule.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
public class GroupTest extends UscheduleApplicationTests {

    @Autowired
    private GroupService groupService;
    @Autowired
    private UserService userService;
    @Autowired
    private ApplicationRoleRepository applicationRoleRepository;

    @Before
    public void createAppRole() {
        ApplicationRole applicationRole = new ApplicationRole();
        applicationRole.setRole("User");
        applicationRoleRepository.save(applicationRole);
    }

    @Test
    public void createGroup() {
        try {
            Group group = new Group();
            group.setName("A-21");
            group.setKey("cisco");
            groupService.create(group);
            Assert.assertEquals(1, groupService.findAll().size());
        } finally {
            groupService.removeById(groupService.findAll().get(0).getId());
        }
    }

    @Test
    public void updateGroup() {
        try {
            Group group = new Group();
            group.setName("A-21");
            group.setKey("cisco");
            groupService.create(group);
            Group updatedGroup = groupService.findAll().get(0);
            updatedGroup.setName("A-22");
            groupService.create(updatedGroup);
            Assert.assertEquals("A-22", groupService.findAll().get(0).getName());
            Assert.assertEquals(1, groupService.findAll().size());
        } finally {
            groupService.removeById(groupService.findAll().get(0).getId());
        }

    }

    @Test
    public void saveUserAndGroup() {
        try {
            User user = new User();
            user.setFirstName("First");
            user.setLastName("Last");
            user.setPassword("Password");
            user.setApplicationRole(applicationRoleRepository.findAll().get(0));
            userService.create(user);

            Group group = new Group();
            group.setName("A-21");
            group.setKey("cisco");

            UserToGroup groupUsers = new UserToGroup();
            groupUsers.setUser(user);
            groupUsers.setGroup(group);
            groupUsers.setGroupRole(GroupRole.STUDENT); //extra column
            group.getGroupUsers().add(groupUsers);

            groupService.create(group);

            Assert.assertEquals(1, groupService.findAll().size());
            Assert.assertEquals(1, userService.findAll().size());
            //check if intermediate table was created
            Assert.assertEquals("First", groupService.findAll().get(0).getGroupUsers().iterator().next().getUser().getFirstName());
        } finally {
            groupService.removeById(groupService.findAll().get(0).getId());
            userService.removeById(userService.findAll().get(0).getId());
        }

    }


}
