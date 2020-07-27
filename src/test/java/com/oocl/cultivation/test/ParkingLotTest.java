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
        ParkingBoy parkingBoy = new ParkingBoy();
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLotA = new ParkingLot("A");
        parkingLots.add(parkingLotA);
        parkingBoy.setParkingLot(parkingLots);
        Car car = new Car();
        //when
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
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLotA = new ParkingLot("A");
        parkingLots.add(parkingLotA);
        parkingBoy.setParkingLot(parkingLots);
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
        ParkingBoy parkingBoy = new ParkingBoy();
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLotA = new ParkingLot("A");
        parkingLots.add(parkingLotA);
        parkingBoy.setParkingLot(parkingLots);
        List<CarTicket> tickets = new ArrayList();
        List<Car> fetchCars = new ArrayList();
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
    void should_error_message_when_fetch_given_parking_boy_does_not_provide_ticket() {
        //given

        CarTicket ticket = new CarTicket();
        //when
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.fetch(ticket);
        //then
        assertEquals("Unrecognized parking ticket.\n", systemOut());

    }

    @Test
    void should_error_message_when_fetch_given_ticket_has_been_used() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLotA = new ParkingLot("A");
        parkingLots.add(parkingLotA);
        parkingBoy.setParkingLot(parkingLots);
        Car car = new Car();
        CarTicket ticket = parkingBoy.park(car);
        parkingBoy.fetch(ticket);
        //when
        parkingBoy.fetch(ticket);
        //then
        assertEquals("Unrecognized parking ticket.\n", systemOut());
    }

    @Test
    void should_error_message_when_fetch_given_customer_not_provide_ticket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLotA = new ParkingLot("A");
        parkingLots.add(parkingLotA);
        parkingBoy.setParkingLot(parkingLots);
        //when
        parkingBoy.fetch(null);
        //then
        assertEquals("Please provide your parking ticket.\n", systemOut());
    }

    @Test
    void should_error_message_when_park_no_position_given_car() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLotA = new ParkingLot("A");
        parkingLots.add(parkingLotA);
        parkingBoy.setParkingLot(parkingLots);
        for (int i = 0; i < 10; i++) {
            Car car = new Car();
            parkingBoy.park(car);
        }
        //when
        parkingBoy.park(new Car());
        //then
        assertEquals("Not enough position.\n", systemOut());
    }

    @Test
    void should_in_order_when_park_given_two_parkingLot() {
        //given
        ParkingLot parkingLotA = new ParkingLot("A");
        ParkingLot parkingLotB = new ParkingLot("B");
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLotA);
        parkingLots.add(parkingLotB);
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            Car car = new Car();
            cars.add(car);
        }
        //when
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.setParkingLot(parkingLots);
        List<CarTicket> tickets = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            CarTicket ticket = parkingBoy.park(cars.get(i));
            tickets.add(ticket);
        }
        //then
//        for (int i = 0; i < 10; i++) {
//            assertEquals(cars.get(i),parkingLotA.getParkingRooms().get(tickets.get(i)));
//        }
        assertEquals(cars.get(10),parkingLotB.getParkingRooms().get(tickets.get(10)));
    }

    @Test
    void should_park_lot_which_contains_more_empty_position_when_park_given_smart_parking_boy() {
        //given
        ParkingBoy parkingBoy=new ParkingBoy();
        parkingBoy.setId("smart parking boy");
        ParkingLot parkingLotA = new ParkingLot("A");
        ParkingLot parkingLotB = new ParkingLot("B");
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLotA);
        parkingLots.add(parkingLotB);
        parkingBoy.setParkingLot(parkingLots);
        //when
        List<Car> cars=new ArrayList<>();
        List<CarTicket> tickets=new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Car car=new Car();
            cars.add(car);
            CarTicket ticket=parkingBoy.park(car);
            tickets.add(ticket);
        }
        //then
        assertEquals(cars.get(0),parkingLotB.getParkingRooms().get(tickets.get(0)));
        assertEquals(cars.get(1),parkingLotA.getParkingRooms().get(tickets.get(1)));
        assertEquals(cars.get(2),parkingLotB.getParkingRooms().get(tickets.get(2)));
        assertEquals(cars.get(3),parkingLotA.getParkingRooms().get(tickets.get(3)));
    }

    @Test
    void should_park_lot_which_contains_more_empty_position_when_smart_park_given_super_smart_parking_boy() {
        //given
        ParkingBoy parkingBoy=new ParkingBoy();
        parkingBoy.setId("super smart parking boy");
        ParkingLot parkingLotA = new ParkingLot("A");
        ParkingLot parkingLotB = new ParkingLot("B");
        parkingLotA.setCapacity(10);
        parkingLotB.setCapacity(20);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLotA);
        parkingLots.add(parkingLotB);
        parkingBoy.setParkingLot(parkingLots);
        //when
        List<Car> cars=new ArrayList<>();
        List<CarTicket> tickets=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Car car=new Car();
            cars.add(car);
            CarTicket ticket=parkingBoy.park(car);
            tickets.add(ticket);
        }
        //then
        assertEquals(cars.get(0),parkingLotB.getParkingRooms().get(tickets.get(0)));
        assertEquals(cars.get(1),parkingLotA.getParkingRooms().get(tickets.get(1)));
        assertEquals(cars.get(2),parkingLotB.getParkingRooms().get(tickets.get(2)));
        assertEquals(cars.get(3),parkingLotB.getParkingRooms().get(tickets.get(3)));
        assertEquals(cars.get(4),parkingLotA.getParkingRooms().get(tickets.get(4)));
    }
}
