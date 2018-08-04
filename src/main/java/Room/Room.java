package Room;

import java.util.ArrayList;

public abstract class Room {

    private boolean isChargeable;

    public Room(boolean isChargeable) {
        this.isChargeable = isChargeable;
    }

    public boolean getIsChargeable(){
        return this.isChargeable;
    }
}
