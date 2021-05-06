package net.pentzlin.garagemanager.dao;

import net.pentzlin.garagemanager.entity.garage.Garage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GarageRepository extends JpaRepository <Garage, Integer> {
}
