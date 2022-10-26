package com.parking.backendapplication.booking.resource;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateParkingLotResource {

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String address;

    @NotNull
    @NotBlank
    @Column(unique = true)
    private Number spaces_free;

    @NotNull
    @NotBlank
    @Column(unique = true)
    private Number spaces_available;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(unique = true)
    private String company_name;
}
