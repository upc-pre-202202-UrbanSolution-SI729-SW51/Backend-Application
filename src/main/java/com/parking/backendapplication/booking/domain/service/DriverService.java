package com.parking.backendapplication.booking.domain.service;

import com.parking.backendapplication.booking.domain.model.entity.Driver;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DriverService {

    List<Driver> getAll();
    Page<Driver> getAll(Pageable pageable);

    Driver getById(Long driverId);

    Driver create(Driver driver);

    Driver update(Long driverId,Driver request);

    ResponseEntity<?> delete(Long driverId);
}
