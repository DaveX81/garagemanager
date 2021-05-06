package net.pentzlin.garagemanager.exception;

public class VehicleNotFoundException extends Exception {
    public VehicleNotFoundException(String errorMessage) {
        super(errorMessage);
    }
    public VehicleNotFoundException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
