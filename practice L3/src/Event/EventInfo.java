package Event;

public class EventInfo {
    private int duration;
    private String event;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
    public String toString(){
        return event+" - "+duration;
    }
}
