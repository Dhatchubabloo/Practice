package hotel_management;

import java.util.HashMap;
import java.util.Map;

public enum Cache {
    OBJECT;
    Map<Integer,HotelInfo>hotelMap = new HashMap<>();

    void setHotelMap(Map<Integer,HotelInfo> map){
        hotelMap = map;
    }
    Map<Integer,HotelInfo>getHotelMap(){
        return hotelMap;
    }
}
