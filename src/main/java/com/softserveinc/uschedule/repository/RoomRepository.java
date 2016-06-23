package com.softserveinc.uschedule.repository;

import com.softserveinc.uschedule.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {

}
