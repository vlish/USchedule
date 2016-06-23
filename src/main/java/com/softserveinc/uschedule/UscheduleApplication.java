package com.softserveinc.uschedule;

import com.softserveinc.uschedule.entity.Room;
import com.softserveinc.uschedule.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class UscheduleApplication {

    @PostConstruct
    public void init() {
    }

    public static void main(String[] args) {
        SpringApplication.run(UscheduleApplication.class, args);
    }
}
