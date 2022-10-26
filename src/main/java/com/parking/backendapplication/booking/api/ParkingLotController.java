package com.parking.backendapplication.booking.api;


import com.parking.backendapplication.booking.domain.service.ParkingLotService;
import com.parking.backendapplication.booking.mapping.ParkingLotMapper;
import com.parking.backendapplication.booking.resource.CreateParkingLotResource;
import com.parking.backendapplication.booking.resource.ParkingLotResource;
import com.parking.backendapplication.booking.resource.UpdateParkingLotResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/parking_lots",produces = "application/json")
public class ParkingLotController {

    private final ParkingLotService parkingLotService;
    private final ParkingLotMapper mapper;

    public ParkingLotController(ParkingLotService parkingLotService, ParkingLotMapper mapper) {
        this.parkingLotService = parkingLotService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<ParkingLotResource> getAll(Pageable pageable) {
        return mapper.modelListPage(parkingLotService.getAll(), pageable);
    }

    @GetMapping("{parkingLotId}")
    public ParkingLotResource getById(@PathVariable Long parkingLotId) {
        return mapper.toResource(parkingLotService.getById(parkingLotId));
    }

    @PostMapping
    public ResponseEntity<ParkingLotResource> create(@RequestBody CreateParkingLotResource resource) {
        return new ResponseEntity<>(mapper.toResource(parkingLotService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }
    @PutMapping("{parkingLotId}")
    public ParkingLotResource update(@PathVariable Long parkingLotId,
                                         @RequestBody UpdateParkingLotResource resource) {
        return mapper.toResource(parkingLotService.update(parkingLotId, mapper.toModel(resource)));
    }

    @DeleteMapping("{parkingLotId}")
    public ResponseEntity<?> delete(@PathVariable Long parkingLotId) {
        return parkingLotService.delete(parkingLotId);
    }


}
