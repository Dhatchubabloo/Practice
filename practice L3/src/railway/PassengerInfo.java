package railway;

public class PassengerInfo {
    private String name;
    private int age;
    private char gender;
    private String berthPref;
    private char child;
    private String status;
    private int seatNo;
    private int ticketId;

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public char getChild() {
        return child;
    }

    public void setChild(char child) {
        this.child = child;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getBerthPref() {
        return berthPref;
    }

    public void setBerthPref(String berthPref) {
        this.berthPref = berthPref;
    }
    public String toString(){
        return "Name : "+name+" Age : "+age+"  Berth : "+berthPref+" status : "+status;
    }
}
