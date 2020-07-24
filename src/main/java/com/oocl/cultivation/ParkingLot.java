package com.oocl.cultivation;



import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<CarTicket, Car> parkingRooms = new HashMap<>();

    public Car fetch(CarTicket ticket) {
        System.out.println(parkingRooms);
        return parkingRooms.get(ticket);
    }

    public CarTicket park(Car car) {
        CarTicket ticket=new CarTicket();
        parkingRooms.put(ticket,car);
        return ticket;
    }
}
