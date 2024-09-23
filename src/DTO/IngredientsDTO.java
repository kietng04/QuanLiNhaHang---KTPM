/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Tai
 */
public class IngredientsDTO {
    private long id;
    private String name;
    private String des;
    private int quantity;
    private String unit;
    private boolean isDeleted;

    // Constructors
    public IngredientsDTO() {
    }

    public IngredientsDTO(long id, String name, String des, int quantity, String unit, boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.quantity = quantity;
        this.unit = unit;
        this.isDeleted = isDeleted;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
    
}
