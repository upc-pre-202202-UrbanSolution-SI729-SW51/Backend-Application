package com.parking.backendapplication.booking.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ParkingLotResource {
    private Long id;
    private String address;
    private Number spaces_free;
    private Number spaces_available;
    private String company_name;
}
