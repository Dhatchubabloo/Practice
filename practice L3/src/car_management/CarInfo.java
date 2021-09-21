package car_management;

public class CarInfo {
    private String car;
    private int count;

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public String toString(){
        return car+" = = "+count;
    }
}
