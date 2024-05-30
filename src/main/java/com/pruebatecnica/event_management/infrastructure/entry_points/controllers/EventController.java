package com.pruebatecnica.event_management.infrastructure.entry_points.controllers;

import com.pruebatecnica.event_management.application.contracts.IEventService;
import com.pruebatecnica.event_management.infrastructure.dto.EventDto;
import com.pruebatecnica.event_management.infrastructure.dto.request.RegistryUserEvent;
import com.pruebatecnica.event_management.infrastructure.dto.response.ResponseRegistryUserEvent;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@AllArgsConstructor
public class EventController {
    private final IEventService eventService;
    @PostMapping()
    ResponseEntity<EventDto> createEvent(@RequestBody EventDto eventDto) {
        EventDto newEventDto = eventService.createEvent(eventDto);
        return new ResponseEntity<>(newEventDto,HttpStatus.CREATED);
    }

    @GetMapping("/{idEvent}")
    ResponseEntity<EventDto> findEventById(@PathVariable String idEvent) {
        EventDto eventFinded = eventService.findEventById(idEvent);
        return new ResponseEntity<>(eventFinded,HttpStatus.OK);
    }

    @GetMapping()
    ResponseEntity<List<EventDto>> findEvents() {
        List<EventDto> eventsFinded = eventService.findAllEvents();
        return new ResponseEntity<>(eventsFinded,HttpStatus.OK);
    }

    @PostMapping("/{idEvent}/register")
    ResponseEntity<ResponseRegistryUserEvent> createEvent(@RequestBody RegistryUserEvent registryUserEvent, @PathVariable String idEvent) {
        EventDto registedEvent = eventService.registyUser(registryUserEvent.getUserId(),idEvent);

        ResponseRegistryUserEvent response = ResponseRegistryUserEvent.builder()
                .mensaje("Usuario".concat(registryUserEvent.getUserId()).concat(" registado al evento ").concat(idEvent))
                .build();

        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
