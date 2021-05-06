package net.pentzlin.garagemanager.service;

import net.pentzlin.garagemanager.dao.ParkingPlaceRepository;
import net.pentzlin.garagemanager.dao.VehicleRepository;
import net.pentzlin.garagemanager.entity.garage.ParkingPlace;
import net.pentzlin.garagemanager.entity.vehicle.Vehicle;
import net.pentzlin.garagemanager.exception.NoFreeParkingPlaceException;
import net.pentzlin.garagemanager.exception.VehicleAlreadyExistsException;
import net.pentzlin.garagemanager.exception.VehicleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GarageServiceImpl implements GarageService {
    private final ParkingPlaceRepository parkingPlaceRepository;
    private final VehicleRepository vehicleRepository;

    @Autowired
    public GarageServiceImpl(ParkingPlaceRepository parkingPlaceRepository,
                             VehicleRepository vehicleRepository) {
        this.parkingPlaceRepository = parkingPlaceRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public void enterGarage(Vehicle vehicle) throws NoFreeParkingPlaceException, VehicleAlreadyExistsException,
            VehicleNotFoundException {
        var dbVehicle = vehicleRepository.findVehicleByLicensePlate(vehicle.getLicensePlate());
        if(dbVehicle.isEmpty()) throw new VehicleNotFoundException("Vehicle not found");
        var parkingPlace = parkingPlaceRepository.findFirstByParkedVehicleIsNull();
        if(parkingPlace.isEmpty()) throw new NoFreeParkingPlaceException("No free parking places");
        else {
            parkingPlace.get().setParkedVehicle(dbVehicle.get());
            try {
                this.parkingPlaceRepository.save(parkingPlace.get());
            } catch (DataIntegrityViolationException e) {
                throw new VehicleAlreadyExistsException("Vehicle already parked", e);
            }
        }
    }

    @Override
    public void exitGarage(Vehicle vehicle) throws VehicleNotFoundException {
        var dbVehicle = vehicleRepository.findVehicleByLicensePlate(vehicle.getLicensePlate());
        if(dbVehicle.isEmpty()) throw new VehicleNotFoundException("Vehicle not found");
        Optional<ParkingPlace> parkingPlace = parkingPlaceRepository.findParkingPlaceByParkedVehicle(dbVehicle.get());
        if(parkingPlace.isPresent()) {
            parkingPlace.get().setParkedVehicle(null);
            parkingPlaceRepository.save(parkingPlace.get());
        }
        else throw new VehicleNotFoundException("Vehicle not parked");
    }

    @Override
    public long getNumberOfFreeParkingPlaces() {
        return parkingPlaceRepository.findAll().stream()
                .filter(parkingPlace -> !parkingPlace.isOccoupied())
                .count();
    }

    @Override
    public List<ParkingPlace> getAllParkingPlaces() {
        return parkingPlaceRepository.findAll();
    }

    @Override
    public ParkingPlace getParkingPlaceFor(String licensePlate) throws VehicleNotFoundException {
        var vehicle = vehicleRepository.findVehicleByLicensePlate(licensePlate);
        if(vehicle.isEmpty()) throw new VehicleNotFoundException("Vehicle not found");
        var parkingPlace = parkingPlaceRepository.findParkingPlaceByParkedVehicle(vehicle.get());
        return parkingPlace.orElseThrow(() -> new VehicleNotFoundException("Car not Parked"));
    }
}
