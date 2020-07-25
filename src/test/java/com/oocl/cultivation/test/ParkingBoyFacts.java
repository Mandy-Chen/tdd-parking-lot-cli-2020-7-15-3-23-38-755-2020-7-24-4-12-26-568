package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkingBoyFacts {
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
        for (int i = 0; i < 10; i++) {
            assertEquals(cars.get(i),parkingLotA.getParkingRooms().get(tickets.get(i)));
        }
        assertEquals(cars.get(10),parkingLotB.getParkingRooms().get(tickets.get(10)));
    }
}
