package com.oocl.cultivation;

public interface Parkable {
    String park(Car car);
    Car fetch(CarTicket ticket);
    int getAvailableNumber();
    boolean hasCar(CarTicket ticket);
}
