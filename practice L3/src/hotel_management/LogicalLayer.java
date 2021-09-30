package hotel_management;

import java.util.*;

public class LogicalLayer {
    static HashMap <Integer,BookingInfo>userMap = new HashMap<>();
    String hotelBooking(BookingInfo info){
        userMap.put(info.getUserId(),info);
        return "Booking Successfully";
    }
    HashMap <Integer,BookingInfo>getUserData(){
        return userMap;
    }
    String hotelInitialization(ArrayList<HotelInfo>list){
        HashMap<Integer,HotelInfo>hotelMap = new HashMap<>();
        for(int i=0;i< list.size();i++){
            HotelInfo info = list.get(i);
            hotelMap.put(info.getHotelId(),info);
        }
        Cache.OBJECT.setHotelMap(hotelMap);
        return "Hotel Initialisation successfully............!";
    }
    Map<Integer,HotelInfo> getHotelData(){
        return Cache.OBJECT.getHotelMap();
    }
    List<Map.Entry<Integer,HotelInfo>> getList(){
        Map<Integer,HotelInfo>hotelMap = Cache.OBJECT.getHotelMap();
        Set<Map.Entry<Integer,HotelInfo>>entry = hotelMap.entrySet();
        List<Map.Entry<Integer,HotelInfo>> list = new ArrayList<>(entry);
        return list;
    }
    List<Map.Entry<Integer,HotelInfo>> sortByName(){
        List<Map.Entry<Integer,HotelInfo>> list = getList();
        Collections.sort(list, new Comparator<Map.Entry<Integer, HotelInfo>>() {
            @Override
            public int compare(Map.Entry<Integer, HotelInfo> o1, Map.Entry<Integer, HotelInfo> o2) {
                int rate =  o1.getValue().getHotelName().compareTo(o2.getValue().getHotelName());
                if(rate>0)
                    return 1;
                else if(rate <0)
                    return -1;
                else
                    return 0;
            }
        });
        return list;
    }
    List<Map.Entry<Integer,HotelInfo>> sortByRating(){
        List<Map.Entry<Integer,HotelInfo>> list = getList();
        Collections.sort(list, new Comparator<Map.Entry<Integer, HotelInfo>>() {
            @Override
            public int compare(Map.Entry<Integer, HotelInfo> o1, Map.Entry<Integer, HotelInfo> o2) {
                return o1.getValue().getRating()-o2.getValue().getRating();
            }
        });
        return list;
    }

    ArrayList<HotelInfo> getHotelForLocation(String location){
        ArrayList<HotelInfo> locationList = new ArrayList<>();
        for(Map.Entry<Integer,HotelInfo> entry :Cache.OBJECT.getHotelMap().entrySet()){
            HotelInfo info = entry.getValue();
            if(info.getLocation().equals(location))
                locationList.add(info);
        }
        return locationList;
    }
    List<Map.Entry<Integer,HotelInfo>> sortByRoomsAvailable(){
        List<Map.Entry<Integer,HotelInfo>> list = getList();
        Collections.sort(list, new Comparator<Map.Entry<Integer, HotelInfo>>() {
            @Override
            public int compare(Map.Entry<Integer, HotelInfo> o1, Map.Entry<Integer, HotelInfo> o2) {
                return o1.getValue().getRooms()-o2.getValue().getRooms();
            }
        });
        return list;
    }
}
