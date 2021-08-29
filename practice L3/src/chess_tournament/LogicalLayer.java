package chess_tournament;

import java.util.*;

public class LogicalLayer {

    public void playerDetails(ArrayList<PlayerInfo> list){
        HashMap<Integer,PlayerInfo>points = new HashMap<>();
        for(int i=0;i<list.size();i++){
            PlayerInfo info = list.get(i);
            points.put(info.getPlayer_id(),info);
        }
        sortTable(points);
    }

    public HashMap<Integer,PlayerInfo> getPoints(){
        HashMap<Integer,PlayerInfo>pointsTable=Maphandler.OBJECT.pointsData();
        return sortTable(pointsTable);
    }

    public HashMap<Integer,PlayerInfo> sortTable(HashMap<Integer,PlayerInfo>points){
        ArrayList<Map.Entry<Integer,PlayerInfo>>pointsList = new ArrayList<>();
        for(Map.Entry<Integer,PlayerInfo>entry:points.entrySet()){
            pointsList.add(entry);
        }
//        for(int i=pointsList.size()-1;i< points.size() ;i++){
//            float a = pointsList.get(i).getValue()+1;
//        }
//        Comparator<Map.Entry<Integer,PlayerInfo>>cmp = new Comparator<Map.Entry<Integer, PlayerInfo>>() {
//            @Override
//            public int compare(Map.Entry<Integer, PlayerInfo> o1, Map.Entry<Integer, PlayerInfo> o2) {
//                PlayerInfo info1 =o2.getValue();
//                PlayerInfo info2 =o1.getValue();
//                return info1.getPoints().compareTo(info2.getPoints());
//            }
//        };
//        Collections.sort(pointsList,cmp);
        LinkedHashMap<Integer,PlayerInfo> pointsTable =new LinkedHashMap();
        for(int i=0;i<pointsList.size();i++){
            Map.Entry entry = pointsList.get(i);
            PlayerInfo info =(PlayerInfo) entry.getValue();
            pointsTable.put((Integer) entry.getKey(),info);
        }
        Maphandler.OBJECT.playersData(pointsTable);
        return pointsTable;
    }

    public void pointsDetails(String result){
        HashMap<Integer,PlayerInfo>pointsTable=Maphandler.OBJECT.pointsData();
        for(Map.Entry<Integer,PlayerInfo> entry:pointsTable.entrySet()){
            PlayerInfo infer =entry.getValue();
                if (infer.getName().equals(result)) {
                    PlayerInfo value = entry.getValue();
                    float res = value.getPoints()+1;
                    PlayerInfo info = new PlayerInfo();
                    info.setPoints(value.getPoints()+res);
                    info.setName(value.getName());
                    Maphandler.OBJECT.pointupdate(info);
                }
        }
    }
    public void pointsDetails(ArrayList<String>names){
        HashMap<Integer,PlayerInfo>pointsTable=Maphandler.OBJECT.pointsData();
        for(int i=0;i<2;i++) {
            for (Map.Entry<Integer, PlayerInfo> entry : pointsTable.entrySet()) {
                PlayerInfo infer =entry.getValue();
                if (infer.getName().equals(names.get(i))) {
                    PlayerInfo value = entry.getValue();
                    float res=  value.getPoints()+0.5f;
                    PlayerInfo info = new PlayerInfo();
                    info.setPoints(value.getPoints()+res);
                    info.setName(value.getName());
                    Maphandler.OBJECT.pointupdate(info);
                }
            }
        }
    }
    public String winner(){
        float max =0f;
        String name ="";
        for(Map.Entry<Integer,PlayerInfo> entry :getPoints().entrySet()) {
            PlayerInfo info = entry.getValue();
            if(info.getPoints()>max){
                max = info.getPoints();
                name = info.getName();
            }
        }
        return name;
    }
}
