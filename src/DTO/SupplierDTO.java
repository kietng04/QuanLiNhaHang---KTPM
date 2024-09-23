/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Tai
 */
public class SupplierDTO {
    private long id;
    private String name;
    private String address;
    private String phone;
    private Boolean isdeleted;

    // Constructor mặc định
    public SupplierDTO() {
    }
    // Constructor
    public SupplierDTO(long id, String name, String address, String phone, boolean isdeleted) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isdeleted = isdeleted;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }
    public long createId() {
        this.id = (int) System.currentTimeMillis();
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
	public Boolean getIsdeleted() {
		return isdeleted;
	}
	public void setIsdeleted(Boolean isdeleted) {
		this.isdeleted = isdeleted;
	}
    
}
