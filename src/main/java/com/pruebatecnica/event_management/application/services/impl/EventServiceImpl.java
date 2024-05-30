package com.pruebatecnica.event_management.application.services.impl;

import com.pruebatecnica.event_management.application.contracts.IEventService;
import com.pruebatecnica.event_management.application.transformers.EventTransformer;
import com.pruebatecnica.event_management.infrastructure.dto.EventDto;
import com.pruebatecnica.event_management.infrastructure.dto.UserDto;
import com.pruebatecnica.event_management.infrastructure.persistence.entities.EventEntity;
import com.pruebatecnica.event_management.infrastructure.persistence.entities.UserEntity;
import com.pruebatecnica.event_management.infrastructure.persistence.jpa_repository.EventJpaRepository;
import com.pruebatecnica.event_management.infrastructure.persistence.jpa_repository.UserJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EventServiceImpl implements IEventService {
    private final EventJpaRepository eventJpaRepository;
    private final UserJpaRepository userJpaRepository;
    @Override
    public EventDto createEvent(EventDto eventDto) {
        EventEntity eventEntity = eventJpaRepository
                .save(EventTransformer.mapper.toEntity(eventDto));
        return EventTransformer.mapper.toDto(eventEntity);
    }

    @Override
    public EventDto findEventById(String id) {
        EventEntity eventEntity = eventJpaRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Error"));
        return EventTransformer.mapper.toDto(eventEntity);
    }

    @Override
    public List<EventDto> findAllEvents() {
       List<EventEntity> listEvents = eventJpaRepository.findAll();

       if(listEvents.isEmpty()){
           throw new RuntimeException("No hay Eventos disponibles");
       }
       List<EventDto> listEventsDto = new ArrayList<>();
       listEvents.forEach(event -> {
           listEventsDto.add(EventTransformer.mapper.toDto(event));
       });

        return  listEventsDto;
    }

    @Override
    public List<EventDto> findEventsByIdUser(String idUser) {
        return List.of();
    }

    @Override
    public EventDto registyUser(String userId, String eventId) {
        UserEntity userFinded = userJpaRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("Error No se econtró el usuario"));

        EventEntity eventEntity = eventJpaRepository.findById(eventId)
                .orElseThrow(()->new RuntimeException("Error no se econtró el evento"));

        userFinded.getEvents().add(eventEntity);
        eventEntity.getUsers().add(userFinded);
        EventEntity updatedEvent = eventJpaRepository.save(eventEntity);

        return EventTransformer.mapper.toDto(updatedEvent);
    }


}
