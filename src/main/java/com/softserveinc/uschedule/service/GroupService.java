package com.softserveinc.uschedule.service;

import com.softserveinc.uschedule.entity.Group;
import com.softserveinc.uschedule.entity.User;
import com.softserveinc.uschedule.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public Group findById(Integer id) {
        return groupRepository.findOne(id);
    }

    public Group create(Group group) {
        return groupRepository.save(group);
    }

    public void removeById(Integer id) {
        groupRepository.delete(id);
    }
}
