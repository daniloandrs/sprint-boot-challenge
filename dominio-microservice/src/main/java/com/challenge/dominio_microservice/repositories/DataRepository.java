package com.challenge.dominio_microservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.dominio_microservice.entities.DataEntity;

public interface DataRepository extends JpaRepository<DataEntity, Long> {}