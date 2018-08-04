import Guest.Guest;
import Room.*;

import java.util.ArrayList;

public class Hotel {

    private ArrayList rooms;

    public Hotel(){
        this.rooms = new ArrayList();
        populateRooms();
    }

    public ArrayList getRooms(){
        return this.rooms;
    }

    public void populateRooms(){
        for (int i = 1; i < 11; i++ ){
            this.rooms.add(new Bedroom(true, false, BedroomType.SINGLE, i, 70));
            this.rooms.add(new Bedroom(true, false,BedroomType.DOUBLE, 10 + i, 90));
        }
        this.rooms.add(new ConferenceRoom(true, false,"The Small One", 120));
        this.rooms.add(new ConferenceRoom(true, false,"The Big One", 150));
        this.rooms.add(new Restaurant(false, false));
    }

    public void addRoom(Room room){
        this.rooms.add(room);
    }
}
