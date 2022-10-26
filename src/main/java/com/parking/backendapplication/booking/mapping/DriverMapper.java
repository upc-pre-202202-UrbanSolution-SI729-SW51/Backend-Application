package com.parking.backendapplication.booking.mapping;

import com.parking.backendapplication.booking.domain.model.entity.Driver;
import com.parking.backendapplication.booking.resource.CreateDriverResource;
import com.parking.backendapplication.booking.resource.DriverResource;
import com.parking.backendapplication.booking.resource.UpdateDriverResource;
import com.parking.backendapplication.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class DriverMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public DriverResource toResource(Driver model) {
        return mapper.map(model, DriverResource.class);
    }

    public Driver toModel(CreateDriverResource resource) {
        return mapper.map(resource, Driver.class);
    }

    public Driver toModel(UpdateDriverResource resource) {
        return mapper.map(resource, Driver.class);
    }

    public Page<DriverResource> modelListPage(List<Driver> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, DriverResource.class), pageable, modelList.size());
    }
}
