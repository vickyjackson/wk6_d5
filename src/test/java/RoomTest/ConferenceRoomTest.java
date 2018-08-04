package RoomTest;

import Room.ConferenceRoom;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {

    private ConferenceRoom conferenceRoom1;

    @Before
    public void before(){
        conferenceRoom1 = new ConferenceRoom(true,"Room1", 300.00);
    }

    @Test
    public void canGetIsChargeable(){
        assertEquals(true, conferenceRoom1.getIsChargeable());
    }

    @Test
    public void canGetName(){
        assertEquals("Room1", conferenceRoom1.getName());
    }

    @Test
    public void canGetDailyRate(){
        assertEquals(300.00, conferenceRoom1.getDailyRate(), 0.0);
    }
}
