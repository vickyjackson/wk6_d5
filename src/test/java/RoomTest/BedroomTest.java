package RoomTest;

import Guest.Guest;
import Room.Bedroom;
import Room.BedroomType;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    private Bedroom bedroom1;
    private Bedroom bedroom2;
    private Bedroom bedroom3;
    private Guest guest1;

    @Before
    public void before(){
        bedroom1 = new Bedroom(true, BedroomType.SINGLE, 1, 70);
        bedroom2 = new Bedroom(true, BedroomType.DOUBLE, 2, 90);
        bedroom3 = new Bedroom(true, BedroomType.TWIN, 3, 80);
        guest1 = new Guest("Spongebob", "Squarepants", 6587);
    }

    @Test
    public void guestsStartsEmpty(){
        assertEquals(0, bedroom1.getCheckedInGuests().size());
    }


    @Test
    public void canGetBedroomType(){
        assertEquals(BedroomType.SINGLE, bedroom1.getBedroomType());
    }

    @Test
    public void canGetBedroomCapacity(){
        assertEquals(1, bedroom1.getBedroomCapacity());
    }

    @Test
    public void canGetIsChargeable(){
        assertEquals(true, bedroom1.getIsChargeable());
    }

    @Test
    public void canGetIsReserved(){
        assertEquals(false, bedroom1.getIsReserved());
    }

    @Test
    public void canGetBedroomTypeSingle(){
        assertEquals( BedroomType.SINGLE, bedroom1.getBedroomType());
    }

    @Test
    public void canGetBedroomTypeDouble(){
        assertEquals( BedroomType.DOUBLE, bedroom2.getBedroomType());
    }

    @Test
    public void canGetRoomNumber(){
        assertEquals( 1, bedroom1.getRoomNumber());
    }

    @Test
    public void canGetNightlyRate(){
        assertEquals( 70, bedroom1.getNightlyRate());
    }

    @Test
    public void canAddGuest(){
        bedroom1.addGuest(guest1);
        assertEquals(1, bedroom1.getCheckedInGuests().size());
    }
}
