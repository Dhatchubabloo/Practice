/*
writing fast test 60min
overloading in python 45min
lua for the masses 30min
ruby error version 45min
common ruby error 45min
rails for python developer 30min
communicating over distance 60min
accounting developement 45min
woah 30min
sit down and write 30min
pair vs noise 45min
rail magic 60min
ruby on rails 60min
clojure ate 45min
programming in boondocks 30min
ruby vs clojure 30min
ruby on rail legacy 60min
a world without hacker 30min
user interface CSS 30min
 */
package Event_management;

import sun.util.resources.cldr.gu.LocaleNames_gu;

import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Logical logic = new Logical();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of Events");
        int events = scan.nextInt();
        scan.nextLine();
        ArrayList<String>eventList = new ArrayList<>();
        for(int i=0;i<events;i++){
            eventList.add(scan.nextLine());
        }
        ArrayList<String> list = logic.eventManagement(eventList);
        for(String i:list)
            System.out.println(i);
    }
}







