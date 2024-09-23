/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import BUS.DetailsReciptBUS;
import BUS.IngredientsBUS;
import BUS.MenuItemBUS;
import BUS.MenuItemStatusBUS;
import GUI.Comp.Panel.PanelProductOrder;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author quang
 */
public class MenuItemDTO {
    private long id;
    private String name;
    private String description;
    private String image;
    private long price;
    private long profit;
    private boolean isDelete;
    private String statusID;
    private long categoryID;
    private Date createTime;
    private Date updateTime;      
    
    
    private boolean isSelected;
    private int index;
    private PanelProductOrder panelProductOrder;
    
    private CategoriesDTO categoriesDTO;
    private MenuItemStatusDTO menuItemStatusDTO;
    
    
    public MenuItemDTO() {
        
    }

    
    
    public MenuItemDTO(long id, String name, String description, String image, long price, long profit, boolean isDelete, String statusID, long categoryID, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.profit = profit;
        this.isDelete = isDelete;
        this.statusID = statusID;
        this.categoryID = categoryID;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public PanelProductOrder createCart(int index) {
        this.index = index;
        panelProductOrder = new PanelProductOrder();
        
        
        MenuItemStatusDTO menuItemStatusDTO = new MenuItemStatusBUS().findItemStatusByID(statusID);
        
        int quantity = Integer.MAX_VALUE;
        
        ArrayList<DetailsRecipeDTO>listDetailRecipe = new DetailsReciptBUS().readByIDItem(id);
        for (DetailsRecipeDTO detailRecipe : listDetailRecipe) {
            IngredientsDTO ingredientsDTO = new IngredientsBUS().getIngredientById(detailRecipe.getIngredientID());
            if (ingredientsDTO == null) {
                continue;
            }
            int quantityNew = ingredientsDTO.getQuantity() / detailRecipe.getQuantity();
            if (quantityNew < quantity) {
                quantity = quantityNew;
            }
        }
        if (quantity == 0) {
            statusID = "TAMHET";
        }
        else {
            statusID = "SANSANG";

        }

        
        panelProductOrder.insertData(index, name, price, statusID, image, description, quantity);
//        System.out.println(description + " " + ingredient + " 1");
        
        return panelProductOrder;
    }

    public long createID() {
        this.id = System.currentTimeMillis();
        return id;
    }
    
    public boolean isIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
    
    
    
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getStatusID() {
        return statusID;
    }

    public void setStatusID(String statusID) {
        this.statusID = statusID;
    }

    public long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(long categoryID) {
        this.categoryID = categoryID;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public CategoriesDTO getCategoriesDTO() {
        return categoriesDTO;
    }

    public void setCategoriesDTO(CategoriesDTO categoriesDTO) {
        this.categoriesDTO = categoriesDTO;
    }

    public MenuItemStatusDTO getMenuItemStatusDTO() {
        return menuItemStatusDTO;
    }

    public void setMenuItemStatusDTO(MenuItemStatusDTO menuItemStatusDTO) {
        this.menuItemStatusDTO = menuItemStatusDTO;
    }
    
    
    
}
