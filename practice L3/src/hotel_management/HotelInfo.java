package hotel_management;

public class HotelInfo {
    private String hotelName;
    private int rooms;
    private String location;
    private int rating;
    private int pricePerRoom;
    private int hotelId;

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getPricePerRoom() {
        return pricePerRoom;
    }

    public void setPricePerRoom(int pricePerRoom) {
        this.pricePerRoom = pricePerRoom;
    }
    public String toString(){
        return hotelName+"\t"+rooms+"\t"+location+"\t"+rating+"\t"+pricePerRoom;
    }
}
