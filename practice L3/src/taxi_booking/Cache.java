package taxi_booking;

import java.util.HashMap;
import java.util.Map;

public enum Cache {
    OBJECT;
    HashMap<Integer,TaxiInfo> taxiInfoMap = new HashMap<>();
    HashMap<Integer,BookingInfo> bookingInfoMap = new HashMap<>();
    public void setTaxiData( HashMap<Integer,TaxiInfo> dataMap){
        taxiInfoMap = dataMap;
    }
    public  HashMap<Integer,TaxiInfo> getTaxiData(){
        return taxiInfoMap;
    }
    public void setBookingData( HashMap<Integer,BookingInfo> bookingMap){
        bookingInfoMap = bookingMap;
    }
    public  HashMap<Integer,BookingInfo> getBookingData(){
        return bookingInfoMap;
    }
    public void bookingUpdation(int taxiId,BookingInfo info){
        bookingInfoMap.put(taxiId,info);
    }
}
