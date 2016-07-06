package com.softserveinc.uschedule.crud;

import com.softserveinc.uschedule.UscheduleApplicationTests;
import com.softserveinc.uschedule.entity.ApplicationRole;
import com.softserveinc.uschedule.entity.User;
import com.softserveinc.uschedule.repository.ApplicationRoleRepository;
import com.softserveinc.uschedule.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserTests extends UscheduleApplicationTests {

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
    public void saveUser() {
        try {
            User user = new User();
            user.setFirstName("First");
            user.setLastName("Last");
            user.setPassword("Password");
            user.setApplicationRole(applicationRoleRepository.findAll().get(0));

            userService.create(user);
            Assert.assertEquals(1, userService.findAll().size());
        } finally {
            userService.removeById(userService.findAll().get(0).getId());
        }
    }

    @Test
    public void updateUser() {
        try {
            User user = new User();
            user.setFirstName("First");
            user.setLastName("Last");
            user.setPassword("Password");
            user.setApplicationRole(applicationRoleRepository.findAll().get(0));
            userService.create(user);
            User newUser = userService.findAll().get(0);
            newUser.setFirstName("Second");
            userService.create(newUser);
            Assert.assertEquals("Second", userService.findAll().get(0).getFirstName());
            Assert.assertEquals(1,userService.findAll().size());
        } finally {
            userService.removeById(userService.findAll().get(0).getId());
        }
    }

}
