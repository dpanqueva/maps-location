package com.invexdijin.maps.location.application;

import com.invexdijin.maps.location.domain.model.Geometry;
import com.invexdijin.maps.location.infrastructure.model.AddressDto;

public interface ICaseUseMapService {

    Geometry googleMapsApiAddressLocation(AddressDto address);
}
