package com.parking.backendapplication.booking.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateDriverResource {

    @NotNull
    @NotBlank
    @Size(max = 20)
    private String vehicleNumber;

    private Date registrationDate;
    @NotNull
    @NotBlank
    @Size(max = 50)
    private String contact;

    private int creditCard;

    private int numberCard;
}
