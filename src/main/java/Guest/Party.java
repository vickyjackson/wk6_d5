package Guest;

import java.util.ArrayList;

public class Party {

    private ArrayList<Guest> party;

    public Party(){
        this.party = new ArrayList<Guest>();
    }

    public ArrayList<Guest> getParty(){
        return this.party;
    }

    public void addGuest(Guest guest){
        this.party.add(guest);
    }

    public void removeGuest(Guest guest){
        this.party.remove(guest);
    }

    public void removeAllGuests(){
        this.party.clear();
    }
}
