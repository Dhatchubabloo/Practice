package railway;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        execution();
    }
    public static void execution() {
        Scanner scan = new Scanner(System.in);
        Logics logic= new Logics();
        System.out.println();
        System.out.println("1.booking\n2.Ticket Booking Details\n3.Cancellation\n4.Available Tickets\n5.Exit");
        logic.berthInitialisation();
        switch(scan.nextInt()){
            case 1:
                System.out.println("Enter number of Tickets");
                int count = scan.nextInt();
                ArrayList<PassengerInfo> infoList = new ArrayList<>();
                for(int i=1;i<=count;i++){
                    PassengerInfo info = new PassengerInfo();
                    System.out.println("Enter details for person "+i);
                    System.out.println("Enter name");
                    info.setName(scan.next());
                    System.out.println("Enter Age");
                    int age = scan.nextInt();
                    info.setAge(age);
                    System.out.println("Enter gender (M/F)");
                    char gender = scan.next().charAt(0);
                    info.setGender(gender);
                    System.out.println("Enter berth preference (U/M/L/SU/SL)");
                    info.setBerthPref(scan.next());
                    if(gender=='F'&&age>18){
                        System.out.println("Are you Having child (y/n)");
                        info.setChild(scan.next().charAt(0));
                    }
                    infoList.add(info);
                }
                ArrayList<String>status = logic.ticktBooking(infoList);
                for(String i:status) {
                    System.out.println();
                    System.out.println(i);
                }
                execution();
            case 2:
                for(Map.Entry<Integer,HashMap<Integer,PassengerInfo>> entry:logic.getConfirmMapInfo().entrySet()){
                    if(entry.getValue().size()!=0) {
                        System.out.println("ticket id :" + entry.getKey());
                        for (Map.Entry val : entry.getValue().entrySet()) {
                            System.out.println("seat No :" + val.getKey());
                            System.out.println(val.getValue());
                        }
                    }
                }
                ArrayList<PassengerInfo> list = logic.getRacMapInfo();
                if(list.size()!=0){
                    for(PassengerInfo i:list)
                        System.out.println(i);
                }
                ArrayList<PassengerInfo> list1 = logic.getWaitMapInfo();
                if(list1.size()!=0){
                    for(PassengerInfo i:list1)
                        System.out.println(i);
                }
                execution();
            case 3:
                PassengerInfo info = new PassengerInfo();
                System.out.println("Enter ticketId");
                info.setTicketId(scan.nextInt());
                System.out.println("Enter seat No:");
                info.setSeatNo(scan.nextInt());
                System.out.println(logic.cancellation(info));
                execution();
            case 4:
                ArrayList<Integer> ticketList = logic.getAvilableTickets();
                System.out.println("Confirm ticket - "+ticketList.get(0));
                System.out.println("RAC ticket - "+ticketList.get(1));
                System.out.println("WaitingList ticket - "+ticketList.get(2));
                execution();
            case 5:
                break;
        }
    }
}
