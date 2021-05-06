package net.pentzlin.garagemanager.service;

import net.pentzlin.garagemanager.entity.garage.ParkingPlace;
import net.pentzlin.garagemanager.entity.vehicle.Vehicle;
import net.pentzlin.garagemanager.exception.NoFreeParkingPlaceException;
import net.pentzlin.garagemanager.exception.VehicleAlreadyExistsException;
import net.pentzlin.garagemanager.exception.VehicleNotFoundException;

import java.util.List;

public interface GarageService {

    void enterGarage(Vehicle vehicle) throws NoFreeParkingPlaceException, VehicleAlreadyExistsException,
            VehicleNotFoundException;

    void exitGarage(Vehicle vehicle) throws VehicleNotFoundException;

    long getNumberOfFreeParkingPlaces();

    List<ParkingPlace> getAllParkingPlaces();

    ParkingPlace getParkingPlaceFor(String licensePlate) throws VehicleNotFoundException;
}
