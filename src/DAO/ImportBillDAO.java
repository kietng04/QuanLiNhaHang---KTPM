/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Tai
 */
import DTO.ImportBillDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Timestamp;


public class ImportBillDAO {
    
    public static ArrayList<ImportBillDTO> getImportBills() {
        ArrayList<ImportBillDTO> importBillList = new ArrayList<>();
        String query = "SELECT i.id, i.quantity, i.total, i.import_date, st.username AS username, s.name AS supplierName, staffid, supplierid FROM tb_import_bill AS i LEFT JOIN tb_staff AS st ON i.staffid = st.id LEFT JOIN tb_supplier AS s ON i.supplierID = s.id WHERE i.isdeleted = false";
        try (PreparedStatement ps = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
              
                ImportBillDTO importBill = new ImportBillDTO();
                importBill.setId(rs.getLong("id"));
                importBill.setQuantity(rs.getInt("quantity"));
                importBill.setTotal(rs.getLong("total"));
                importBill.setSupplierID( rs.getLong("supplierid"));
                importBill.setUserId(rs.getLong("staffid"));
                importBill.setImport_date(rs.getTimestamp("import_date"));
                importBillList.add(importBill);
            
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return importBillList;
        
    }


    public ImportBillDTO getImportBillById(long id) {
        ImportBillDTO importBill = new ImportBillDTO();
        String query = "SELECT * FROM tb_import_bill WHERE isdeleted = false AND id = ?";
        try (PreparedStatement ps = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                importBill.setId(rs.getLong("id"));
                importBill.setQuantity(rs.getInt("quantity"));
                importBill.setTotal(rs.getLong("total"));
                importBill.setSupplierID( rs.getLong("supplierid"));
                importBill.setUserId(rs.getLong("staffid"));
                importBill.setImport_date(rs.getTimestamp("import_date"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return importBill;

    }
        
        
    public boolean addImportBill(ImportBillDTO importBill) {
        String sql = "INSERT INTO tb_import_bill (id, quantity, total, import_date, staffid, supplierid, isdeleted) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = Helper.ConnectDB.getInstance().getConnection().prepareStatement(sql)) {
            pstmt.setLong(1, importBill.getId());
            pstmt.setInt(2, importBill.getQuantity());
            pstmt.setDouble(3, importBill.getTotal());
            pstmt.setTimestamp(4, new Timestamp(importBill.getImport_date().getTime()));
            pstmt.setLong(5, importBill.getUserId());
            pstmt.setLong(6, importBill.getSupplierID());
            pstmt.setBoolean(7, false);
            return pstmt.executeUpdate() > 0;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static void deleteImportBill(Long importBillId) {
        String query = "UPDATE tb_import_bill SET isdeleted = true WHERE id = ?";
        try (PreparedStatement ps = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            ps.setLong(1, importBillId);
            ps.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
