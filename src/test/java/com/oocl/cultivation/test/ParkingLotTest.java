package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    public ByteArrayOutputStream out = null;

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }


    private String systemOut() {
        return outContent.toString();
    }

    @Test
    void should_return_ticket_when_park_given_car() {
        //given
        Car car = new Car();
        //when
        ParkingBoy parkingBoy = new ParkingBoy();
        CarTicket ticket = parkingBoy.park(car);
        //then
        assertNotNull(ticket);
    }

    @Test
    void should_fetch_car_when_fetch_from_parking_lot_given_car_ticket() {
        //given
        Car car = new Car();
        //when
        ParkingBoy parkingBoy = new ParkingBoy();
        CarTicket ticket = parkingBoy.park(car);
        Car fetchedCar = parkingBoy.fetch(ticket);
        //then
        assertNotNull(fetchedCar);
        assertEquals(car, fetchedCar);
    }

    @Test
    void should_return_tickets_when_given_multiple_cars() {
        //given
        List<Car> cars = new ArrayList();
        for (int i = 0; i < 2; i++) {
            Car car = new Car();
            cars.add(car);
        }

        //when
        List<CarTicket> tickets = new ArrayList();
        List<Car> fetchCars = new ArrayList();
        ParkingBoy parkingBoy = new ParkingBoy();
        for (int i = 0; i < cars.size(); i++) {
            CarTicket ticket = parkingBoy.park(cars.get(i));
            tickets.add(ticket);
            Car car = parkingBoy.fetch(ticket);
            fetchCars.add(car);
        }

        //then
        assertNotNull(fetchCars);
        assertEquals(cars, fetchCars);

    }

    @Test
    void should_no_car_be_fetched_when_fetch_given_wrong_ticket() {
        //given
        CarTicket ticket = new CarTicket();
        //when
        ParkingBoy parkingBoy = new ParkingBoy();
        Car fetchedCar = parkingBoy.fetch(ticket);
        //then
        assertEquals(null, fetchedCar);
    }

    @Test
    void should_no_car_be_fetched_when_fetch_given_no_ticket() {
        //given

        //when
        ParkingBoy parkingBoy = new ParkingBoy();
        Car fetchedCar = parkingBoy.fetch(null);
        //then
        assertEquals(null, fetchedCar);
    }

    @Test
    void should_no_car_when_fetch_given_already_been_used_ticket() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        CarTicket ticketFirst = parkingBoy.park(car);
        parkingBoy.fetch(ticketFirst);
        //when
        Car fetchCar = parkingBoy.fetch(ticketFirst);
        //then
        assertEquals(null, fetchCar);
    }

    @Test
    void should_get_no_ticket_when_park_no_position_given_car() {
        //given
        List<Car> cars = new ArrayList<>();
        ParkingBoy parkingBoy = new ParkingBoy();
        for (int i = 0; i < 10; i++) {
            Car car = new Car();
            cars.add(car);
            parkingBoy.park(car);
        }
        //when
        cars.add(new Car());
        CarTicket ticket = parkingBoy.park(cars.get(10));
        //then
        assertNull(ticket);
    }

    @Test
    void should_error_message_when_fetch_given_parking_boy_does_not_provide_ticket () {
        //given
        CarTicket ticket=new CarTicket();
        //when
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.fetch(ticket);
        //then
        assertEquals("Unrecognized parking ticket.\n", systemOut());

    }

    @Test
    void should_error_message_when_fetch_given_ticket_has_been_used() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        CarTicket ticket = parkingBoy.park(car);
        parkingBoy.fetch(ticket);
        //when
        parkingBoy.fetch(ticket);
        //then
        assertEquals("Unrecognized parking ticket.\n", systemOut());
    }

    @Test
    void should_error_message_when_park_no_position_given_car() {
        //given
        List<Car> cars = new ArrayList<>();
        ParkingBoy parkingBoy = new ParkingBoy();
        for (int i = 0; i < 10; i++) {
            Car car = new Car();
            cars.add(car);
            parkingBoy.park(car);
        }
        //when
        cars.add(new Car());
        parkingBoy.park(cars.get(10));
        //then
        assertEquals("Not enough position.\n", systemOut());
    }

    //TODO 测试没写完，也没git
    @Test
    void should_in_order_when_park_given_two_parkingLot() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLotFirst = new ParkingLot();
        ParkingLot parkingLotSecond = new ParkingLot();
        parkingLotFirst.setCapacity(10);
        parkingLotSecond.setCapacity(10);
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Car car = new Car();
            cars.add(car);
        }
        //when
        for (int i = 0; i < cars.size(); i++) {
            parkingBoy.park(cars.get(i));
            if (i == 10) {

            }
        }

        //then
    }
}
