package com.oocl.cultivation;

public interface Parkable {
    String park(Car car);
    Car fetch(String ticket);
    int getAvaliableNumber();
    boolean hasCar(String ticket);
}
