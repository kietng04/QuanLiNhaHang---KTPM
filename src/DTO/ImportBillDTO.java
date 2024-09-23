/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Tai
 */
import java.util.Date;



public class ImportBillDTO {
    private long id;
    private int quantity;
    private double total;
    private Date import_date;
    private long userId;
    private long supplierID;

    
    
    public ImportBillDTO() {
    
    }

    
    
    // Constructor
    public ImportBillDTO(long id, int quantity, double total, Date import_date, long userId, long supplierID) {
        this.id = id;
        this.quantity = quantity;
        this.total = total;
        this.import_date = import_date;
        this.userId = userId;
        this.supplierID = supplierID;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getImport_date() {
        return import_date;
    }

    public void setImport_date(Date import_date) {
        this.import_date = import_date;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(long supplierID) {
        this.supplierID = supplierID;
    }
}

