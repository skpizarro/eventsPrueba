package com.pruebatecnica.event_management.infrastructure.persistence.jpa_repository;


import com.pruebatecnica.event_management.infrastructure.persistence.entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventJpaRepository extends JpaRepository<EventEntity, String> {
}
