package chess_tournament;

import java.util.HashMap;
import java.util.LinkedHashMap;

public enum Maphandler{
    OBJECT;

    private LinkedHashMap<Integer,PlayerInfo> playerDetails = new LinkedHashMap<>();

    public void playersData(LinkedHashMap<Integer,PlayerInfo> pointsMap){
        playerDetails = pointsMap;
    }

    public HashMap <Integer,PlayerInfo>pointsData(){
        return playerDetails;
    }
    public void pointupdate(PlayerInfo info){
        playerDetails.put(info.getPlayer_id(),info);
    }
}
