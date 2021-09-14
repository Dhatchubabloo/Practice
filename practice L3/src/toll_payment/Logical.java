package toll_payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Logical {
    public HashMap<Integer, ChargingInfo> initialCharging(ArrayList<ChargingInfo>list){
        HashMap<Integer, ChargingInfo>tollMap = new HashMap<>();
        for(int i=0;i<list.size();i++){
            ChargingInfo info = list.get(i);
            tollMap.put(info.getTollNumber(),info);
        }
        Cache.OBJECT.setTollDetails(tollMap);
        return tollMap;
    }

    ArrayList<VehicleInfo> vehicleList = new ArrayList<>();

    public  ArrayList<VehicleInfo> vehicleDetails(VehicleInfo info){
        int start = info.getStartPoint();
        int end = info.getDestPoint();
        int amount = info.getAmount();
        String vehicle = info.getVehicle();
        HashMap<Integer, ChargingInfo> map = Cache.OBJECT.getTollDetails();
        if(vehicle.equals("2-wheeler")) {
            for (int i = start; i <= end; i++) {
                ChargingInfo object = map.get(i);
                amount += object.getTwoWheeler();
            }
            if(info.getVip().equals("yes")){
                int discount = (amount*20)/100;
                amount -=discount;
            }
            info.setAmount(amount);
            vehicleList.add(info);
        }
        else if(vehicle.equals("4-wheeler")){
            for (int i = start; i <= end; i++) {
                ChargingInfo object = map.get(i);
                amount += object.getFourWheeler();
            }
            if(info.getVip().equals("yes")){
                int discount = (amount*20)/100;
                amount -=discount;
            }
            info.setAmount(amount);
            vehicleList.add(info);
        }
        else if(vehicle.equals("heavyLoader")){
            for (int i = start; i <= end; i++) {
                ChargingInfo object = map.get(i);
                amount += object.getHeavyLoadVehicle();
            }
            if(info.getVip().equals("yes")){
                int discount = (amount*20)/100;
                amount -=discount;
            }
            info.setAmount(amount);
            vehicleList.add(info);
        }
        return vehicleList;
    }

    public void setVehicleData(ArrayList<VehicleInfo> info){
        Cache.OBJECT.setVehicleDetails(info);
    }
    public ArrayList<VehicleInfo> getvehicleData(){
        return Cache.OBJECT.getVehicleDetails();
    }

    public HashMap<Integer,ArrayList<TollInfo>> tollDetails
            (HashMap<Integer,ArrayList<TollInfo>> tollMap,VehicleInfo info){
        int start = info.getStartPoint();
        int end = info.getDestPoint();
        while(start<=end){
            TollInfo obj = new TollInfo();
            for(Map.Entry<Integer,ArrayList<TollInfo>>entry:tollMap.entrySet()){
                if(entry.getKey()==start){
                    ArrayList<TollInfo>list = entry.getValue();
                    obj.setVehicleType(info.getVehicle());
                    HashMap<Integer,ChargingInfo>map = Cache.OBJECT.getTollDetails();
                    ChargingInfo charge = map.get(start);
                    if(info.getVehicle().equals("2-wheeler")){
                        int amount = obj.getTotalAmount();
                        amount+=charge.getTwoWheeler();
                        if(info.getVip().equals("yes")){
                            int discount = (amount*20)/100;
                            amount-=discount;
                        }
                        obj.setTotalAmount(amount);
                    }
                    else if(info.getVehicle().equals("4-wheeler")){
                        int amount = obj.getTotalAmount();
                        amount+=charge.getFourWheeler();
                        if(info.getVip().equals("yes")){
                            int discount = (amount*20)/100;
                            amount-=discount;
                        }
                        obj.setTotalAmount(amount);
                    }
                    else if(info.getVehicle().equals("heavyLoader")){
                        int amount = obj.getTotalAmount();
                        amount+=charge.getHeavyLoadVehicle();
                        if(info.getVip().equals("yes")){
                            int discount = (amount*20)/100;
                            amount-=discount;
                        }
                        obj.setTotalAmount(amount);
                    }
                    list.add(obj);
                    tollMap.put(entry.getKey(),list);
                    start++;
                    break;
                }
            }
        }
        return tollMap;
    }
}
