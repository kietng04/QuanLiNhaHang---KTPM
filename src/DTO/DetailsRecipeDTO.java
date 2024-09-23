/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author quang
 */
public class DetailsRecipeDTO {
    private long id;
    private int quantity;
    private String unit;
    private long ingredientID;
    private long itemid;
    private boolean isDelete;
    public DetailsRecipeDTO() {
    }

    
    
    public DetailsRecipeDTO(long id, int quantity, String unit, long ingredientID, long itemid, boolean isDelete) {
        this.id = id;
        this.quantity = quantity;
        this.unit = unit;
        this.ingredientID = ingredientID;
        this.itemid = itemid;
        this.isDelete = isDelete;
    }

    public long createID() {
        this.id = System.currentTimeMillis();
        return id;
    }
    
    
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public long getIngredientID() {
        return ingredientID;
    }

    public void setIngredientID(long ingredientID) {
        this.ingredientID = ingredientID;
    }

    public long getItemid() {
        return itemid;
    }

    public void setItemid(long itemid) {
        this.itemid = itemid;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }
    
    
    
}
