package com.softserveinc.uschedule.service;


import com.softserveinc.uschedule.entity.User;
import com.softserveinc.uschedule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Integer id){
        return userRepository.findOne(id);
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public void removeById(Integer id){
        userRepository.delete(id);
    }

}
