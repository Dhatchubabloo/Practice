package chess_tournament;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Runner {
    static Scanner scan = new Scanner(System.in);
    public static void main(String [] args){
        LogicalLayer logic = new LogicalLayer();
        System.out.println("lets start the Mega Chess Tournament");
        System.out.println("Enter number of players");
        int number = scan.nextInt();
            ArrayList<PlayerInfo> playerList = new ArrayList<>();
            System.out.println("Enter the players Name");
            for (int i = 1; i <= number; i++) {
                PlayerInfo info = new PlayerInfo();
                info.setPlayer_id(i);
                info.setName(scan.next());
                info.setPoints(0);
                playerList.add(info);
            }
            logic.playerDetails(playerList);
        System.out.println("Enter the Number of Rounds");
        int round = scan.nextInt();
        for(int i=1;i<=round;i++){
            System.out.println("Round"+i);
            for(int j=1;j<=round;j++){
                System.out.println("match"+j);
                input();
            }
            System.out.println("Round"+i+"Pointstable");
            for(Map.Entry entry :logic.getPoints().entrySet()){
                System.out.println(entry.getValue());
            }
        }
        System.out.println("The Winner of this Mega Chess Tournament is");
        System.out.println(logic.winner());
    }
    public static void input(){
        LogicalLayer logic = new LogicalLayer();
        System.out.println("Enter Players");
        String player1 = scan.next();
        //if(logic.getPoints().containsValue(player1)) {
            System.out.println("vs");
            String player2 = scan.next();
          //  if(logic.getPoints().containsKey(player2)) {
                System.out.println("Winner of match");
                System.out.println("1." + player1 + "\n" + "2." + player2 + "\n" + "3.Tie" + "\n");
                int result = scan.nextInt();
                if (result == 1) {
                    logic.pointsDetails(player1);
                    System.out.println(player1 + " Vs " + player2 + "\n" + "Winner is " + player1 + "\n");
                } else if (result == 2) {
                    logic.pointsDetails(player2);
                    System.out.println(player1 + " Vs " + player2 + "\n" + "Winner is " + player2 + "\n");
                } else {
                    ArrayList<String> names = new ArrayList<>();
                    names.add(player1);
                    names.add(player2);
                    logic.pointsDetails(names);
                    System.out.println(player1 + " Vs " + player2 + "\n" + "Match was Tie" + "\n");
                }
//            }else {
//                System.out.println("Invalid Player Name" + "\n");
//                input();
//            }
//        }
//        else {
//            System.out.println("Invalid Player Name"+"\n");
//            input();
//        }
    }
}
