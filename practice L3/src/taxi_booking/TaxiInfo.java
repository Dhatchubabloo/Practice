package taxi_booking;

public class TaxiInfo {
    private int taxiId;
    private char currentPoint;
    private int freeTime;
    private int totalAmount;

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(int taxiId) {
        this.taxiId = taxiId;
    }

    public char getcurrentPoint() {
        return currentPoint;
    }

    public void setcurrentPoint(char initialpoint) {
        this.currentPoint = initialpoint;
    }

    public int getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(int freeTime) {
        this.freeTime = freeTime;
    }
    public String toString(){
        return "\t"+currentPoint+"\t\t\t\t"+freeTime+"\t\t\t\t"+totalAmount;
    }
}
