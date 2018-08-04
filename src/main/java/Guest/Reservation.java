package Guest;

import Room.Room;

public class Reservation {

    private Party party;
    private Room room;

    public Reservation(Party party, Room room){
        this.party = party;
        this.room = room;
    }

    public Party getParty(){
        return this.party;
    }

    public Room getRoom(){
        return this.room;
    }
}
