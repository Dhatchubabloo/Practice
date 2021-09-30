package Zcart;

import java.util.ArrayList;

public class CustomerInfo {
    private String username;
    private String password;
    private String name;
    private long MobileNo;
    private ArrayList<String>passwordList;
    private ArrayList<InvoiceInfo>invoiceList;


    public ArrayList<String> getPasswordList() {
        return passwordList;
    }

    public void setPasswordList(ArrayList<String> passwordList) {
        this.passwordList = passwordList;
    }

    public ArrayList<InvoiceInfo> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(ArrayList<InvoiceInfo> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(long mobileNo) {
        MobileNo = mobileNo;
    }

    @Override
    public String toString() {
        return "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", MobileNo=" + MobileNo;
    }
}
