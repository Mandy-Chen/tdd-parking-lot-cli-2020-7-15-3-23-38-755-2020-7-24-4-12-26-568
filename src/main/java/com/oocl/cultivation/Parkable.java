package com.oocl.cultivation;

import com.oocl.cultivation.exception.PleaseProvideTicketException;
import com.oocl.cultivation.exception.UnrecognizedTicketException;

public interface Parkable {
    CarTicket park(Car car);
    Car fetch(CarTicket ticket) ;
    int getAvailableNumber();
    boolean hasCar(CarTicket ticket);
}
