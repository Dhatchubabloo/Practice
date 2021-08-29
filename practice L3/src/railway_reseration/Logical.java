package railway_reseration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Logical {
    public String booking(ArrayList<PassengerInfo> list){
        HashMap<Integer,PassengerInfo>confirmMap = new HashMap<>();
        HashMap<Integer,PassengerInfo>racMap = new HashMap<>();
        HashMap<Integer,PassengerInfo>waitMap = new HashMap<>();
        int tickert_no = 1000;
        int count=0;
        for(int i=0;i<list.size();i++){
            PassengerInfo info = list.get(i);
            if(confirmMap.size()<2){
                info.setStatus("confirm");
                int age = info.getAge();
                if(age>60 || info.getGender().equals("female")){
                    info.setBerthPref("lower");
                }
                if(age<5)
                    confirmMap.put(0,info);
                else
                    confirmMap.put(tickert_no, info);
                tickert_no++;
            }
            else if(racMap.size()<1){
                info.setStatus("RAC");
                info.setBerthPref("side-lower");
                int age = info.getAge();
                if(age<5)
                    confirmMap.put(0,info);
                else
                    racMap.put(tickert_no,info);
                tickert_no++;
            }
            else if(waitMap.size()<1){
                info.setStatus("Waiting");
                int age = info.getAge();
                info.setBerthPref(" - ");
                if(age<5)
                    confirmMap.put(0,info);
                else
                    waitMap.put(tickert_no,info);
                tickert_no++;
            }
            else{
                count++;
                break;
            }
        }
        Maphandler.OBJECT.confirmDetails(confirmMap);
        Maphandler.OBJECT.racDetails(racMap);
        Maphandler.OBJECT.waitingDetails(waitMap);
        if(count==0){
            return "tickets booked successfully";
        }
        else
            return "no tickets";
    }
    public HashMap<Integer,PassengerInfo> bookingDetails(){
        HashMap<Integer,PassengerInfo> mainMap = new HashMap<>();
        HashMap<Integer,PassengerInfo> confirmMap = Maphandler.OBJECT.retriveConfirmDetails();
        HashMap<Integer,PassengerInfo>racMap = Maphandler.OBJECT.retriveRacDetails();
        HashMap<Integer,PassengerInfo>waitMap = Maphandler.OBJECT.retriveWaitingDetails();
        if(confirmMap.size()!=0) {
            for (Map.Entry<Integer, PassengerInfo> entry : confirmMap.entrySet()) {
                Integer ticket = entry.getKey();
                PassengerInfo info = entry.getValue();
                mainMap.put(ticket, info);
            }
        }
        if(racMap.size()!=0) {
            for (Map.Entry<Integer, PassengerInfo> entry : racMap.entrySet()) {
                Integer ticket = entry.getKey();
                PassengerInfo info = entry.getValue();
                mainMap.put(ticket, info);
            }
        }
        if(waitMap.size()!=0) {
            for (Map.Entry<Integer, PassengerInfo> entry : waitMap.entrySet()) {
                Integer ticket = entry.getKey();
                PassengerInfo info = entry.getValue();
                mainMap.put(ticket, info);
            }
        }

        return mainMap;
    }
    public void cancelling(Integer ticket){
        Maphandler.OBJECT.cancellingTicket(ticket);
    }
    public ArrayList available(){
        ArrayList list = Maphandler.OBJECT.availableTickets();
        return list;
    }
}
