package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperSmartParkingBoyTest {

    @Test
    void should_park_lot_which_contains_more_empty_position_when_smart_park_given_super_smart_parking_boy() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(3);
        ParkingLot secondParkingLot = new ParkingLot(5);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(firstParkingLot, secondParkingLot);
        //when
        List<Car> cars = new ArrayList<>();
        List<CarTicket> tickets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Car car = new Car();
            cars.add(car);
            CarTicket ticket = superSmartParkingBoy.park(car);
            tickets.add(ticket);
        }
        //then
        assertEquals(cars.get(0), secondParkingLot.fetch(tickets.get(0)));
        assertEquals(cars.get(1), firstParkingLot.fetch(tickets.get(1)));
        assertEquals(cars.get(2), secondParkingLot.fetch(tickets.get(2)));
        assertEquals(cars.get(3), firstParkingLot.fetch(tickets.get(3)));
    }

}
