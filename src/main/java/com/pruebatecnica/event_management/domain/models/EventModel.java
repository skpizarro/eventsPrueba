package com.pruebatecnica.event_management.domain.models;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventModel {
    private String id;
    private String name;
    private LocalDate date;
    private String location;
    private List<UserModel> users;
}
