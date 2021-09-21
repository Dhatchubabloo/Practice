package car_management;

import java.util.ArrayList;
import java.util.HashMap;

public enum Cache {
    OBJECT;
    HashMap<String, HashMap<String, ArrayList<CarInfo>>>wholeInfoMap = new HashMap<>();
    int array[]=null;
    void setData(HashMap<String, HashMap<String, ArrayList<CarInfo>>> map){
        wholeInfoMap =map;
    }
    HashMap<String, HashMap<String, ArrayList<CarInfo>>> getData(){
        return wholeInfoMap;
    }

    public void setSalesData(int[] array) {
        this.array = array;
    }
    public int [] getSalesData(){
        return array;
    }
}
