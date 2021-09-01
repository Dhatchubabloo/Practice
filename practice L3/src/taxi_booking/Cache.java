package taxi_booking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public enum Cache {
    OBJECT;
    HashMap<Integer,TaxiInfo> taxiInfoMap = new HashMap<>();
    HashMap<Integer,ArrayList<BookingInfo>> bookingInfoMap = new HashMap<>();
    public void setTaxiData( HashMap<Integer,TaxiInfo> dataMap){
        taxiInfoMap = dataMap;
    }
    public  HashMap<Integer,TaxiInfo> getTaxiData(){
        return taxiInfoMap;
    }
    public void setBookingData( HashMap<Integer, ArrayList<BookingInfo>> bookingMap){
        bookingInfoMap = bookingMap;
    }
    public  HashMap<Integer,ArrayList<BookingInfo>> getBookingData(){
        return bookingInfoMap;
    }
    public void bookingUpdation(int taxiId,ArrayList<BookingInfo> info){
        bookingInfoMap.put(taxiId,info);
    }
}
