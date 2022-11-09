package com.parking.backendapplication.parkingHistory.domain.model.entity;

import com.parking.backendapplication.shared.domain.model.AuditModel;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Owner extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(unique = true)
    private String parkingSpace;

    @NotNull
    @NotBlank
    @Column(unique = true)
    private int spaces;

    @NotNull
    @NotBlank
    @Size(max = 20)
    @Column(unique = true)
    private String parkingAddress;
}
