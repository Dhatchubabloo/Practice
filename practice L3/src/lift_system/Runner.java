package lift_system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Runner {
    static Scanner scan = new Scanner(System.in);
    public static void main(String []args) {
        new Runner().execution();
    }
        public void execution(){
            System.out.println("1.initial position");
            System.out.println("2.Assigned to user");
            System.out.println("3.Maintenance");
            System.out.println("4.Lift status");
            System.out.println("5.Exit");
            int option = scan.nextInt();
            Logical logic = new Logical();
            switch (option) {
                case 1:
                    System.out.println("Enter no of lifts");
                    int number = scan.nextInt();
                    ArrayList<LiftInfo> list = new ArrayList();
                    System.out.println("Enter Lifts");
                    for (int i = 0; i < number; i++) {
                        LiftInfo info = new LiftInfo();
                        info.setLiftNumber(scan.nextInt());
                        System.out.println("Enter capacity");
                        info.setCapacity(scan.nextInt());
                        info.setFloor(0);
                        list.add(info);
                    }
                    HashMap<Integer, Integer> map = logic.LiftDetails(list);
                    System.out.println("Initial positions of Lifts");
                    System.out.println("lift\t\tFloor");
                    for (Map.Entry entry : map.entrySet()) {
                        System.out.println(entry.getKey() + "\t\t\t" + entry.getValue());
                    }
                    execution();
                    break;
                case 2:
                    System.out.println("From floor");
                    int from = scan.nextInt();
                    if(from<0){
                        System.out.println("Enter valid floor");
                        execution();
                    }
                    System.out.println("To floor");
                    int to = scan.nextInt();
                    if(to<0){
                        System.out.println("Enter valid floor");
                        execution();
                    }
                    HashMap<Integer, Integer> liftMap = logic.liftAssign(from, to);
                    System.out.println("lift\t\tFloor");
                    for (Map.Entry entry : liftMap.entrySet()) {
                        System.out.println(entry.getKey() + "\t\t\t" + entry.getValue());
                    }
                    execution();
                    break;
                case 3:
                    System.out.println("1.Working");
                    System.out.println("2.Not Working");
                    int choice = scan.nextInt();
                    if(choice==1) {
                        System.out.println("Enter the lift");
                        int lift = scan.nextInt();
                        System.out.println(logic.working(lift));
                        execution();
                    }
                    else if(choice==2){
                        System.out.println("Enter the lift");
                        int lift = scan.nextInt();
                        System.out.println(logic.notWorking(lift));
                        execution();
                    }
                    else
                        System.out.println("invalid option");
                    break;
                case 4:
                    System.out.println("lift\t\tFloor");
                    if(logic.liftStatus().entrySet()==null){
                        System.out.println("There will be no lifts");
                    }else {
                        for (Map.Entry entry : logic.liftStatus().entrySet()) {
                            System.out.println(entry.getKey() + "\t\t\t" + entry.getValue());
                        }
                    }
                    execution();
                    break;
                case 5:
                    break;
            }
        }
    }
