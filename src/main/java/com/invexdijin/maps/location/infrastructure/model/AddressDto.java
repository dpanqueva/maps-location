package com.invexdijin.maps.location.infrastructure.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddressDto {

    private String department;
    private String municipality;
    private String address;
}
