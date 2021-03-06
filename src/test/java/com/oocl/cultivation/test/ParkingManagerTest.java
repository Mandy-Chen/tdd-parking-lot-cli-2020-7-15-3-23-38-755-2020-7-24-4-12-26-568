package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingManagerTest {
    @Test
    void should_parking_the_cars_when_manager_manage_a_parking_lot_and_2_parking_boy() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot(1));
        ParkingManager parkingManager = new ParkingManager(parkingBoy, parkingLot, smartParkingBoy);
        Car firstCar = new Car();
        Car secondCar = new Car();
        Car thirdCar = new Car();

        //when
        CarTicket ticket1 = parkingManager.parking(firstCar);
        CarTicket ticket2 = parkingManager.parking(secondCar);
        CarTicket ticket3 = parkingManager.parking(thirdCar);

        //then
        assertNotNull(ticket1);
        assertNotNull(ticket2);
        assertNotNull(ticket3);
    }

    @Test
    void should_get_ticket_and_get_car_when_manager_park_and_fetch() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingManager parkingManager = new ParkingManager(parkingLot);
        Car car = new Car();
        //when
        CarTicket ticket = parkingManager.parking(car);
        Car fetchedCar = parkingManager.fetch(ticket);
        //then
        assertEquals(car, fetchedCar);
    }

    @Test
    void should_return_error_message_when_manager_manage_parking_boy_to_park() throws Exception {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
        ParkingManager parkingManager = new ParkingManager(parkingBoy);
        Car firstCar = new Car();
        Car secondCar = new Car();
        //when
        parkingManager.parking(firstCar);
        parkingManager.parking(secondCar);
        //then
        assertEquals("Parking failure.", parkingManager.getMessage());

    }

    @Test
    void should_return_error_message_when_manager_manage_parking_boy_to_fetch() throws Exception {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
        ParkingManager parkingManager = new ParkingManager(parkingBoy);
        CarTicket ticket = new CarTicket();
        //when
        parkingManager.fetch(ticket);
        //then
        assertEquals("Fetching failure.", parkingManager.getMessage());
    }
}
