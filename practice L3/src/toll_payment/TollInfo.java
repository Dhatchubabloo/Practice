package toll_payment;

public class TollInfo {
    private String vehicleType;
    private int totalAmount=0;

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
    public String toString(){
        return vehicleType+"    -\t"+totalAmount+"\n"+
                "--------------------------------------";
    }
}
