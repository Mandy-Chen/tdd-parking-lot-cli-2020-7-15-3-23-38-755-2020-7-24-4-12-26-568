package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.exception.UnrecognizedTicketException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ParkingLotTest {

    @Test
    void should_error_message_when_fetch_given_parking_boy_does_not_provide_ticket() {
        //given
        CarTicket ticket = new CarTicket();
        //when
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.fetch(ticket);
        //then
        assertEquals("Unrecognized parking ticket.", parkingLot.getMessage());
    }

    @Test
    void should_error_message_when_fetch_given_ticket_has_been_used() throws UnrecognizedTicketException {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        //when
        CarTicket ticket = parkingLot.park(car);
        parkingLot.fetch(ticket);
        parkingLot.fetch(ticket);
        //then
        assertEquals("Unrecognized parking ticket.", parkingLot.getMessage());
    }

    @Test
    void should_error_message_when_fetch_given_customer_not_provide_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        //when
        parkingLot.fetch(null);
        //then
        assertEquals("Please provide your parking ticket.", parkingLot.getMessage());
    }

    @Test
    void should_error_message_when_park_no_position_given_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car firstCar = new Car();
        Car secondCar = new Car();
        //when
        parkingLot.park(firstCar);
        parkingLot.park(secondCar);
        //then
        assertEquals("Not enough position.", parkingLot.getMessage());
    }


}
