package net.pentzlin.garagemanager.controller;

import net.pentzlin.garagemanager.entity.garage.ParkingPlace;
import net.pentzlin.garagemanager.entity.vehicle.Vehicle;
import net.pentzlin.garagemanager.exception.NoFreeParkingPlaceException;
import net.pentzlin.garagemanager.exception.VehicleAlreadyExistsException;
import net.pentzlin.garagemanager.exception.VehicleNotFoundException;
import net.pentzlin.garagemanager.service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api")
public class GarageController {

    private final GarageService garageService;

    @Autowired
    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    @PutMapping("/garage/enter")
    public ParkingPlace enterGarage(@RequestBody Vehicle vehicle) throws VehicleAlreadyExistsException,
            NoFreeParkingPlaceException, VehicleNotFoundException {
        return this.garageService.enterGarage(vehicle);
    }

    @PutMapping("/garage/exit")
    public void exitGarage(@RequestBody Vehicle vehicle) throws VehicleNotFoundException {
        this.garageService.exitGarage(vehicle);
    }

    @GetMapping("/garage/parkingPlace/{licensePlate}")
    public ParkingPlace getParkingPlace(@PathVariable String licensePlate) throws VehicleNotFoundException {
        return this.garageService.getParkingPlaceFor(licensePlate);
    }

    @GetMapping("/garage/freeParkingPlaces")
    public long getNumberofFreeParkingPlaces() {
        return this.garageService.getNumberOfFreeParkingPlaces();
    }
}
