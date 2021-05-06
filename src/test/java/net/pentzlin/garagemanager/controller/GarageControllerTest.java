package net.pentzlin.garagemanager.controller;

import net.pentzlin.garagemanager.entity.garage.ParkingPlace;
import net.pentzlin.garagemanager.entity.vehicle.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GarageControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    private String url = "http://localhost:";

    @Test
    void testEnterGarageWithCarABC() {
        Car car = new Car("ABC");
        this.testRestTemplate.put(this.url + this.port + "/api/garage/enter", car);
    }

    @Test
    void testGetParkingPlaceForCarABC() {
        ParkingPlace parkingPlace = this.testRestTemplate.getForObject(
                this.url + this.port + "/api/garage/parkingPlace/ABC", ParkingPlace.class);
        assertThat(parkingPlace.getParkedVehicle() != null
                && parkingPlace.getParkedVehicle().getLicensePlate() == "ABC");
    }

    @Test
    void testExitGarageWithCarABC() {
        Car car = new Car("ABC");
        this.testRestTemplate.put(this.url + this.port + "/api/garage/exit/ABC", car);
    }

    @Test
    void testNumberOfParkedCarsGreaterOrEqualZero() {
        Long response = testRestTemplate.getForObject(
                this.url + this.port + "/api/garage/freeParkingPlaces", Long.class);
        assertThat(response != null && response >= 0);
    }
}
