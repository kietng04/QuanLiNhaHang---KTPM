/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Tai
 */
import DTO.IngredientsDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;




public class IngredientsDAO {

    public IngredientsDTO getIngredientById(long id) {
        String query = "SELECT id, name, des, quantity, unit, isDeleted FROM tb_ingredients WHERE id=? AND isdeleted = false";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setLong(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    IngredientsDTO ingredient = new IngredientsDTO();
                    ingredient.setId(rs.getLong("id"));
                    ingredient.setName(rs.getString("name"));
                    ingredient.setDes(rs.getString("des"));
                    ingredient.setQuantity(rs.getInt("quantity"));
                    ingredient.setUnit(rs.getString("unit"));
                    ingredient.setIsDeleted(rs.getBoolean("isDeleted"));
                    return ingredient;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addIngredient(IngredientsDTO ingredient) {
        String query = "INSERT INTO tb_ingredients (id, name, des, quantity, unit, isDeleted) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setLong(1, ingredient.getId());
            pstm.setString(2, ingredient.getName());
            pstm.setString(3, ingredient.getDes());
            pstm.setInt(4, ingredient.getQuantity());
            pstm.setString(5, ingredient.getUnit());
            pstm.setBoolean(6, ingredient.isDeleted());
            int affectedRows = pstm.executeUpdate();
            return affectedRows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateIngredient(IngredientsDTO ingredient) {
        String query = "UPDATE tb_ingredients SET name = ?, des = ?, quantity = ?, unit = ?, isDeleted = ? WHERE id = ?";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setString(1, ingredient.getName());
            pstm.setString(2, ingredient.getDes());
            pstm.setInt(3, ingredient.getQuantity());
            pstm.setString(4, ingredient.getUnit());
            pstm.setBoolean(5, ingredient.isDeleted());
            pstm.setLong(6, ingredient.getId());

            int rowsAffected = pstm.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean setIngredientAsDeleted(long id) {
        String query = "UPDATE tb_ingredients SET isDeleted = true WHERE id = ?";
        try (PreparedStatement preparedStatement = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<IngredientsDTO> getAllActiveIngredients() {
        ArrayList<IngredientsDTO> ingredientsList = new ArrayList<>();
        String query = "SELECT * FROM tb_ingredients WHERE isDeleted = false";
        try (PreparedStatement preparedStatement = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                IngredientsDTO ingredient = new IngredientsDTO();
                ingredient.setId(resultSet.getLong("id"));
                ingredient.setName(resultSet.getString("name"));
                ingredient.setDes(resultSet.getString("des"));
                ingredient.setQuantity(resultSet.getInt("quantity"));
                ingredient.setUnit(resultSet.getString("unit"));
                ingredientsList.add(ingredient);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ingredientsList;
    }
    

    public boolean checkIngredientExistence(long ingredientId) {
        String sql = "SELECT COUNT(*) AS count FROM tb_ingredients WHERE id = ?";
        try (PreparedStatement pstmt = Helper.ConnectDB.getInstance().getConnection().prepareStatement(sql)) {
            pstmt.setLong(1, ingredientId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt("count");
                    return count > 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getIngredientQuantity(long ingredientId) {
        String sql = "SELECT quantity FROM tb_ingredients WHERE id = ?";
        try (PreparedStatement pstmt = Helper.ConnectDB.getInstance().getConnection().prepareStatement(sql)) {
            pstmt.setLong(1, ingredientId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("quantity");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void updateIngredientQuantity(long ingredientId, int newQuantity) {
        String sql = "UPDATE tb_ingredients SET quantity = ? WHERE id = ?";
        try (PreparedStatement pstmt = Helper.ConnectDB.getInstance().getConnection().prepareStatement(sql)) {
            pstmt.setInt(1, newQuantity);
            pstmt.setLong(2, ingredientId);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
