package com.parking.backendapplication.booking.domain.persistence;

import com.parking.backendapplication.booking.domain.model.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {

    Driver findByVehicleNumber(String name);
}
