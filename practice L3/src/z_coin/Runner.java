package z_coin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Runner {
    static Scanner scan = new Scanner(System.in);
    static Logical logic= new Logical();
    public static void main(String[] args) {
        execution();
    }
    private static int id=1;
    public static void execution() {
        String zeMail = "dhatchu@gmail.com";
        String zePassword = "12345";
        System.out.println("1.create account\n2.Login");
        int option = scan.nextInt();
        switch(option){
            case 1:
                UserInfo info = new UserInfo();
                info.sethId(id++);
                System.out.println("Enter name");
                info.setName(scan.next());
                System.out.println("Enter Email-Id");
                info.setMailId(scan.next());
                System.out.println("Enter Mobile Number");
                info.setMobileNo(scan.nextLong());
                System.out.println("Enter Password");
                System.out.println("It should be AlphaNumeric with a Mixed case and limited Special character (!#%><&*)\n" +
                        "support");
                String password = scan.next();
                if(logic.passwordChecker(password))
                    info.setPassword(password);
                System.out.println("Enter initial Deposite Amount");
                info.setRcAmount(scan.nextDouble());
                logic.userRegistration(info);
                execution();
            case 2:
                System.out.println("1.Agent Login\n2.User Login");
                switch (scan.nextInt()) {
                    case 1:
                        System.out.println("Enter mail-Id");
                        String mail = scan.next();
                        if (mail.equals(zeMail)) {
                            System.out.println("Enter Password");
                            String pass = scan.next();
                            if (pass.equals(zePassword)){
                                System.out.println("Login Successfully\n");
                                int k=0;
                                while(k==0) {
                                System.out.println("1.Approval or rejection\n2.fix Zc Rate\n3.Transaction history\n4.Exit");
                                    switch (scan.nextInt()) {
                                        case 1:
                                            System.out.println("UserList");
                                            ArrayList<UserInfo> list = logic.getUser();
                                            for (int i = 0; i < list.size(); i++) {
                                                UserInfo value = list.get(i);
                                                System.out.println(value);
                                                System.out.println("1.Approval\n2.Rejection");
                                                switch (scan.nextInt()) {
                                                    case 1:
                                                        int id = logic.zidGeneration(value);
                                                        System.out.println("ZID is : " + id);
                                                        break;
                                                    case 2:
                                                        list.remove(value);
                                                        System.out.println("Rejected!............");
                                                }
                                            }
                                            logic.setApproveList(list);
                                            logic.clear();
                                            break;
                                        case 2:
                                            System.out.println("Enter ZC rate (in times)");
                                            logic.setZcrate(scan.nextInt());
                                            break;
                                        case 3:
                                            System.out.println("Enter Account_id");
                                            int id = scan.nextInt();
                                            HashMap<Integer, ArrayList<RC_TransactionInfo>> rcMap = logic.getRCtransaction();
                                            HashMap<Integer, ArrayList<ZC_TransactionInfo>> zcMap = logic.getZCtransaction();
                                            if(rcMap.size()!=0) {
                                                ArrayList<RC_TransactionInfo> list1 = rcMap.get(id);
                                                for (RC_TransactionInfo i : list1)
                                                    System.out.println(i);
                                            }
                                            if(zcMap.size()!=0) {
                                                ArrayList<ZC_TransactionInfo> list2 = zcMap.get(id);
                                                for (ZC_TransactionInfo i : list2)
                                                    System.out.println(i);
                                            }
                                            else
                                                System.out.println("No Transaction history");
                                            break;
                                        case 4:
                                            k++;
                                    }
                                }
                                execution();
                            }
                            else{
                                System.out.println("invalid credentials");
                            }
                        }
                        else{
                            System.out.println("invalid credentials");
                        }
                        execution();
                    case 2:
                        System.out.println("Enter mail-Id");
                        String mailId = scan.next();
                        System.out.println("Enter password");
                        String word = scan.next();
                        if (logic.checkUser(mailId, word)) {
                            System.out.println("login successfully");
                            System.out.println();
                            UserInfo information= logic.getAccountDetails(mailId);
                            int k=0;
                            while(k==0) {
                                System.out.println("1.Account_details\n2.Transaction history\n3.Transaction\n4Exit");
                                switch (scan.nextInt()) {
                                    case 1:
                                        System.out.println(information);
                                        break;
                                    case 2:
                                        HashMap<Integer, ArrayList<RC_TransactionInfo>> rcMap = logic.getRCtransaction();
                                        HashMap<Integer, ArrayList<ZC_TransactionInfo>> zcMap = logic.getZCtransaction();
                                        if (rcMap.size() != 0) {
                                            ArrayList<RC_TransactionInfo> list = rcMap.get(information.getZid());
                                            for (RC_TransactionInfo i : list)
                                                System.out.println(i);
                                        }
                                        if(zcMap.size()!=0) {
                                            ArrayList<ZC_TransactionInfo> list1 = zcMap.get(information.getZid());
                                            for (ZC_TransactionInfo i : list1)
                                                System.out.println(i);
                                        }
                                        else {
                                            System.out.println("No Transaction history");
                                        }
                                        break;
                                    case 3:
                                        transactionDetails(mailId);
                                        break;
                                    case 4:
                                        k++;
                                }
                            }
                        }
                        else{
                            System.out.println("Invalid credentials");
                        }
                        execution();
                }
        }
    }

    public static void transactionDetails(String mailId) {
        int k=0;
        while(k==0){
        System.out.println("1.RC transaction\n2.ZCoin Transaction\n3.Exit");
        switch (scan.nextInt()) {
            case 1:
                System.out.println("1.Deposite\n2.Withdraw\n3.RC to ZC");
                switch (scan.nextInt()) {
                    case 1:
                        logic.deposite(data(mailId,"Deposite"));
                        break;
                    case 2:
                        logic.withdraw(data(mailId,"Withdraw"));
                        break;
                    case 3:
                        System.out.println("1ZC = 2RC");
                        System.out.println("Enter amount to change as ZC");
                        String res = logic.zcConversion(scan.nextDouble(), mailId);
                        System.out.println(res);
                        break;
                }
                break;
            case 2:
                System.out.println("1.ZC Account Transfer\n2.ZC to RC");
                switch (scan.nextInt()) {
                    case 1:
                        System.out.println("Enter your Account_id");
                        int account_id = scan.nextInt();
                        System.out.println("Enter the Amount to Transfer");
                        double amount = scan.nextDouble();
                        System.out.println("Enter Account_id to Transfer");
                        int toAccount_id = scan.nextInt();
                        System.out.println(logic.zcAccountTransfer(account_id, toAccount_id, amount));
                        break;
                    case 2:
                        System.out.println("Enter ZC amount");
                        System.out.println(logic.rcConversion(scan.nextDouble(), mailId));
                        break;
                }
                break;
            case 3:
                k++;
                break;
            }
        }
    }
    static UserInfo data(String mailId ,String type){
        UserInfo info = new UserInfo();
        System.out.println("Enter account Id");
        int account_id = scan.nextInt();
        System.out.println("Enter Amount for "+type);
        double dAmount = scan.nextDouble();
        info.setMailId(mailId);
        info.setZid(account_id);
        info.setRcAmount(dAmount);
        return info;
    }
}
