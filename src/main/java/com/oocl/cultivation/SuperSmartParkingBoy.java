package com.oocl.cultivation;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuperSmartParkingBoy implements Parkable {

    private List<ParkingLot> parkingLots = new ArrayList<>();
    public SuperSmartParkingBoy(ParkingLot... parkingLot) {
        this.parkingLots = Arrays.asList(parkingLot);
    }


    @Override
    public CarTicket park(Car car) {
            int minParkingLotSub = 0;
            for (int i = 0; i < parkingLots.size(); i++) {
                if (parkingLots.get(i).getParkingRooms().size() * 1000 / parkingLots.get(i).getCapacity() <= parkingLots.get(minParkingLotSub).getParkingRooms().size() * 1000 / parkingLots.get(minParkingLotSub).getCapacity()) {
                    minParkingLotSub = i;
                }
            }
            CarTicket ticket = new CarTicket();
        parkingLots.get(minParkingLotSub).getParkingRooms().put(ticket, car);
            return ticket;
    }

    @Override
    public Car fetch(CarTicket ticket) {
        Car fetchedCar = null;
        for (int i = 0; i < parkingLots.size(); i++) {
            fetchedCar=parkingLots.get(i).fetch(ticket);
        }
        return fetchedCar;
    }

    @Override
    public int getAvailableNumber() {
        int getAllAvailableNumber = 0;
        for (int i = 0; i < parkingLots.size(); i++) {
            if (parkingLots.get(i).getAvailableNumber() > 0) {
                getAllAvailableNumber += parkingLots.get(i).getAvailableNumber();
            }
        }
        return getAllAvailableNumber;
    }

    @Override
    public boolean hasCar(CarTicket ticket) {
        for (int i = 0; i < parkingLots.size(); i++) {
            if (parkingLots.get(i).getParkingRooms().get(ticket) != null) {
                return true;
            }
        }
        return false;
    }
}
