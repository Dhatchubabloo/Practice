package railway;

import java.util.ArrayList;
import java.util.HashMap;

public class Logics {

    private static int seatNo = 1000;
    private static int ticketId = 1;

    BerthInfo berthinfo = new BerthInfo();
    private static int confirmTicket = 4;
    private static int racTicket = 1;
    private static int waitingTicket =1;
    void berthInitialisation(){
        berthinfo.setLower(1);
        berthinfo.setMiddle(1);
        berthinfo.setUpper(1);
        berthinfo.setSideUpper(1);
    }

    ArrayList<String> ticktBooking(ArrayList<PassengerInfo> list){
        ArrayList<PassengerInfo>confirmList = new ArrayList<>();
        ArrayList<PassengerInfo>racList = new ArrayList<>();
        ArrayList<PassengerInfo>waitList = new ArrayList<>();
        ArrayList<String>bookingDetils = new ArrayList<>();
        int count=0;

        for(int i=0;i< list.size();i++){
            PassengerInfo info = list.get(i);
            if(info.getAge()>60||info.getChild()=='y'){
                info.setBerthPref("L");
            }
            if(confirmTicket>0){
                info.setStatus("confirm");
                berthAllocation(info);
                info.setTicketId(ticketId);
                info.setSeatNo(seatNo++);
                confirmList.add(info);
                confirmTicket--;
                bookingDetils.add("Booking successful for "+info.getName());
            }
            else if(racTicket>0){
                info.setStatus("RAC");
                info.setBerthPref("SL");
                info.setTicketId(ticketId);
                info.setSeatNo(seatNo++);
                racList.add(info);
                racTicket--;
                bookingDetils.add("Booking successful for "+info.getName());
            }
            else if(waitingTicket>0){
                info.setStatus("WaitingList");
                info.setTicketId(ticketId);
                info.setSeatNo(seatNo++);
                waitList.add(info);
                waitingTicket--;
                bookingDetils.add("Booking successful for "+info.getName());
            }
            else{
                count++;
                bookingDetils.add("Booking Failed for "+info.getName());
            }
        }
        if(count==list.size()){
            ticketId--;
        }
        Cache.OBJECT.setConfirm(confirmList,ticketId);
        if(racList.size()!=0)
        Cache.OBJECT.setRacMap(racList);
        if(waitList.size()!=0)
        Cache.OBJECT.setWaitMap(waitList);
        ticketId++;
        return bookingDetils;
    }

    void berthAllocation(PassengerInfo info){
        String berth = info.getBerthPref();
            if (berth.equals("U") && berthinfo.getUpper() > 0) {
                berthinfo.setUpper(berthinfo.getUpper() - 1);
            } else if (berth.equals("L") && berthinfo.getLower() > 0) {
                berthinfo.setUpper(berthinfo.getLower() - 1);
            } else if (berth.equals("M") && berthinfo.getMiddle() > 0) {
                berthinfo.setUpper(berthinfo.getMiddle() - 1);
            } else if (berth.equals("SU") && berthinfo.getSideUpper() > 0) {
                berthinfo.setUpper(berthinfo.getSideUpper() - 1);
            } else {
                if(berthinfo.getUpper()>0)
                    info.setBerthPref("U");
                else if(berthinfo.getLower()>0)
                    info.setBerthPref("L");
                else if(berthinfo.getMiddle()>0)
                    info.setBerthPref("M");
                else if(berthinfo.getSideUpper()>0)
                    info.setBerthPref("SU");
            }
    }
    HashMap<Integer, HashMap<Integer,PassengerInfo>> getConfirmMapInfo(){
        return Cache.OBJECT.getConfirmMap();
    }

   ArrayList<PassengerInfo> getRacMapInfo(){
        return Cache.OBJECT.getRacMap();
    }
    ArrayList<PassengerInfo> getWaitMapInfo(){
        return Cache.OBJECT.getWaitMap();
    }

    String  cancellation(PassengerInfo info){
       return Cache.OBJECT.updateConfirmMap(info);
    }
    public ArrayList<Integer>getAvilableTickets(){
        ArrayList<Integer>ticketList = new ArrayList<>();
        ticketList.add(confirmTicket);
        ticketList.add(racTicket);
        ticketList.add(waitingTicket);
        return ticketList;
    }
}
