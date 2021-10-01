package chessTournament;

import java.util.*;

public class Logical {

    void playersInitialisation(ArrayList<PlayerInfo> playerList){
        LinkedHashMap<Integer,PlayerInfo>map = new LinkedHashMap<>();
        for(int i=0;i<playerList.size();i++){
            PlayerInfo info = playerList.get(i);
            map.put(info.getPlayerId(),info);
        }
        Cache.OBJECT.setPlayerMap(map);
    }

     List<Map.Entry<Integer,PlayerInfo>> getPlayerList(){
        LinkedHashMap<Integer,PlayerInfo>map =  Cache.OBJECT.getPlayerMap();
        Set<Map.Entry<Integer,PlayerInfo>> entrySet = map.entrySet();
        List<Map.Entry<Integer,PlayerInfo>> playerList = new ArrayList<>(entrySet);
        Collections.sort(playerList, new Comparator<Map.Entry<Integer, PlayerInfo>>() {
            @Override
            public int compare(Map.Entry<Integer, PlayerInfo> player1, Map.Entry<Integer, PlayerInfo> player2) {
                float player1Point =  player1.getValue().getPoint();
                float player2point = player2.getValue().getPoint();
                if(player1Point>player2point)
                    return -1;
                else if(player2point>player1Point)
                    return 1;
                else
                    return 0;
            }
        });
        return playerList;
    }

    void opponentSet(List<Map.Entry<Integer,PlayerInfo>> list){
        if(list.size()%2==0){
            for(int i=0;i<list.size();i+=2){
                Map.Entry<Integer,PlayerInfo> player1 = list.get(i);
                Map.Entry<Integer,PlayerInfo> player2 = list.get(i+1);
                ArrayList<String >list1 = player1.getValue().getOpponentList();
                if(list1==null)
                    list1 = new ArrayList<>();
                list1.add(player2.getValue().getName());
                ArrayList<String >list2 = player2.getValue().getOpponentList();
                if(list2==null)
                    list2 = new ArrayList<>();
                list2.add(player1.getValue().getName());
            }
        }
    }

    List<Map.Entry<Integer,PlayerInfo>> getPoints(List<Map.Entry<Integer,PlayerInfo>>playerMap){
        Map.Entry<Integer,PlayerInfo> oddInfo = null;
        LinkedHashMap<Integer,PlayerInfo>map =new LinkedHashMap<>();
        if(playerMap.size()%2!=0){
             oddInfo = playerMap.remove(playerMap.size()-1);
        }
        for(int i=0;i<playerMap.size();i++){
            Map.Entry<Integer,PlayerInfo> entry = playerMap.get(i);
            PlayerInfo info = entry.getValue();
            if(i%2==0){
                info.setPoint(info.getPoint()+1.0f);
                info.setMatchPoint(1.0f);
                ArrayList<String> list = info.getResultList();
                if(list==null)
                    list = new ArrayList<>();
                list.add("win");
                info.setResultList(list);
                info.setStatus("win");
            }
            else{
                info.setPoint(info.getPoint()+0.0f);
                info.setMatchPoint(0.0f);
                ArrayList<String> list = info.getResultList();
                if(list==null)
                    list = new ArrayList<>();
                list.add("lose");
                info.setResultList(list);
                info.setStatus("lose");
            }
            map.put(info.getPlayerId(),info);
        }
        if(oddInfo!=null){
            PlayerInfo info = oddInfo.getValue();
            info.setStatus("win");
            info.setPoint(info.getPoint()+1.0f);
            info.setMatchPoint(1.0f);
            ArrayList<String> list = info.getResultList();
            if(list==null)
                list = new ArrayList<>();
            list.add("win");
            info.setResultList(list);
            map.put(info.getPlayerId(),info);
        }
        playerMap=new ArrayList<>(map.entrySet());
        Cache.OBJECT.setPlayerMap(map);
        return playerMap;
    }

}
