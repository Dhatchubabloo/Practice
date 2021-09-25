package railway;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public enum Cache {
    OBJECT;
    private HashMap<Integer, HashMap<Integer,PassengerInfo>>confirmMap = new HashMap<>();
    private ArrayList<PassengerInfo>racList = new ArrayList<>();
    private ArrayList<PassengerInfo>waitList = new ArrayList<>();

    void setConfirm(ArrayList<PassengerInfo> list,int ticket){
        HashMap<Integer,PassengerInfo>inner = new HashMap<>();
       for(int i=0;i<list.size();i++){
           PassengerInfo info =list.get(i);
           inner.put(info.getSeatNo(),info);
       }
       confirmMap.put(ticket,inner);
    }
    void setRacMap(ArrayList<PassengerInfo> list){
        for(int i=0;i<list.size();i++){
            racList.add(list.get(i));
        }
    }
    void setWaitMap(ArrayList<PassengerInfo> list){
        for(int i=0;i<list.size();i++){
            waitList.add(list.get(i));
        }

    }
    HashMap<Integer, HashMap<Integer,PassengerInfo>> getConfirmMap(){

        return confirmMap;
    }
    ArrayList<PassengerInfo> getRacMap()
    {
        return racList;
    }
   ArrayList<PassengerInfo> getWaitMap(){

        return waitList;
    }
    String  updateConfirmMap(PassengerInfo info){
        int seat=0;
        String berth = null;
        for(Map.Entry<Integer, HashMap<Integer,PassengerInfo>> entry:confirmMap.entrySet()){
            if(entry.getKey()==info.getTicketId()){
                HashMap<Integer,PassengerInfo> inner = entry.getValue();
                PassengerInfo info1 = inner.get(info.getSeatNo());
                seat = info1.getSeatNo();
                berth = info1.getBerthPref();
                inner.remove(info.getSeatNo());
                break;
            }
        }
        if(racList.size()!=0) {
            PassengerInfo racInfo = racList.remove(0);
            racInfo.setSeatNo(seat);
            racInfo.setBerthPref(berth);
            racInfo.setStatus("confirm");
            HashMap<Integer, PassengerInfo> temp = new HashMap<>();
            temp.put(racInfo.getSeatNo(), racInfo);
            confirmMap.put(racInfo.getTicketId(), temp);
            if(waitList.size()!=0) {
                PassengerInfo waitInfo = waitList.remove(0);
                waitInfo.setStatus("WaitingList");
                racList.add(waitInfo);
            }
        }
        return "Cancellation Successfully";
    }
}