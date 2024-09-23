/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.TableStatusDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author quang
 */
public class TableStatusDAO {
    
    public ArrayList<TableStatusDTO> read() {
        ArrayList<TableStatusDTO> list = new ArrayList<>();
        String query = "SELECT * FROM tb_table_status WHERE isdeleted = FALSE";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
    
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                TableStatusDTO tableStatusDTO = new TableStatusDTO();
                tableStatusDTO.setId(rs.getString("id"));
                tableStatusDTO.setName(rs.getString("name"));
                tableStatusDTO.setDes(rs.getString("des"));
                tableStatusDTO.setIsDelete(rs.getBoolean("isdeleted"));
                list.add(tableStatusDTO);
            }
            return list;
            
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    public TableStatusDTO readByID(String id) {
        String query = "SELECT * FROM tb_table_status WHERE id = ? AND isdeleted = FALSE";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setString(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                TableStatusDTO tableStatusDTO = new TableStatusDTO();
                tableStatusDTO.setId(rs.getString("id"));
                tableStatusDTO.setName(rs.getString("name"));
                tableStatusDTO.setDes(rs.getString("des"));
                tableStatusDTO.setIsDelete(rs.getBoolean("isdeleted"));
                return tableStatusDTO;
            }
            
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
