package com.oocl.cultivation;


import java.util.HashMap;
import java.util.Map;

public class ParkingLot implements Parkable {
    private final int totalPlaceNum;
    private Map<CarTicket, Car> parkingRooms ;
    private int capacity = 10;

    public ParkingLot(int totalPlaceNum) {
        this.totalPlaceNum = totalPlaceNum;
        this.parkingRooms=new HashMap<>();
    }

    public Map<CarTicket, Car> getParkingRooms() {
        return parkingRooms;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String park(Car car) {
        if(this.parkingRooms.size()>=this.totalPlaceNum){
            throw new IndexOutOfBoundsException("Parking Rooms are full!");
        }
        CarTicket ticket=new CarTicket();
        this.parkingRooms.put(ticket,car);
        return null;
    }

    @Override
    public Car fetch(CarTicket ticket) {
        return parkingRooms.remove(ticket);
    }

    @Override
    public int getAvailableNumber() {
        return this.totalPlaceNum-parkingRooms.size();
    }

    @Override
    public boolean hasCar(CarTicket ticket) {
        return parkingRooms.containsKey(ticket);
    }
}
