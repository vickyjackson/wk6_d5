package RoomTest;

import Room.Restaurant;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class RestaurantTest {

    private Restaurant restaurant1;

    @Before
    public void before(){
        restaurant1 = new Restaurant(false, false);
    }

    public void canGetIsChargeable(){
        assertEquals(false, restaurant1.getIsChargeable());
    }

    public void canGetIsReserved(){
        assertEquals(false, restaurant1.getIsReserved());
    }

}
