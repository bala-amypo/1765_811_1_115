package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TemperatureLogEntity;

@Repository
public interface TemperatureSensorLogRepository
        extends JpaRepository<TemperatureLogEntity, Long> {

}