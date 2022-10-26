package com.parking.backendapplication.booking.domain.model.entity;

import com.parking.backendapplication.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.transform.Source;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "parking_lots")
public class ParkingLot extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(unique = true)
    private String address;


    private Number spaces_free;

    private Number spaces_available;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(unique = true)
    private String company_name;

}
