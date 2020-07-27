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



    @Override
    public CarTicket park(Car car) {
        if(getAvailableNumber()<=0){
            throw new IndexOutOfBoundsException("PNot enough position.");
        }
        CarTicket ticket=new CarTicket();
        this.parkingRooms.put(ticket,car);
        return ticket;
    }

    @Override
    public Car fetch(CarTicket ticket) {
//        if (ticket == null) {
//            throw new IndexOutOfBoundsException("Please provide your parking ticket.");
//        }
//        if (!hasCar(ticket)) {
//            throw new IndexOutOfBoundsException("Unrecognized parking ticket.");
//        }
//        else {
//            parkingRooms.remove(ticket);
////            for (int i = 0; i < parkingLots.size(); i++) {
////                if (parkingLots.get(i).getParkingRooms().get(ticket) != null) {
////                    fetchedCar = parkingLots.get(i).getParkingRooms().remove(ticket);
////                }
////            }
////            return fetchedCar;
//        }
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
