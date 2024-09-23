/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author quang
 */
public class DiscountDTO {
    private long id;
    private String name;
    private String des;
    private long minimum;
    private int remaining;
    private long value;
    private String type;
    private Date expiredTime;
    private Date createTime;
    private Date updateTime;
    private boolean isDelete;

    public DiscountDTO() {
    }

    public DiscountDTO(String name, String des, long minimum, int remaining, long value, String type, Date expiredTime, Date createTime, Date updateTime, boolean isDelete) {
        createID();
        this.name = name;
        this.des = des;
        this.minimum = minimum;
        this.remaining = remaining;
        this.value = value;
        this.type = type;
        this.expiredTime = expiredTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
    }
    
    

    public long createID() {
        this.id = System.currentTimeMillis() ;
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

    public long getMinimum() {
        return minimum;
    }

    public void setMinimum(long minimum) {
        this.minimum = minimum;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
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

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }
    
    
    
}
