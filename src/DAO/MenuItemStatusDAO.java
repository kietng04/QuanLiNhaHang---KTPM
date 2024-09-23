/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.MenuItemStatusDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author quang
 */
public class MenuItemStatusDAO {
    
    public ArrayList<MenuItemStatusDTO> read() {
        ArrayList<MenuItemStatusDTO> list = new ArrayList<>();
        String query = "SELECT * FROM tb_menu_item_status WHERE isdeleted = FALSE"; 
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query);) {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                MenuItemStatusDTO menuItemStatusDTO = new MenuItemStatusDTO();
                menuItemStatusDTO.setId(rs.getString("id"));
                menuItemStatusDTO.setName(rs.getString("name"));
                menuItemStatusDTO.setDes(rs.getString("des"));
                menuItemStatusDTO.setIsDelete(rs.getBoolean("isdeleted"));
                list.add(menuItemStatusDTO);
            }
            return list;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    public MenuItemStatusDTO findByID(String id) {
        String query = "SELECT * FROM tb_menu_item_status WHERE id = ? AND isdeleted = FALSE"; 
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query);) {
            pstm.setString(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                MenuItemStatusDTO menuItemStatusDTO = new MenuItemStatusDTO();
                menuItemStatusDTO.setId(rs.getString("id"));
                menuItemStatusDTO.setName(rs.getString("name"));
                menuItemStatusDTO.setDes(rs.getString("des"));
                menuItemStatusDTO.setIsDelete(rs.getBoolean("isdeleted"));
                return menuItemStatusDTO;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
