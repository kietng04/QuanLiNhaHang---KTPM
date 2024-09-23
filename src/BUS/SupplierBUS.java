package BUS;

import DAO.SupplierDAO;
import DTO.SupplierDTO;
import java.util.ArrayList;

public class SupplierBUS {
    private SupplierDAO supplierDAO;
    
    public SupplierBUS() {
        supplierDAO = new SupplierDAO();
    }
    
    public ArrayList<SupplierDTO> getAllData() {
        try {
            return supplierDAO.readAllSuppliers();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public SupplierDTO getSupplierById(long id) {
        return supplierDAO.getSupplierById(id);
    }
    
    
    public boolean insertSupplier(SupplierDTO supplier) {
        try {
            return supplierDAO.insertSupplierData(supplier);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateSupplier(SupplierDTO supplier) {
        try {
            return supplierDAO.updateSupplierData(supplier);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<SupplierDTO> getAllActiveSupplier() {
        try {
            ArrayList<SupplierDTO> allSuppliers = supplierDAO.readAllSuppliers();
            ArrayList<SupplierDTO> activeSuppliers = new ArrayList<>();

            // Lọc ra các nhà quản lí có isdeleted = false
            for (SupplierDTO supplier : allSuppliers) {
                if (!supplier.getIsdeleted()) {
                    activeSuppliers.add(supplier);
                }
            }

            return activeSuppliers;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
