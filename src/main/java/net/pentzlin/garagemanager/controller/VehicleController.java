package net.pentzlin.garagemanager.controller;

import net.pentzlin.garagemanager.entity.vehicle.Vehicle;
import net.pentzlin.garagemanager.exception.VehicleAlreadyExistsException;
import net.pentzlin.garagemanager.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }
    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @PostMapping("/vehicles")
    @ResponseStatus(HttpStatus.CREATED)
    public void addVehicle(@RequestBody Vehicle vehicle) throws VehicleAlreadyExistsException {
        vehicleService.addVehicle(vehicle);
    }
}
