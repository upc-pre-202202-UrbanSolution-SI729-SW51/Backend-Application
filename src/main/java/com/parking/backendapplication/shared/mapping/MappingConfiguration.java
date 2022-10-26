package com.parking.backendapplication.shared.mapping;

import com.parking.backendapplication.booking.mapping.DriverMapper;
import com.parking.backendapplication.booking.mapping.ParkingLotMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("enhancedModelMapperConfiguration")
public class MappingConfiguration {

    @Bean
<<<<<<< Updated upstream
<<<<<<< Updated upstream
    public EnhancedModelMapper modelMapper(){
=======
    public EnhancedModelMapper ModelMapper(){

>>>>>>> Stashed changes
        return new EnhancedModelMapper();
=======
    public ParkingLotMapper parkingLotMapper(){
        return new ParkingLotMapper();
>>>>>>> Stashed changes
    }

    @Bean
    public DriverMapper driverMapper(){
        return new DriverMapper();
    }

}