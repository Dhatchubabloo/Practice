package toll_payment;

public class ChargingInfo {
    private int tollNumber;
    private int twoWheeler;
    private int fourWheeler;
    private int heavyLoadVehicle;


    public int getTollNumber() {
        return tollNumber;
    }

    public void setTollNumber(int tollNumber) {
        this.tollNumber = tollNumber;
    }


    @Override
    public String toString() {
        return "\t\t"+twoWheeler+"\t\t"+fourWheeler+"\t\t\t"+heavyLoadVehicle;
    }

    public int getTwoWheeler() {
        return twoWheeler;
    }

    public void setTwoWheeler(int twoWheeler) {
        this.twoWheeler = twoWheeler;
    }

    public int getFourWheeler() {
        return fourWheeler;
    }

    public void setFourWheeler(int fourWheeler) {
        this.fourWheeler = fourWheeler;
    }

    public int getHeavyLoadVehicle() {
        return heavyLoadVehicle;
    }

    public void setHeavyLoadVehicle(int heavyLoadVehicle) {
        this.heavyLoadVehicle = heavyLoadVehicle;
    }
}
