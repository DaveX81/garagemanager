package net.pentzlin.garagemanager.dao;

import net.pentzlin.garagemanager.entity.garage.ParkingPlace;
import net.pentzlin.garagemanager.entity.vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParkingPlaceRepository extends JpaRepository <ParkingPlace, Integer> {
    Optional<ParkingPlace> findFirstByParkedVehicleIsNull();
    Optional<ParkingPlace> findParkingPlaceByParkedVehicle(Vehicle vehicle);
}
