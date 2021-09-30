package city_route;

public class RouteInfo {
    private char fromCity;

    public char getFromCity() {
        return fromCity;
    }

    public void setFromCity(char fromCity) {
        this.fromCity = fromCity;
    }

    private char destCity;
    private int distance;

    public char getDestCity() {
        return destCity;
    }

    public void setDestCity(char destCity) {
        this.destCity = destCity;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
