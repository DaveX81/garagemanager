package net.pentzlin.garagemanager.exception;

public class VehicleAlreadyExistsException extends Exception {
    public VehicleAlreadyExistsException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
