package com.parking.backendapplication.booking.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("bookingMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public ParkingLotMapper parkingLotMapper(){return new ParkingLotMapper();}
}
