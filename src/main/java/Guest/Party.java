package Guest;

import java.util.ArrayList;

public class Party {

    private ArrayList<Guest> guests;

    public Party(){
        this.guests = new ArrayList<Guest>();
    }

    public ArrayList<Guest> getGuests(){
        return this.guests;
    }

    public void addGuest(Guest guest){
        this.guests.add(guest);
    }

    public void removeGuest(Guest guest){
        this.guests.remove(guest);
    }

    public void removeAllGuests(){
        this.guests.clear();
    }
}
