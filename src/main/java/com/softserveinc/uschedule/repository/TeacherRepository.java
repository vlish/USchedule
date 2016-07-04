package com.softserveinc.uschedule.repository;

import com.softserveinc.uschedule.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
