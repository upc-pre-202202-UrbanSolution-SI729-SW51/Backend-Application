package com.parking.backendapplication.booking.resource;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdateParkingLotResource {

    private Long id;

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
