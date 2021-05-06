package net.pentzlin.garagemanager.entity.vehicle;

import javax.persistence.*;

@Entity
@DiscriminatorValue("MotorBike")
public class MotorBike extends Vehicle {
    public MotorBike () {
        super();
    }

    public MotorBike(String licensePlate) {
        super(licensePlate);
    }
}
