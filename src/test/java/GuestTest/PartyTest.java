package GuestTest;

import Guest.Guest;
import Guest.Party;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PartyTest {

    private Guest guest1;
    private Guest guest2;
    private Guest guest3;
    private Party party1;

    @Before
    public void before(){
        party1 = new Party();
        guest1 = new Guest("Spongebob", "Squarepants", 4365);
        guest2 = new Guest("Patrick", "Star", 9745);
        guest3 = new Guest("Squidward", "Tentacles", 2243);
    }

    @Test
    public void partyStartsEmpty(){
        assertEquals(0, party1.getParty().size());
    }

    @Test
    public void canAddGuest(){
        party1.addGuest(guest1);
        assertEquals(1, party1.getParty().size());
        assertEquals(guest1, party1.getParty().get(0));
    }

    @Test
    public void canAddMultipleGuests(){
        party1.addGuest(guest1);
        party1.addGuest(guest2);
        party1.addGuest(guest3);
        assertEquals(3, party1.getParty().size());
        assertEquals(guest1, party1.getParty().get(0));
        assertEquals(guest2, party1.getParty().get(1));
        assertEquals(guest3, party1.getParty().get(2));
    }

    @Test
    public void canRemoveGuest(){
        party1.addGuest(guest1);
        party1.addGuest(guest2);
        assertEquals(2, party1.getParty().size());
        party1.removeGuest(guest1);
        assertEquals(1, party1.getParty().size());
        assertEquals(guest2, party1.getParty().get(0));
    }

    @Test
    public void canRemoveAllGuests(){
        party1.addGuest(guest1);
        party1.addGuest(guest2);
        assertEquals(2, party1.getParty().size());
        party1.removeAllGuests();
        assertEquals(0, party1.getParty().size());
    }

}