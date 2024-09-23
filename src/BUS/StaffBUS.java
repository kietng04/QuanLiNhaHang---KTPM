package BUS;

import DAO.StaffDAO;
import DTO.StaffDTO;
import java.util.ArrayList;

public class StaffBUS {
    private StaffDAO staffDAO;
    
    public StaffBUS() {
        staffDAO = new StaffDAO();
    }
    
    public ArrayList<StaffDTO> getAllData() {
        return staffDAO.readAllStaffData();
    }
    
    public StaffDTO getStaffById(long id) {
        return staffDAO.getStaffById(id);
    }
    
    public boolean insertStaff(StaffDTO staff) {
        return staffDAO.insertStaffData(staff);
    }
    
    public boolean updateStaff(StaffDTO staff) {
        return staffDAO.updateStaffData(staff);
    }
    
    public String[] getRoleIDs() {
        return staffDAO.getRoleIDs();
    }

    public StaffDTO isExists(String username, String password) {
        return staffDAO.isExists(username, password);
    }
    
}
