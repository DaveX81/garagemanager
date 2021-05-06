package net.pentzlin.garagemanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoFreeParkingPlaceException extends RuntimeException{
    public NoFreeParkingPlaceException(String errorMessage) {
        super(errorMessage);
    }
    public NoFreeParkingPlaceException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
