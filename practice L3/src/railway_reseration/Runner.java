package railway_reseration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Runner {
    public static void main(String[]args){
        new Runner().execution();
    }
    public void execution(){
        System.out.println();
        System.out.println("1.Booking");
        System.out.println("2.Booked ticket Details");
        System.out.println("3.Ticket Cancelling");
        System.out.println("4.Available Ticket details");
        System.out.println("5.Exit");
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        Logical logic = new Logical();
        switch (option){
            case 1:
                System.out.println("Enter number of tickets");
                int ticket = scan.nextInt();
                ArrayList<PassengerInfo> list = new ArrayList();
                for(int i=1;i<=ticket;i++) {
                    PassengerInfo info = new PassengerInfo();
                    System.out.println("Enter the details for passenger"+i);
                    System.out.println("Enter name");
                    info.setName(scan.next());
                    System.out.println("Enter age");
                    info.setAge(scan.nextInt());
                    System.out.println("Enter gender");
                    info.setGender(scan.next());
                    System.out.println("Enter berth preference");
                    info.setBerthPref(scan.next());
                    list.add(info);
                }
                String result = logic.booking(list);
                System.out.println(result);
                execution();
            case 2:
                System.out.println("booking Details");
                HashMap<Integer,PassengerInfo> bookingMap =  logic.bookingDetails();
                for(Map.Entry<Integer,PassengerInfo>entry:bookingMap.entrySet()){
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("Ticket No : "+entry.getKey()+"\t\t"+entry.getValue());
                }
                System.out.println("-----------------------------------------------------------------");
                System.out.println("The total ticket booked : "+bookingMap.size());
                execution();
            case 3:
                System.out.println("Enter ticket Number");
                logic.cancelling(scan.nextInt());
                System.out.println("Ticket Cancelled Successfully");
                execution();
            case 4:
                ArrayList sizeList = logic.available();
                System.out.println("Available Tickets are:");
                System.out.println("confirm Tickets : "+sizeList.get(0));
                System.out.println("RAC Tickets : "+sizeList.get(1));
                System.out.println("WaitList Tickets : "+sizeList.get(2));
                execution();
            case 5:
                break;
        }
    }
}
