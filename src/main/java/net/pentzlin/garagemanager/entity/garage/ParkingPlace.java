package net.pentzlin.garagemanager.entity.garage;

import net.pentzlin.garagemanager.entity.vehicle.Vehicle;

import javax.persistence.*;

@Entity
@Table(name="parking_place", uniqueConstraints = {@UniqueConstraint(columnNames = {"parking_number", "parkinglevel_id"})})
public class ParkingPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="parking_number", nullable = false)
    private int parkingNumber;

    @OneToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id", unique = true)
    private Vehicle parkedVehicle;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parkinglevel_id", referencedColumnName = "id", nullable = false)
    private ParkingLevel parkingLevel;

    public ParkingPlace() { }

    public int getParkingNumber() {
        return parkingNumber;
    }

    public void setParkingNumber(int parkingNumber) {
        this.parkingNumber = parkingNumber;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void setParkedVehicle(Vehicle parkedVehicle) {
        this.parkedVehicle = parkedVehicle;
    }

    public ParkingLevel getParkingLevel() {
        return parkingLevel;
    }

    public void setParkingLevel(ParkingLevel parkingLevel) {
        this.parkingLevel = parkingLevel;
    }

    public boolean isOccoupied() {
        return this.parkedVehicle != null;
    }
}
