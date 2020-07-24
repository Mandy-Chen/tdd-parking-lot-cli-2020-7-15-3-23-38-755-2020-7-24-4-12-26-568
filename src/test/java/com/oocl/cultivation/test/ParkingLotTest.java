package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    public ByteArrayOutputStream out = null;

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() throws Throwable {
        out.close();
        System.setOut(System.out); //将输出重新设置为控制台输出
    }

    @Test
    void should_return_ticket_when_park_given_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        //when
        CarTicket ticket = parkingLot.park(car);
        //then
        assertNotNull(ticket);
    }

    @Test
    void should_fetch_car_when_fetch_from_parking_lot_given_car_ticket() {
        //given
        Car car = new Car();
        //when
        ParkingLot parkingLot = new ParkingLot();
        CarTicket ticket = parkingLot.park(car);
        Car fetchedCar = parkingLot.fetch(ticket);
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
        ParkingLot parkingLot = new ParkingLot();
        for (int i = 0; i < cars.size(); i++) {
            CarTicket ticket = parkingLot.park(cars.get(i));
            tickets.add(ticket);
            Car car = parkingLot.fetch(ticket);
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
        ParkingLot parkingLot = new ParkingLot();
        Car fetchedCar = parkingLot.fetch(ticket);
        //then
        assertEquals(null, fetchedCar);
    }

    @Test
    void should_no_car_be_fetched_when_fetch_given_no_ticket() {
        //given

        //when
        ParkingLot parkingLot = new ParkingLot();
        Car fetchedCar = parkingLot.fetch(null);
        //then
        assertEquals(null, fetchedCar);
    }

    @Test
    void should_no_car_when_fetch_given_already_been_used_ticket() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        CarTicket ticketFirst = parkingLot.park(car);
        parkingLot.fetch(ticketFirst);
        //when
        Car fetchCar = parkingLot.fetch(ticketFirst);
        //then
        assertEquals(null, fetchCar);
    }

    @Test
    void should_get_no_ticket_when_park_no_position_given_car() {
        //given
        List<Car> cars = new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot();
        for (int i = 0; i < 10; i++) {
            Car car = new Car();
            cars.add(car);
            parkingLot.park(car);
        }
        //when
        cars.add(new Car());
        CarTicket ticket = parkingLot.park(cars.get(10));
        //then
        assertNull(ticket);
    }

    @Test
    void should_error_message_when_fetch_given_no_ticket() {
        //given

        //when
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.fetch(null);
        String error_message = out.toString();
        //then
        assertEquals("Unrecognized parking ticket.", error_message);
    }
}
