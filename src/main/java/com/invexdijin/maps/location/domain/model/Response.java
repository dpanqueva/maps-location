package com.invexdijin.maps.location.domain.model;

import java.util.List;
import lombok.Data;

@Data
public class Response{
	private List<ResultsItem> results;
	private String status;
}