package Room;

public enum BedroomType {

    SINGLE(1),
    TWIN(2),
    DOUBLE(2);

    private int capacity;

    BedroomType(int capacity){
        this.capacity = capacity;
    }

    public int getCapacity(){
        return this.capacity;
    }
}
