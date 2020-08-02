package com.oocl.cultivation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingBoy implements Parkable {
    private List<ParkingLot> parkingLots = new ArrayList<>();

    public ParkingBoy(ParkingLot... parkingLot) {
        this.parkingLots = Arrays.asList(parkingLot);
    }

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
            if(parkingLots.get(i).getParkingRooms().get(ticket)!=null){
                return true;
            }
        }
        return false;
    }

    public CarTicket park(Car car) {
        if(getAvailableNumber()>0){
            return parkingLots.stream().filter(parkingLot -> parkingLot.getAvailableNumber() > 0).findFirst().get().park(car);
        }
        return null ;
    }
    public  String getMessage(){
        return parkingLots.stream().filter(parkingLot -> parkingLot.getMessage().length()>0).findFirst().get().getMessage();
    }


}
