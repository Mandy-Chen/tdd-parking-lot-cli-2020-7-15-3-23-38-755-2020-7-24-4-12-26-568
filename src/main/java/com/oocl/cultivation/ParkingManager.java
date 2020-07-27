package com.oocl.cultivation;

import java.util.Arrays;
import java.util.List;

public class ParkingManager {
    private final List<Parkable> parkables;

    public ParkingManager(Parkable... parkables) {
        this.parkables = Arrays.asList(parkables);
    }
    public  CarTicket parking(Car car){
        return parkables.stream().filter(this::isFull).findFirst().get().park(car);
    }

    private boolean isFull(Parkable parkable) {
        return parkable.getAvailableNumber()>0;
    }
    public Car  fetch(CarTicket ticket){
        return parkables.stream().filter(parkable -> parkable.hasCar(ticket)).findFirst().get().fetch(ticket);
    }
}
