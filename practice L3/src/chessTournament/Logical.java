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

    void shedule(List<Map.Entry<Integer,PlayerInfo>> playerList){
        for(int i=0;i< playerList.size();i++){

        }
    }

    void opponentSet(){
        LinkedHashMap<Integer,PlayerInfo>map =Cache.OBJECT.getPlayerMap();
        List<Map.Entry<Integer,PlayerInfo>> list = new ArrayList<>(map.entrySet());
        if(list.size()%2==0){
            map=getOpponent(list);
        }
        else{
            Map.Entry<Integer,PlayerInfo> oddPlayer = list.remove(list.size()-1);
           map =  getOpponent(list);
            PlayerInfo oddInfo = oddPlayer.getValue();
            ArrayList<Integer> oddList = oddInfo.getOpponentIdList();
            if(oddList==null)
                oddList = new ArrayList<>();
            oddList.add(0);
            oddInfo.setOpponentIdList(oddList);
            map.put(oddInfo.getPlayerId(),oddInfo);
        }
        System.out.println(list);
        System.out.println("map size -------------"+map.size());
        System.out.println(map);
        Cache.OBJECT.setPlayerMap(map);
    }


    LinkedHashMap<Integer,PlayerInfo> getOpponent(List<Map.Entry<Integer,PlayerInfo>> list){
        LinkedHashMap<Integer,PlayerInfo>map =new LinkedHashMap<>();
        for(int i=0;i<list.size();i+=2){
            Map.Entry<Integer,PlayerInfo> player1 = list.get(i);
            Map.Entry<Integer,PlayerInfo> player2 = list.get(i+1);

            PlayerInfo player1Info = player1.getValue();
            ArrayList<Integer> idList1 = player1Info.getOpponentIdList();
            if(idList1==null)
                idList1 =new ArrayList<>();
            idList1.add(player2.getValue().getPlayerId());
            player1Info.setOpponentIdList(idList1);
            map.put(player1Info.getPlayerId(),player1Info);
            PlayerInfo player2Info = player2.getValue();
            ArrayList<Integer> idList2 = player2Info.getOpponentIdList();
            if(idList2==null)
                idList2 =new ArrayList<>();
            idList2.add(player1.getValue().getPlayerId());
            player2Info.setOpponentIdList(idList2);
            map.put(player2Info.getPlayerId(),player2Info);
        }
        return map;
    }
    List<Map.Entry<Integer,PlayerInfo>> getPoints(List<Map.Entry<Integer,PlayerInfo>>playerMap){
        Map.Entry<Integer,PlayerInfo> oddInfo = null;
        LinkedHashMap<Integer,PlayerInfo>map =new LinkedHashMap<>();
        if(playerMap.size()%2!=0){
             oddInfo = playerMap.remove(playerMap.size()-1);
        }
        for(int i=0;i<playerMap.size();i+=2){
            int min=0;
            int max =2;
            int val = (int)Math.floor((Math.random()*(max-min+1)+min));
            PlayerInfo player1Info = playerMap.get(i).getValue();
            PlayerInfo player2Info = playerMap.get(i+1).getValue();
            ArrayList<PlayerInfo>list=null;
            if(val==1){
               list = setPoint(player1Info,player2Info,"win","lose");
            }
            else if(val==2){
                list =   setPoint(player1Info,player2Info,"lose","win");
            }
            else if(val==0){
                list =   setPoint(player1Info,player2Info,"Tie","Tie");
            }
            player1Info = list.get(0);
            player2Info = list.get(1);
            map.put(player1Info.getPlayerId(),player1Info);
            map.put(player2Info.getPlayerId(),player2Info);
        }
        if(oddInfo!=null){
            PlayerInfo info = oddInfo.getValue();
            info.setStatus("win");
            info.setPoint(info.getPoint()+1.0f);
            info.setMatchPoint(1.0f);
            float bonus = info.getBonusPoint();
            info.setBonusPoint(++bonus);
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


    ArrayList<PlayerInfo> setPoint(PlayerInfo player1Info,PlayerInfo player2Info,String type1,String type2){
        ArrayList<PlayerInfo>playerList = new ArrayList<>();
        float player1point=0;
        float player2point=0;
        if(type1.equals("win")){
            player1point=1;
            player2point=0;
        }
        else if(type1.equals("lose")){
            player1point=0;
            player2point=1;
        }
        else if(type1.equals("Tie")){
            player1point=0.5f;
            player2point=0.5f;
        }
        player1Info.setPoint(player1Info.getPoint()+player1point);
        player1Info.setMatchPoint(player1point);
        ArrayList<String> list = player1Info.getResultList();
        if(list==null)
            list = new ArrayList<>();
        list.add(type1);
        player1Info.setResultList(list);
        player1Info.setStatus(type1);

        player2Info.setPoint(player2Info.getPoint()+player2point);
        player2Info.setMatchPoint(player2point);
        ArrayList<String> list1 = player2Info.getResultList();
        if(list1==null)
            list1 = new ArrayList<>();
        list1.add(type2);
        player2Info.setResultList(list1);
        player2Info.setStatus(type2);
        playerList.add(player1Info);
        playerList.add(player2Info);
        return playerList;
    }
    LinkedHashMap<Integer,PlayerInfo> getPlayerMap(){
        return Cache.OBJECT.getPlayerMap();
    }

    ArrayList<String> getPlayerDetails(String playerName){
        LinkedHashMap<Integer,PlayerInfo> map = Cache.OBJECT.getPlayerMap();
        int count=0;
        ArrayList<String>playerDetailsList = new ArrayList<>();
        for(Map.Entry<Integer,PlayerInfo> entry:map.entrySet()){
            PlayerInfo info = entry.getValue();
            if(info.getName().equals(playerName)){
                count++;
                ArrayList<Integer > opponent = info.getOpponentIdList();
                ArrayList<String> result = info.getResultList();
                for(int i=0;i< opponent.size();i++){
                    int match = i+1;
                    if(opponent.get(i)==0) {
                        String temp = "Match "+match+"\t\tvs\t\t bye"+"\t"+result.get(i);
                        playerDetailsList.add(temp);
                        continue;
                    }
                    PlayerInfo opponentInfo= map.get(opponent.get(i));
                    String temp = "Match "+match+"\t\tvs\t\t"+opponentInfo.getName()+"\t"+result.get(i);
                    playerDetailsList.add(temp);
                }
            }
        }
        if(count==map.size())
            playerDetailsList.add("Invalid player...No player details");
        return playerDetailsList;
    }
    ArrayList<String > getPlayerRank(){
        LinkedHashMap<Integer,PlayerInfo>map =  Cache.OBJECT.getPlayerMap();
        int rank=1;
        ArrayList<String>rankList = new ArrayList<>();
        List<Map.Entry<Integer,PlayerInfo>> list = getPlayerList();
        Map.Entry<Integer,PlayerInfo> val = list.get(0);
        List<Map.Entry<Integer,PlayerInfo>>tempList = new ArrayList<>();
        for(int i=1;i< list.size();i++){
            Map.Entry<Integer,PlayerInfo> entry = list.get(i);
            if(val.getValue().getPoint()==entry.getValue().getPoint()){
                tempList.add(entry);
                continue;
            }
            if(tempList.size()!=0){
                tempList.add(val);
                ArrayList<Map.Entry<Integer,PlayerInfo>>cumulativePointList = new ArrayList<>();
                for(Map.Entry<Integer,PlayerInfo>entries:tempList){
                    ArrayList<Integer> idList= entries.getValue().getOpponentIdList();
                    float sum=0;
                    for(Integer id:idList){
                        sum+=map.get(id).getPoint();
                    }
                    entries.getValue().setCumulativepoint(sum);
                    cumulativePointList.add(entries);
                }
                List<Map.Entry<Integer,PlayerInfo>>sortList =   sortByCumulativePoints(cumulativePointList);
                for(int j=0;j< sortList.size();j++){
                    Map.Entry<Integer,PlayerInfo> entry1 = sortList.get(j);
                    String temp = "Rank "+rank+":\t"+entry1.getValue().getName()+"("+entry1.getValue().getPoint()+")";
                    rankList.add(temp);
                    rank++;
                }
                val = list.get(i);
            }
            else {
                Map.Entry<Integer,PlayerInfo>prevInfo = list.get(i-1);
                String prevtemp ="Rank " + rank + ":\t" + prevInfo.getValue().getName() + "(" + prevInfo.getValue().getPoint() + ")";
                rankList.add(prevtemp);
                rank++;
                val = list.get(i);
            }

        }
        return rankList;
    }

    List<Map.Entry<Integer,PlayerInfo>> sortByCumulativePoints(List<Map.Entry<Integer,PlayerInfo>>playerList){
        Collections.sort(playerList, new Comparator<Map.Entry<Integer, PlayerInfo>>() {
            @Override
            public int compare(Map.Entry<Integer, PlayerInfo> p1, Map.Entry<Integer, PlayerInfo> p2) {
                float player1Point = p1.getValue().getCumulativepoint();
                float player2Point = p2.getValue().getCumulativepoint();
                if(player1Point>player2Point)
                    return -1;
                else if(player1Point<player2Point)
                    return 1;
                else
                    return 0;
            }
        });
        return playerList;
    }

    void rankListSort(){

    }
}