package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {
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
    //TODO AC2
//
//    @Test
//    void should_return_tickets_when_given_multiple_cars() {
//        //given
//        List<Car> cars=new ArrayList();
//        for (int i = 0; i <4; i++) {
//             Car car= new Car();
//             cars.add(car);
//        }
//        //when
//        List<CarTicket> tickets=new ArrayList();
//        ParkingLot parkingLot=new ParkingLot();
//        for (int i = 0; i < cars.size(); i++) {
//            CarTicket ticket=parkingLot.park(cars.get(i));
//            tickets.add(ticket);
//        }
//        //then
//
//    }

    @Test
    void should_no_car_be_fetched_when_given_wrong_ticket() {
        //given
        CarTicket ticket = new CarTicket();
        //when
        ParkingLot parkingLot = new ParkingLot();
        Car fetchedCar = parkingLot.fetch(ticket);
        //then
        assertEquals(null, fetchedCar);
    }

    @Test
    void should_no_car_be_fecthed_when_given_no_ticket() {
        //given

        //when
        ParkingLot parkingLot = new ParkingLot();
        Car fetchedCar = parkingLot.fetch(null);
        //then
        assertEquals(null,fetchedCar);
    }
}
