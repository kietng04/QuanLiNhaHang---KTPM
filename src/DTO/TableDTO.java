package DTO;

import GUI.Comp.Panel.PanelTable;
import GUI.Comp.Panel.PanelTableBooking;
import java.util.Date;
import java.util.Random;

public class TableDTO {
    private long id;
    private String name;
    private String des;
    private String statusID;
    private String customerCode;
    private Date createTime;
    private Date updateTime;
    private boolean isDelete;
    private boolean isSelected = false;

    private PanelTable pnTable;
    private PanelTableBooking pnTableBooking;
    private TableStatusDTO tableStatusDTO;
    
    public TableDTO() {
    }

    
    
    
    
    public long createID() {
        this.id = System.currentTimeMillis();
        return id;
    }

    public PanelTableBooking createTableBooking() {
        pnTableBooking = new PanelTableBooking();
        pnTableBooking.setNameTable(name);
//        if (statusID.equals("DANGSUDUNG")) {
//            pnTableBooking.setStatusID(statusID);
//        }
        pnTableBooking.setStatusID(statusID);
        return pnTableBooking;
    } 
    
    public PanelTable createTable() {
        pnTable = new PanelTable(name, statusID, customerCode);
        if (statusID.equals("DANGSUDUNG")) {
            pnTable.setStatusID(statusID);
        }
//        pnTable.
        return pnTable;
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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getStatusID() {
        return statusID;
    }

    public void setStatusID(String statusID) {
        this.statusID = statusID;
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

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public PanelTableBooking getPnTableBooking() {
        return pnTableBooking;
    }

    public TableStatusDTO getTableStatusDTO() {
        return tableStatusDTO;
    }

    public void setTableStatusDTO(TableStatusDTO tableStatusDTO) {
        this.tableStatusDTO = tableStatusDTO;
    }
    
    
    
}
