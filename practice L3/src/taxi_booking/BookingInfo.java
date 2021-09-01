package taxi_booking;

public class BookingInfo {
    private char pickPoint;
    private char dropPoint;
    private int pickTime;
    private int payAmount;
    private int bookingId;
    private int taxiId;

    public int getDropTime() {
        return dropTime;
    }

    public void setDropTime(int dropTime) {
        this.dropTime = dropTime;
    }

    private int dropTime;

    public int getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(int taxiId) {
        this.taxiId = taxiId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public char getPickPoint() {
        return pickPoint;
    }

    public void setPickPoint(char pickPoint) {
        this.pickPoint = pickPoint;
    }

    public char getDropPoint() {
        return dropPoint;
    }

    public void setDropPoint(char dropPoint) {
        this.dropPoint = dropPoint;
    }

    public int getPickTime() {
        return pickTime;
    }

    public void setPickTime(int pickTime) {
        this.pickTime = pickTime;
    }

    public int getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(int payAmount) {
        this.payAmount = payAmount;
    }
    public String toString(){
        return ""+bookingId+"\t\t\t"+pickPoint+"\t\t"+dropPoint+
                "\t\t"+pickTime+"\t\t\t"+dropTime+"\t\t\t"+payAmount;
    }
}
