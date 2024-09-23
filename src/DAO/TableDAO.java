/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Criteria.TableCriteria;
import DTO.TableDTO;
import DTO.TableStatusDTO;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author quang
 */
public class TableDAO {


    public ArrayList<TableDTO> read(TableCriteria criteria) {
        ArrayList<TableDTO> list = new ArrayList<>();
        String query = "SELECT tb_tables.*, tb_table_status.name AS status_name FROM tb_tables LEFT JOIN tb_table_status ON statusid = tb_table_status.id";
        if (criteria.createClause(false).isEmpty()) {
            return list;
        }
        query += " WHERE " + criteria.createClause(false) + " ORDER BY tb_tables.name";

        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)){
            int i = 1;
            if (criteria.getId() != null) {
                pstm.setLong(i++, criteria.getId());
            }
            if (criteria.getName() != null) {
                pstm.setString(i++, criteria.getName());
            }
            if (criteria.getDes() != null) {
                pstm.setString(i++, criteria.getDes());
            }
            if (criteria.isIsDelete() != null) {
                pstm.setBoolean(i++, criteria.isIsDelete());
            }
            if (criteria.getCustomerCode()!= null) {
                pstm.setString(i++, criteria.getCustomerCode());
            }
            if (criteria.getStatus()!= null) {
                pstm.setString(i++, criteria.getStatus());
            }
            if (criteria.getUpdateTime()!= null) {
                pstm.setTimestamp(i++, new Timestamp(criteria.getUpdateTime().getTime()));
            }
            if (criteria.getCreateTime()!= null) {
                pstm.setTimestamp(i++, new Timestamp(criteria.getCreateTime().getTime()));
            }
            
            
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
                TableDTO table = new TableDTO();
                table.setId(rs.getLong("id"));
                table.setName(rs.getString("name"));
                table.setDes(rs.getString("des"));
                table.setCustomerCode(rs.getString("customer_code"));
                table.setStatusID(rs.getString("statusid"));
                table.setCreateTime(rs.getTimestamp("create_time"));
                table.setUpdateTime(rs.getTimestamp("update_time"));
                table.setIsDelete(rs.getBoolean("isdeleted"));
       
                TableStatusDTO tableStatusDTO = new TableStatusDTO();
                tableStatusDTO.setName(rs.getString("status_name"));
                table.setTableStatusDTO(tableStatusDTO);
                list.add(table);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return list;  
    }


    public boolean insert(TableDTO table) {
        String query = "INSERT INTO tb_tables VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setLong(1, table.getId());
            pstm.setString(2, table.getName());
            pstm.setString(3, table.getDes());
            pstm.setBoolean(4, false);
            pstm.setString(5, "");
            pstm.setString(6, table.getStatusID());
            

            

            pstm.setTimestamp(7, new Timestamp(table.getUpdateTime().getTime()));
            pstm.setTimestamp(8, new Timestamp(table.getCreateTime().getTime()));
            return pstm.executeUpdate() > 0;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }




  
    
    public boolean update(TableCriteria criteria, String listID) {
        String query = "UPDATE tb_tables";
        if (criteria.createClause(true).isEmpty()) {
            return false;
        }
        else {
            if (!listID.isEmpty()) {
                query += " SET " + criteria.createClause(true) + " WHERE id IN (" + listID + ")";
            }
            else {
                query += " SET " + criteria.createClause(true) + " WHERE id IN (?)";
                System.out.println(query);
            }

        }
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            int i = 1;
            if (criteria.getName() != null) {
                pstm.setString(i++, criteria.getName());
            }
            if (criteria.getDes() != null) {
                pstm.setString(i++, criteria.getDes());
            }
            if (criteria.isIsDelete() != null) {
                pstm.setBoolean(i++, criteria.isIsDelete());
            }
            if (criteria.getCustomerCode()!= null) {
                pstm.setString(i++, criteria.getCustomerCode());
            }
            if (criteria.getStatus()!= null) {
                pstm.setString(i++, criteria.getStatus());
            }
            if (criteria.getUpdateTime()!= null) {
                pstm.setTimestamp(i++, new Timestamp(criteria.getUpdateTime().getTime()));
            }
            if (listID.isEmpty()) {
                pstm.setLong(i++, criteria.getId());
            }
            return pstm.executeUpdate() > 0;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
  
}
