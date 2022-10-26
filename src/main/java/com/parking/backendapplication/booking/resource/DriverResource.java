package com.parking.backendapplication.booking.resource;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class DriverResource {

    private String vehicleNumber;
    private Date registrationDate;
    private String contact;
    private int creditCard;
    private int numberCard;
}
