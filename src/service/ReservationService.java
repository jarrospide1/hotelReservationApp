package service;

import model.*;

import java.util.*;

public class ReservationService {

    private static ReservationService single_instance;

    // private constructor to avoid client applications using the constructor
    private ReservationService() {}
    //Static method for obtaining the instance
    public static ReservationService getInstance() {
        if(single_instance == null) {
            single_instance = new ReservationService();
        }
        return single_instance;
    }

    //Create new hashmap to store all the rooms
    public static Map<String, IRoom> rooms = new HashMap<String, IRoom>();
    //Create new hashmap to store all the reservations
    public static Map<String, Collection<Reservation>> reservations = new HashMap<String, Collection<Reservation>>();

    public static void addRoom(IRoom room) {
        if(rooms.containsKey(room.getRoomNumber())) {
            throw new IllegalArgumentException("This room number already exists");
        } else {
            rooms.put(room.getRoomNumber(), room);
        }
    }

    public static Map<String, IRoom> getAllRooms() {
        return rooms;
    }
    public static IRoom getRoom(String roomId) {
        if(rooms.containsKey(roomId)) {
            return rooms.get(roomId);
        } else {
            return null;
        }
    }
    public static Collection<Reservation> totalReservations = null;

    public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Collection<Reservation> listOfCustomerReservations = getCustomersReservation(customer);

        if(listOfCustomerReservations == null) {
            listOfCustomerReservations = new LinkedList<>();
        }
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        listOfCustomerReservations.add(reservation);
        reservations.put(customer.getEmail(), listOfCustomerReservations);
        return reservation;
    }

    public static Collection<Reservation> getCustomersReservation(Customer customer) {
        return reservations.get(customer.getEmail());
    }

    public static Collection<Reservation> getAllReservations() {
        //iterar por el hash y sumar los valores a un linklist de reservas
        if(null == totalReservations) {
            totalReservations = new ArrayList<Reservation>();
        }
        reservations.forEach((key, value) -> {
            totalReservations.addAll(value);
            //System.out.println(totalReservations);
        });
        return totalReservations;
    }
    //=======================================================================================
    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        Map<String, IRoom> availableRooms = new HashMap<>(rooms);
        //availableRooms = getAllRooms();

        Collection<Reservation> totalReservations = getAllReservations();
        //Tengo que encontrar por que available rooms no se copia
        //System.out.println(availableRooms);

        totalReservations.forEach((eachReservation) -> {
//            if (checkInDate.before(eachReservation.checkInDate) && checkOutDate.after(eachReservation.checkInDate) ||
//                    checkInDate.before(eachReservation.checkOutDate) && checkOutDate.after(eachReservation.checkOutDate)) {
//                            availableRooms.remove(eachReservation.getRoom().getRoomNumber());
//            }
            if((checkInDate.before(eachReservation.getCheckInDate()) || checkInDate.compareTo(eachReservation.getCheckOutDate()) >= 0)
                && (checkOutDate.compareTo(eachReservation.getCheckInDate()) <= 0 || checkOutDate.after(eachReservation.getCheckOutDate())) ) {
                    availableRooms.remove(eachReservation.getRoom().getRoomNumber());
            }
        });


        //return new ArrayList<>(availableRooms.values());
        return availableRooms.values();


//        Collection<Reservation> totalReservations = getAllReservations();

//        totalReservations.forEach((reservation) -> {
//            if(checkOutDate.before(reservation.checkInDate) == true && checkInDate.before(checkOutDate) == true ||
//               checkInDate.after(reservation.checkOutDate) == true && checkInDate.before(checkOutDate) == true) {
//               availableRooms.add(reservation.getRoomFromReservation(reservation));
//           }
//        });
//        return availableRooms;
    }
    //Esto me tiene que dar un available room si se cumple la condicion
    public static Reservation checkDateRangeAvailability(Reservation reservation, Date checkIn, Date checkOut){
        if(checkOut.before(reservation.checkInDate) && checkIn.before(checkOut) ||
        checkIn.after(reservation.checkOutDate) && checkIn.before(checkOut)) {
            return reservation;
        } else {
            return null;
        }
    }
    //=======================================================================================

    public static void printAllReservation() {
        reservations.forEach((key, value) -> {
            System.out.println("\n" + value);
        });
    }
}



