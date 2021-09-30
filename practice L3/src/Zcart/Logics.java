package Zcart;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Logics {
    private long invoiceNo = 1000;
    void setAdminCredentials(AdminInfo info){
        Cache.OBJECT.setAdminInfo(info);
    }

    String adminChangePassword(AdminInfo info,String oldPass){
        AdminInfo adinfo = Cache.OBJECT.getAdminInfo();
        adinfo.setPassword(encrypt(info.getPassword()));
        List<String> list = adinfo.getPasswordList();
        if(list==null)
            list = new ArrayList<>();
        list.add(oldPass);
        return "Password Changed Successfully";
    }

    public String checkAdminCredentials(AdminInfo info){
        AdminInfo adInfo =  Cache.OBJECT.getAdminInfo();
        if(adInfo.getUserName().equals(info.getUserName())){
            if(adInfo.getPassword().equals(encrypt(info.getPassword()))){
                return "login successfully";
            }
            else
                return "Invalid password";
        }
        else
            return "Invalid username";

    }
    ArrayList<CustomerInfo> getCustomerData(){
        ArrayList<CustomerInfo>customerList = new ArrayList<>();
        FileReader fr=null;
        BufferedReader br=null;
        try {
            File file = new File("C:\\Users\\ELCOT\\IdeaProjects\\PracticeDemo\\practice L3\\src\\Zcart\\zuser.txt");
            file.createNewFile();
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                int i=0;
                String[]array = line.split("  ");
                CustomerInfo info = new CustomerInfo();
                info.setUsername(array[i++]);
                info.setPassword(array[i++]);
                info.setName(array[i++]);
                info.setMobileNo(Long.parseLong(array[i]));
                customerList.add(info);
            }
        }
        catch (Exception e){

            System.out.println(e);
        }
        finally {
            try {
                fr.close();
                br.close();
            }catch(Exception e){
                System.out.println(e);
            }
        }
        return customerList;
    }
    String  encrypt(String password){
        char array[] = password.toCharArray();
        for(int i=0;i<password.length();i++){
            if (array[i] == 'Z') {
                array[i] = 'A';
            }
            else if(array[i]=='z'){
                array[i]='a';
            }
            else if(array[i]=='9'){
                array[i]='0';
            }
            else{
                array[i] = (char)((int)array[i]+1);
            }
        }
        String encrypt = new String(array);
        return encrypt;
    }
    ArrayList<ItemInfo> getItemData(){
        ArrayList<ItemInfo>itemList = new ArrayList<>();
        FileReader fr=null;
        BufferedReader br = null;
        try {
            File file = new File("C:\\Users\\ELCOT\\IdeaProjects\\PracticeDemo\\practice L3\\src\\Zcart\\zkart.txt");
            file.createNewFile();
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                int i=0;
                String array[] = line.split("  ");
                ItemInfo info = new ItemInfo();
                info.setCategory(array[i++]);
                info.setBrand(array[i++]);
                info.setModel(array[i++]);
                info.setPrice(Long.parseLong(array[i++]));
                info.setStock(Integer.parseInt(array[i]));
                itemList.add(info);
            }
            fr.close();
        }catch (Exception e){
            System.out.println(e);
        }
        finally {
            try {
                fr.close();
                br.close();
            }catch(Exception e){
                System.out.println(e);
            }
        }
        return itemList;
    }
    void itemInitialisation(ArrayList<ItemInfo> itemList){
        HashMap<String, HashMap<String,ArrayList<ItemInfo>>> map = Cache.OBJECT.getItemMap();
        for(int i=0;i<itemList.size();i++){
            ItemInfo info = itemList.get(i);
            HashMap<String,ArrayList<ItemInfo>> inner = map.getOrDefault(info.getCategory(),new HashMap<String,ArrayList<ItemInfo>>());
            ArrayList<ItemInfo> itemsList = inner.getOrDefault(info.getBrand(),new ArrayList<ItemInfo>());
            itemsList.add(info);
            inner.put(info.getBrand(),itemsList);
            map.put(info.getCategory(),inner);
        }
        Cache.OBJECT.setItemMap(map);
    }

    void customerInitialisation(ArrayList<CustomerInfo> customerList){
        HashMap<String,CustomerInfo> map = new HashMap<>();
        for(int i=0;i<customerList.size();i++){
            CustomerInfo info = customerList.get(i);
            map.put(info.getUsername(),info);
        }
        Cache.OBJECT.setCustomerMap(map);
    }
     String signup(CustomerInfo info){
        HashMap<String,CustomerInfo> map =Cache.OBJECT.getCustomerMap();
        String pass = encrypt(info.getPassword());
        info.setPassword(pass);
        map.put(info.getUsername(),info);
        Cache.OBJECT.setCustomerMap(map);
        return "Customer Account created successfully";
     }
     String login(CustomerInfo info){
         HashMap<String,CustomerInfo> map =Cache.OBJECT.getCustomerMap();
         if(map.containsKey(info.getUsername())){
             if(map.get(info.getUsername()).getPassword().equals(encrypt(info.getPassword()))){
                 return "login successfully";
             }
             else
                 return "Invalid password";
         }
         else
             return "Invalid userName";

     }
    HashMap<String, HashMap<String,ArrayList<ItemInfo>>> getItemList(){

        return Cache.OBJECT.getItemMap();
    }

    String shopping(ArrayList<ItemInfo> list){
        HashMap<String, HashMap<String,ArrayList<ItemInfo>>>map =  Cache.OBJECT.getItemMap();
        ArrayList<ItemInfo>cartList = new ArrayList<>();
        double amount=0;
        for(int i=0;i<list.size();i++){
            int count=0;
            double price=0;
            ItemInfo info = list.get(i);
            HashMap<String,ArrayList<ItemInfo>>itemMap = map.get(info.getCategory());
            if(itemMap.containsKey(info.getBrand())) {
                ArrayList<ItemInfo> itemList = itemMap.get(info.getBrand());
                for (int j = 0; j < itemList.size(); j++) {
                    ItemInfo in = itemList.get(j);
                    if (in.getModel().equals(info.getModel())) {
                        int stock = in.getStock();
                        if (stock > 0) {
                            price = in.getPrice();
                            amount += in.getPrice();
                            in.setStock(--stock);
                            itemMap.put(info.getBrand(), itemList);
                            map.put(info.getCategory(), itemMap);
                            Cache.OBJECT.setItemMap(map);
                        } else
                            return "No stock Available...";
                    } else
                       count++;
                }
                if(count==itemList.size())
                    return "The Model was Not Available";
                info.setPrice(price);
                cartList.add(info);
            }
            else
                return "The brand was Not available.....";
        }
        Cache.OBJECT.setCartList(cartList);
        return "Your Invoice amount is : "+amount;
    }
    ArrayList<ItemInfo>getCartList(String userName){
        CustomerInfo info = Cache.OBJECT.getCustomerMap().get(userName);
        ArrayList<ItemInfo> cartList = Cache.OBJECT.getCartList();
        ArrayList invoiceList = Cache.OBJECT.getInvoiceMap().getOrDefault(userName,new ArrayList<>());
        InvoiceInfo invoiceinfo = new InvoiceInfo();
        ArrayList<ItemInfo> itemList= invoiceinfo.getItemList();
        if(itemList==null)
            itemList = new ArrayList<>();
        double amount=0;
        for (ItemInfo itemInfo : cartList) {
            itemList.add(itemInfo);
            amount += itemInfo.getPrice();
        }
        invoiceinfo.setInvoiceNo(invoiceNo++);
        invoiceinfo.setTotalAmount(amount);
        invoiceinfo.setItemList(itemList);
        invoiceList.add(invoiceinfo);
        Cache.OBJECT.setInvoiceMap(userName,invoiceList);
        return cartList;
    }
    String changePassword(String username,String newPassword){
        HashMap<String,CustomerInfo> cusMap = Cache.OBJECT.getCustomerMap();
        CustomerInfo info = cusMap.get(username);
        ArrayList<String>passwordList = info.getPasswordList();
        if(passwordList!=null){
            if(passwordList.size()>3)
                passwordList.remove(passwordList.get(0));
            if(passwordList.contains(newPassword)){
                return "don't use this password...please use Another password";
            }
            passwordList.add(info.getPassword());
        }
        else{
            passwordList = new ArrayList<>();
            passwordList.add(info.getPassword());
        }
        info.setPassword(encrypt(newPassword));
        cusMap.put(username,info);
        Cache.OBJECT.setCustomerMap(cusMap);
        return "Password Changed Successfully....!";
    }

    HashMap<String,ArrayList<InvoiceInfo>> getInvoiceDetails(){
        return Cache.OBJECT.getInvoiceMap();
    }

    ArrayList<ItemInfo> lessStockDisplay(){
        ArrayList<ItemInfo>stockList = new ArrayList<>();
        for(Map.Entry<String,HashMap<String,ArrayList<ItemInfo>>>map:Cache.OBJECT.getItemMap().entrySet()){
            for(Map.Entry <String,ArrayList<ItemInfo>> inner:map.getValue().entrySet()){
                ArrayList<ItemInfo> infoList = inner.getValue();
                for(ItemInfo info : infoList){
                 if(info.getStock()<=10)
                     stockList.add(info);
                }
            }
        }
        return stockList;
    }

    String addStock(ItemInfo itemInfo,int number){
        HashMap<String,ArrayList<ItemInfo>> inner = Cache.OBJECT.getItemMap().get(itemInfo.getCategory());
        ArrayList<ItemInfo> infoList =inner.get(itemInfo.getBrand());
        for(ItemInfo item:infoList){
            if(item.getModel().equals(itemInfo.getModel())){
                item.setStock(item.getStock()+number);
            }
        }
        return "Reordering successfully";
    }
}
