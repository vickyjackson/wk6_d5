import Guest.Guest;
import Room.*;

import Guest.Reservation;
import Guest.Party;

import java.util.ArrayList;

public class Hotel {

    private ArrayList<Room> allRooms;
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private ArrayList<Restaurant> restaurants;
    private ArrayList<Reservation> reservations;
    private ArrayList<Guest> allCheckedInGuests;

    public Hotel(){
        this.allRooms = new ArrayList<Room>();
        this.bedrooms = new ArrayList<Bedroom>();
        this.conferenceRooms = new ArrayList<ConferenceRoom>();
        this.restaurants = new ArrayList<Restaurant>();
        this.reservations = new ArrayList<Reservation>();
        this.allCheckedInGuests = new ArrayList<Guest>();
        populateRooms();
    }

    public ArrayList getAllRooms(){
        this.allRooms.addAll(bedrooms);
        this.allRooms.addAll(conferenceRooms);
        this.allRooms.addAll(restaurants);
        return this.allRooms;
    }

    public ArrayList getBedrooms(){
        return this.bedrooms;
    }

    public ArrayList getConferenceRooms(){
        return this.conferenceRooms;
    }

    public ArrayList getRestaurants(){
        return this.restaurants;
    }

    public void populateRooms(){
        for (int i = 1; i < 11; i++ ){

            this.bedrooms.add(new Bedroom(true, BedroomType.SINGLE, i, 70));
            this.bedrooms.add(new Bedroom(true,BedroomType.DOUBLE, 10 + i, 90));
        }
        this.conferenceRooms.add(new ConferenceRoom(true,"Squidward's House", 120));
        this.conferenceRooms.add(new ConferenceRoom(true,"Pineapple Under the Sea", 150));
        this.restaurants.add(new Restaurant( false));
    }

    public void addRoom(Bedroom room){
        this.bedrooms.add(room);
    }

    public void addRoom(ConferenceRoom room){
        this.conferenceRooms.add(room);
    }

    public void addRoom(Restaurant room){
        this.restaurants.add(room);
    }

    public ArrayList<Reservation> getReservations(){
        return this.reservations;
    }

    public void createReservation(Party party, BedroomType bedroomType) {
        if (getAvailableBedrooms(bedroomType).size() > 0) {
            Bedroom selectedBedroom = getAvailableBedrooms(bedroomType).get(0);
            selectedBedroom.setIsReserved(true);
            Reservation newReservation = new Reservation(party, selectedBedroom) ;
            this.reservations.add(newReservation);
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

    public ArrayList<Bedroom> getAvailableBedrooms(BedroomType bedroomType){
        ArrayList availableBedrooms = new ArrayList<Bedroom>();
        for (Bedroom room : bedrooms){
            if (room.getIsReserved() == false){
                if (room.getBedroomType() == bedroomType){
                    availableBedrooms.add(room);
                }
            }
        }
        return availableBedrooms;
    }
}
