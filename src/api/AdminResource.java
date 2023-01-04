package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AdminResource {
    private static AdminResource single_instance;

    private AdminResource() {};

    public static AdminResource getInstance() {
        if(single_instance == null) {
            single_instance = new AdminResource();
        }
        return single_instance;
    }

    private CustomerService customerService = CustomerService.getInstance();
    private ReservationService reservationService = ReservationService.getInstance();

    public Customer getCustomer(String email) {
        return CustomerService.getCustomer(email);
    }

    public void addRoom(List<IRoom> rooms) {
        for(IRoom room: rooms) {
            reservationService.addRoom(room);
        }
    }
    public Collection<IRoom> getAllRooms() {
        Map<String, IRoom> mapOfRooms = ReservationService.getAllRooms();
        List<IRoom> allRooms = new LinkedList<>(mapOfRooms.values());
        return allRooms;
    }
    public Collection<Customer> getAllCustomers() {
        List<Customer> listOfCustomers = new LinkedList<>(CustomerService.getAllCustomers());
        return listOfCustomers;
    }
    public void displayAllReservations() {
        List<Reservation> listOfReservations = new LinkedList<>(ReservationService.getAllReservations());
        System.out.println(listOfReservations);
    }
}


