package net.pentzlin.garagemanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class VehicleAlreadyExistsException extends RuntimeException {
    public VehicleAlreadyExistsException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
