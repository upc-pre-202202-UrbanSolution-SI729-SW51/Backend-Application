package com.parking.backendapplication.parkingHistory.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class OwnerResource {
        private Long id;
        private String parkingSpace;
        private int spaces;
        private String parkingAddress;
}
