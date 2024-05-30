package com.pruebatecnica.event_management.infrastructure.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventDto {
    private String id;
    private String name;
    private LocalDate date;
    private String location;
    private List<UserDto> users;
}
