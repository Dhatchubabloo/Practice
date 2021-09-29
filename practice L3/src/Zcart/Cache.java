package Zcart;

import java.util.ArrayList;
import java.util.HashMap;

public enum Cache {
    OBJECT;
    private AdminInfo adminInfo;
    private HashMap<String, HashMap<String,ArrayList<ItemInfo>>> itemMap = new HashMap<>();
    private HashMap<String,CustomerInfo> customerMap = new HashMap<>();
    private HashMap<String,ArrayList<InvoiceInfo>>invoiceMap = new HashMap<>();
    private ArrayList<ItemInfo>cartList = new ArrayList<>();

    public ArrayList<ItemInfo> getCartList() {
        return cartList;
    }

    public void setCartList(ArrayList<ItemInfo> cartList) {
        this.cartList = cartList;
    }
    public void setInvoiceMap(String userName,ArrayList<InvoiceInfo> invoiceList){
        invoiceMap.put(userName,invoiceList);
    }
    HashMap<String,ArrayList<InvoiceInfo>> getInvoiceMap(){
        return invoiceMap;
    }

    public HashMap<String, CustomerInfo> getCustomerMap() {
        return customerMap;
    }

    public void  setAdminInfo(AdminInfo info){
        adminInfo  =info;
    }

    public AdminInfo getAdminInfo(){
        return adminInfo;
    }

    public void setCustomerMap(HashMap<String, CustomerInfo> customerMap) {
        this.customerMap = customerMap;
    }

    public HashMap<String, HashMap<String,ArrayList<ItemInfo>>> getItemMap() {
        return itemMap;
    }

    public void setItemMap(HashMap<String, HashMap<String,ArrayList<ItemInfo>>> itemMap) {
        this.itemMap = itemMap;
    }

}
