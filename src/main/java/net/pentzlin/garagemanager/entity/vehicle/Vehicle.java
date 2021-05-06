package net.pentzlin.garagemanager.entity.vehicle;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import net.pentzlin.garagemanager.entity.garage.ParkingPlace;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "vehicle_type")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "vehicleType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Car.class, name = "Car"),
        @JsonSubTypes.Type(value = MotorBike.class, name = "MotorBike")
})
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "license_plate", nullable = false, unique = true)
    private String licensePlate;

    @OneToOne(mappedBy = "parkedVehicle", cascade = CascadeType.ALL)
    private ParkingPlace parkingPlace;

    public Vehicle() {}
    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getId() {
        return id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @JsonIgnore
    public ParkingPlace getParkingPlace() {
        return parkingPlace;
    }

    public void setParkingPlace(ParkingPlace parkingPlace) {
        this.parkingPlace = parkingPlace;
    }
}
