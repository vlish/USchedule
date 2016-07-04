package com.softserveinc.uschedule.service;

import com.softserveinc.uschedule.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;
}
