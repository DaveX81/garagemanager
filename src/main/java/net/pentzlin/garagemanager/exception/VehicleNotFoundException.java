package net.pentzlin.garagemanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class VehicleNotFoundException extends RuntimeException {
    public VehicleNotFoundException(String errorMessage) {
        super(errorMessage);
    }
    public VehicleNotFoundException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
