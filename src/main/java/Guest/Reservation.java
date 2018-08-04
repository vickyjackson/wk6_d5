package Guest;

import Room.Room;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Reservation {

    private ArrayList<Guest> party;
    private Room room;

    public Reservation(ArrayList<Guest> party, Room room){
        this.party = party;
        this.room = room;
    }

    public ArrayList<Guest> getparty(){
        return this.party;
    }

    public Room getRoom(){
        return this.room;
    }
}
