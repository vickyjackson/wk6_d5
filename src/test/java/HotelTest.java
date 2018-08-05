import Guest.Guest;
import Guest.Party;
import Guest.Reservation;
import Room.Bedroom;
import Room.BedroomType;
import Room.ConferenceRoom;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    private Hotel hotel1;
    private Guest guest1;
    private Guest guest2;
    private Party party1;
    private Party party2;
    private Bedroom bedroom1;
    private Bedroom bedroom2;
    private ConferenceRoom conferenceroom1;

    @Before
    public void before(){
        hotel1 = new Hotel();
        guest1 = new Guest("Spongebob", "Squarepants", 4365);
        guest2 = new Guest("Patrick", "Star", 9745);
        party1 = new Party();
        party2 = new Party();
        bedroom1 = new Bedroom(true, BedroomType.SINGLE, 1, 70);
        bedroom2 = new Bedroom(true, BedroomType.DOUBLE, 2, 90);
        conferenceroom1 = new ConferenceRoom(false,"Test", 100);
    }

    @Test
    public void roomsStartsPopulated(){
        assertEquals(20, hotel1.getBedrooms().size());
        assertEquals(2, hotel1.getConferenceRooms().size());
        assertEquals(1, hotel1.getRestaurants().size());
    }

    @Test
    public void canAddBedroom(){
        hotel1.addRoom(bedroom1);
        assertEquals(21, hotel1.getBedrooms().size());
        assertEquals(bedroom1, hotel1.getBedrooms().get(20));
    }

    @Test
    public void canAddMultipleRooms(){
        hotel1.addRoom(bedroom1);
        hotel1.addRoom(bedroom2);
        assertEquals(22, hotel1.getBedrooms().size());
        assertEquals(bedroom1, hotel1.getBedrooms().get(20));
        assertEquals(bedroom2, hotel1.getBedrooms().get(21));
    }

    @Test
    public void reservationsStartsEmpty(){
        assertEquals(0, hotel1.getReservations().size());
    }

    @Test
    public void canCreateReservation(){
        party1.addGuest(guest1);
        party1.addGuest(guest2);
        hotel1.createReservation(party1, BedroomType.DOUBLE);
        assertEquals(1, hotel1.getReservations().size());
    }

    @Test
    public void canGetAvailableSingleBedrooms(){
        party1.addGuest(guest1);
        hotel1.createReservation(party1, BedroomType.SINGLE);
        assertEquals(1, hotel1.getReservations().size());
        assertEquals(9, hotel1.getAvailableBedrooms(BedroomType.SINGLE).size());
    }

    @Test
    public void canGetAvailableDoubleBedrooms(){
        party1.addGuest(guest1);
        party1.addGuest(guest2);
        hotel1.createReservation(party1, BedroomType.DOUBLE);
        assertEquals(1, hotel1.getReservations().size());
        assertEquals(9, hotel1.getAvailableBedrooms(BedroomType.DOUBLE).size());
    }

    @Test
    public void roomIsReservedIfReservationWasCreated(){
        party1.addGuest(guest1);
        party1.addGuest(guest2);
        hotel1.createReservation(party1, BedroomType.DOUBLE);
        assertEquals(true, hotel1.getReservations().get(0).getRoom().getIsReserved());
    }

    @Test
    public void canFindReservation(){
        party2.addGuest(guest1);
        hotel1.createReservation(party2, BedroomType.SINGLE);
        Reservation reservation = hotel1.findReservation(guest1);
        assertEquals(guest1, reservation.getParty().getGuests().get(0));
    }

    @Test
    public void allCheckedInGuestsStartsEmpty(){
        assertEquals(0, hotel1.getAllCheckedInGuests().size());
    }

    @Test
    public void canCheckInGuest(){
        party1.addGuest(guest1);
        hotel1.createReservation(party1, BedroomType.SINGLE);
        hotel1.checkInGuest(guest1);
        assertEquals(1, hotel1.getAllCheckedInGuests().size());
        assertEquals(guest1, hotel1.getAllCheckedInGuests().get(0));
        assertEquals(1, hotel1.findReservation(guest1).getRoom().getCheckedInGuests().size());
        assertEquals(guest1, hotel1.findReservation(guest1).getRoom().getCheckedInGuests().get(0));
    }

    @Test
    public void canCheckInMultipleGuests(){
        party2.addGuest(guest1);
        party2.addGuest(guest2);
        hotel1.createReservation(party2, BedroomType.DOUBLE);
        hotel1.checkInGuest(guest1);
        assertEquals(2, hotel1.getAllCheckedInGuests().size());
        assertEquals(guest1, hotel1.getAllCheckedInGuests().get(0));
        assertEquals(guest2, hotel1.getAllCheckedInGuests().get(1));
        assertEquals(2, hotel1.findReservation(guest1).getRoom().getCheckedInGuests().size());
        assertEquals(guest1, hotel1.findReservation(guest1).getRoom().getCheckedInGuests().get(0));
        assertEquals(guest2, hotel1.findReservation(guest1).getRoom().getCheckedInGuests().get(1));
    }

    @Test
    public void canGetCheckedInGetsByRoom(){
        party2.addGuest(guest1);
        party2.addGuest(guest2);
        hotel1.createReservation(party2, BedroomType.DOUBLE);
        hotel1.checkInGuest(guest1);
        assertEquals(2, hotel1.findReservation(guest1).getRoom().getCheckedInGuests().size());
        assertEquals(guest1, hotel1.findReservation(guest1).getRoom().getCheckedInGuests().get(0));
        assertEquals(guest2, hotel1.findReservation(guest1).getRoom().getCheckedInGuests().get(1));
    }

    @Test
    public void cantCheckInGuestsWithoutReservation(){
        party2.addGuest(guest1);
        hotel1.checkInGuest(guest1);
        assertEquals(0, hotel1.getAllCheckedInGuests().size());
    }

    @Test
    public void canCheckOutGuest(){
        party1.addGuest(guest1);
        hotel1.createReservation(party1, BedroomType.SINGLE);
        hotel1.checkInGuest(guest1);
        assertEquals(1, hotel1.getAllCheckedInGuests().size());
        assertEquals(guest1, hotel1.getAllCheckedInGuests().get(0));

        hotel1.checkOutGuest(guest1);
        assertEquals(0, hotel1.getAllCheckedInGuests().size());
        assertEquals(0, hotel1.findReservation(guest1).getRoom().getCheckedInGuests().size());
    }

    @Test
    public void roomIsNotReservedIfEveryoneIsCheckedOut(){
        party1.addGuest(guest1);
        hotel1.createReservation(party1, BedroomType.SINGLE);
        hotel1.checkInGuest(guest1);
        hotel1.checkOutGuest(guest1);
        assertEquals(false, hotel1.findReservation(guest1).getRoom().getIsReserved());
    }
}
