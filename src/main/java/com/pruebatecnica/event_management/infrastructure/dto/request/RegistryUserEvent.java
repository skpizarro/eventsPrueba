package com.pruebatecnica.event_management.infrastructure.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistryUserEvent {
    private String userId;
}
