package com.parking.backendapplication.booking.mapping;

import com.parking.backendapplication.booking.domain.model.entity.ParkingLot;
import com.parking.backendapplication.booking.resource.CreateParkingLotResource;
import com.parking.backendapplication.booking.resource.ParkingLotResource;
import com.parking.backendapplication.booking.resource.UpdateParkingLotResource;
import com.parking.backendapplication.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class ParkingLotMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public ParkingLotResource toResource(ParkingLot model) {
        return mapper.map(model, ParkingLotResource.class);
    }

    public ParkingLot toModel(CreateParkingLotResource resource) {
        return mapper.map(resource, ParkingLot.class);
    }

    public ParkingLot toModel(UpdateParkingLotResource resource) {
        return mapper.map(resource, ParkingLot.class);
    }

    public Page<ParkingLotResource> modelListPage(List<ParkingLot> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ParkingLotResource.class), pageable, modelList.size());
    }
}
