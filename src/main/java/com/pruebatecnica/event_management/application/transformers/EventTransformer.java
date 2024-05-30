package com.pruebatecnica.event_management.application.transformers;

import com.pruebatecnica.event_management.infrastructure.dto.EventDto;
import com.pruebatecnica.event_management.infrastructure.persistence.entities.EventEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EventTransformer {
    public EventTransformer mapper = Mappers.getMapper(EventTransformer.class);

    EventDto toDto(EventEntity eventEntity);
    EventEntity toEntity(EventDto eventDto);

}
