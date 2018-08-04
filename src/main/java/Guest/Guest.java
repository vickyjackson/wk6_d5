package Guest;

public class Guest {

    private String firstName;
    private String lastName;
    private int cardNumberEndingIn;

    public Guest(String firstName, String lastName, int cardNumberEndingIn){
        this.firstName = firstName;
        this.lastName = lastName;
        this.cardNumberEndingIn = cardNumberEndingIn;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public int getCardNumberEndingIn(){
        return this.cardNumberEndingIn;
    }
}
