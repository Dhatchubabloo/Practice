package z_coin;

public class UserInfo {
    private String name;
    private String mailId;
    private long mobileNo;
    private int hId;
    private String password;
    private double rcAmount;
    private int Zid;
    private String status;
    private double ZCamount;

    public double getZCamount() {
        return ZCamount;
    }

    public void setZCamount(double ZCamount) {
        this.ZCamount = ZCamount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getZid() {
        return Zid;
    }

    public void setZid(int zid) {
        Zid = zid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public int gethId() {
        return hId;
    }

    public void sethId(int hId) {
        this.hId = hId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getRcAmount() {
        return rcAmount;
    }

    public void setRcAmount(double rcAmount) {
        this.rcAmount = rcAmount;
    }
    public String toString(){
        return "Name : "+name+"\nMail : "+mailId+"\n Account Id : "+Zid+"\n RC Amount : "+rcAmount+"\n ZC Amount : "+ZCamount;
    }
}
