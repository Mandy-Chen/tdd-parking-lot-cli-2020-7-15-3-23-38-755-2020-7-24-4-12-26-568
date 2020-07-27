package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuperSmartParkingBoy implements Parkable {
    private List<ParkingLot> parkingLot = new ArrayList<>();

    public SuperSmartParkingBoy(ParkingLot parkingLot) {
        this.parkingLot= Arrays.asList(parkingLot);
    }

    @Override
    public CarTicket park(Car car) {
            int minParkingLotSub = 0;
            for (int i = 0; i < parkingLot.size(); i++) {
                if (parkingLot.get(i).getParkingRooms().size() * 1000 / parkingLot.get(i).getCapacity() <= parkingLot.get(minParkingLotSub).getParkingRooms().size() * 1000 / parkingLot.get(minParkingLotSub).getCapacity()) {
                    minParkingLotSub = i;
                }
            }
            CarTicket ticket = new CarTicket();
            parkingLot.get(minParkingLotSub).getParkingRooms().put(ticket, car);
            return ticket;
    }

    @Override
    public Car fetch(CarTicket ticket) {
        return null;
    }

    @Override
    public int getAvailableNumber() {
        return 0;
    }

    @Override
    public boolean hasCar(CarTicket ticket) {
        return false;
    }
}
