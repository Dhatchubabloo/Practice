package chessTournament;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        execution();
    }

    private static void execution() {
        Scanner scan = new Scanner(System.in);
        Logical logic = new Logical();
        ArrayList<PlayerInfo> playerList = new ArrayList<>();
        System.out.println("Enter Number of Players");
        int player = scan.nextInt();
        System.out.println("Enter Number of Rounds");
        int round = scan.nextInt();
        scan.nextLine();
        for(int i=1;i<=player;i++){
            PlayerInfo info = new PlayerInfo();
            System.out.println("Enter name of player"+i);
            info.setName(scan.nextLine());
            info.setPlayerId(i);
            info.setPoint(0.0f);
            playerList.add(info);
        }
        logic.playersInitialisation(playerList);

        for(int i=1;i<=round;i++){
            System.out.println();
            System.out.println("Schedule for round "+i);
            System.out.println();
            List<Map.Entry<Integer,PlayerInfo>> list =  logic.getPlayerList();
            if(list.size()%2==0) {
                for (int j = 0; j < list.size(); j+=2) {
                    Map.Entry<Integer, PlayerInfo> info1 = list.get(j);
                    Map.Entry<Integer, PlayerInfo> info2 = list.get(j+1);
                    info1.getValue().setOpponent(info2.getValue().getName());
                    info2.getValue().setOpponent(info1.getValue().getName());
                    System.out.println(info1.getValue().getName()+" \tvs\t "+info2.getValue().getName());
                    System.out.println("Not by Values=============================================>");
                }
            }
            else {
                for (int j = 0; j < list.size() - 1; j += 2) {
                    Map.Entry<Integer, PlayerInfo> info1 = list.get(j);
                    Map.Entry<Integer, PlayerInfo> info2 = list.get(j + 1);
                    info1.getValue().setOpponent(info2.getValue().getName());
                    info2.getValue().setOpponent(info1.getValue().getName());
                    System.out.println(info1.getValue().getName() + " vs " + info2.getValue().getName());
                }
                Map.Entry<Integer, PlayerInfo> byes = list.get(list.size() - 1);
                PlayerInfo oddin = byes.getValue();
                System.out.println(oddin.getName() + " gets a Bye");
                System.out.println("bye values =====================================================>");
               // PlayerInfo byeinfo = oddin;
            }
            logic.opponentSet();
            List<Map.Entry<Integer,PlayerInfo>> pointList  = logic.getPoints(list);


            System.out.println();
                System.out.println("Result of Round "+i);
            System.out.println();
                if(pointList.size()%2==0) {
                    for (int j = 0; j < pointList.size(); j+=2) {
                        Map.Entry<Integer, PlayerInfo> info1 = pointList.get(j);
                        Map.Entry<Integer, PlayerInfo> info2 = pointList.get(j+1);
                        PlayerInfo player1 = info1.getValue();
                        PlayerInfo player2 = info2.getValue();
                        System.out.println(player1.getName()+"("+player1.getMatchPoint()+"  :  "+player2.getMatchPoint()+")"+player2.getName());
                    }
                }
                else{
                    for (int j = 0; j < pointList.size()-1; j+=2) {
                        Map.Entry<Integer, PlayerInfo> info1 = pointList.get(j);
                        Map.Entry<Integer, PlayerInfo> info2 = pointList.get(j+1);
                        PlayerInfo player1 = info1.getValue();
                        PlayerInfo player2 = info2.getValue();
                        System.out.println(player1.getName()+"\t("+player1.getMatchPoint()+"  :  "+player2.getMatchPoint()+")\t"+player2.getName());
                    }
                    Map.Entry<Integer, PlayerInfo> info = pointList.get(pointList.size()-1);
                    PlayerInfo infos = info.getValue();
                    System.out.println(infos.getName()+"\t("+infos.getMatchPoint()+"  :  "+0.0+")\tBye");

                }

                System.out.println();
            List<Map.Entry<Integer,PlayerInfo>> pointList1 =  logic.getPlayerList();
                System.out.println("point List for Round "+i);
            System.out.println();

                for(Map.Entry<Integer,PlayerInfo> points:pointList1) {
                        String point = points.getValue().getName()+"("+points.getValue().getPoint()+")";
                    System.out.println(point);
                }
        }

        System.out.println();
        int k=0;
        while(k==0) {
            System.out.println("1.view player details\n2.view player Rank\n3.Exit");
            switch (scan.nextInt()) {
                case 1:
                    System.out.println("Enter player name");
                    scan.nextLine();
                    String playerName = scan.nextLine();
                    ArrayList<String> list = logic.getPlayerDetails(playerName);
                    for (String val : list)
                        System.out.println(val);
                    break;

                case 2:
                    ArrayList<String> rankList = logic.getPlayerRank();
                    for (String val : rankList)
                        System.out.println(val);
                    break;

                case 3:
                    k++;
                    break;
            }
        }
    }
}
