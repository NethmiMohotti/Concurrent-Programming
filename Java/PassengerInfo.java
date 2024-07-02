package lk.iit.level6.concurrent.coursework;

public class PassengerInfo {
    private final String passengerName;
    private String passengerNumber;
    private String passengerEmail;

    public PassengerInfo(String passengerName, String passengerNumber, String passengerEmail) {
        this.passengerName = passengerName;
        this.passengerNumber = passengerNumber;
        this.passengerEmail = passengerEmail;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getPassengerNumber() {
        return passengerNumber;
    }

    public String getPassengerEmail() {
        return passengerEmail;
    }

    @Override
    public String toString() {
        return " PassengerInfo {  " +
                "\n" +"   PassengerName = " + passengerName +
                "\n" +"   PhoneNumber = " + passengerNumber +
                "\n" +"   EmailAddress = " + passengerEmail + " }";
    }

}
