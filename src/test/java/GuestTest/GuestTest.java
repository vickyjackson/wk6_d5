package GuestTest;

import Guest.Guest;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class GuestTest {

    private Guest guest1;

    @Before
    public void before(){
        guest1 = new Guest("Jemima", "Puddleduck", 3554);
    }

    @Test
    public void canGetFirstName(){
        assertEquals("Jemima", guest1.getFirstName());
    }

    @Test
    public void canGetLastName(){
        assertEquals("Puddleduck", guest1.getLastName());
    }

    @Test
    public void canGetCardNumberEndingIn(){
        assertEquals(3554, guest1.getCardNumberEndingIn());
    }


}
