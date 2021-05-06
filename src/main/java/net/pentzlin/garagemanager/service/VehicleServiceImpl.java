package net.pentzlin.garagemanager.service;

import net.pentzlin.garagemanager.dao.VehicleRepository;
import net.pentzlin.garagemanager.entity.vehicle.Vehicle;
import net.pentzlin.garagemanager.exception.VehicleAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle addVehicle(Vehicle vehicle) throws VehicleAlreadyExistsException {
        try {
            return vehicleRepository.save(vehicle);
        } catch (DataIntegrityViolationException e) {
            throw new VehicleAlreadyExistsException("Motorbike already exist", e);
        }
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }
}
