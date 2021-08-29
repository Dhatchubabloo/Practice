package lift_system;

import java.util.HashMap;

public enum Cache {
    OBJECT;
    private HashMap<Integer,Integer> listMap = new HashMap<>();
    public  void LiftDetails( HashMap<Integer,Integer> map){
        listMap=map;
    }
    public  HashMap<Integer,Integer> retriveListDetails(){
        return listMap;
    }

    public void liftUpdation(Integer lift,Integer floor){
        listMap.put(lift,floor);
    }
}
