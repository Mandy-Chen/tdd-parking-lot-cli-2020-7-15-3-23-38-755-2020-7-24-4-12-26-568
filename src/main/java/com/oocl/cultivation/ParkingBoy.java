package com.oocl.cultivation;

public class ParkingBoy {
    ParkingLot parkingLot=new ParkingLot();
    public Car fetch(CarTicket ticket) {
        if (ticket==null || !parkingLot.getParkingRooms().containsKey(ticket)) {
            System.out.println("Unrecognized parking ticket.");
            return null;
        } else {
            return parkingLot.getParkingRooms().remove(ticket);

        }
    }

    public CarTicket park(Car car) {
        if (parkingLot.getParkingRooms().size() < parkingLot.getCapacity()) {
            CarTicket ticket = new CarTicket();
            parkingLot.getParkingRooms().put(ticket, car);
            return ticket;
        } else {
            return null;
        }
    }
}
