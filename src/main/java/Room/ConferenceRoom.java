package Room;

import Room.Room;

public class ConferenceRoom extends Room {

    private String name;
    private double dailyRate;

    public ConferenceRoom(boolean isChargeable, String name, double dailyRate){
        super(isChargeable);
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
