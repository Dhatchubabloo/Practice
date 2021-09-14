package toll_payment;

public class VehicleInfo {
    private String vehicle;
    private int startPoint;
    private int destPoint;
    private int amount;
    private String vip;

    public String getVehicle() {
        return vehicle;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public int getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(int startPoint) {
        this.startPoint = startPoint;
    }

    public int getDestPoint() {
        return destPoint;
    }

    public void setDestPoint(int destPoint) {
        this.destPoint = destPoint;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }
    public String toString(){
        return "\t"+vehicle+"\t\t\t"+startPoint+"\t\t\t"+destPoint+"\t\t"+vip+"\t\t"+amount;
    }
}
