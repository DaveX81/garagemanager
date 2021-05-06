package net.pentzlin.garagemanager.dao;

import net.pentzlin.garagemanager.entity.vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository <Vehicle, Integer> {
    Optional<Vehicle> findVehicleByLicensePlate(String licensePlate);
}
