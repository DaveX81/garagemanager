package net.pentzlin.garagemanager.service;

import net.pentzlin.garagemanager.entity.vehicle.Vehicle;
import net.pentzlin.garagemanager.exception.VehicleAlreadyExistsException;

import java.util.List;

public interface VehicleService {
    Vehicle addVehicle(Vehicle vehicle) throws VehicleAlreadyExistsException;
    List<Vehicle> getAllVehicles();
}
