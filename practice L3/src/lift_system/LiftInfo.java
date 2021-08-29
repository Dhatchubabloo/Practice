package lift_system;

public class LiftInfo {
    private int liftNumber;
    private int floor;
    private int capacity;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getLiftNumber() {
        return liftNumber;
    }

    public void setLiftNumber(int liftNumber) {
        this.liftNumber = liftNumber;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
