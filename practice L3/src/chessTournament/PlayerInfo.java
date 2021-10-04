package chessTournament;

import java.util.ArrayList;

public class PlayerInfo {
    private String name;
    private int playerId;
    private float point;
    private float matchPoint;
    private float bonusPoint;
    private String opponent;
    private float cumulativepoint;

    public float getCumulativepoint() {
        return cumulativepoint;
    }

    public void setCumulativepoint(float cumulativepoint) {
        this.cumulativepoint = cumulativepoint;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

   // private ArrayList<String>opponentList;
    private ArrayList<Integer>opponentIdList;

    public ArrayList<Integer> getOpponentIdList() {
        return opponentIdList;
    }

    public void setOpponentIdList(ArrayList<Integer> opponentIdList) {
        this.opponentIdList = opponentIdList;
    }

    private ArrayList<String>resultList;

    public float getMatchPoint() {
        return matchPoint;
    }

    public void setMatchPoint(float matchPoint) {
        this.matchPoint = matchPoint;
    }

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getBonusPoint() {
        return bonusPoint;
    }

    public void setBonusPoint(float bonusPoint) {
        this.bonusPoint = bonusPoint;
    }

    public ArrayList<String> getResultList() {
        return resultList;
    }

    public void setResultList(ArrayList<String> resultList) {
        this.resultList = resultList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }

//    public ArrayList<String> getOpponentList() {
//        return opponentList;
//    }
//
//    public void setOpponentList(ArrayList<String> opponentList) {
//        this.opponentList = opponentList;
//    }

    @Override
    public String toString() {
        return "name='" + name+
                ", point=" + point +
                ", Player id="+playerId+
                ", bonusPoint=" + bonusPoint +
                ", resultList=" + resultList +
                ", oppidList ="+opponentIdList+
                '}';
    }
}
