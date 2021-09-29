package Zcart;

import java.util.ArrayList;

public class InvoiceInfo {
    private long invoiceNo;
    private double totalAmount;
    private String date;
    private ArrayList<ItemInfo>itemList;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<ItemInfo> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<ItemInfo> itemList) {
        this.itemList = itemList;
    }

    public long getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(long invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
