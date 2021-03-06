package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class ParkingBoyTest {
    @Test
    void should_return_ticket_when_park_given_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
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
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
        CarTicket ticket = parkingBoy.park(car);
        Car fetchedCar = parkingBoy.fetch(ticket);
        //then
        assertNotNull(fetchedCar);
        assertEquals(car, fetchedCar);
    }

    @Test
    void should_return_tickets_when_given_multiple_cars() {
        //given
        Car firstCar = new Car();
        Car secondCar = new Car();
        //when
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(2));
        CarTicket firstTicket = parkingBoy.park(firstCar);
        CarTicket secondTicket = parkingBoy.park(secondCar);
        Car firstFetchedCar = parkingBoy.fetch(firstTicket);
        Car secondFetchedCar = parkingBoy.fetch(secondTicket);
        //then
        assertEquals(firstCar, firstFetchedCar);
        assertEquals(secondCar, secondFetchedCar);
    }

    @Test
    void should_no_car_be_fetched_when_fetch_given_wrong_ticket() {
        //given
        CarTicket ticket = new CarTicket();
        //when
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
        Car fetchedCar = parkingBoy.fetch(ticket);
        //then
        assertNull(fetchedCar);

    }

    @Test
    void should_no_car_be_fetched_when_fetch_given_no_ticket() {
        //given

        //when
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
        Car fetchedCar = parkingBoy.fetch(null);
        //then
        assertNull(fetchedCar);
    }

    @Test
    void should_no_car_when_fetch_given_already_been_used_ticket() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
        CarTicket ticketFirst = parkingBoy.park(car);
        parkingBoy.fetch(ticketFirst);
        //when
        Car fetchCar = parkingBoy.fetch(ticketFirst);
        //then
        assertNull(fetchCar);
    }

    @Test
    void should_get_no_ticket_when_park_no_position_given_car() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
        Car firstCar = new Car();
        Car secondCar = new Car();
        //when
        parkingBoy.park(firstCar);
        parkingBoy.park(secondCar);
        //then
        assertNull(parkingBoy.park(secondCar));
    }

    @Test
    void should_in_order_when_park_given_two_parkingLot() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(2);
        ParkingLot secondParkingLot = new ParkingLot(2);
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Car car = new Car();
            cars.add(car);
        }
        //when
        ParkingBoy parkingBoy = new ParkingBoy(firstParkingLot, secondParkingLot);
        List<CarTicket> tickets = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            CarTicket ticket = parkingBoy.park(cars.get(i));
            tickets.add(ticket);
        }
        //then
        assertEquals(cars.get(1), firstParkingLot.fetch(tickets.get(1)));
        assertEquals(cars.get(2), secondParkingLot.fetch(tickets.get(2)));
    }


}
