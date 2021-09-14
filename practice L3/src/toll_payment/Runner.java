package toll_payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Runner {
    static  Scanner scan = new Scanner(System.in);
    static Logical logic = new Logical();
    static HashMap<Integer,ArrayList<TollInfo>>tollInfoMap = new HashMap<>();
    public static void main(String[]args){
        System.out.println("Enter Number of tolls");
        int toll = scan.nextInt();
        ArrayList<ChargingInfo>chargeList = new ArrayList<>();
        for(int i=1;i<=toll;i++){
            ArrayList<TollInfo>list = new ArrayList<>();
            ChargingInfo info = new ChargingInfo();
            if(i%2==0){
                info.setTollNumber(i);
                info.setTwoWheeler(50);
                info.setFourWheeler(100);
                info.setHeavyLoadVehicle(200);
            }
            else{
                info.setTollNumber(i);
                info.setTwoWheeler(100);
                info.setFourWheeler(150);
                info.setHeavyLoadVehicle(250);
            }
            chargeList.add(info);
            tollInfoMap.put(i,list);
        }
        HashMap<Integer, ChargingInfo> map = logic.initialCharging(chargeList);
        System.out.println("Toll\t2-wheeler\t4-wheeler\theavyloader");
        for(Map.Entry entry :map.entrySet()){
            System.out.println(entry.getKey()+"\t"+entry.getValue());
        }
        execute();
    }
    static Runner run = new Runner();
    ArrayList<VehicleInfo> list = new ArrayList<>();
    public static void execute(){
        System.out.println();
        System.out.println("1.vehicle passing");
        System.out.println("2.Toll Details");
        System.out.println("3.Exit");
        int option = scan.nextInt();
        switch (option){
            case 1:
                System.out.println("Choose vehicle Type");
                System.out.println("a.2-wheeler");
                System.out.println("b.4-wheeler");
                System.out.println("c.heavy Loader");
                char choice = scan.next().charAt(0);
                switch (choice){
                    case 'a':
                       run.vehicle("2-wheeler",run.list);
                        execute();
                        break;
                    case 'b':
                        run.vehicle("4-wheeler",run.list);
                        execute();
                        break;
                    case 'c':
                        run.vehicle("heavyLoader",run.list);
                        execute();
                        break;
                }

            case 2:
                ArrayList<VehicleInfo> infoList = logic.getvehicleData();
                for(int j=0;j<infoList.size();j++) {
                    VehicleInfo info = infoList.get(j);
                    if (info.getVehicle() != null) {
                        HashMap<Integer, ArrayList<TollInfo>> map = logic.tollDetails(tollInfoMap, info);
                        if(j==infoList.size()-1) {
                            for (Map.Entry<Integer, ArrayList<TollInfo>> entry : map.entrySet()) {
                                System.out.println("Toll - " + entry.getKey());
                                ArrayList<TollInfo> list = entry.getValue();
                                int len = list.size();
                                int total = 0;
                                System.out.println("Total vehicle crossed :" + len);
                                for (int i = 0; i < len; i++) {
                                    System.out.println(list.get(i));
                                    total += list.get(i).getTotalAmount();
                                }
                                System.out.println("Total Amount Collected by the Toll was :" + total);
                                System.out.println("***********************************************************************");
                            }
                        }
                    } else
                        System.out.println("No vehicle passed in any Tollgates");
                }
                execute();
            case 3:
                break;
        }
    }
    public void vehicle(String type,ArrayList<VehicleInfo> list){
        VehicleInfo info = new VehicleInfo();
        System.out.println("Enter Starting toll");
        int startToll = scan.nextInt();
        System.out.println("Enter destination toll");
        int destToll = scan.nextInt();
        System.out.println("Are you a VIP user (yes/no)");
        String vip = scan.next();
        info.setVehicle(type);
        info.setStartPoint(startToll);
        info.setDestPoint(destToll);
        info.setVip(vip);
        info.setAmount(0);
        list.add(info);
        ArrayList<VehicleInfo> list1 =logic.vehicleDetails(info);
        logic.setVehicleData(list1);
        System.out.println("Number\tvehicle type\t" +
                "start-toll\tEnd-toll\tVIP\t\tAmount");
        for(int i=0;i<list.size();i++){
            System.out.println(i+1+"\t"+list.get(i));
            System.out.println("-------------------------------------------------------------");
        }
    }
}
