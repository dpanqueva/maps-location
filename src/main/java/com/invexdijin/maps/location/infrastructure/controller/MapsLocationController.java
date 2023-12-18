package com.invexdijin.maps.location.infrastructure.controller;

import com.invexdijin.maps.location.application.ICaseUseMapService;
import com.invexdijin.maps.location.domain.model.Geometry;
import com.invexdijin.maps.location.infrastructure.model.AddressDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/invexdijin")
public class MapsLocationController {

    @Autowired
    private ICaseUseMapService mapService;

    @PostMapping("/location-address")
    public ResponseEntity<Geometry> geometryLocationAddress(@RequestBody AddressDto address) {
        return ResponseEntity.ok().body(mapService.googleMapsApiAddressLocation(address));
    }
}
