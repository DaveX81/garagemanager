package net.pentzlin.garagemanager.entity.vehicle;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("Car")
public class Car extends Vehicle {

    public Car() {}

    public Car(String licensePlate) {
        super(licensePlate);
    }
}
