package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_park_given_car() {
        //given
        ParkingLot parkingLot=new ParkingLot();
        Car car=new Car();
        //when
        CarTicket ticket=parkingLot.park(car);
        //then
        assertNotNull(ticket);
    }

    @Test
    void should_fetch_car_when_fetch_from_parking_lot_given_car_ticket() {
        //given
        Car car=new Car();
        //when
        ParkingLot parkingLot=new ParkingLot();
        CarTicket ticket=parkingLot.park(car);
        Car fetchedCar=parkingLot.fetch(ticket);
        //then
        assertNotNull(fetchedCar);
        assertEquals(car,fetchedCar);
    }
}
