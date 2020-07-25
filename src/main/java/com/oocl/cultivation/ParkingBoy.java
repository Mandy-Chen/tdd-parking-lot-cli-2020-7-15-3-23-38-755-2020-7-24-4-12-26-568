package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLot = new ArrayList<>();
    private String id;



    public void setId(String id) {
        this.id = id;
    }



    public void setParkingLot(List<ParkingLot> parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Car fetch(CarTicket ticket) {
        Car fetchedCar = null;
        if (ticket == null) {
            System.out.println("Please provide your parking ticket.");
            return null;
        } else if (!IsContainCar(ticket)) {
            System.out.println("Unrecognized parking ticket.");
            return null;
        } else {
            for (int i = 0; i < parkingLot.size(); i++) {
                if (parkingLot.get(i).getParkingRooms().get(ticket) != null) {
                    fetchedCar = parkingLot.get(i).getParkingRooms().remove(ticket);
                }
            }
            return fetchedCar;
        }
    }

    public CarTicket park(Car car) {
        if (id == "super smart parking boy") {
            int minParkingLotSub = 0;
            for (int i = 0; i < parkingLot.size(); i++) {
                if (parkingLot.get(i).getParkingRooms().size()*1000/parkingLot.get(i).getCapacity() <=parkingLot.get(minParkingLotSub).getParkingRooms().size()*1000/parkingLot.get(minParkingLotSub).getCapacity()) {
                    minParkingLotSub = i;
                }
            }
            CarTicket ticket = new CarTicket();
            System.out.println(parkingLot.get(minParkingLotSub).getId());
            parkingLot.get(minParkingLotSub).getParkingRooms().put(ticket, car);
            return ticket;
        }
        if (id == "smart parking boy") {
            int minParkingLotSub = 0;
            for (int i = 0; i < parkingLot.size(); i++) {
                if (parkingLot.get(i).getParkingRooms().size() <= parkingLot.get(minParkingLotSub).getParkingRooms().size()) {
                    minParkingLotSub = i;
                }
            }
            CarTicket ticket = new CarTicket();
            parkingLot.get(minParkingLotSub).getParkingRooms().put(ticket, car);
            return ticket;
        }
        for (int i = 0; i < parkingLot.size(); i++) {
            if (parkingLot.get(i).getParkingRooms().size() < parkingLot.get(i).getCapacity()) {
                CarTicket ticket = new CarTicket();
                parkingLot.get(i).getParkingRooms().put(ticket, car);
                return ticket;
            }
        }
        System.out.println("Not enough position.");
        return null;
    }

    public boolean IsContainCar(CarTicket ticket) {
        Boolean flag = false;
        for (int i = 0; i < parkingLot.size(); i++) {
            if (parkingLot.get(i).getParkingRooms().containsKey(ticket)) {
                flag = true;
            }
        }
        return flag;
    }
}
