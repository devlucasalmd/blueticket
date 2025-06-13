package com.br.blueticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.blueticket.domain.model.ParkingSession;

public interface ParkingSessionRepository extends JpaRepository<ParkingSession, Long>{

}
