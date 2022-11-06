package com.parking.backendapplication.booking.service;
package com.acme.learningcenter.analytics.service;



import com.parking.backendapplication.booking.domain.model.entity.Driver;
import com.parking.backendapplication.booking.domain.persistence.DriverRepository;
import com.parking.backendapplication.booking.domain.service.DriverService;
import com.parking.backendapplication.shared.exception.ResourceNotFoundException;
import com.parking.backendapplication.shared.exception.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;



import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.constraints.Null;
import java.util.List;
import java.util.Set;

@Service
public class DriverServiceImpl implements DriverService {

    private static final String ENTITY="Driver";

    private final DriverRepository driverRepository;

    private final Validator validator;

    public DriverServiceImpl(DriverRepository driverRepository, Validator validator) {
        this.driverRepository = driverRepository;
        this.validator = validator;
    }

    @Override
    public List<Driver> getAll() {
        return driverRepository.findAll();
    }

    @Override
    public Page<Driver> getAll(Pageable pageable) {
        return driverRepository.findAll(pageable);
    }

    @Override
    public Driver getById(Long driverId) {
        return driverRepository.findById(driverId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY,driverId));
    }

    @Override
    public Driver create(Driver driver) {

        Set<ConstraintViolation<Driver>> violations=validator.validate(driver);

    if (!violations.isEmpty())
        throw new ResourceValidationException(ENTITY,violations);

    Driver driverWithName=driverRepository.findByVehicleNumber(driver.getVehicleNumber());

    if(driverWithName != null)
        throw new ResourceValidationException(ENTITY,
                "An VehicleNumber with the same already exists.");

        return driverRepository.save(driver);
    }

    @Override
    public Driver update(Long driverId, Driver request) {
        Set<ConstraintViolation<Driver>> violations=validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY,violations);

        Driver driverWithName=driverRepository.findByVehicleNumber(request.getVehicleNumber());

        if (driverWithName !=null && !driverWithName.getId().equals(driverId))
            throw new ResourceValidationException(ENTITY,
                    "An vehicleNumber with same already exists.");

        return driverRepository.findById(driverId).map(driver ->
                driverRepository.save(
                    driverWithName.withVehicleNumber(request.getVehicleNumber())
                            .withRegistrationDate(request.getRegistrationDate())
                            .withContact(request.getContact())
                            .withCreditCard(request.getCreditCard())
                            .withNumberCard(request.getNumberCard())))
                .orElseThrow(()->new ResourceNotFoundException(ENTITY,driverId));
    }

    @Override
    public ResponseEntity<?> delete(Long driverId) {
        return driverRepository.findById(driverId).map(driver -> {
        driverRepository.delete(driver);
        return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY,driverId));
    }
}
