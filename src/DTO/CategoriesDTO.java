package DTO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author quang
 */
public class CategoriesDTO {
    private long id;
    private String name;
    private String des;
    private boolean isDelete;

    public CategoriesDTO() {
    }
    
    public CategoriesDTO(long id, String name, String des, boolean isDelete) {
        this.id = id;
        this.name = name;
        this.des = des;
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

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }
    
    
    
    
}
