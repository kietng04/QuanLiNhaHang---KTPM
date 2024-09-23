/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

/**
 *
 * @author Tai
 */

import DAO.DetailImportBillDAO;
import DTO.DetailImportBillDTO;
import DTO.SupplierDTO;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
public class DetailImportBillBUS {

    private DetailImportBillDAO detailImportBillDAO = new DetailImportBillDAO();

    public ArrayList<DetailImportBillDTO> getDetailImportBillByBillId(long billId) {
        return detailImportBillDAO.getDetailImportBillByBillId(billId);
    }
    
    public DetailImportBillDTO getDetailImportBillByBillIdIngre(long ingredientId) {
        return detailImportBillDAO.getDetailImportBillByBillIdIngre(ingredientId);
    }

    // Phương thức để lấy thông tin chi tiết nhà cung cấp theo ID nhà cung cấp
    public SupplierDTO getSupplierById(long supplierId) {
        return detailImportBillDAO.getSupplierById(supplierId);
    }

    public String getIngredientNameById(long ingredientId){
        return detailImportBillDAO.getIngredientNameById(ingredientId);
    }
    public DetailImportBillBUS() {
        this.detailImportBillDAO = new DetailImportBillDAO();
    }

    public boolean addDetailImportBill(DetailImportBillDTO detail) {
        return detailImportBillDAO.addDetailImportBill(detail);
    }
    
    public static void deleteDetailImportBill(Long importBillId) {
        DetailImportBillDAO.deleteDetailImportBill(importBillId);
    }
    public static void insertImportBill(long currentBillId, int totalQuantity, long totalAmount, long supplierIdInput, DefaultTableModel model, long[] ingredientIds) {
        DetailImportBillDAO.insertImportBill(currentBillId, totalQuantity, totalAmount, supplierIdInput, model, ingredientIds); // Xử lý ngoại lệ hoặc thông báo lỗi
    }
}