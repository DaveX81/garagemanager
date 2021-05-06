package net.pentzlin.garagemanager.controller;

import net.pentzlin.garagemanager.entity.garage.ParkingPlace;
import net.pentzlin.garagemanager.exception.NoFreeParkingPlaceException;
import net.pentzlin.garagemanager.exception.VehicleAlreadyExistsException;
import net.pentzlin.garagemanager.exception.VehicleNotFoundException;
import net.pentzlin.garagemanager.service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GarageController {

    private final GarageService garageService;

    @Autowired
    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    @PutMapping("/garage/enter/{licensePlate}")
    public void enterGarage(@PathVariable String licensePlate) throws VehicleAlreadyExistsException,
            NoFreeParkingPlaceException, VehicleNotFoundException {
        this.garageService.enterGarage(licensePlate);
    }

    @PutMapping("/garage/exit/{licensePlate}")
    public void exitGarage(@PathVariable String licensePlate) throws VehicleNotFoundException {
        this.garageService.exitGarage(licensePlate);
    }

    @GetMapping("/garage/parkingPlace/{licensePlate}")
    public ParkingPlace getParkingPlace(@PathVariable String licensePlate) throws VehicleNotFoundException {
        return this.garageService.getParkingPlaceFor(licensePlate);
    }

    @GetMapping("/garage/freeParkingPlaces")
    public long parkedCars() {
        return this.garageService.getNumberOfFreeParkingPlaces();
    }
}
