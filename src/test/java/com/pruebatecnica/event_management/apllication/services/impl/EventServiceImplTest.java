package com.pruebatecnica.event_management.apllication.services.impl;

import com.pruebatecnica.event_management.apllication.services.factories.Eventfactory;
import com.pruebatecnica.event_management.application.services.impl.EventServiceImpl;
import com.pruebatecnica.event_management.application.transformers.EventTransformer;
import com.pruebatecnica.event_management.infrastructure.dto.EventDto;
import com.pruebatecnica.event_management.infrastructure.persistence.entities.EventEntity;
import com.pruebatecnica.event_management.infrastructure.persistence.jpa_repository.EventJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EventServiceImplTest {
    @InjectMocks
    EventServiceImpl eventServiceImpl;

    @Mock
    EventJpaRepository eventJpaRepository;

    EventDto eventDto;
    EventEntity eventEntity;

    @BeforeEach
    public void setUp() {
        eventDto = Eventfactory.eventDtoFactory();
        eventEntity = Eventfactory.eventEntityFactory();
    }

    @Test
    void whenCreateEventThenCreateEventSuccess(){
        Mockito.when(eventJpaRepository.save(Mockito.any())).thenReturn(eventEntity);

        EventDto result = eventServiceImpl.createEvent(eventDto);

        Assertions.assertNotNull(result);

    }

    @Test
    void whenCreateEventThenError(){
        Mockito.when(eventJpaRepository.save(Mockito.any())).thenThrow( new RuntimeException());

        Assertions.assertThrows(RuntimeException.class,() -> eventServiceImpl.createEvent(eventDto));


    }



}
