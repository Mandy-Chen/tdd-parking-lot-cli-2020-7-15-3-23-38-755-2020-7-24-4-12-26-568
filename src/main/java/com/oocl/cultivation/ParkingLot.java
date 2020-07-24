package com.oocl.cultivation;


import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<CarTicket, Car> parkingRooms = new HashMap<>();
    private int capacity = 10;

    public Car fetch(CarTicket ticket) {
        if (ticket==null || !parkingRooms.containsKey(ticket)) {
            System.out.println("Unrecognized parking ticket.");
            return null;
        } else {
            return parkingRooms.remove(ticket);

        }
    }

    public CarTicket park(Car car) {
        if (parkingRooms.size() < capacity) {
            CarTicket ticket = new CarTicket();
            parkingRooms.put(ticket, car);
            return ticket;
        } else {
            return null;
        }
    }
}
