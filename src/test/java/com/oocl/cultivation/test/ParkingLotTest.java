package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ParkingLotTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    public ByteArrayOutputStream out = null;
    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    private String systemOut() {
        return outContent.toString();
    }



    @Test
    void should_error_message_when_fetch_given_parking_boy_does_not_provide_ticket()  {
        //given
        CarTicket ticket = new CarTicket();
        //when
        ParkingLot parkingLot=new ParkingLot(1);
        //then
        assertThrows(Exception.class,()->{
            parkingLot.fetch(ticket);
        });
    }

    @Test
    void should_error_message_when_fetch_given_ticket_has_been_used() {
        //given
        ParkingLot parkingLot=new ParkingLot(1);
        Car car = new Car();
        CarTicket ticket = parkingLot.park(car);
        parkingLot.fetch(ticket);
        //when
        //then
        assertThrows(Exception.class,()->{
            parkingLot.fetch(ticket);
        });
    }

    @Test
    void should_error_message_when_fetch_given_customer_not_provide_ticket() {
        //given
        ParkingLot parkingLot =new ParkingLot(1);
        //when
        //then
        assertThrows(Exception.class,()->{
            parkingLot.fetch(null);
        });
    }

    @Test
    void should_error_message_when_park_no_position_given_car() {
        //given
        ParkingLot parkingLot=new ParkingLot(1);
        Car firstCar=new Car();
        Car secondCar=new Car();
        //when
        parkingLot.park(firstCar);
        //then
        assertThrows(Exception.class,()->{
            parkingLot.park(secondCar);
        });
    }

//    @Test
//    void should_in_order_when_park_given_two_parkingLot() {
//        //given
//        ParkingLot parkingLotA = new ParkingLot(totalPlaceNum, "A");
//        ParkingLot parkingLotB = new ParkingLot(totalPlaceNum, "B");
//        List<ParkingLot> parkingLots = new ArrayList<>();
//        parkingLots.add(parkingLotA);
//        parkingLots.add(parkingLotB);
//        List<Car> cars = new ArrayList<>();
//        for (int i = 0; i < 11; i++) {
//            Car car = new Car();
//            cars.add(car);
//        }
//        //when
//        ParkingBoy parkingBoy = new ParkingBoy();
//        parkingBoy.setParkingLots(parkingLots);
//        List<CarTicket> tickets = new ArrayList<>();
//        for (int i = 0; i < cars.size(); i++) {
//            CarTicket ticket = parkingBoy.park(cars.get(i));
//            tickets.add(ticket);
//        }
//        //then
////        for (int i = 0; i < 10; i++) {
////            assertEquals(cars.get(i),parkingLotA.getParkingRooms().get(tickets.get(i)));
////        }
//        assertEquals(cars.get(10),parkingLotB.getParkingRooms().get(tickets.get(10)));
//    }
//
//    @Test
//    void should_park_lot_which_contains_more_empty_position_when_park_given_smart_parking_boy() {
//        //given
//        ParkingBoy parkingBoy=new ParkingBoy();
//        parkingBoy.setId("smart parking boy");
//        ParkingLot parkingLotA = new ParkingLot(totalPlaceNum, "A");
//        ParkingLot parkingLotB = new ParkingLot(totalPlaceNum, "B");
//        List<ParkingLot> parkingLots = new ArrayList<>();
//        parkingLots.add(parkingLotA);
//        parkingLots.add(parkingLotB);
//        parkingBoy.setParkingLots(parkingLots);
//        //when
//        List<Car> cars=new ArrayList<>();
//        List<CarTicket> tickets=new ArrayList<>();
//        for (int i = 0; i < 4; i++) {
//            Car car=new Car();
//            cars.add(car);
//            CarTicket ticket=parkingBoy.park(car);
//            tickets.add(ticket);
//        }
//        //then
//        assertEquals(cars.get(0),parkingLotB.getParkingRooms().get(tickets.get(0)));
//        assertEquals(cars.get(1),parkingLotA.getParkingRooms().get(tickets.get(1)));
//        assertEquals(cars.get(2),parkingLotB.getParkingRooms().get(tickets.get(2)));
//        assertEquals(cars.get(3),parkingLotA.getParkingRooms().get(tickets.get(3)));
//    }
//
//    @Test
//    void should_park_lot_which_contains_more_empty_position_when_smart_park_given_super_smart_parking_boy() {
//        //given
//        ParkingBoy parkingBoy=new ParkingBoy();
//        parkingBoy.setId("super smart parking boy");
//        ParkingLot parkingLotA = new ParkingLot(totalPlaceNum, "A");
//        ParkingLot parkingLotB = new ParkingLot(totalPlaceNum, "B");
//        parkingLotA.setCapacity(10);
//        parkingLotB.setCapacity(20);
//        List<ParkingLot> parkingLots = new ArrayList<>();
//        parkingLots.add(parkingLotA);
//        parkingLots.add(parkingLotB);
//        parkingBoy.setParkingLots(parkingLots);
//        //when
//        List<Car> cars=new ArrayList<>();
//        List<CarTicket> tickets=new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            Car car=new Car();
//            cars.add(car);
//            CarTicket ticket=parkingBoy.park(car);
//            tickets.add(ticket);
//        }
//        //then
//        assertEquals(cars.get(0),parkingLotB.getParkingRooms().get(tickets.get(0)));
//        assertEquals(cars.get(1),parkingLotA.getParkingRooms().get(tickets.get(1)));
//        assertEquals(cars.get(2),parkingLotB.getParkingRooms().get(tickets.get(2)));
//        assertEquals(cars.get(3),parkingLotB.getParkingRooms().get(tickets.get(3)));
//        assertEquals(cars.get(4),parkingLotA.getParkingRooms().get(tickets.get(4)));
//    }
}
