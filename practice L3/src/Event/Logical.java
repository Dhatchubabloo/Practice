package Event;

import java.util.ArrayList;

public class Logical {
    ArrayList<String>orderList = new ArrayList<>();
    int startTime = 540;int midTime = 720;
    int endTime = 1020;EventInfo light;int k=0;
    public ArrayList<String> eventManagement(ArrayList<EventInfo>eventList){
            for (int i = 0; i < eventList.size(); i++) {
                EventInfo info = eventList.get(i);
                if (info.getDuration() == 5&&k==0) {
                    light =info;k++;
                    continue;
                }
                else if(info.getDuration() == 5 && k==1){
                    eventList.add(info);
                }
                int temp = startTime + info.getDuration();
                if (temp < midTime) {
                    int diff = Math.abs(temp-midTime);
                    if(diff<=45){
                        for(int j=0;j<eventList.size();j++){
                            EventInfo info1 = eventList.get(j);
                            if(info1.getDuration()==diff){
                                String event = getBeforeTime(startTime, info1);
                                orderList.add(event);
                                eventList.remove(j);
                                startTime = temp;
                                break;
                            }
                        }
                    }
                    else{
                        String event = getBeforeTime(startTime, info);
                        orderList.add(event);
                        eventList.remove(i--);
                        startTime = temp;
                    }
                } else if (temp == midTime) {
                    String event = getBeforeTime(startTime, info);
                    orderList.add(event);
                    eventList.remove(i--);
                    startTime = temp;
                    orderList.add("12.00PM Lunch Break");
                    startTime += 60;
                } else {
                    if (temp < endTime) {
                        String event = getAfterTime(startTime, info);
                        orderList.add(event);
                        eventList.remove(i--);
                        startTime = temp;
                    } else if (temp == endTime) {
                        String event = getAfterTime(startTime, info);
                        orderList.add(event);
                        eventList.remove(i--);
                        orderList.add("5.00PM Network class");
                        System.out.println();
                        orderList.add("Track -2");
                        startTime = 540;
                    }
                    else {
                        System.out.println(info);
                        eventList.add(info);
                    }
                }
            }
            orderList.add("5.00PM Network class");
        return orderList;
    }

    ArrayList<EventInfo> setTime(ArrayList<EventInfo> infoList){
        for(int i=0;i<infoList.size();i++){
            System.out.println(i);
            EventInfo info = infoList.get(i);
            String event = info.getEvent();
            String array[] = event.split(" ");
            int len = array.length;
            String time1 = array[len-1];int sum=0;
            if(time1.equals("lightning")){
                info.setDuration(5);
                infoList.add(info);
                //continue;
            }
            else {
                for (int j = 0; j < 2; j++) {
                    sum = (sum * 10) + time1.charAt(j) - 48;
                }
                System.out.println(sum + "sum");
                info.setDuration(sum);
            }
        }
        return infoList;
    }
    String getBeforeTime(int startTime,EventInfo info){
        int minute = startTime%60;
        int hour = startTime/60;
        String event =hour+"."+minute+" AM"+info.getEvent();
        return event;
    }
    String getAfterTime(int startTime,EventInfo info){
        int minute = startTime%60;
        int hour = (startTime/60)-12;
        String event =hour+"."+minute+" PM"+info.getEvent();
        return event;
    }
}
