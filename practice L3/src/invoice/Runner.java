package invoice;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Runner {
    static Scanner scan = new Scanner(System.in);
    static  Logical logic = new Logical();
    public static void main(String[] args) {
        System.out.println("Enter Number Of items");
        int item = scan.nextInt();
        ArrayList<ItemInfo> itemList = new ArrayList();
        for(int i=1;i<=item;i++){
            ItemInfo info = new ItemInfo();
            System.out.println("Enter item name");
            scan.nextLine();
            info.setItemName(scan.nextLine());
            System.out.println("Enter item price");
            info.setItemPrice(scan.nextLong());
            info.setItemId(i);
            itemList.add(info);
        }
        System.out.println(logic.itemInitialisation(itemList));
        execution();
    }
    public static void execution() {
        int k=0;
        while(k==0) {
            System.out.println();
            System.out.println("1.Add customer\n2.Add invoice\n3.Add Item to invoice\n" +
                    "4.All customers\n5.All invoices\n6.All invoices of customer\n7.Display an invoice\n8.Exit");
            switch (scan.nextInt()) {
                case 1:
                    System.out.println("your customer_id is : " + newCustomer());
                    break;
                case 2:
                    System.out.println("1.New  customer\n2.Existing Customer");
                    switch (scan.nextInt()) {
                        case 1:
                            System.out.println("your customer_id is : " + newCustomer());
                            break;
                        case 2:
                            System.out.println("Enter customer_id");
                            int cusId = scan.nextInt();
                            String choice = getChoice();
                            int invoice_id = logic.makeInvoice(choice, cusId);
                            System.out.println("your invoice id is : " + invoice_id);
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Enter invoice Number");
                    int invoiceId = scan.nextInt();
                    System.out.println(logic.addItemToInvoice(invoiceId, getChoice()));
                    break;
                case 4:
                    for (Map.Entry<Integer, CustomerInfo> entry : logic.getAllCustomers().entrySet()) {
                        System.out.println("Customer id : " + entry.getKey());
                        System.out.println(entry.getValue());
                    }
                    break;
                case 5:
                    for (Map.Entry<Integer, InvoiceInfo> entry : logic.getAllInvoices().entrySet()) {
                        System.out.println("Invoice_no : " + entry.getKey());
                        InvoiceInfo info = entry.getValue();
                        ArrayList<String> items = info.getItemList();
                        for (String itemName : items)
                            System.out.println(itemName);
                        System.out.println(info);
                    }
                   break;
                case 6:
                    System.out.println("Enter customer Id");
                    ArrayList<InvoiceInfo> list = logic.getCustomerInvoice(scan.nextInt());
                    for (int i = 0; i < list.size(); i++) {
                        InvoiceInfo info = list.get(i);
                        System.out.println("Invoice_no : " + info.getInvoiceId());
                        ArrayList<String> item = info.getItemList();
                        for (String j : item)
                            System.out.println(j);
                        System.out.println(info);
                    }
                    break;
                case 7:
                    System.out.println("Enter invoice No");
                    InvoiceInfo info = logic.getAllInvoices().get(scan.nextInt());
                    System.out.println("Invoice_no : " + info.getInvoiceId());
                    ArrayList<String> item = info.getItemList();
                    for (String j : item)
                        System.out.println(j);
                    System.out.println(info);
                    break;
                case 8:
                    k++;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    static int newCustomer(){
        CustomerInfo info = new CustomerInfo();
        System.out.println("Enter name");
        info.setName(scan.next());
        System.out.println("Enter city");
        info.setCity(scan.next());
        System.out.println("Enter Mobile No");
        info.setMobile(scan.nextLong());
        return logic.addNewCustomer(info);
    }
    static String getChoice(){
        String choice="";
        while(true) {
            System.out.println("Select the Items");
            System.out.println("1.headphone Rs.400\n2.Speaker Rs.1000" +
                    "\n3.SD card Rs.500\n4.Battery Rs.6000");
            choice+= scan.next();
            System.out.println("Are you want to add More items Yes 1 or No 0");
            if (scan.nextInt() == 0) {
                break;
            }
        }
        return choice;
    }
}
