package hotel_management;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Runner {
    static Scanner scan = new Scanner(System.in);
    static LogicalLayer logic= new LogicalLayer();
    public static void main(String[] args) {
        ArrayList<HotelInfo>hotelList = new ArrayList<>();
        System.out.println("Enter Number of Hotels");
        int hotel = scan.nextInt();
        for(int i=1;i<=hotel;i++){
            System.out.println("Enter the hote details "+i);
            HotelInfo info = new HotelInfo();
            info.setHotelId(i);
            System.out.println("Enter Hotel Name");
            scan.nextLine();
            info.setHotelName(scan.nextLine());
            System.out.println("Enter Number of room Available");
            info.setRooms(scan.nextInt());
            System.out.println("Enter the hotel Location");
            scan.nextLine();
            info.setLocation(scan.nextLine());
            System.out.println("Enter Hotel Rating");
            info.setRating(scan.nextInt());
            System.out.println("Enter the price per room");
            info.setPricePerRoom(scan.nextInt());
            hotelList.add(info);
        }
        System.out.println(logic.hotelInitialization(hotelList));
        execution();
    }
static int userId =1;
    static double cost = 1000;
    public static void execution() {
        int k=0;
        while(k==0) {
            System.out.println();
            System.out.println("0.Hotel booking\n1.print the hotel data\n2.sortByName\n3.sortByRatings" +
                    "\n4.print hotel data for location\n5.sort by rooms Available\n6.user booking data\n7.Exit");
            switch (scan.nextInt()) {
                case 0:
                    BookingInfo data = new BookingInfo();
                    System.out.println("Enter Name");
                    scan.nextLine();
                    data.setUserName(scan.nextLine());
                    System.out.println("Enter HotelName");
                    data.setHotelName(scan.nextLine());
                    data.setUserId(userId++);
                    data.setBookingCost(cost);
                    cost += 200;
                    logic.hotelBooking(data);
                    break;
                case 1:
                    for (Map.Entry entry : logic.getHotelData().entrySet()) {
                        System.out.println(entry.getValue());
                    }
                    break;
                case 2:
                    List<Map.Entry<Integer, HotelInfo>> list = logic.sortByName();
                    for (Map.Entry val : list)
                        System.out.println(val.getValue());
                    break;

                case 3:
                    List<Map.Entry<Integer, HotelInfo>> list1 = logic.sortByRating();
                    for (Map.Entry val : list1)
                        System.out.println(val.getValue());
                    break;

                case 4:
                    System.out.println("Enter Location");
                    scan.nextLine();
                    ArrayList<HotelInfo> local = logic.getHotelForLocation(scan.nextLine());
                    for (HotelInfo info : local)
                        System.out.println(info);
                    break;

                case 5:
                    List<Map.Entry<Integer, HotelInfo>> list2 = logic.sortByRoomsAvailable();
                    for (Map.Entry val : list2)
                        System.out.println(val.getValue());
                    break;
                case 6:
                    for (Map.Entry<Integer, BookingInfo> entry : logic.getUserData().entrySet()) {
                        System.out.println("User id : " + entry.getKey());
                        System.out.println(entry.getValue());
                    }
                    break;
                case 7:
                    k++;
                    break;
            }
        }
    }
}
