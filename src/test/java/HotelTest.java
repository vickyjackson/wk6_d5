import Room.Bedroom;
import Room.BedroomType;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    private Hotel hotel1;
    private Bedroom bedroom1;
    private Bedroom bedroom2;

    @Before
    public void before(){
        hotel1 = new Hotel();
        bedroom1 = new Bedroom(true, false, BedroomType.SINGLE, 1, 70);
        bedroom2 = new Bedroom(true, false, BedroomType.DOUBLE, 2, 90);
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
}
