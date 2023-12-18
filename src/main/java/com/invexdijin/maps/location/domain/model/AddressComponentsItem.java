package com.invexdijin.maps.location.domain.model;

import java.util.List;
import lombok.Data;

@Data
public class AddressComponentsItem{
	private List<String> types;
	private String shortName;
	private String longName;
}