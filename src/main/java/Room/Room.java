package Room;

import Guest.Guest;

import java.util.ArrayList;

public abstract class Room {

    private boolean isChargeable;
    private boolean isReserved;
    private ArrayList checkedInGuests;

    public Room(boolean isChargeable) {
        this.isChargeable = isChargeable;
        this.isReserved = false;
        this.checkedInGuests = new ArrayList();
    }

    public boolean getIsChargeable(){
        return this.isChargeable;
    }

    public boolean getIsReserved(){
        return this.isReserved;
    }

    public ArrayList getCheckedInGuests(){
        return this.checkedInGuests;
    }

    public void addGuest(Guest guest){
        this.checkedInGuests.add(guest);
    }

    public void setIsReserved(Boolean setToTrueOrFalse){
        this.isReserved = setToTrueOrFalse;
    }
}
