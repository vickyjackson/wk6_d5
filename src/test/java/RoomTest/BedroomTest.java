package RoomTest;

import Room.Bedroom;
import Room.BedroomType;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    private Bedroom bedroom1;
    private Bedroom bedroom2;

    @Before
    public void before(){
        bedroom1 = new Bedroom(true, BedroomType.SINGLE, 1, 70);
        bedroom2 = new Bedroom(true, BedroomType.DOUBLE, 2, 90);
    }

    @Test
    public void canGetIsChargeable(){
        assertEquals(true, bedroom1.getIsChargeable());
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
}