package invoice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public enum Cache {
    OBJECT;
    Map<Integer,CustomerInfo> customerMap = new HashMap();
    Map<Integer,ItemInfo>itemMap = new HashMap<>();
    Map<Integer,ArrayList<InvoiceInfo>>customerInvoiceMap = new HashMap<>();
    Map<Integer,InvoiceInfo>allInvoiceMap = new HashMap();

    void setCustomerMap(CustomerInfo info){
        customerMap.put(info.getCustomer_id(),info);
    }
    Map<Integer,CustomerInfo> getCustomerMap(){
        return customerMap;
    }

    void setItemMap(Map<Integer,ItemInfo> map){
        itemMap=map;
    }
    Map<Integer,ItemInfo>getItemMap(){
        return itemMap;
    }
    void setCustomerInvoiceMap(int customer_id,ArrayList<InvoiceInfo>list){
        customerInvoiceMap.put(customer_id,list);
    }

    Map<Integer,ArrayList<InvoiceInfo>>getCustomerInvoiceMap(){
        return customerInvoiceMap;
    }
    void setAllInvoiceMap(int invoiceId,InvoiceInfo info){
        allInvoiceMap.put(invoiceId,info);
    }
    Map<Integer,InvoiceInfo>getAllInvoiceMap(){
        return allInvoiceMap;
    }
}
