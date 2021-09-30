package city_route;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Runner {
    static ArrayList<RouteInfo>cityList = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    static Logic logic = new Logic();
    public static void main(String[] args) {
        System.out.println("Enter Number of cities");
        int count = scan.nextInt();
        for(int i=0;i<count;i++){
            System.out.println("Enter city");
            char city = scan.next().charAt(0);
            System.out.println("Enter dest Points");
            int dest = scan.nextInt();
            for(int j=0;j<dest;j++){
                RouteInfo info = new RouteInfo();
                System.out.println("Enter dest city");
                info.setDestCity(scan.next().charAt(0));
                System.out.println("Enter distance");
                info.setDistance(scan.nextInt());
                cityList.add(info);
            }
            logic.setDistance(city,cityList);
        }
        execution();
    }

    public static void execution() {
        System.out.println("1.List cities\n2.Find city\n3.shortest-route\n4.Add route\n5.Delete root\nexit");
        switch (scan.nextInt()){
            case 1:
                for(Map.Entry entry: logic.getCities().entrySet())
                    System.out.println(entry.getKey());
                execution();

            case 2:
                System.out.println("Enter city");
                char city = scan.next().charAt(0);
                HashMap<Character, HashMap<Character,Integer>> map = logic.getCities();
                    if (map.containsKey(city))
                        System.out.println("city " + city + " found");
                    else
                        System.out.println("city " + city + " Not found");
                 execution();

            case 3:
                System.out.println("Enter city");
                char from = scan.next().charAt(0);
                System.out.println("Enter Destination city");
                char to = scan.next().charAt(0);
                execution();

            case 4:
                RouteInfo info = new RouteInfo();
                System.out.println("Enter city");
                info.setFromCity(scan.next().charAt(0));
                System.out.println("Enter Destination city");
                info.setDestCity(scan.next().charAt(0));
                System.out.println("Enter distance");
                info.setDistance(scan.nextInt());
                System.out.println(logic.addRoute(info));
                execution();

            case 5:
                RouteInfo routeInfo = new RouteInfo();
                System.out.println("Enter city");
                routeInfo.setFromCity(scan.next().charAt(0));
                System.out.println("Enter Destination city");
                routeInfo.setDestCity(scan.next().charAt(0));
                System.out.println(logic.deleteRoute(routeInfo));
                execution();
            case 6:
                break;

        }
    }
}
