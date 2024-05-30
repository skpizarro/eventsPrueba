package com.pruebatecnica.event_management.apllication.services.factories;

import com.pruebatecnica.event_management.infrastructure.dto.EventDto;
import com.pruebatecnica.event_management.infrastructure.persistence.entities.EventEntity;

import java.time.LocalDate;

public class Eventfactory {

    public static EventDto eventDtoFactory() {
        EventDto eventDto = EventDto.builder()
                .id("123")
                .name("Evento1")
                .date(LocalDate.now())
                .location("Calle 10")
                .build();
        return eventDto;
    }

    public static EventEntity eventEntityFactory() {
        EventEntity eventEntity = EventEntity.builder()
                .id("123")
                .name("Evento1")
                .date(LocalDate.now())
                .location("Calle 10")
                .build();
        return eventEntity;
    }
}
