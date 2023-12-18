package com.invexdijin.maps.location.domain.service;

import com.invexdijin.maps.location.application.ICaseUseMapService;
import com.invexdijin.maps.location.domain.model.Geometry;
import com.invexdijin.maps.location.domain.model.Response;
import com.invexdijin.maps.location.infrastructure.exceptions.NotFoundException;
import com.invexdijin.maps.location.infrastructure.model.AddressDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CaseUseMapServiceImpl implements ICaseUseMapService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${client.google.maps.url}")
    private String url;

    @Value("${client.google.maps.key}")
    private String apiKey;

    @Override
    public Geometry googleMapsApiAddressLocation(AddressDto address) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String finalUrl = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("address", address.getAddress().concat(",").concat(address.getDepartment())
                        .concat(",").concat(address.getMunicipality()))
                .queryParam("key", apiKey)
                .toUriString();
        ResponseEntity<Response> response = restTemplate.getForEntity(finalUrl, Response.class, headers);
        if (response.getBody() == null) {
            notFoundException();
        }
        if (response.getBody().getResults() == null) {
            notFoundException();
        }

        if (response.getBody().getResults().get(0) == null) {
            notFoundException();
        }

        if (response.getBody().getResults().get(0).getGeometry() == null) {
            notFoundException();
        }

        return response.getBody().getResults().get(0).getGeometry();
    }

    private void notFoundException() {
        throw new NotFoundException("Resources not found");
    }
}
