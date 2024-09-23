/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CategoriesDTO;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author quang
 */
public class CategoriesDAO {
    
    public ArrayList<CategoriesDTO> read() {
        ArrayList<CategoriesDTO> list = new ArrayList<>();
        String query = "SELECT * FROM tb_categories WHERE isdeleted = false";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                CategoriesDTO categories = new CategoriesDTO();
                categories.setId(rs.getLong("id"));
                categories.setName(rs.getString("name"));
                categories.setDes(rs.getString("des"));
                categories.setIsDelete(rs.getBoolean("isdeleted"));
                list.add(categories);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public CategoriesDTO findByID(long id) {
        
        String query = "SELECT * FROM tb_categories WHERE isdeleted = false AND id = ?";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setLong(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                CategoriesDTO categories = new CategoriesDTO();
                categories.setId(rs.getLong("id"));
                categories.setName(rs.getString("name"));
                categories.setDes(rs.getString("des"));
                categories.setIsDelete(rs.getBoolean("isdeleted"));
                return categories;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean insert(CategoriesDTO categories) {
        String query = "INSERT INTO tb_categories VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            
           pstm.setLong(1, categories.getId());
           pstm.setString(2, categories.getName());
           pstm.setString(3, categories.getDes());
           pstm.setBoolean(4, categories.isIsDelete());
           return pstm.executeUpdate() > 0;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean update(CategoriesDTO categories) {
        String query = "UPDATE tb_categories SET name = ?, des = ?, isdeleted = ? WHERE id = ?";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            
           pstm.setString(1, categories.getName());
           pstm.setString(2, categories.getDes());
           pstm.setBoolean(3, categories.isIsDelete());
           pstm.setLong(4, categories.getId());
           return pstm.executeUpdate() > 0;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
}
