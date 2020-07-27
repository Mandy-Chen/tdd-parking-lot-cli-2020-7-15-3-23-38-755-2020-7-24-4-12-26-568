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
        } else if (!hasCar(ticket)) {
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

    //todo
    @Override
    public int getAvailableNumber() {
        return 1;
    }

    @Override
    public boolean hasCar(CarTicket ticket) {
        Car car = (Car) parkingLots.stream().filter(parkingLot -> parkingLot.getParkingRooms().get(ticket) == null);
        return car.equals(null);
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
