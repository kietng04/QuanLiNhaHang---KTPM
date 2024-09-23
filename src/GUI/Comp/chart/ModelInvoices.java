package GUI.Comp.chart;

import java.util.Date;

public class ModelInvoices {

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ModelInvoices(Date date, long ID, double price, double discount, double total) {
        this.date = date;
        this.ID = ID;
        this.price = price;
        this.discount = discount;
        this.total = total;
    }

    public ModelInvoices() {
    }

    private Date date;
    private long ID;
    private double price;
    private double discount;
    private double total;

    public Object[] toDataTable() {
        return new Object[] { date, ID, price, discount, total };
    }
}
