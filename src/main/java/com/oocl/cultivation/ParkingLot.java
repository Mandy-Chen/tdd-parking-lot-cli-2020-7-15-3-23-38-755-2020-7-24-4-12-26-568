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

    public String getId() {
        return id;
    }



    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
