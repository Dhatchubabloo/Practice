package invoice;

import java.util.ArrayList;

public class InvoiceInfo {
    private int invoiceId;
    private double totalAmount;
    private ArrayList<String> itemList;

    public ArrayList<String> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<String> itemList) {
        this.itemList = itemList;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public String toString(){
        return "Total Amount : "+totalAmount;
    }
}
