package com.br.blueticket.service;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.br.blueticket.domain.model.ParkingSession;
import com.br.blueticket.repository.ParkingSessionRepository;

@Service
public class ParkingSessionService {

	@Autowired
	private ParkingSessionRepository parkingSessionRepository;
	

    public ParkingSession create(ParkingSession parkingSession) {
   
        parkingSession.setHoraInicio(LocalDateTime.now());
       
        parkingSession.setHoraFim(parkingSession.getHoraInicio().plusMinutes(parkingSession.getDuration()));

        return parkingSessionRepository.save(parkingSession);
    }
    
	public ParkingSession update(Long id, ParkingSession parkingSession) {
		ParkingSession parkingSessionSaved = findParkingSessionById(id);
		BeanUtils.copyProperties(parkingSession, parkingSessionSaved, "id");
		return parkingSessionRepository.save(parkingSessionSaved);
	}
	
	public ParkingSession findParkingSessionById(Long id) {
		ParkingSession parkingSessionSaved = parkingSessionRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return parkingSessionSaved;
	}

}
