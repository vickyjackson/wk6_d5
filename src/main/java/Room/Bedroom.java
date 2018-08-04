package Room;

import Room.Room;

public class Bedroom extends Room {

    private int roomNumber;
    private BedroomType bedroomType;
    private int nightlyRate;

    public Bedroom(boolean isChargeable, boolean isReserved, BedroomType bedroomType, int roomNumber, int nightlyRate){
        super(isChargeable, isReserved);
        this.bedroomType = bedroomType;
        this.roomNumber = roomNumber;
        this.nightlyRate = nightlyRate;
    }

    public BedroomType getBedroomType(){
        return this.bedroomType;
    }

    public int getBedroomCapacity(){
        return bedroomType.getCapacity();
    }

    public int getRoomNumber(){
        return this.roomNumber;
    }

    public int getNightlyRate(){
        return this.nightlyRate;
    }
}
