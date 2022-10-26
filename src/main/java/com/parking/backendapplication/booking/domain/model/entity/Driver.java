package com.parking.backendapplication.booking.domain.model.entity;

import com.parking.backendapplication.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "drivers")
public class Driver extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    @NotBlank
    @Size(max = 20)
    @Column(unique = true)
    private String vehicleNumber;

    private Date registrationDate;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String contact;

    private int creditCard;

    private int numberCard;


}
