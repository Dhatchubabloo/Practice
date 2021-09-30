package Zcart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Runner {
    static Scanner scan = new Scanner(System.in);
    static Logics logic = new Logics();
    static int number =0;
    public static void main(String[] args) {
        AdminInfo info = new AdminInfo();
        info.setUserName("admin@zoho.com");
        String password = "xyzzy";
        info.setPassword(logic.encrypt(password));
        logic.setAdminCredentials(info);
       logic.customerInitialisation(logic.getCustomerData());
       logic.itemInitialisation(logic.getItemData());
        execution();
    }

    public static void execution() {
        int i=0;
        while(i==0) {
            System.out.println("1.signup\n2.login\n3.Exit");
            switch (scan.nextInt()) {
                case 1:
                    CustomerInfo info = new CustomerInfo();
                    System.out.println("Enter Name");
                    scan.nextLine();
                    info.setName(scan.nextLine());
                    System.out.println("Enter User name");
                    info.setUsername(scan.nextLine());
                    System.out.println("Enter password");
                    info.setPassword(scan.next());
                    System.out.println("Enter Mobile Number");
                    info.setMobileNo(scan.nextLong());
                    System.out.println(logic.signup(info));
                    break;
                case 2:
                    System.out.println("1.customer\n2.Admin");
                    switch (scan.nextInt()) {
                        case 1:
                            CustomerInfo cusInfo = new CustomerInfo();
                            System.out.println("Enter user Name");
                            cusInfo.setUsername(scan.next());
                            System.out.println("Enter password");
                            cusInfo.setPassword(scan.next());
                            System.out.println(logic.login(cusInfo));
                            System.out.println();
                            int k=0;
                            while(k==0) {
                                System.out.println("1.Shopping\n2.password change\n3.order History\n4.Exit");
                                switch (scan.nextInt()) {
                                    case 1:
                                        ArrayList<ItemInfo> shoppingList = new ArrayList<>();
                                        HashMap<String, HashMap<String, ArrayList<ItemInfo>>> map = logic.getItemList();
                                        if(map!=null) {
                                            for (String value : map.keySet())
                                                System.out.println(value);
                                            System.out.println();
                                            System.out.println("Enter Category");
                                            String cat = scan.next();
                                            shoppingList.add(showBrand(map, cat));
                                            int j = 0;
                                            while (j == 0) {
                                                System.out.println("1.Continue shopping");
                                                System.out.println("2.checkout");
                                                switch (scan.nextInt()) {
                                                    case 1:
                                                        for (String val : map.keySet())
                                                            System.out.println(val);
                                                        System.out.println();
                                                        System.out.println("Enter Category");
                                                        cat = scan.next();
                                                        ItemInfo  infoVal = showBrand(map,cat);
                                                        if(infoVal!=null)
                                                            shoppingList.add(showBrand(map, cat));
                                                        else
                                                            System.out.println("Category Not Available...");
                                                        break;
                                                    case 2:
                                                        System.out.println(logic.shopping(shoppingList));
                                                        ArrayList<ItemInfo> cart = logic.getCartList(cusInfo.getUsername());
                                                        if (cart != null) {
                                                            for (ItemInfo cartInfo : cart)
                                                                System.out.println("Brand : " + cartInfo.getBrand() + " Model : " + cartInfo.getModel() + " price : " + cartInfo.getPrice());
                                                            j++;
                                                        }
                                                        Cache.OBJECT.getCartList().clear();
                                                        break;
                                                }
                                            }
                                        }

                                        break;
                                    case 2:
                                        System.out.println("Enter New Password");
                                        String pass = scan.next();
                                        System.out.println("re-enter password");
                                        String repass = scan.next();
                                        if (pass.equals(repass)) {
                                            System.out.println(logic.changePassword(cusInfo.getUsername(), pass));
                                        } else
                                            System.out.println("Password didn't match enter the valid password....");
                                        break;

                                    case 3:
                                        ArrayList<InvoiceInfo> invoiceList = logic.getInvoiceDetails().get(cusInfo.getUsername());
                                        if(invoiceList!=null) {
                                            for (InvoiceInfo invoice : invoiceList) {
                                                System.out.println("Invoice No : " + invoice.getInvoiceNo());
                                                System.out.println("Items : ");
                                                ArrayList<ItemInfo> list = invoice.getItemList();
                                                for (ItemInfo it : list)
                                                    System.out.println("Brand : " + it.getBrand() + " Model : " + it.getModel() + " price : " + it.getPrice());
                                                System.out.println("Total Amount : " + invoice.getTotalAmount());
                                            }
                                        }
                                        else
                                            System.out.println("No Order History....");
                                        break;

                                    case 4:
                                        k++;
                                        break;
                                }
                            }
                            break;
                        case 2:
                            AdminInfo adInfo = new AdminInfo();
                            System.out.println("Enter Username");
                            String userName = scan.next();
                            System.out.println("Enter password");
                            String password = scan.next();
                            adInfo.setUserName(userName);
                            adInfo.setPassword(password);
                            String val = logic.checkAdminCredentials(adInfo);
                            System.out.println(val);
                            if (val.equals("login successfully")) {
                                System.out.println();
                                if(number++==0) {
                                    System.out.println("you need to change password");
                                    AdminInfo adminInfo = new AdminInfo();
                                    System.out.println("Enter new password");
                                    String newPass = scan.next();
                                    System.out.println("Re enter the password");
                                    String rePass = scan.next();
                                    if (newPass.equals(rePass)) {
                                        adminInfo.setPassword(newPass);
                                        adminInfo.setUserName(userName);
                                        System.out.println(logic.adminChangePassword(adminInfo, password));
                                    }
                                }
                                System.out.println("Item Display(stock<10)");
                                ArrayList<ItemInfo> stockInfo = logic.lessStockDisplay();
                                if(stockInfo!=null) {
                                    for (ItemInfo stock : stockInfo) {
                                        System.out.println(stock);
                                        System.out.println("Enter reordering quantity");
                                        int quantity = scan.nextInt();
                                        System.out.println(logic.addStock(stock, quantity));
                                    }
                                }
                                else
                                    System.out.println("No items are available to reorder");
                            }
                    }
                    break;
                case 3:
                    i++;
                    break;
            }
        }
    }
    private static ItemInfo showBrand(HashMap<String, HashMap<String,ArrayList<ItemInfo>>> map,String cat) {
        ItemInfo item =null;
        if(map.containsKey(cat)) {
            HashMap<String, ArrayList<ItemInfo>> brandMap = map.get(cat);
            for (Map.Entry<String, ArrayList<ItemInfo>> entry : brandMap.entrySet()) {
                System.out.println("Brand : " + entry.getKey());
                ArrayList<ItemInfo> list = entry.getValue();
                for (ItemInfo items : list)
                    System.out.println(items);
            }
            item = getbrand();
            item.setCategory(cat);
        }
        return item;
    }

    public static ItemInfo getbrand() {
        ItemInfo items = new ItemInfo();
        System.out.println("Enter brand");
        items.setBrand(scan.next());
        System.out.println("Enter Model");
        items.setModel(scan.next());
        return items;
    }
}
