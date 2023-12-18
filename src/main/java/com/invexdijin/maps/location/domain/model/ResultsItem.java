package com.invexdijin.maps.location.domain.model;

import java.util.List;
import lombok.Data;

@Data
public class ResultsItem{
	private String formattedAddress;
	private List<String> types;
	private Geometry geometry;
	private List<AddressComponentsItem> addressComponents;
	private PlusCode plusCode;
	private String placeId;
}