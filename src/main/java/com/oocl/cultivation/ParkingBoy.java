package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingBoy implements Parkable {
    private List<ParkingLot> parkingLots = new ArrayList<>();

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLots = Arrays.asList(parkingLot);
    }

    public void setParkingLots(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }
    public Car fetch(CarTicket ticket) {
        Car fetchedCar = null;
        if (ticket == null) {
            throw new IndexOutOfBoundsException("Please provide your parking ticket.");
        } else if (!IsContainCar(ticket)) {
            throw new IndexOutOfBoundsException("Unrecognized parking ticket.");
        } else {
            for (int i = 0; i < parkingLots.size(); i++) {
                if (parkingLots.get(i).getParkingRooms().get(ticket) != null) {
                    fetchedCar = parkingLots.get(i).getParkingRooms().remove(ticket);
                }
            }
            return fetchedCar;
        }
    }

    @Override
    public int getAvailableNumber() {
//        return parkingLot.stream().filter(parkingLot1 -> )
        return 0;
    }

    @Override
    public boolean hasCar(CarTicket ticket) {
        return false;
    }

    //todo
    public CarTicket park(Car car) {
        for (int i = 0; i < parkingLots.size(); i++) {
            if (parkingLots.get(i).getParkingRooms().size() < parkingLots.get(i).getCapacity()) {
                CarTicket ticket = new CarTicket();
                parkingLots.get(i).getParkingRooms().put(ticket, car);
                return ticket;
            }
        }
        System.out.println("Not enough position.");
        return null;
    }


}
