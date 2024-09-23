package DTO;

import GUI.Comp.Panel.PanelConfirmOrder;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;


public class DetailOrderDTO {
    private long id;
    private long price;
    private long profit;
    private long total;
    private long itemID;
    private long orderID;
    private long invoiceID;
    private int quantity;
    private String name;
    private boolean isDelete;
    private PanelConfirmOrder cartOder;

    public DetailOrderDTO(long id, long price, long profit, long total, long itemID, long orderID, long invoiceID, int quantity, String name, boolean isDelete, PanelConfirmOrder cartOder) {
        this.id = id;
        this.price = price;
        this.profit = profit;
        this.total = total;
        this.itemID = itemID;
        this.orderID = orderID;
        this.invoiceID = invoiceID;
        this.quantity = quantity;
        this.name = name;
        this.isDelete = isDelete;
        this.cartOder = cartOder;
    }

    public DetailOrderDTO(long price, long profit, long itemID, int quantity, String name, boolean isDelete) {
        createID();
        this.price = price;
        this.profit = profit;
        this.itemID = itemID;
        this.quantity = quantity;
        this.name = name;
        this.isDelete = isDelete;
        this.total = price * quantity;
        createCartOrder();
    }

    public DetailOrderDTO() {
    }
    
    
    
    public DetailOrderDTO(String name, long price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity > 1 ? quantity : 1;
        this.total = price * quantity;
        createCartOrder();
        isDelete = false;
    }

    public long createID() {
        this.id = System.currentTimeMillis();
        return id;
    }
    
    public PanelConfirmOrder createCartOrder() {
        if (quantity == 0) {
            isDelete = true;
            cartOder = null;
        }
        else {
            PanelConfirmOrder cartOder1 = new PanelConfirmOrder();
            cartOder1.insertData(name, price, quantity);
            cartOder = cartOder1;
            rerender();
        }
        return cartOder;
    }
    
    public void rerender() {
        if (cartOder != null) {
            quantity = cartOder.getQuantity();
            total = quantity * price;
        }
        else {
            quantity = 0;
        }
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getProfit() {
        return profit;
    }

    public void setProfit(long profit) {
        this.profit = profit;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public long getItemID() {
        return itemID;
    }

    public void setItemID(long itemID) {
        this.itemID = itemID;
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public long getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(long invoiceID) {
        this.invoiceID = invoiceID;
    }
    
    
    
    
}
