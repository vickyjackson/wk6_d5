package RoomTest;

import Room.BedroomType;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class BedroomTypeTest {

    BedroomType bedroomType1;

    @Before
    public void before(){
        bedroomType1 = BedroomType.SINGLE;
    }

    @Test
    public void canGetCapacity(){
        assertEquals(1, bedroomType1.getCapacity());
    }
}
