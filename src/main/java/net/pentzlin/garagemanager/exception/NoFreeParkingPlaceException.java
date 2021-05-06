package net.pentzlin.garagemanager.exception;

public class NoFreeParkingPlaceException extends Exception{
    public NoFreeParkingPlaceException(String errorMessage) {
        super(errorMessage);
    }
    public NoFreeParkingPlaceException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
