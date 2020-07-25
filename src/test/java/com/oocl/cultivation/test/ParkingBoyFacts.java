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
    void should_park_lot_which_contains_more_empty_position_when_smart_park_given_smart_parking_boy() {
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
}
