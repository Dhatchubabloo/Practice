package toll_payment;

import java.util.ArrayList;
import java.util.HashMap;

public enum Cache {
    OBJECT;
    HashMap<Integer, ChargingInfo> tollDetailsMap = new HashMap<>();
    ArrayList<VehicleInfo>list = new ArrayList<>();

    public void setTollDetails(HashMap<Integer, ChargingInfo> tollMap){
        tollDetailsMap = tollMap;
    }

    public  HashMap<Integer, ChargingInfo> getTollDetails(){
        return tollDetailsMap;
    }

    public void setVehicleDetails(ArrayList<VehicleInfo> info){
        list = info;
    }
    public  ArrayList<VehicleInfo> getVehicleDetails(){
        return list;
    }
}
