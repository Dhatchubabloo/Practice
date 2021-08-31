package taxi_booking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Logical {
    public void taxiData(ArrayList<TaxiInfo> list){
        HashMap<Integer,TaxiInfo> taxiMap = new HashMap();
        for(int i=0;i<list.size();i++){
            TaxiInfo info = list.get(i);
            taxiMap.put(info.getTaxiId(),info);
        }
        Cache.OBJECT.setTaxiData(taxiMap);
    }
    public void bookingData(ArrayList<BookingInfo> list){
        HashMap<Integer,BookingInfo> bookingMap = new HashMap();
        for(int i=0;i<list.size();i++){
            ArrayList<BookingInfo> infoList = new ArrayList();
            BookingInfo info = list.get(i);
            infoList.add(info);
            bookingMap.put(info.getTaxiId(),info);
        }
        Cache.OBJECT.setBookingData(bookingMap);
    }

    public ArrayList<Integer>  booking(ArrayList<BookingInfo> list){
        HashMap<Integer,TaxiInfo> taxiMap = Cache.OBJECT.getTaxiData();
        ArrayList<Integer> display = new ArrayList<>();
        BookingInfo bookingInfo = list.get(0);
        int pp = bookingInfo.getPickPoint();
        int dp = bookingInfo.getDropPoint();
        int pt = bookingInfo.getPickTime();
        int distance = Math.abs(pp-dp)*15;
        int amount = 100+(distance-5)*10;
        bookingInfo.setPayAmount(amount);
        int dropTime = pt+(Math.abs(pp-dp));
        bookingInfo.setDropTime(dropTime);
        display.add(amount);
        for(Map.Entry entry:taxiMap.entrySet()){
            TaxiInfo taxinfo = (TaxiInfo) entry.getValue();
            int taxiId=0;
            if(taxinfo.getcurrentPoint()==pp&&
                        pt>=taxinfo.getFreeTime()){
                 taxiId=taxinfo.getTaxiId();
                 taxinfo.setFreeTime(dropTime);
                 idUpdation(taxiId,bookingInfo);
                display.add(taxiId);
                taxinfo.setFreeTime(dropTime);
                break;
            }
            else{

            }

        }
        return display;
    }

    private void idUpdation(int taxiId,BookingInfo info) {
        for(Map.Entry<Integer,BookingInfo> entry:Cache.OBJECT.getBookingData().entrySet()){
            if(entry.getKey()==taxiId){
                Cache.OBJECT.bookingUpdation(entry.getKey(), info);
            }
        }
    }

    public  HashMap<Integer,BookingInfo> getBookingDetails(){
        HashMap<Integer,BookingInfo> map = Cache.OBJECT.getBookingData();
        return map;
    }
}
