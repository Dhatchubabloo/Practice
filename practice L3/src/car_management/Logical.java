package car_management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Logical {

    void dataStore(HashMap<String, HashMap<String, ArrayList<CarInfo>>>wholeMap){
        Cache.OBJECT.setData(wholeMap);
    }

    public String dispatch(ArrayList<DispatchInfo> list){
        HashMap <String, HashMap<String, ArrayList<CarInfo>>>detailsMap =Cache.OBJECT.getData();
        for(int i=0;i<list.size();i++) {
            for (Map.Entry<String, HashMap<String, ArrayList<CarInfo>>> entry : detailsMap.entrySet()) {
                DispatchInfo info = list.get(i);
                if (entry.getKey().equals(info.getCity())) {
                    for (Map.Entry<String, ArrayList<CarInfo>> map : entry.getValue().entrySet()) {
                        if (map.getKey().equals(info.getBranch())) {
                            CarInfo data =map.getValue().get(i);
                            data.setCar(info.getCar());
                            data.setCount(info.getCount());
                            break;
                        }
                    }
                }
            }
        }
        Cache.OBJECT.setData(detailsMap);
        return "CAR DISPATCHED....!";
    }
    public boolean customer(CustomerInfo info){
        int temp=0;
        HashMap <String, HashMap<String, ArrayList<CarInfo>>>detailsMap =Cache.OBJECT.getData();
        for(Map.Entry<String, HashMap<String, ArrayList<CarInfo>>> entry:detailsMap.entrySet()){
            if(entry.getKey().equals(info.getCity())){
                for(Map.Entry<String, ArrayList<CarInfo>> map:entry.getValue().entrySet()){
                    if(map.getKey().equals(info.getBranch())){
                        for(int i=0;i<2;i++) {
                            CarInfo data = map.getValue().get(i);
                            if (info.getCar().equals(data.getCar())) {
                                System.out.println("Happy");
                                int count = data.getCount();
                                System.out.println(count+" : count");
                                if (count == 0) {
                                    temp++;
                                } else
                                    data.setCount(--count);
                                break;
                            } else
                                temp++;
                        }
                    }
                }
            }
        }
        Cache.OBJECT.setData(detailsMap);
        return temp<=1;
    }
    String soldFirst=null;
    void setSoldFirst(String city,String car){
        soldFirst = city+" - "+car;
    }
    String getSoldFirst(){
        return soldFirst;
    }
    HashMap<String, HashMap<String, ArrayList<CarInfo>>> getData(){
        return Cache.OBJECT.getData();
    }
    String soldLast=null;
    public void setSoldRecent(String city,String car) {
        soldLast = city+" - "+car;
    }
    String getSoldLast(){
        return soldLast;
    }
    HashMap addStock(){
        HashMap<String,Integer> countList = new HashMap();
        for(Map.Entry<String, HashMap<String, ArrayList<CarInfo>>> entry:Cache.OBJECT.getData().entrySet()){
            int count=0;
            for(Map.Entry<String, ArrayList<CarInfo>> map:entry.getValue().entrySet()){
                for(int i=0;i<2;i++) {
                    CarInfo info = map.getValue().get(i);
                    count += info.getCount();
                }
            }
            if(count<20){
                countList.put(entry.getKey(), count);
            }
        }
        return countList;
    }

    public String updateSalesData(int[] array) {
        Cache.OBJECT.setSalesData(array);
        return "SALES DATA UPDATED....!";
    }
    ArrayList<String> getProdfitData() {
        ArrayList<String> profitList=new ArrayList<>();
        int[] array = Cache.OBJECT.getSalesData();
        if (array == null){
            profitList.add("No Sales Data....!");
        }
        else {
            String temp = "(";
            int start = 0;
            int index = 0;
            int count = 0;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] < array[i + 1]) {
                    count++;
                    index = i + 1;
                } else {
                    if (start == index)
                        temp += array[start] + ")";
                    else
                        temp += array[start] + "," + array[index] + ")";
                    profitList.add(temp);
                    start = i + 1;
                    temp = "(";
                    index=start;
                }
            }

            if (count == 0) {
                profitList.clear();
                profitList.add("No profit...!");
            } else {
                if(start==index)
                    temp += array[start] + ")";
                else {
                    temp += array[start] + "," + array[index] + ")";
                    profitList.add(temp);
                }
            }
        }
         return profitList;
    }
}
