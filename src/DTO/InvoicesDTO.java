
package DTO;

import java.util.Date;
import java.util.Random;

public class InvoicesDTO {
    private long id;
    private double amount;
    private double discount;
    private double total;
    private Date createTime;
    private Long discountID;
    private boolean isDelete;
    private OrderDTO orderDTO;

    public InvoicesDTO(double amount, double total, Date createTime, boolean isDelete) {
        createID();
        this.amount = amount;
        this.total = total;
        this.createTime = createTime;
        this.isDelete = isDelete;
    }

    public InvoicesDTO(long id, double amount, double discount, double total, Date createTime, Long discountID,
        boolean isDelete) {
        this.id = id;
        this.amount = amount;
        this.discount = discount;
        this.total = total;
        this.createTime = createTime;
        this.discountID = discountID;
        this.isDelete = isDelete;
    }

    public InvoicesDTO() {
    }

    public long createID() {
        this.id = System.currentTimeMillis();
        return id;
    }

    public void addDiscount(Long discountID, double discount) {
        this.discountID = discountID;
        this.discount = discount;
        total = amount - discount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getDiscountID() {
        return discountID;
    }

    public void setDiscountID(Long discountID) {
        this.discountID = discountID;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public OrderDTO getOrderDTO() {
        return orderDTO;
    }

    public void setOrderDTO(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
    }

    public boolean isIsSelected() {
        return isDelete;
    }

    public void setIsSelected(boolean isDelete) {
        this.isDelete = isDelete;
    }
}
