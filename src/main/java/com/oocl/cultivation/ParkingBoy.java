package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLot=new ArrayList<>();

    public List<ParkingLot> getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(List<ParkingLot> parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Car fetch(CarTicket ticket) {
        Car fetchedCar = null;
        if(ticket==null){
            System.out.println("Please provide your parking ticket.");
            return null;
        }else if (!IsContainCar(ticket)) {
            System.out.println("Unrecognized parking ticket.");
            return null;
        } else {
            for (int i = 0; i < parkingLot.size(); i++) {
                if (parkingLot.get(i).getParkingRooms().get(ticket)!=null){
                    fetchedCar=parkingLot.get(i).getParkingRooms().remove(ticket);
                }
            }
            return fetchedCar;
        }
    }

    public CarTicket park(Car car) {
        for (int i = 0; i < parkingLot.size(); i++) {
            if (parkingLot.get(i).getParkingRooms().size()<parkingLot.get(i).getCapacity()){
                CarTicket ticket = new CarTicket();
                parkingLot.get(i).getParkingRooms().put(ticket, car);
                return ticket;
            }
        }
        System.out.println("Not enough position.");
        return null;
    }
    public boolean IsContainCar(CarTicket ticket){
        Boolean flag=false;
        for (int i = 0; i < parkingLot.size(); i++) {
            if(parkingLot.get(i).getParkingRooms().containsKey(ticket)){
                flag =true;
            }
        }
        return flag;
    }
}
