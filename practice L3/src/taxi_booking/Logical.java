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
        HashMap<Integer,ArrayList<BookingInfo>> bookingMap = new HashMap();
        for(int i=0;i<list.size();i++){
            ArrayList<BookingInfo> infoList = new ArrayList();
            BookingInfo info = list.get(i);
            infoList.add(info);
            bookingMap.put(info.getTaxiId(),infoList);
        }
        Cache.OBJECT.setBookingData(bookingMap);
    }


    ArrayList<BookingInfo> taxi1 = new ArrayList();
    ArrayList<BookingInfo> taxi2 = new ArrayList();
    ArrayList<BookingInfo> taxi3 = new ArrayList();
    ArrayList<BookingInfo> taxi4 = new ArrayList();

    public ArrayList<Integer>  booking(ArrayList<BookingInfo> list){
        HashMap<Integer,TaxiInfo> taxiMap = Cache.OBJECT.getTaxiData();
        ArrayList<Integer> display = new ArrayList<>();
        ArrayList<BookingInfo>dataList;
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
        int count=0;
        for(Map.Entry entry:taxiMap.entrySet()){
            TaxiInfo taxinfo = (TaxiInfo) entry.getValue();
            int cp = taxinfo.getcurrentPoint();
            int taxiId=0;
            if(cp==pp&&pt>=taxinfo.getFreeTime()){
                 taxiId=taxinfo.getTaxiId();
                 if(taxiId==1){
                     taxi1.add(bookingInfo);
                     dataList = taxi1;
                 }else if(taxiId==2){
                     taxi2.add(bookingInfo);
                     dataList = taxi2;
                 }else if(taxiId==3){
                     taxi3.add(bookingInfo);
                     dataList = taxi3;
                 }else{
                     taxi4.add(bookingInfo);
                     dataList = taxi4;
                 }
                 taxinfo.setFreeTime(dropTime);
                 taxinfo.setcurrentPoint((char)dp);
                 int prevAmount = taxinfo.getTotalAmount();
                 taxinfo.setTotalAmount(prevAmount+amount);
                 idUpdation(taxiId,dataList);
                display.add(taxiId);
                taxinfo.setFreeTime(dropTime);
                break;
            }
            else if(pt>=taxinfo.getFreeTime()){
                int diff =Math.abs(cp-pp);
                taxiId = (int) entry.getKey();
                TaxiInfo info =null;
                for(Map.Entry entry1:taxiMap.entrySet()) {
                    info = (TaxiInfo) entry1.getValue();
                    cp = info.getcurrentPoint();
                    int diff1 = Math.abs(cp - pp);
                    if (diff1 <= diff) {
                        taxiId = (int) entry1.getKey();
                    }
                }
                if(taxiId==1){
                    taxi1.add(bookingInfo);
                    dataList = taxi1;
                }else if(taxiId==2){
                    taxi2.add(bookingInfo);
                    dataList = taxi2;
                }else if(taxiId==3){
                    taxi3.add(bookingInfo);
                    dataList = taxi3;
                }else{
                    taxi4.add(bookingInfo);
                    dataList = taxi4;
                }
                info.setFreeTime(dropTime);
                info.setcurrentPoint((char)dp);
                int prevAmount = info.getTotalAmount();
                info.setTotalAmount(prevAmount+amount);
                idUpdation(taxiId,dataList);
                display.add(taxiId);
                info.setFreeTime(dropTime);
                break;
            }
            else
                count++;

        }
        display.add(count);
        return display;
    }

    public void idUpdation(int taxiId,ArrayList<BookingInfo> info) {
        for(Map.Entry<Integer,ArrayList<BookingInfo>> entry:Cache.OBJECT.getBookingData().entrySet()){
            if(entry.getKey()==taxiId){
                Cache.OBJECT.bookingUpdation(entry.getKey(), info);
            }
        }
    }
    public HashMap<Integer,TaxiInfo> getTaxiDetails(){
        return Cache.OBJECT.getTaxiData();
    }

    public  HashMap<Integer,ArrayList<BookingInfo>> getBookingDetails(){
        HashMap<Integer,ArrayList<BookingInfo>> map = Cache.OBJECT.getBookingData();
        return map;
    }
}
