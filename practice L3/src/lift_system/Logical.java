package lift_system;

import java.util.*;

public class Logical {
    public HashMap<Integer,Integer> LiftDetails(ArrayList<LiftInfo> list){
        HashMap<Integer,Integer>listMap = new HashMap<>();
        for(int i=0;i<list.size();i++){
            LiftInfo info = list.get(i);
            listMap.put(info.getLiftNumber(), info.getFloor());
        }
        Cache.OBJECT.LiftDetails(listMap);
        return listMap;
    }

    public  HashMap<Integer,Integer> liftAssign(Integer from,Integer to){
        HashMap<Integer,Integer> map = Cache.OBJECT.retriveListDetails();
        Collection<Integer> keys = map.values();
        int count=0;
        for(Integer value:keys){
            if(value!=0){
                count++;
            }
        }
        if(count==0){
            map.put(1,to);
            Cache.OBJECT.liftUpdation(1,to);
        }
        else {
            ArrayList list = new ArrayList();
            for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
                list.add(entry.getKey());
                list.add(entry.getValue());
            }
            Integer diff = from -(Integer) list.get(1);
            if(diff<0){
                diff = diff*(-1);
            }
            Integer lift = (Integer) list.get(0);
            for(int i=1;i< list.size();i+=2){
                if(from==list.get(i)){
                    lift = (Integer) list.get(i - 1);
                    map.put(lift,to);
                    Cache.OBJECT.liftUpdation(lift,to);
                    break;
                }
                else {
                    Integer diff1 = from - (Integer) list.get(i);
                    if(diff1<0){
                        diff1 = diff1*(-1);
                    }
//                    if(diff1==diff){
//                        if(from>to){
//
//                        }
//                        else{
//
//                        }
//                    }
                    if (diff1 < diff) {
                        diff = diff1;
                        lift = (Integer) list.get(i - 1);
                    }
                }
            }
            map.put(lift,to);
            Cache.OBJECT.liftUpdation(lift,to);
        }
        return map;
    }
    public  HashMap<Integer,Integer> liftStatus(){
        HashMap<Integer,Integer> map = Cache.OBJECT.retriveListDetails();
        return map;
    }
    public String working(int lift){
        HashMap<Integer,Integer> map=Cache.OBJECT.retriveListDetails();
        map.put(lift,0);
        Cache.OBJECT.liftUpdation(lift,0);
        return "The life was marked as working...";
    }
    public String notWorking(int lift){
        HashMap<Integer,Integer> map=Cache.OBJECT.retriveListDetails();
        map.put(lift,-1);
        Cache.OBJECT.liftUpdation(lift,-1);
        return "The life was marked as not working...";
    }
}
