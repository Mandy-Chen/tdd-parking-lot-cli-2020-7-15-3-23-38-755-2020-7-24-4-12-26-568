package com.oocl.cultivation;



import java.util.HashMap;
import java.util.Map;

public class ParkingLot implements Parkable {
    private final int totalPlaceNum;
    private Map<CarTicket, Car> parkingRooms;
    private int capacity = 10;
    private String message;

    public ParkingLot(int totalPlaceNum) {
        this.totalPlaceNum = totalPlaceNum;
        this.parkingRooms = new HashMap<>();
    }

    public String getMessage() {
        return message;
    }

    public Map<CarTicket, Car> getParkingRooms() {
        return parkingRooms;
    }

    public int getCapacity() {
        return capacity;
    }


    @Override
    public CarTicket park(Car car) {
        if (getAvailableNumber() <= 0) {
            message="Not enough position.";
        }
        CarTicket ticket = new CarTicket();
        this.parkingRooms.put(ticket, car);
        return ticket;
    }

    @Override
    public Car fetch(CarTicket ticket){
        Car fetchedCar = null;
        if (ticket == null) {
            message="Please provide your parking ticket.";
        }
        fetchedCar = parkingRooms.remove(ticket);
        if (fetchedCar == null) {
            message="Unrecognized parking ticket.";
        }
//        else {
//            parkingRooms.remove(ticket);
//            for (int i = 0; i < parkingLots.size(); i++) {
//                if (parkingLots.get(i).getParkingRooms().get(ticket) != null) {
//                    fetchedCar = parkingLots.get(i).getParkingRooms().remove(ticket);
//                }
//            }
//            return fetchedCar;
//        }
        return fetchedCar;
    }

    @Override
    public int getAvailableNumber() {
        return this.totalPlaceNum - parkingRooms.size();
    }

    @Override
    public boolean hasCar(CarTicket ticket) {
        return parkingRooms.containsKey(ticket);
    }
}
