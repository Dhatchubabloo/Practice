package chessTournament;

import java.util.LinkedHashMap;

public enum Cache {
    OBJECT;
    private LinkedHashMap<Integer,PlayerInfo>playerMap = new LinkedHashMap<>();

    void setPlayerMap(LinkedHashMap<Integer,PlayerInfo> map){
        playerMap = map;
    }

    LinkedHashMap<Integer,PlayerInfo> getPlayerMap(){
        return playerMap;
    }

}
