package com.parking.backendapplication.booking.domain.service;

import com.parking.backendapplication.booking.domain.model.entity.ParkingLot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ParkingLotService {
    List<ParkingLot> getAll();
    Page<ParkingLot> getAll(Pageable pageable);
    ParkingLot getById(Long parkingLotId);
    ParkingLot create(ParkingLot parkingLot);
    ParkingLot update(Long parkingLotId, ParkingLot request);
    ResponseEntity<?> delete(Long parkingLotId);
}
