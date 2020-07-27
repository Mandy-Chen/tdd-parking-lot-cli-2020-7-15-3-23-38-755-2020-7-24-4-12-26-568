package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingBoy implements Parkable {
    private List<ParkingLot> parkingLot = new ArrayList<>();

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot= Arrays.asList(parkingLot);
    }

    public void setParkingLot(List<ParkingLot> parkingLot) {
        this.parkingLot = parkingLot;
    }
    public Car fetch(CarTicket ticket) {
        Car fetchedCar = null;
        if (ticket == null) {
            throw new IndexOutOfBoundsException("Please provide your parking ticket.");
        } else if (!IsContainCar(ticket)) {
            throw new IndexOutOfBoundsException("Unrecognized parking ticket.");
        } else {
            for (int i = 0; i < parkingLot.size(); i++) {
                if (parkingLot.get(i).getParkingRooms().get(ticket) != null) {
                    fetchedCar = parkingLot.get(i).getParkingRooms().remove(ticket);
                }
            }
            return fetchedCar;
        }
    }

    @Override
    public int getAvailableNumber() {
        return parkingLot.
        return 0;
    }

    @Override
    public boolean hasCar(CarTicket ticket) {
        return false;
    }

    //todo
    public CarTicket park(Car car) {
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


}
