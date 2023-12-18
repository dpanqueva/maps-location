package com.invexdijin.maps.location.infrastructure.exceptions;

public class NotFoundException  extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public NotFoundException() {

    }

    public NotFoundException(String message) {
        super(message);
    }
}
