package Room;

import Room.Room;

public class ConferenceRoom extends Room {

    private String name;
    private double dailyRate;

    public ConferenceRoom(boolean isChargeable, boolean isReserved, String name, double dailyRate){
        super(isChargeable, isReserved);
        this.name = name;
        this.dailyRate = dailyRate;
    }

    public String getName(){
        return this.name;
    }

    public double getDailyRate(){
        return this.dailyRate;
    }
}
