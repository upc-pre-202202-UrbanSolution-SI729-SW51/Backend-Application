package com.parking.backendapplication.booking.domain.persistence;

import com.parking.backendapplication.booking.domain.model.entity.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long> {
    List<ParkingLot> findAllById(Long id);
    ParkingLot findByCompany_name(String company_name);
}
