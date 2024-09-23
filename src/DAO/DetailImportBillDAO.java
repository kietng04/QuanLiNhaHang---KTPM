/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Tai
 */
import DTO.DetailImportBillDTO;
import DTO.StaffDTO;
import DTO.SupplierDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
public class DetailImportBillDAO {

    public ArrayList<DetailImportBillDTO> getDetailImportBillByBillId(long billId)  {
        ArrayList<DetailImportBillDTO> detailImportBillList = new ArrayList<>();
        String query = "SELECT * FROM tb_detail_import_bill WHERE billid = ?";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setLong(1, billId);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                DetailImportBillDTO detailImportBill = new DetailImportBillDTO();
                detailImportBill.setId(rs.getLong("id"));
                detailImportBill.setQuantity(rs.getInt("quantity"));
                detailImportBill.setPrice(rs.getLong("price"));
                detailImportBill.setTotal(rs.getLong("total"));
                detailImportBill.setBillid(rs.getLong("billid"));
                detailImportBill.setIngredientid(rs.getLong("ingredientid"));
                detailImportBillList.add(detailImportBill);
            }
        } 
        catch (Exception e) {
            e.printStackTrace(); 
        }
        return detailImportBillList;
    }
    
    
    public DetailImportBillDTO getDetailImportBillByBillIdIngre(long ingredientId)  {
        String query = "SELECT details.* FROM tb_detail_import_bill details JOIN tb_import_bill bill ON details.billid = bill.id WHERE details.ingredientid = ? ORDER BY import_date DESC LIMIT 1";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setLong(1, ingredientId);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                DetailImportBillDTO detailImportBill = new DetailImportBillDTO();
                detailImportBill.setId(rs.getLong("id"));
                detailImportBill.setQuantity(rs.getInt("quantity"));
                detailImportBill.setPrice(rs.getLong("price"));
                detailImportBill.setTotal(rs.getLong("total"));
                detailImportBill.setBillid(rs.getLong("billid"));
                detailImportBill.setIngredientid(rs.getLong("ingredientid"));
                return detailImportBill;
            }
        } 
        catch (Exception e) {
            e.printStackTrace(); 
        }
        return null;
    }
    

    // Phương thức để lấy thông tin chi tiết nhà cung cấp theo ID nhà cung cấp
    public SupplierDTO getSupplierById(long supplierId) {
        String query = "SELECT * FROM tb_supplier WHERE id = ?";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setLong(1, supplierId);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    SupplierDTO supplier = new SupplierDTO();
                    supplier.setId(rs.getInt("id"));
                    supplier.setName(rs.getString("name"));
                    supplier.setAddress(rs.getString("address"));
                    supplier.setPhone(rs.getString("phone"));
                    return supplier;
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return null;
    }

    public String getIngredientNameById(long ingredientId) {
        String query = "SELECT name FROM tb_ingredients WHERE id = ?";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setLong(1, ingredientId);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("name");
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return null;
    }

    public boolean addDetailImportBill(DetailImportBillDTO detail) {
        String sql = "INSERT INTO tb_detail_import_bill (id, quantity, price, total, billid, ingredientid, isdeleted) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = Helper.ConnectDB.getInstance().getConnection().prepareStatement(sql)) {
            pstmt.setLong(1, detail.getId());
            pstmt.setInt(2, detail.getQuantity());
            pstmt.setDouble(3, detail.getPrice());
            pstmt.setDouble(4, detail.getTotal());
            pstmt.setLong(5, detail.getBillid());
            pstmt.setLong(6, detail.getIngredientid());
            pstmt.setBoolean(7, false);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return false;
    }
    
    public static void deleteDetailImportBill(Long importBillId)  {
        String query = "UPDATE tb_detail_import_bill SET isdeleted = true WHERE billid = ?";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setLong(1, importBillId);
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
     public static void insertImportBill(long currentBillId, int totalQuantity, long totalAmount, long supplierIdInput, DefaultTableModel model, long[] ingredientIds) {
        String insertImportBillQuery = "INSERT INTO tb_import_bill (id, quantity, total, import_date, staffid, supplierid, isdeleted) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String insertDetailImportBillQuery = "INSERT INTO tb_detail_import_bill (id, quantity, price, total, billid, ingredientid, isdeleted) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String updateIngredientsQuery = "UPDATE tb_ingredients SET quantity = quantity + ? WHERE id = ?";

        try (PreparedStatement insertImportBillStmt = Helper.ConnectDB.getInstance().getConnection().prepareStatement(insertImportBillQuery);
             PreparedStatement insertDetailImportBillStmt = Helper.ConnectDB.getInstance().getConnection().prepareStatement(insertDetailImportBillQuery);
             PreparedStatement updateIngredientsStmt = Helper.ConnectDB.getInstance().getConnection().prepareStatement(updateIngredientsQuery)) {

            Helper.ConnectDB.getInstance().getConnection().setAutoCommit(false);

            // Thêm dữ liệu vào tb_import_bill
            insertImportBillStmt.setLong(1, currentBillId);
            insertImportBillStmt.setInt(2, totalQuantity);
            insertImportBillStmt.setLong(3, totalAmount);
            insertImportBillStmt.setDate(4, new java.sql.Date(new java.util.Date().getTime()));
            insertImportBillStmt.setLong(5, StaffDTO.staffLogging.getId());
            insertImportBillStmt.setLong(6, supplierIdInput);
            insertImportBillStmt.setBoolean(7, false);
            insertImportBillStmt.executeUpdate();

            // Thêm dữ liệu vào tb_detail_import_bill
            for (int i = 0; i < model.getRowCount(); i++) {
                insertDetailImportBillStmt.setLong(1, (long) model.getValueAt(i, 0));
                insertDetailImportBillStmt.setInt(2, (int) model.getValueAt(i, 1));
                insertDetailImportBillStmt.setLong(3, (long) model.getValueAt(i, 2));
                insertDetailImportBillStmt.setLong(4, (long) model.getValueAt(i, 3));
                insertDetailImportBillStmt.setLong(5, currentBillId);
                insertDetailImportBillStmt.setLong(6, ingredientIds[i]);
                insertDetailImportBillStmt.setBoolean(7, false);
                insertDetailImportBillStmt.addBatch();

                // Cập nhật quantity trong tb_ingredients
                updateIngredientsStmt.setInt(1, (int) model.getValueAt(i, 1)); // quantity từ tb_detail_import_bill
                updateIngredientsStmt.setLong(2, ingredientIds[i]);
                updateIngredientsStmt.addBatch();
            }

            // Thực thi các lệnh batch
            insertDetailImportBillStmt.executeBatch();
            updateIngredientsStmt.executeBatch();

            // Commit transaction
            Helper.ConnectDB.getInstance().getConnection().commit();
            Helper.ConnectDB.getInstance().getConnection().setAutoCommit(true);

        } catch (Exception e) {
            e.printStackTrace();
            try {
                Helper.ConnectDB.getInstance().getConnection().rollback();
                Helper.ConnectDB.getInstance().getConnection().setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
