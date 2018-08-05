package GuestTest;

import Guest.Party;
import Guest.Reservation;
import Room.Bedroom;
import Room.BedroomType;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class ReservationTest {

    private Party party1;
    private Bedroom bedroom1;
    private Reservation reservation1;

    @Before
    public void before(){
        party1 = new Party();
        bedroom1 = new Bedroom(true, BedroomType.SINGLE, 1, 70);
        reservation1 = new Reservation(party1, bedroom1);
    }

    @Test
    public void canGetParty(){
        assertEquals(party1, reservation1.getParty());
    }

    @Test
    public void canGetRoom(){
        assertEquals(bedroom1, reservation1.getRoom());
    }
}
