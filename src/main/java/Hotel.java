import Guest.Guest;
import Room.*;

import Guest.Reservation;

import java.util.ArrayList;

public class Hotel {

    private ArrayList<Room> rooms;
    private ArrayList<Reservation> reservations;
    private ArrayList<Guest> allCheckedInGuests;

    public Hotel(){
        this.rooms = new ArrayList<Room>();
        this.reservations = new ArrayList<Reservation>();
        this.allCheckedInGuests = new ArrayList<Guest>();
        populateRooms();
    }

    public ArrayList getRooms(){
        return this.rooms;
    }

    public void populateRooms(){
        for (int i = 1; i < 11; i++ ){
            this.rooms.add(new Bedroom(true, false, BedroomType.SINGLE, i, 70));
            this.rooms.add(new Bedroom(true, false,BedroomType.DOUBLE, 10 + i, 90));
        }
        this.rooms.add(new ConferenceRoom(true, false,"The Small One", 120));
        this.rooms.add(new ConferenceRoom(true, false,"The Big One", 150));
        this.rooms.add(new Restaurant(false, false));
    }

    public void addRoom(Room room){
        this.rooms.add(room);
    }

    public ArrayList<Reservation> getReservations(){
        return this.reservations;
    }

    public void createReservation(Reservation reservation){
        if (reservation.getRoom().getIsReserved() == true ){
            return;
        }
        else{
            this.reservations.add(reservation);
            reservation.getRoom().setIsReserved(true);
        }
    }

    public Reservation findReservation(Guest guestToFind) {
        for (Reservation reservation : reservations) {
            for (Guest guest : reservation.getParty().getGuests()) {
                if (guest == guestToFind) {
                    return reservation;
                }
            }
        }
        return null;
    }

    public void checkInGuest(Guest guestToCheckIn){
        Reservation foundReservation = findReservation(guestToCheckIn);
        if (foundReservation == null){
            return;
        }
        else{
            Room room = foundReservation.getRoom();
            for (Guest guest : foundReservation.getParty().getGuests()) {
                allCheckedInGuests.add(guest);
                room.getCheckedInGuests().add(guest);
            }
        }
    }

    public ArrayList<Guest> getAllCheckedInGuests(){
        return this.allCheckedInGuests;
    }

    public Guest findCheckedInGuest(Guest guestToFind){
        for (Guest guest : allCheckedInGuests){
            if (guest == guestToFind){
                return guest;
            }
        }
        return null;
    }

    public void checkOutGuest(Guest guestToCheckOut){
        Guest foundGuest = findCheckedInGuest(guestToCheckOut);
        Reservation foundReservation = findReservation(guestToCheckOut);
        if (foundGuest == null){
            return;
        }
        else if (foundGuest == guestToCheckOut){
            Room room = foundReservation.getRoom();
            allCheckedInGuests.remove(foundGuest);
            room.getCheckedInGuests().remove(foundGuest);
            room.setIsReserved(false);
        }
    }
}
