package Event;

import java.util.ArrayList;
import java.util.Scanner;

/*
        writing fast test 60min
        overloading in python 45min
        lua for the masses 30min
        ruby error version 45min
        common ruby error 45min
        rails for python developer lightning
        communicating over distance 60min
        accounting developement 45min
        woah 30min
        sit down and write 30min
        pair vs noise 45min
        rail magic 60min
        ruby on rails move 60min
        clojure ate 45min
        programming in boondocks 30min
        ruby vs clojure 30min
        ruby on rail legacy 60min
        a world without hacker 30min
        user interface CSS 30min
 */
public class Runner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Logical logic = new Logical();
        System.out.println("Enter events");
        ArrayList<EventInfo> eventList = new ArrayList<>();
        for(int i=0;i<18;i++){
            EventInfo info = new EventInfo();
            String event = scan.nextLine();
            info.setEvent(event);
            String array[] = event.split(" ");
            int len = array.length;
            String time1 = array[len-1];int sum=0;
            if(time1.equals("lightning")){
                info.setDuration(5);
                eventList.add(info);
                continue;
            }
            for(int j=0;j<2;j++){
                sum = (sum*10)+time1.charAt(j)-48;
            }
            System.out.println(sum+"sum");
            info.setDuration(sum);
            eventList.add(info);
        }
        ArrayList<String> orderList =logic.eventManagement(eventList);
        System.out.println("Track-1");
        for(String i:orderList)
            System.out.println(i);
    }
}





















