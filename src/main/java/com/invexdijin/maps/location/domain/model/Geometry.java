package com.invexdijin.maps.location.domain.model;

import lombok.Data;

@Data
public class Geometry{
	private Viewport viewport;
	private Location location;
	private String locationType;
}