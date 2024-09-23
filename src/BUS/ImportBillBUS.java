/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

/**
 *
 * @author Tai
 */
import DAO.ImportBillDAO;
import DTO.ImportBillDTO;
import java.util.ArrayList;




public class ImportBillBUS {
    private ImportBillDAO importBillDAO = new ImportBillDAO();
    private ArrayList<ImportBillDTO> listImportBills = new ArrayList<>();

    public ArrayList<ImportBillDTO> loadImportBills() {
        return importBillDAO.getImportBills();

    }
    
    public ImportBillDTO getImportBillById(long id) {
        return importBillDAO.getImportBillById(id);
    }
    
    
    public ImportBillBUS() {
        this.importBillDAO = new ImportBillDAO();
    }

    public boolean addImportBill(ImportBillDTO importBill) {
        return importBillDAO.addImportBill(importBill);
    }
    public static void deleteImportBill(Long importBillId) {
        ImportBillDAO.deleteImportBill(importBillId);
    }

}