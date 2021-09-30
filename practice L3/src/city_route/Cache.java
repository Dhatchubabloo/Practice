package city_route;

import java.util.HashMap;

public enum Cache {
    OBJECT;
    private static HashMap<Character, HashMap<Character,Integer>>routeMap = new HashMap<>();

    void setRouteMap(char city,HashMap<Character,Integer>map){
        routeMap.put(city,map);
    }
    HashMap<Character, HashMap<Character,Integer>>getRouteMap(){
        return routeMap;
    }
}
