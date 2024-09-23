/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Tai
 */
import DTO.SupplierDTO;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class SupplierDAO {
    // Method to get all suppliers from database
	public ArrayList<SupplierDTO> readAllSuppliers() {
	    ArrayList<SupplierDTO> list = new ArrayList<>();
	    String query = "SELECT * FROM tb_supplier WHERE isdeleted = false";
	    try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
	        ResultSet rs = pstm.executeQuery();
	        while(rs.next()) {
	            SupplierDTO supplier = new SupplierDTO();
	            supplier.setId(rs.getInt("id"));
	            supplier.setName(rs.getString("name"));
	            supplier.setAddress(rs.getString("address"));
	            supplier.setPhone(rs.getString("phone"));
	            supplier.setIsdeleted(rs.getBoolean("isdeleted"));
	            list.add(supplier);
	        }
	    } catch(SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}

        public SupplierDTO getSupplierById(long id) {
	    SupplierDTO supplier = new SupplierDTO();
	    String query = "SELECT * FROM tb_supplier WHERE isdeleted = false AND id = ?";
	    try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
	        pstm.setLong(1, id);
                ResultSet rs = pstm.executeQuery();
	        if(rs.next()) {
	            supplier.setId(rs.getInt("id"));
	            supplier.setName(rs.getString("name"));
	            supplier.setAddress(rs.getString("address"));
	            supplier.setPhone(rs.getString("phone"));
	            supplier.setIsdeleted(rs.getBoolean("isdeleted"));
	        }
	    } catch(SQLException e) {
	        e.printStackTrace();
	    }
	    return supplier;
	}
        
    
	public boolean insertSupplierData(SupplierDTO supplier) throws HeadlessException, Exception {
	    String query = "INSERT INTO tb_supplier (id, name, address, phone, isdeleted) VALUES (?, ?, ?, ?, ?)";
	    try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
	        pstm.setLong(1, supplier.createId());
	        pstm.setString(2, supplier.getName());
	        pstm.setString(3, supplier.getAddress());
	        pstm.setString(4, supplier.getPhone());
	        pstm.setBoolean(5, false);

	        return pstm.executeUpdate() > 0;
	    } catch(SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

    
    
    private boolean isPhoneExists(String phone) throws Exception {
        String query = "SELECT COUNT(*) AS count FROM tb_supplier WHERE phone = ?";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setString(1, phone);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateSupplierData(SupplierDTO supplier) {
       
        String query = "UPDATE tb_supplier SET name = ?, address = ?, phone = ?, isdeleted = ? WHERE id = ?";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setString(1, supplier.getName());
            pstm.setString(2, supplier.getAddress());
            pstm.setString(3, supplier.getPhone());
            pstm.setBoolean(4, supplier.getIsdeleted());
            pstm.setLong(5, supplier.getId());

            return pstm.executeUpdate() > 0;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    private boolean isSupplierPhoneExistsForUpdate(String phone, long currentSupplierId) {
        String query = "SELECT COUNT(*) AS count FROM tb_supplier WHERE phone = ? AND id != ? AND isdeleted = false";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setString(1, phone);
            pstm.setLong(2, currentSupplierId);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    
    

    
}
