package taxi_booking;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Runner {
    static Logical logic = new Logical();
    public static void main(String[]args){
        ArrayList<TaxiInfo> taxiList = new ArrayList();
        ArrayList<BookingInfo> bookingList = new ArrayList<>();
        for(int i=1;i<=4;i++){
            BookingInfo bookingInfo = new BookingInfo();
            TaxiInfo info = new TaxiInfo();
            info.setTaxiId(i);
            info.setcurrentPoint('A');
            info.setFreeTime(6);
            bookingInfo.setTaxiId(i);
            bookingInfo.setBookingId(0);
            bookingInfo.setPayAmount(0);
            bookingInfo.setPickTime(0);
            bookingInfo.setDropPoint('-');
            bookingInfo.setPickPoint('-');
            bookingInfo.setDropTime(0);
            bookingList.add(bookingInfo);
            taxiList.add(info);
        }
        System.out.println("Initial condition");
        for(TaxiInfo info:taxiList){
            System.out.println("Taxi"+info.getTaxiId()+
                    "\t-"+info.getcurrentPoint()+
                    "\t"+info.getFreeTime());
        }
        logic.taxiData(taxiList);
        logic.bookingData(bookingList);
        new Runner().execution();
    }

    private void execution() {
        BookingInfo info = new BookingInfo();
        Scanner scan = new Scanner(System.in);
        System.out.println("1.Booking");
        System.out.println("2.Taxi Details");
        int option = scan.nextInt();
        int bookingid = 0;
        switch (option){
            case 1:
                ArrayList<BookingInfo> tripList = new ArrayList();
                System.out.println("Enter pickup point");
                info.setPickPoint(scan.next().charAt(0));
                System.out.println("Enter drop point");
                info.setDropPoint(scan.next().charAt(0));
                System.out.println("Enter pickup time");
                info.setPickTime(scan.nextInt());
                info.setBookingId(++bookingid);
                tripList.add(info);
                ArrayList<Integer> result = logic.booking(tripList);
                System.out.println("Amount to pay :"+result.get(0));
                System.out.println("Taxi"+result.get(1)+" is Booked");
                execution();
                break;
            case 2:
                System.out.println("Booking-id | From | To | pick-time | drop-time | amount");
                for(Map.Entry entry: logic.getBookingDetails().entrySet()){
                    System.out.println("Taxi -"+entry.getKey());
                    ArrayList<BookingInfo> list = (ArrayList<BookingInfo>) entry.getValue();
                   for(int i=0;i<list.size();i++){
                       list.get(i).setBookingId(i+1);
                       System.out.println(list.get(i));
                   }
                }
                execution();
                break;
            default:
                System.out.println("Invalid option");
        }
    }
}
