package com.parking.backendapplication.booking.api;

import com.parking.backendapplication.booking.domain.service.DriverService;
import com.parking.backendapplication.booking.mapping.DriverMapper;
import com.parking.backendapplication.booking.resource.CreateDriverResource;
import com.parking.backendapplication.booking.resource.DriverResource;
import com.parking.backendapplication.booking.resource.UpdateDriverResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/drivers", produces = "application/json")
public class DriverController {

    private final DriverService driverService;

    private final DriverMapper mapper;

    public DriverController(DriverService driverService,DriverMapper mapper) {
        this.driverService = driverService;
        this.mapper=mapper;
    }

    @GetMapping
    public Page<DriverResource> getAllDrivers(Pageable pageable) {
        return mapper.modelListPage(driverService.getAll(), pageable);
    }

    @GetMapping("{driverId}")
    public DriverResource getDriverById(@PathVariable Long driverId) {
        return mapper.toResource(driverService.getById(driverId));
    }

    @PostMapping
    public ResponseEntity<DriverResource> createDriver(@RequestBody CreateDriverResource resource) {
        return new ResponseEntity<>(mapper.toResource(driverService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{driverId}")
    public DriverResource updateStudent(@PathVariable Long studentId,
                                         @RequestBody UpdateDriverResource resource) {
        return mapper.toResource(driverService.update(studentId, mapper.toModel(resource)));
    }

    @DeleteMapping("{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long studentId) {
        return driverService.delete(studentId);
    }


}
