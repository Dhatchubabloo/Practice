package z_coin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Runner {
    static Scanner scan = new Scanner(System.in);
    static Logical logic= new Logical();
    public static void main(String[] args) {
        UserInfo info = new UserInfo();
        System.out.println("ZE creation");
        System.out.println("Enter Mail-Id");
        info.setMailId(scan.next());
        System.out.println("Enter password");
        info.setPassword(scan.next());
        logic.zeRegistration(info);
        execution();
    }
    private static int id=1;
    public static void execution() {
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
                        UserInfo data = logic.getZE();
                        System.out.println("Enter mail-Id");
                        String mail = scan.next();
                        if (mail.equals(data.getMailId())) {
                            String pass = scan.next();
                            if (pass.equals(data.getPassword())) {
                                System.out.println("Login Successfully\n");
                                System.out.println("UserList");
                                ArrayList<UserInfo> list = logic.getUser();
                                for(int i=0;i< list.size();i++){
                                    UserInfo value = list.get(i);
                                    System.out.println(value);
                                    System.out.println("1.Approval\n2.Rejection");
                                    switch (scan.nextInt()){
                                        case 1:
                                            int id = logic.zidGeneration(value);
                                            System.out.println("ZID is : "+id);
                                            break;
                                        case 2:
                                            list.remove(value);
                                            System.out.println("Rejected!............");
                                            logic.setApproveList(list);
                                    }
                                }

                                logic.clear();
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
                            System.out.println("1.Account_details\n2.Transaction history\n3.Transaction");
                            switch (scan.nextInt()) {
                                case 1:

                                System.out.println(information);
                                case 2:
                                    HashMap<Integer,ArrayList<RC_TransactionInfo>> rcMap =  logic.getRCtransaction();
                                    HashMap<Integer,ArrayList<ZC_TransactionInfo>> zcMap = logic.getZCtransaction();
                                    ArrayList<RC_TransactionInfo>list = rcMap.get(information.getZid());
                                    for(RC_TransactionInfo i:list)
                                        System.out.println(i);
                                    ArrayList<ZC_TransactionInfo>list1 = zcMap.get(information.getZid());
                                    for(ZC_TransactionInfo i:list1)
                                        System.out.println(i);
                                case 3:
                                    transactionDetails(mailId);
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
        System.out.println("1.RC transaction\n2.ZCoin Transaction");
        switch (scan.nextInt()){
            case 1:
                System.out.println("1.Deposite\n2.Withdraw\n3.RC to ZC");
                switch (scan.nextInt()){
                    case 1:
                        logic.deposite(data(mailId));
                    case 2:
                        logic.withdraw(data(mailId));
                    case 3:
                        System.out.println("1ZC = 2RC");
                        System.out.println("Enter amount to change as ZC");
                        String res = logic.zcConversion(scan.nextDouble(), mailId);
                        System.out.println(res);
                }
            case 2:
                System.out.println("1.ZC Account Transfer\n2.ZC to RC Withdraw");
                switch (scan.nextInt()){
                    case 1:
                        System.out.println("Enter your Account_id");
                        int account_id= scan.nextInt();
                        System.out.println("Enter the Amount to Transfer");
                        double amount = scan.nextDouble();
                        System.out.println("Enter Account_id to Transfer");
                        int toAccount_id = scan.nextInt();
                        System.out.println(logic.zcAccountTransfer(account_id,toAccount_id,amount));
                }
        }
    }
    static UserInfo data(String mailId){
        UserInfo info = new UserInfo();
        System.out.println("Enter account Id");
        int account_id = scan.nextInt();
        System.out.println("Enter Amount for Deposite");
        double dAmount = scan.nextDouble();
        info.setMailId(mailId);
        info.setZid(account_id);
        info.setRcAmount(dAmount);
        return info;
    }
}
