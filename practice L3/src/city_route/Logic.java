package city_route;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Logic {

    void setDistance(Character city,ArrayList<RouteInfo>cityList){
        HashMap<Character,Integer>inner = new HashMap<>();
        for(int i=0;i<cityList.size();i++){
            RouteInfo info = cityList.get(i);
            inner.put(info.getDestCity(),info.getDistance());
        }
        Cache.OBJECT.setRouteMap(city,inner);
    }
    HashMap<Character, HashMap<Character,Integer>> getCities(){
        return Cache.OBJECT.getRouteMap();
    }
    String findShortRoute(char fromCity,char toCity){
        HashMap<Character, HashMap<Character,Integer>> route = Cache.OBJECT.getRouteMap();
        if(route.containsKey(fromCity)&&route.containsKey(toCity)){
            HashMap<Character,Integer> val = route.get(fromCity);
            if(val.containsKey(toCity)){

            }
            else{

            }
        }
        else{

        }
        return null;
    }
    String  addRoute(RouteInfo info){
        HashMap<Character, HashMap<Character,Integer>> route = Cache.OBJECT.getRouteMap();
        if(route.containsKey(info.getFromCity())){
            HashMap<Character,Integer> inner = route.get(info.getFromCity());
            if(inner.containsKey(info.getDestCity())){
                return "Route already exists";
            }
            else{
                if(route.containsKey(info.getDestCity())) {
                    inner.put(info.getDestCity(), info.getDistance());
                    Cache.OBJECT.setRouteMap(info.getFromCity(), inner);
                    return "New Route Added";
                }
                else{
                    HashMap<Character,Integer>temp = new HashMap<>();
                    inner.put(info.getDestCity(), info.getDistance());
                    Cache.OBJECT.setRouteMap(info.getFromCity(), inner);
                    Cache.OBJECT.setRouteMap(info.getDestCity(),temp);
                    return "Route added between "+info.getFromCity()+"and"+info.getDestCity()+
                            " with distance "+info.getDistance() +
                            "I is a new city" +
                            " that will also get added.\n";
                }
            }
        }
        else
            return "Route cannot be added as city "+info.getFromCity()+" does not exist";

    }
    String  deleteRoute(RouteInfo info){
        HashMap<Character, HashMap<Character,Integer>> route = Cache.OBJECT.getRouteMap();
        if(route.containsKey(info.getFromCity())){
            HashMap<Character,Integer> inner = route.get(info.getFromCity());
            if(inner.containsKey(info.getDestCity())){
                int distance = inner.get(info.getDestCity());
                inner.remove(info.getDestCity(),distance);
                Cache.OBJECT.setRouteMap(info.getFromCity(),inner);
                return "route ("+info.getFromCity()+","+info.getDestCity()+") Deleted";
            }
            else
                return "route ("+info.getFromCity()+","+info.getDestCity()+") not found";
        }
        return "city Not Exist";
    }
}
