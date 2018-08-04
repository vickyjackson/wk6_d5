import Guest.Guest;
import Guest.Party;
import Guest.Reservation;
import Room.Bedroom;
import Room.BedroomType;
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
    private Reservation reservation1;
    private Reservation reservation2;

    @Before
    public void before(){
        hotel1 = new Hotel();
        guest1 = new Guest("Spongebob", "Squarepants", 4365);
        guest2 = new Guest("Patrick", "Star", 9745);
        party1 = new Party();
        party2 = new Party();
        bedroom1 = new Bedroom(true, false, BedroomType.SINGLE, 1, 70);
        bedroom2 = new Bedroom(true, false, BedroomType.DOUBLE, 2, 90);
        reservation1 = new Reservation(party1, bedroom1);
        reservation2 = new Reservation(party2, bedroom2);
    }

    @Test
    public void roomsStartsPopulated(){
        assertEquals(23, hotel1.getRooms().size());
    }

    @Test
    public void canAddRoom(){
        hotel1.addRoom(bedroom1);
        assertEquals(24, hotel1.getRooms().size());
        assertEquals(bedroom1, hotel1.getRooms().get(23));
    }

    @Test
    public void canAddMultipleRooms(){
        hotel1.addRoom(bedroom1);
        hotel1.addRoom(bedroom2);
        assertEquals(25, hotel1.getRooms().size());
        assertEquals(bedroom1, hotel1.getRooms().get(23));
        assertEquals(bedroom2, hotel1.getRooms().get(24));
    }

    @Test
    public void reservationsStartsEmpty(){
        assertEquals(0, hotel1.getReservations().size());
    }

    @Test
    public void canCreateReservation(){
        party1.addGuest(guest1);
        party1.addGuest(guest2);
        hotel1.createReservation(reservation2);
        assertEquals(1, hotel1.getReservations().size());
        assertEquals(reservation2, hotel1.getReservations().get(0));
    }

    @Test
    public void roomIsReservedIfReservationWasCreated(){
        party1.addGuest(guest1);
        party1.addGuest(guest2);
        hotel1.createReservation(reservation2);
        assertEquals(true, reservation2.getRoom().getIsReserved());
    }

    @Test
    public void canFindReservation(){
        party2.addGuest(guest1);
        hotel1.createReservation(reservation2);
        assertEquals(reservation2, hotel1.findReservation(guest1));
    }

    @Test
    public void allCheckedInGuestsStartsEmpty(){
        assertEquals(0, hotel1.getAllCheckedInGuests().size());
    }

    @Test
    public void canCheckInGuest(){
        party1.addGuest(guest1);
        hotel1.createReservation(reservation1);
        hotel1.checkInGuest(guest1);
        assertEquals(1, hotel1.getAllCheckedInGuests().size());
        assertEquals(guest1, hotel1.getAllCheckedInGuests().get(0));
        assertEquals(1, bedroom1.getCheckedInGuests().size());
        assertEquals(guest1, bedroom1.getCheckedInGuests().get(0));
    }

    @Test
    public void canCheckInMultipleGuests(){
        party2.addGuest(guest1);
        party2.addGuest(guest2);
        hotel1.createReservation(reservation2);
        hotel1.checkInGuest(guest1);
        assertEquals(2, hotel1.getAllCheckedInGuests().size());
        assertEquals(guest1, hotel1.getAllCheckedInGuests().get(0));
        assertEquals(guest2, hotel1.getAllCheckedInGuests().get(1));
        assertEquals(2, bedroom2.getCheckedInGuests().size());
        assertEquals(guest1, bedroom2.getCheckedInGuests().get(0));
        assertEquals(guest2, bedroom2.getCheckedInGuests().get(1));
    }

    @Test
    public void canGetCheckedInGetsByRoom(){
        party2.addGuest(guest1);
        party2.addGuest(guest2);
        hotel1.createReservation(reservation2);
        hotel1.checkInGuest(guest1);
        assertEquals(2, bedroom2.getCheckedInGuests().size());
        assertEquals(guest1, bedroom2.getCheckedInGuests().get(0));
        assertEquals(guest2, bedroom2.getCheckedInGuests().get(1));
    }

    @Test
    public void cantCheckInGuestsWithoutReservation(){
        party2.addGuest(guest1);
        hotel1.checkInGuest(guest1);
        assertEquals(0, hotel1.getAllCheckedInGuests().size());
        assertEquals(0, bedroom1.getCheckedInGuests().size());
        assertEquals(0, bedroom2.getCheckedInGuests().size());
    }

    @Test
    public void canCheckOutGuest(){
        party1.addGuest(guest1);
        hotel1.createReservation(reservation1);
        hotel1.checkInGuest(guest1);
        assertEquals(1, hotel1.getAllCheckedInGuests().size());
        assertEquals(guest1, hotel1.getAllCheckedInGuests().get(0));

        hotel1.checkOutGuest(guest1);
        assertEquals(0, hotel1.getAllCheckedInGuests().size());
        assertEquals(0, bedroom1.getCheckedInGuests().size());
    }
}
