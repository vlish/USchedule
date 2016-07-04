package com.softserveinc.uschedule.repository;

import com.softserveinc.uschedule.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Integer> {
}
