package com.softserveinc.uschedule.repository;

import com.softserveinc.uschedule.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
