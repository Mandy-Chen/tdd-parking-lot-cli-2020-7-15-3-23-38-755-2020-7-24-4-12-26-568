package com.oocl.cultivation;

public interface Parkable {
    String park(Car car);
    Car fetch(String ticket);
    int getAvailableNumber();
    boolean hasCar(String ticket);
}
