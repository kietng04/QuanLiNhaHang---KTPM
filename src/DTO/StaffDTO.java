package DTO;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

public class StaffDTO {
    private long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;
    private boolean isDeleted;
    private String roleId;
    private Date createTime;
    private Date updateTime;
    private String first_name;
    private String last_name;
    
    public static StaffDTO staffLogging;

    public StaffDTO() {
    }

    public StaffDTO(long id, String username, String password, String email, String phone, String address, boolean isDeleted, String roleId, Date createTime, Date updateTime, String first_name, String last_name) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.isDeleted = isDeleted;
        this.roleId = roleId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public String getFirst_name() {
		return first_name;
	}

    public void setFirst_name(String first_name) {
            this.first_name = first_name;
    }

    public String getLast_name() {
            return last_name;
    }

    public void setLast_name(String last_name) {
            this.last_name = last_name;
    }

	// Getter và setter cho id
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public long createId() {
        this.id = System.currentTimeMillis();
        return id;
    }

    // Getter và setter cho username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter và setter cho password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter và setter cho email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter và setter cho phone
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Getter và setter cho address
    public String getAddress() {
        return address;
    }

	public void setAddress(String address) {
        this.address = address;
    }

    // Getter và setter cho isDeleted
    public boolean getisDeleted() {
        return isDeleted;
    }

    public void setisDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    // Getter và setter cho roleId
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    // Getter và setter cho createTime
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    // Getter và setter cho updateTime
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}