/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import Criteria.TableCriteria;
import DAO.TableDAO;
import DTO.TableDTO;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author quang
 */
public class TableBUS {
    private TableDAO tableDAO;
    
    
    public TableBUS() {
        tableDAO = new TableDAO();
    }
    
    public ArrayList<TableDTO> getAllData() {
        TableCriteria criteria = new TableCriteria();
        criteria.setIsDelete(false);
        return tableDAO.read(criteria);
    }
    
    public ArrayList<TableDTO> getTableByCustomerCode(String customerCode) {
        TableCriteria criteria = new TableCriteria();
        criteria.setCustomerCode(customerCode);
        return tableDAO.read(criteria);
    }
    
    public boolean insertTable(TableDTO table) {
        return tableDAO.insert(table);
    }
    

    
    public boolean deleteTable(String listTableDelete) {
        TableCriteria criteria = new TableCriteria();
        criteria.setIsDelete(true);
        return tableDAO.update(criteria, listTableDelete);
    }
    
    public boolean updateTable(TableDTO table) {
        TableCriteria criteria = new TableCriteria();
        criteria.setId(table.getId());
        criteria.setName(table.getName());
        criteria.setDes(table.getDes());
        criteria.setStatus(table.getStatusID());
        criteria.setCustomerCode(table.getCustomerCode());
        criteria.setUpdateTime(table.getUpdateTime());
        return tableDAO.update(criteria, "");
    }
    
    public boolean updateNote(TableDTO table) {
        TableCriteria criteria = new TableCriteria();
        criteria.setId(table.getId());
        return tableDAO.update(criteria, "");
    }
    
     public boolean updateCustomerCode(String listTableID, String customerCode) {
        TableCriteria criteria = new TableCriteria();
        criteria.setCustomerCode(customerCode);
        return tableDAO.update(criteria, listTableID);
    }
     
    public ArrayList<TableDTO> findTableByCustomerCode(String customerCode) {
        TableCriteria criteria = new TableCriteria();
        criteria.setCustomerCode(customerCode);
        return tableDAO.read(criteria);
         
    }
    
    public TableDTO findTableByName(String nameTable) {
        TableCriteria criteria = new TableCriteria();
        criteria.setName(nameTable);
        return tableDAO.read(criteria).size() == 0 ? null : tableDAO.read(criteria).get(0);
    }
    

    
    public TableDTO findTableByID(long idTable) {
        TableCriteria criteria = new TableCriteria();
        criteria.setId(idTable);
        
        return tableDAO.read(criteria).size() == 0 ? null : tableDAO.read(criteria).get(0);
    }
     
    public boolean cancelTable(String listTabeID) {
        TableCriteria criteria = new TableCriteria();
        criteria.setCustomerCode("");
        criteria.setStatus("BANTRONG");
        criteria.setUpdateTime(new Date());
        return tableDAO.update(criteria, listTabeID);
    }
    
}
