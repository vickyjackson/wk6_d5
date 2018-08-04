package Room;

import Guest.Guest;

import java.util.ArrayList;

public abstract class Room {

    private boolean isChargeable;
    private boolean isReserved;
    private ArrayList guests;

    public Room(boolean isChargeable, boolean isReserved) {
        this.isChargeable = isChargeable;
        this.isReserved = isReserved;
    }

    public boolean getIsChargeable(){
        return this.isChargeable;
    }

    public boolean getIsReserved(){
        return this.isReserved;
    }

    public ArrayList getGuests(){
        return this.guests;
    }

    public void addGuest(Guest guest){
        this.guests.add(guest);
    }
}
