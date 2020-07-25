package com.oocl.cultivation;


import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<CarTicket, Car> parkingRooms = new HashMap<>();
    private int capacity = 10;
    private String id;

    public ParkingLot(String id) {
        this.id=id;
    }

    public Map<CarTicket, Car> getParkingRooms() {
        return parkingRooms;
    }

    public void setParkingRooms(Map<CarTicket, Car> parkingRooms) {
        this.parkingRooms = parkingRooms;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
