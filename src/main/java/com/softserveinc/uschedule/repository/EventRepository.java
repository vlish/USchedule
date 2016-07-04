package com.softserveinc.uschedule.repository;

import com.softserveinc.uschedule.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {

}
