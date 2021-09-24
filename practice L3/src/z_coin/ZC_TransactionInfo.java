package z_coin;

public class ZC_TransactionInfo {
    private double zcoin;
    private int accountId;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getZcoin() {
        return zcoin;
    }

    public void setZcoin(double zcoin) {
        this.zcoin = zcoin;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    public String toString(){
        return type+" : "+zcoin;
    }
}
