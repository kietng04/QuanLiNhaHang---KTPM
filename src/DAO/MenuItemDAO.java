/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CategoriesDTO;
import DTO.MenuItemDTO;
import DTO.MenuItemStatusDTO;
import java.util.ArrayList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
/**
 *
 * @author quang
 */
public class MenuItemDAO {
    
    public ArrayList<MenuItemDTO> readData() {
        String query = "SELECT tb_menu_item.*, tb_menu_item_status.name AS status_name, tb_categories.name AS cate_name FROM tb_menu_item_status JOIN tb_menu_item ON tb_menu_item_status.id = tb_menu_item.statusid JOIN tb_categories ON tb_menu_item.categoryid = tb_categories.id WHERE tb_menu_item.isdeleted = ? ORDER BY create_time ASC";
        try(PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query);) {
            pstm.setBoolean(1, false);
            ResultSet rs = pstm.executeQuery();
            ArrayList<MenuItemDTO> list = new ArrayList<>();
            while(rs.next()) {
                MenuItemDTO menuItem = new MenuItemDTO();
                menuItem.setId(rs.getLong("id"));
                menuItem.setName(rs.getString("name"));
                menuItem.setPrice(rs.getLong("price"));
                menuItem.setProfit(rs.getLong("profit"));
                menuItem.setImage(rs.getString("image_path"));
                menuItem.setIsDelete(rs.getBoolean("isdeleted"));
                menuItem.setUpdateTime(rs.getDate("update_time"));
                menuItem.setCreateTime(rs.getDate("create_time"));
                menuItem.setStatusID(rs.getString("statusid"));
                menuItem.setCategoryID(rs.getLong("categoryid"));
                menuItem.setDescription(rs.getString("description"));
                
                MenuItemStatusDTO itemStatusDTO = new MenuItemStatusDTO();
                itemStatusDTO.setName(rs.getString("status_name"));
                
                CategoriesDTO categoriesDTO = new CategoriesDTO();
                categoriesDTO.setName(rs.getString("cate_name"));
                
                menuItem.setMenuItemStatusDTO(itemStatusDTO);
                menuItem.setCategoriesDTO(categoriesDTO);
                
                list.add(menuItem);
            }
            return list;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean insert(MenuItemDTO menuItemDTO) {
        String query = "INSERT INTO tb_menu_item VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query);) {
            pstm.setLong(1, menuItemDTO.getId());
            pstm.setString(2, menuItemDTO.getName());
            pstm.setString(3, menuItemDTO.getDescription());
            pstm.setString(4, menuItemDTO.getImage());
            pstm.setLong(5, menuItemDTO.getPrice());
            pstm.setLong(6, menuItemDTO.getProfit());
            pstm.setBoolean(7, menuItemDTO.isIsDelete());
            pstm.setString(8, menuItemDTO.getStatusID());
            pstm.setLong(9, menuItemDTO.getCategoryID());
            pstm.setTimestamp(10, new Timestamp(menuItemDTO.getCreateTime().getTime()));
            pstm.setTimestamp(11, new Timestamp(menuItemDTO.getUpdateTime().getTime()));
            
            return pstm.executeUpdate() > 0;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean update(MenuItemDTO menuItemDTO) {
        String query = "UPDATE tb_menu_item SET name = ?, description = ?, price = ?, profit = ?, image_path = ?, isdeleted = ?, update_time = ?, statusid = ?, categoryid = ? WHERE id = ?";
        try(PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query);) {
            pstm.setString(1, menuItemDTO.getName());
            pstm.setString(2, menuItemDTO.getDescription());
            pstm.setLong(3, menuItemDTO.getPrice());
            pstm.setLong(4, menuItemDTO.getProfit());
            pstm.setString(5, menuItemDTO.getImage());
            pstm.setBoolean(6, menuItemDTO.isIsDelete());
            pstm.setTimestamp(7, new Timestamp(menuItemDTO.getUpdateTime().getTime()));
            pstm.setString(8, menuItemDTO.getStatusID());
            pstm.setLong(9, menuItemDTO.getCategoryID());
            pstm.setLong(10, menuItemDTO.getId());
            
            return pstm.executeUpdate() > 0;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(String listID) {
        String query = "UPDATE tb_menu_item SET isdeleted = ?, update_time = ? WHERE id iN ( + " + listID + ")";
        try(PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query);) {
            pstm.setBoolean(1, true);
            pstm.setTimestamp(2, new Timestamp(new Date().getTime()));
            return pstm.executeUpdate() > 0;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
