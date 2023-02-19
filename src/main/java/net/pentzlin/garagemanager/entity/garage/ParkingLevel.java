package net.pentzlin.garagemanager.entity.garage;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="parking_level")
public class ParkingLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="level_number", nullable = false, unique = true)
    private int levelNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "garage_id", referencedColumnName = "id", nullable = false)
    private Garage garage;

    @OneToMany(mappedBy = "parkingLevel")
    private List<ParkingPlace> parkingPlaces;

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    @JsonIgnore
    public List<ParkingPlace> getParkingPlaces() {
        return parkingPlaces;
    }

    public void setParkingPlaces(List<ParkingPlace> parkingPlaces) {
        this.parkingPlaces = parkingPlaces;
    }
}
