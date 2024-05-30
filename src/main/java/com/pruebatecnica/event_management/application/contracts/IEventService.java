package com.pruebatecnica.event_management.application.contracts;

import com.pruebatecnica.event_management.infrastructure.dto.EventDto;

import java.util.List;

public interface IEventService {

    EventDto createEvent(EventDto eventDto);
    EventDto findEventById(String id);
    List<EventDto> findAllEvents();
    List<EventDto> findEventsByIdUser(String idUser);
    EventDto registyUser(String userId, String eventId);
}
