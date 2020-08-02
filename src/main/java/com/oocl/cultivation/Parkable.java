package com.oocl.cultivation;

public interface Parkable {
    CarTicket park(Car car);
    Car fetch(CarTicket ticket) ;
    int getAvailableNumber();
    boolean hasCar(CarTicket ticket);
}
