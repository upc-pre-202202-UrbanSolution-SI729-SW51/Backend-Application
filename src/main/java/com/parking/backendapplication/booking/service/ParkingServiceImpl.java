package com.parking.backendapplication.booking.service;

import com.parking.backendapplication.booking.domain.model.entity.ParkingLot;
import com.parking.backendapplication.booking.domain.persistence.ParkingLotRepository;
import com.parking.backendapplication.booking.domain.service.ParkingLotService;
import com.parking.backendapplication.shared.exception.ResourceNotFoundException;
import com.parking.backendapplication.shared.exception.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.xml.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ParkingServiceImpl implements ParkingLotService {

    private static final String ENTITY="ParkingLot";
    private final ParkingLotRepository parkingLotRepository;
    private final Validator validator;

    public ParkingServiceImpl(ParkingLotRepository parkingLotRepository, Validator validator) {
        this.parkingLotRepository = parkingLotRepository;
        this.validator = validator;
    }


    @Override
    public List<ParkingLot> getAll() {
        return parkingLotRepository.findAll();
    }

    @Override
    public Page<ParkingLot> getAll(Pageable pageable) {
        return parkingLotRepository.findAll(pageable);
    }

    @Override
    public ParkingLot getById(Long parkingLotId) {
        return parkingLotRepository.findById(parkingLotId)
                .orElseThrow(()->new ResourceNotFoundException(ENTITY,parkingLotId));
    }

    @Override
    public ParkingLot create(ParkingLot parkingLot) {
        Set<ConstraintViolation<ParkingLot>> violations = validator.validate(parkingLot);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY,violations);

        ParkingLot parkingLotWithCompanyName=parkingLotRepository.findByCompany_name(parkingLot.getCompany_name());
        if(parkingLotWithCompanyName!=null)
            throw new ResourceValidationException(ENTITY,"An parkingLot with the same name already exists.");
        return parkingLotRepository.save(parkingLot);
    }

    @Override
    public ParkingLot update(Long parkingLotId, ParkingLot request) {
        Set<ConstraintViolation<ParkingLot>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

       ParkingLot studentWithName = parkingLotRepository.findByCompany_name(request.getCompany_name());

        if(studentWithName != null && !studentWithName.getId().equals(parkingLotId))
            throw new ResourceValidationException(ENTITY,
                    "An parkingLot with the same name already exists.");

        return parkingLotRepository.findById(parkingLotId).map(parkingLot ->
                        parkingLotRepository.save(
                                parkingLot.withAddress(request.getAddress())
                                        .withSpaces_free(request.getSpaces_free())
                                        .withSpaces_available(request.getSpaces_available())
                                        .withCompany_name(request.getCompany_name())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, parkingLotId));
    }

    @Override
    public ResponseEntity<?> delete(Long parkingLotId) {
        return parkingLotRepository.findById(parkingLotId).map(parkingLot -> {
            parkingLotRepository.delete(parkingLot);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, parkingLotId));
    }
}
