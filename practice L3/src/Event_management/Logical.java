package Event_management;

import java.util.ArrayList;

public class Logical {
    public ArrayList eventManagement(ArrayList<String> eventList){
        ArrayList<String>outList = new ArrayList<>();
        float startTime = 09.00f;
        float afterstartTime = 01.00f;
        for(int i=0;i<eventList.size();i++){
            String event = eventList.get(i);
            String array[] = event.split(" ");
            int len = array.length;
            String time = array[len-1];float sum=0f;
            for(int j=0;j<2;j++){
                sum = (sum*10)+time.charAt(j)-48;
            }
            sum/=100;
            String eventTime="";
            if(startTime<12.00&&afterstartTime<=1.00)
                 eventTime= startTime+"AM ";
            else if(startTime==12.00){
                outList.add("12.00PM Lunch break");
                eventTime = afterstartTime +"PM ";
            }
            else if(startTime>1.00){
                eventTime = afterstartTime + "PM ";
            }

            String result = eventTime+event;
            outList.add(result);
            if(sum>=0.6){
                float decimal = sum-0.6f;
                if(startTime>12){
                    startTime=afterstartTime;
                }
                startTime += (1+decimal);
            }
            else {
                if(startTime>12)
                    startTime = afterstartTime;
                float number= startTime+sum;
                System.out.println(number+" : number");
                number*=100;
                number%=100;
                number/=100;
                System.out.println(number+" : after number");
                if(number>=0.6){
                    float decimal = number-0.6f;
                    int timer = (int) (startTime*100);
                    startTime=timer/100;
                    System.out.println(startTime +" : starttime after operation");
                   startTime += (1+decimal);
                    System.out.println(startTime+": if time");
                }
                else {
                    startTime += sum;
                    System.out.println(sum+" :  sum");
                    System.out.println(startTime + ": else time");
                }
            }
        }
        return outList;
    }
}
