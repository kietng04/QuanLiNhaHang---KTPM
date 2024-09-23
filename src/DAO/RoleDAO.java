/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.RoleDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class RoleDAO {
    
    public ArrayList<RoleDTO> read() {
        ArrayList<RoleDTO> list = new ArrayList<>();
        String query = "SELECT * FROM tb_roles WHERE isdeleted = false";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
                RoleDTO role = new RoleDTO();
                role.setId(rs.getString("id"));
                role.setName(rs.getString("name"));
                role.setDes(rs.getString("des"));
                role.setIsDelete(rs.getBoolean("isdeleted"));
                list.add(role);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public RoleDTO getRoleByID(String id) {
        String query = "SELECT * FROM tb_roles WHERE isdeleted = false AND id = ?";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setString(1, id);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()) {
                RoleDTO role = new RoleDTO();
                role.setId(rs.getString("id"));
                role.setName(rs.getString("name"));
                role.setDes(rs.getString("des"));
                role.setIsDelete(rs.getBoolean("isdeleted"));
                return role;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
