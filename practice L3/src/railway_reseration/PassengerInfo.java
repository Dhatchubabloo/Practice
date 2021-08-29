package railway_reseration;

public class PassengerInfo {
    private String name;
    private int age;
    private String gender;
    private String berthPref;
    private String status;

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
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
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getBerthPref() {
        return berthPref;
    }
    public void setBerthPref(String berthPref) {
        this.berthPref = berthPref;
    }
    public String toString(){
        return "Name : "+name+"\t\t"+"Status : "+status+"\t\t"+"berth : "+berthPref;
    }
}
