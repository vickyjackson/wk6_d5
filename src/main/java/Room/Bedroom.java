package Room;

import Room.Room;

public class Bedroom extends Room {

    private int roomNumber;
    private BedroomType bedroomType;
    private int nightlyRate;

    public Bedroom(boolean isChargeable, BedroomType bedroomType, int roomNumber, int nightlyRate){
        super(isChargeable);
        this.bedroomType = bedroomType;
        this.roomNumber = roomNumber;
        this.nightlyRate = nightlyRate;
    }

    public BedroomType getBedroomType(){
        return this.bedroomType;
    }

    public int getRoomNumber(){
        return this.roomNumber;
    }

    public int getNightlyRate(){
        return this.nightlyRate;
    }
}
