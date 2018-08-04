import Room.Bedroom;
import Room.BedroomType;
import Room.Hotel;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    private Hotel hotel1;
    private Bedroom bedroom1;
    private Bedroom bedroom2;

    @Before
    public void before(){
        hotel1 = new Hotel();
        bedroom1 = new Bedroom(true, BedroomType.SINGLE, 1, 70);
        bedroom2 = new Bedroom(true, BedroomType.DOUBLE, 2, 90);
    }

    @Test
    public void roomsStartsEmpty(){
        assertEquals(0, hotel1.getRooms().size());
    }

    @Test
    public void canAddRoom(){
        hotel1.addRoom(bedroom1);
        assertEquals(1, hotel1.getRooms().size());
        assertEquals(bedroom1, hotel1.getRooms().get(0));
    }

    @Test
    public void canAddMultipleRooms(){
        hotel1.addRoom(bedroom1);
        hotel1.addRoom(bedroom2);
        assertEquals(2, hotel1.getRooms().size());
        assertEquals(bedroom1, hotel1.getRooms().get(0));
        assertEquals(bedroom2, hotel1.getRooms().get(1));
    }
}
