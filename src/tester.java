import api.HotelResource;
import model.Customer;
import model.IRoom;
import model.Room;
import model.RoomType;
import service.CustomerService;
import service.ReservationService;

import java.util.Calendar;
import java.util.Date;

import static service.ReservationService.totalReservations;

public class tester {
    public static void main(String[] args) {
//
        //====================Testing CustomerService class methods=============================
        Customer juan = new Customer("juan", "arrospide", "juan@email.com");
        Customer paz = new Customer("Paz", "arrospide", "paz@email.com");
        CustomerService.addCustomer(juan.getEmail(), juan.getFirstName(), juan.getLastName());
        CustomerService.addCustomer("flo@email.com", "flo", "medina");
        //System.out.println(CustomerService.getAllCustomers());
        //System.out.println(CustomerService.getCustomer("flo@email.com"));


        //====================Testing ReservationService class methods=============================
        IRoom room1 = new Room("101",100.0, RoomType.SINGLE);
        IRoom room2 = new Room("102",100.0, RoomType.DOUBLE);
        ReservationService.addRoom(room1);
        ReservationService.addRoom(room2);
        //System.out.println(ReservationService.rooms);
        //System.out.println(ReservationService.getRoom("102"));

        //System.out.println(ReservationService.reserveARoom(juan, room1, new Date(2023-01-12), new Date(2023-01-15)));
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2023, 02, 20);
        Date date1In = calendar1.getTime();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2023, 02, 24);
        Date date1Out = calendar2.getTime();

        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(2024, 03, 05);
        Date date2In = calendar3.getTime();
        Calendar calendar4 = Calendar.getInstance();
        calendar4.set(2024, 04, 10);
        Date date2Out = calendar4.getTime();

        ReservationService.reserveARoom(juan, room1, date1In, date1Out);
        ReservationService.reserveARoom(paz, room2, date1In, date1Out);
        //ReservationService.reserveARoom(paz, room1, date2In, date2Out);
        //System.out.println(ReservationService.reservations);
        //System.out.println(ReservationService.getAllReservations());
        //System.out.println(ReservationService.rooms);

        //System.out.println(ReservationService.findRooms(date2In,date2Out));

        //ReservationService.printAllReservation();
        //System.out.println(ReservationService.getCustomersReservation(paz));
        //System.out.println(ReservationService.reservations);
        //System.out.println(totalReservations);

        //HotelResource.createACustomer("flor@email.com", "flor", "medina");
        //System.out.println(HotelResource.getCustomer("flor@email.com"));

        //System.out.println(HotelResource.findARoom(date2In, date2Out));
        System.out.println(ReservationService.findRooms(date2In, date2Out));
    }
}
