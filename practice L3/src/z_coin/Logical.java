package z_coin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Logical {
    private int zid =1000;
    HashMap<Integer,UserInfo>validMap =new HashMap<>();
    Boolean passwordChecker(String password){
        return true;
    }

    String zeRegistration(UserInfo info){
        Cache.OBJECT.setZEcredentials(info);
        return "Registered successfully";
    }

    UserInfo getZE(){
        return Cache.OBJECT.getZEcredentials();
    }
    void userRegistration(UserInfo info){
       Cache.OBJECT.setUserData(info);
    }

    boolean checkUser(String mail,String password){
        for(Map.Entry<String ,UserInfo> entry:Cache.OBJECT.getchecMap().entrySet()){
            if(entry.getKey().equals(mail)){
                UserInfo info  = entry.getValue();
                if(info.getPassword().equals(password)){
                    return true;
                }
            }
        }
        return false;
    }
    void setApproveList(ArrayList<UserInfo> list){
        for(int i=0;i< list.size();i++) {
            UserInfo info = list.get(i);
            validMap.put(info.getZid(), info);
        }
    }
    HashMap<Integer,UserInfo> getApproveList(){
        return validMap;
    }
    UserInfo getAccountDetails(String mail){
        UserInfo info = null;
        for(Map.Entry<String ,UserInfo> entry:Cache.OBJECT.getchecMap().entrySet()){
            if(entry.getKey().equals(mail)) {
                info = entry.getValue();
            }
        }
        return info;
    }
    public ArrayList<UserInfo> getUser(){
        return Cache.OBJECT.getUserData();
    }
    void clear(){
        Cache.OBJECT.clearData();
    }
    int zidGeneration(UserInfo info){
        int id= zid++;
        info.setZid(id);
        info.setStatus("Approved");
        Cache.OBJECT.setCheckMap(info);
        return id;
    }
    public String withdraw(UserInfo data) {
        RC_TransactionInfo info = new RC_TransactionInfo();
        info.setType("Withdraw");
        for(Map.Entry<String ,UserInfo> entry:Cache.OBJECT.getchecMap().entrySet()){
            if(entry.getKey().equals(data.getMailId())){
                UserInfo  val = entry.getValue();
                double amount= val.getRcAmount();
                if(amount>=data.getRcAmount()){
                    double balance = amount-data.getRcAmount();
                    val.setRcAmount(balance);
                    info.setAccount_id(val.getZid());
                    info.setAmount(data.getRcAmount());
                    Cache.OBJECT.checkMapUpdation(val);
                    Cache.OBJECT.setRCTransactionData(info);
                    return "Transaction Successful!.....";
                }
                else
                    return "Insufficient Balance";
            }
        }
        return null;
    }
   public String deposite(UserInfo data) {
        RC_TransactionInfo info = new RC_TransactionInfo();
        info.setType("Deposite");
        for (Map.Entry<String, UserInfo> entry : Cache.OBJECT.getchecMap().entrySet()) {
            if (entry.getKey().equals(data.getMailId())) {
                UserInfo val = entry.getValue();
                double amount = val.getRcAmount();
                val.setRcAmount(amount + data.getRcAmount());
                info.setAccount_id(val.getZid());
                info.setAmount(data.getRcAmount());
                Cache.OBJECT.checkMapUpdation(val);
                Cache.OBJECT.setRCTransactionData(info);
                return "Transaction Successful!.....";
            }
        }
        return null;
    }
    public String zcConversion(double amount,String mailId){
        for (Map.Entry<String, UserInfo> entry : Cache.OBJECT.getchecMap().entrySet()){
            if (entry.getKey().equals(mailId)){
                UserInfo val = entry.getValue();
                if (amount <= val.getRcAmount()) {
                    double zCoin = amount/2;
                    Cache.OBJECT.checkMapUpdation(zCoin,mailId);
                    return "RC converted into :"+zCoin+"ZC";
                }
                else{
                    return "Insufficient Amount";
                }
            }
        }
        return null;
    }

    public HashMap<Integer,ArrayList<RC_TransactionInfo>> getRCtransaction(){
        return Cache.OBJECT.getRCTransactionData();
    }
    public HashMap<Integer,ArrayList<ZC_TransactionInfo>> getZCtransaction(){
        return Cache.OBJECT.getZCTransactionData();
    }
    public String zcAccountTransfer(int from,int to,double zamount){
        ZC_TransactionInfo info = new ZC_TransactionInfo();
        UserInfo fromUser = validMap.get(from);
        double zcoin = fromUser.getZCamount();
        if(zcoin>=zamount){
            info.setType("ZC Transaction to");
            double balance = zcoin-zamount;
            fromUser.setZCamount(balance);
            info.setAccountId(from);
            info.setZcoin(balance);
            Cache.OBJECT.setZCTransactionData(info);
            Cache.OBJECT.checkMapUpdation(fromUser);
            ZC_TransactionInfo info1 = new ZC_TransactionInfo();
            info1.setType("ZC Transaction from");
            UserInfo toUser = validMap.get(to);
            zcoin = toUser.getZCamount();
            balance = zcoin+zamount;
            toUser.setZCamount(balance);
            info1.setAccountId(to);
            info1.setZcoin(balance);
            Cache.OBJECT.setZCTransactionData(info);
            Cache.OBJECT.checkMapUpdation(toUser);
            return "Transfer Successfully completed";
        }
        else{
            return "Transaction Failed;";
        }
    }
}
