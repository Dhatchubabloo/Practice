package railway_reseration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public enum Maphandler {
    OBJECT;
    HashMap<Integer,PassengerInfo> confirmMap = new HashMap<>();
    HashMap<Integer,PassengerInfo>racMap = new HashMap<>();
    HashMap<Integer,PassengerInfo>waitMap = new HashMap<>();

    public void confirmDetails(HashMap<Integer,PassengerInfo> map){
        confirmMap = map;
    }
    public void racDetails(HashMap<Integer,PassengerInfo> map){
        racMap = map;
    }
    public void waitingDetails( HashMap<Integer,PassengerInfo>map){
        waitMap =map;
    }
    public HashMap<Integer,PassengerInfo> retriveConfirmDetails(){
        return confirmMap;
    }
    public HashMap<Integer,PassengerInfo> retriveRacDetails(){
        return racMap;
    }
    public HashMap<Integer,PassengerInfo> retriveWaitingDetails(){

        return waitMap;
    }
    public void cancellingTicket(int ticket_no){
        for(Map.Entry<Integer,PassengerInfo>entry:confirmMap.entrySet()){
            if(entry.getKey()==ticket_no){
                confirmMap.remove(ticket_no);
                for(Map.Entry<Integer,PassengerInfo>entries:racMap.entrySet()){
                    entries.getValue().setStatus("confirm");
                    break;
                }
                for(Map.Entry<Integer,PassengerInfo>entries:waitMap.entrySet()){
                    entries.getValue().setStatus("RAC");
                    entries.getValue().setBerthPref("side-lower");
                    break;
                }
                break;
            }
        }
    }
    public  ArrayList<Integer> availableTickets(){
        ArrayList<Integer>sizeList = new ArrayList<>();
        int confirmSize =0;
        int racSize =0;
        int waitSize =0;
        if(confirmMap.size()<2)
            confirmSize = 2-confirmMap.size();
        else
            confirmSize=0;
        sizeList.add(confirmSize);
        if(racMap.size()<2)
            racSize = 2-racMap.size();
        else
            racSize =0;
        sizeList.add(racSize);
        if(waitMap.size()<1)
            waitSize = 1-waitMap.size();
        else
            waitSize=0;
        sizeList.add(waitSize);
        return sizeList;
    }
}
