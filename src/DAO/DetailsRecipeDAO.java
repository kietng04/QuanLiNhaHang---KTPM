/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DetailsRecipeDTO;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author quang
 */
public class DetailsRecipeDAO {
    
    public ArrayList<DetailsRecipeDTO> readByIDItem(long itemid) {
        ArrayList<DetailsRecipeDTO> list = new ArrayList<>();
        String query = "SELECT * FROM tb_detail_recipe WHERE itemid = ? and isdeleted = ?";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setLong(1, itemid);
            pstm.setBoolean(2, false);
            
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                DetailsRecipeDTO detailRecipe = new DetailsRecipeDTO();
                detailRecipe.setId(rs.getLong("id"));
                detailRecipe.setQuantity(rs.getInt("quantity"));
                detailRecipe.setUnit(rs.getString("unit"));
                detailRecipe.setIngredientID(rs.getLong("ingredientid"));
                detailRecipe.setItemid(rs.getLong("itemid"));
                detailRecipe.setIsDelete(rs.getBoolean("isdeleted"));
                list.add(detailRecipe);
            }
            return list;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<DetailsRecipeDTO> findRecipeByItemid(String listItemID) {
        ArrayList<DetailsRecipeDTO> list = new ArrayList<>();
        String query = "SELECT * FROM tb_detail_recipe WHERE isdeleted = ? AND itemid IN (" + listItemID + ")";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setBoolean(1, false);
            
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                DetailsRecipeDTO detailRecipe = new DetailsRecipeDTO();
                detailRecipe.setId(rs.getLong("id"));
                detailRecipe.setQuantity(rs.getInt("quantity"));
                detailRecipe.setUnit(rs.getString("unit"));
                detailRecipe.setIngredientID(rs.getLong("ingredientid"));
                detailRecipe.setItemid(rs.getLong("itemid"));
                detailRecipe.setIsDelete(rs.getBoolean("isdeleted"));
                list.add(detailRecipe);
            }
            return list;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    
    public DetailsRecipeDTO findDetailsByIngreNItem(long ingreid, long itemid) {
     
        String query = "SELECT * FROM tb_detail_recipe WHERE ingredientid = ? AND itemid = ? AND isdeleted = ?";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setLong(1, ingreid);
            pstm.setLong(2, itemid);
            pstm.setBoolean(3, false);
            
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                DetailsRecipeDTO detailRecipe = new DetailsRecipeDTO();
                detailRecipe.setId(rs.getLong("id"));
                detailRecipe.setQuantity(rs.getInt("quantity"));
                detailRecipe.setUnit(rs.getString("unit"));
                detailRecipe.setIngredientID(rs.getLong("ingredientid"));
                detailRecipe.setItemid(rs.getLong("itemid"));
                detailRecipe.setIsDelete(rs.getBoolean("isdeleted"));
                return detailRecipe;
            }
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public boolean update(DetailsRecipeDTO x) {
        String query = "UPDATE tb_detail_recipe SET quantity = ?, unit = ?, ingredientid = ?, isdeleted = ?, itemid = ? WHERE id = ?";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setInt(1, x.getQuantity());
            pstm.setString(2, x.getUnit());
            pstm.setLong(3, x.getIngredientID());
            pstm.setBoolean(4, x.isIsDelete());
            pstm.setLong(5, x.getItemid());
            pstm.setLong(6, x.getId());
            return pstm.executeUpdate() > 0;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean insert(DetailsRecipeDTO x) {
        String query = "INSERT INTO tb_detail_recipe VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setLong(1, x.getId());
            pstm.setInt(2, x.getQuantity());
            pstm.setString(3, x.getUnit());
            pstm.setLong(4, x.getIngredientID());
            pstm.setBoolean(5, x.isIsDelete());
            pstm.setLong(6, x.getItemid());
            return pstm.executeUpdate() > 0;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
