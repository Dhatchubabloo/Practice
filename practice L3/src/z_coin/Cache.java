package z_coin;

import java.util.ArrayList;
import java.util.HashMap;

public enum Cache {
    OBJECT;
    UserInfo ZEinfo = new UserInfo();
    HashMap<String,UserInfo> ApproveMap = new HashMap();
    HashMap<Integer,ArrayList<RC_TransactionInfo>> rcTransactionInfomap = new HashMap<>();
    HashMap<Integer,ArrayList<ZC_TransactionInfo>> zcTransactionInfomap = new HashMap<>();

   ArrayList userList = new ArrayList();

   void setCheckMap(UserInfo info){
       ApproveMap.put(info.getMailId(),info);
   }
    HashMap<String,UserInfo> getchecMap(){
       return ApproveMap;
   }
   void checkMapUpdation(UserInfo info){
       ApproveMap.put(info.getMailId(),info);
   }
   void checkMapUpdation(double zcAmount,String mailID){
       UserInfo info = ApproveMap.get(mailID);
       info.setZCamount(zcAmount);
       ApproveMap.put(mailID,info);
   }
    void setZEcredentials(UserInfo data){
        ZEinfo = data;
    }
    UserInfo getZEcredentials(){
        return ZEinfo;
    }
    void setUserData(UserInfo user){
      userList.add(user);
    }
    void clearData(){
       userList.clear();
    }
    void setRCTransactionData(RC_TransactionInfo info){
       int account_id = info.getAccount_id();
       if(rcTransactionInfomap.containsKey(account_id)){
           ArrayList<RC_TransactionInfo> list = rcTransactionInfomap.get(account_id);
           list.add(info);
       }
       else{
           ArrayList list = new ArrayList();
           list.add(info);
           rcTransactionInfomap.put(account_id,list);
       }
    }
    HashMap<Integer,ArrayList<RC_TransactionInfo>> getRCTransactionData(){
       return rcTransactionInfomap;
    }
    void setZCTransactionData(ZC_TransactionInfo info){
        int account_id = info.getAccountId();
        if(rcTransactionInfomap.containsKey(account_id)){
            ArrayList<ZC_TransactionInfo> list = zcTransactionInfomap.get(account_id);
            list.add(info);
        }
        else{
            ArrayList list = new ArrayList();
            list.add(info);
            zcTransactionInfomap.put(account_id,list);
        }
    }
    HashMap<Integer,ArrayList<ZC_TransactionInfo>> getZCTransactionData(){
        return zcTransactionInfomap;
    }
    ArrayList<UserInfo> getUserData(){
        return userList;
    }
}
