package invoice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Logical {
    private static int customer_id = 1;
    private static int invoice_id=1;

    String itemInitialisation(ArrayList<ItemInfo>list){
        Map<Integer,ItemInfo> itemMap = new HashMap<>();
        for(int i=0;i< list.size();i++){
            ItemInfo info = list.get(i);
            itemMap.put(info.getItemId(),info);
        }
        Cache.OBJECT.setItemMap(itemMap);
        return "Item Initiialized successfully";
    }
    int addNewCustomer(CustomerInfo info){
        info.setCustomer_id(customer_id);
        Cache.OBJECT.setCustomerMap(info);
        return customer_id++;
    }
    int makeInvoice(String itemId,int customer_id){
        Map<Integer,ItemInfo>map = Cache.OBJECT.getItemMap();
        double amount=0;
        InvoiceInfo invoice = new InvoiceInfo();
        ArrayList<String>itemList = new ArrayList<>();
       for(int i=0;i<itemId.length();i++){
           int id = itemId.charAt(i)-48;
           ItemInfo info =map.get(id);
           double itemAmount = info.getItemPrice();
           String item = info.getItemName()+"\t-\t"+itemAmount;
           itemList.add(item);
           amount+=info.getItemPrice();
       }
       invoice.setItemList(itemList);
       invoice.setTotalAmount(amount);
        int invoiceId = invoice_id++;
        invoice.setInvoiceId(invoiceId);
       ArrayList list = Cache.OBJECT.getCustomerInvoiceMap().get(customer_id);
       if(list!=null) {
           list.add(invoice);
           Cache.OBJECT.setCustomerInvoiceMap(customer_id,list);
       }
       else{
           ArrayList<InvoiceInfo>item = new ArrayList<>();
           item.add(invoice);
           Cache.OBJECT.setCustomerInvoiceMap(customer_id,item);
       }
       Cache.OBJECT.setAllInvoiceMap(invoiceId,invoice);
       return invoiceId;
    }

    String addItemToInvoice(int invoice_id,String choice){
        InvoiceInfo info = Cache.OBJECT.getAllInvoiceMap().get(invoice_id);
        double amount = info.getTotalAmount();
        Map<Integer,ItemInfo>map = Cache.OBJECT.getItemMap();
        ArrayList<String > itemList = info.getItemList();
        for(int i=0;i<choice.length();i++){
            int id = choice.charAt(i)-48;
            ItemInfo info1 =map.get(id);
            double itemAmount = info1.getItemPrice();
            String item = info1.getItemName()+"\t-\t"+itemAmount;
            itemList.add(item);
            amount+=info1.getItemPrice();
        }
        info.setItemList(itemList);
        info.setTotalAmount(amount);
        Cache.OBJECT.setAllInvoiceMap(invoice_id,info);
        return "Item Added successfully";
    }

    Map<Integer,CustomerInfo> getAllCustomers(){
        return Cache.OBJECT.getCustomerMap();
    }
    Map<Integer,InvoiceInfo>getAllInvoices(){
        return Cache.OBJECT.getAllInvoiceMap();
    }
    ArrayList<InvoiceInfo> getCustomerInvoice(int customer_id){
        return Cache.OBJECT.getCustomerInvoiceMap().get(customer_id);
    }
}
