package model;

import java.util.Date;

public class Reservation {
    private Customer customer;
    private IRoom room;
    public Date checkInDate;
    public Date checkOutDate;

    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public IRoom getRoom() {
        return room;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    //    public IRoom getRoomFromReservation(Reservation reservation) {
//        return room;
//    }

    @Override
    public String toString() {
        return "Customer: \n" + customer + "\n" +
                "Room: \n" + room + "\n" +
                "Check In: " + checkInDate + "\n" +
                "Check Out: " + checkOutDate + "\n";
    }

}
