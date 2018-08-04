package Room;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Hotel {

    private ArrayList rooms;

    public Hotel(){
        this.rooms = new ArrayList();
    }

    public ArrayList getRooms(){
        return this.rooms;
    }

    public void addRoom(Room room){
        this.rooms.add(room);
    }
}
