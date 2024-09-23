package DAO;

import DTO.StaffDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class StaffDAO {
    
    public ArrayList<StaffDTO> readAllStaffData() {
        ArrayList<StaffDTO> list = new ArrayList<>();
        String query = "SELECT * FROM tb_staff WHERE isdeleted = false";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
                StaffDTO staff = new StaffDTO();
                staff.setId(rs.getLong("id"));
                staff.setUsername(rs.getString("username"));
                staff.setPassword(rs.getString("password"));
                staff.setEmail(rs.getString("email"));
                staff.setPhone(rs.getString("phone"));
                staff.setAddress(rs.getString("address"));
                staff.setisDeleted(rs.getBoolean("isdeleted"));
                staff.setRoleId(rs.getString("roleid"));
                staff.setCreateTime(rs.getDate("create_time"));
                staff.setUpdateTime(rs.getDate("update_time"));
                staff.setFirst_name(rs.getString("first_name"));
                staff.setLast_name(rs.getString("last_name"));
                list.add(staff);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public StaffDTO getStaffById(long id) {
        StaffDTO staff = new StaffDTO();
        String query = "SELECT * FROM tb_staff WHERE isdeleted = false AND id = ?";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setLong(1, id);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()) {
                staff.setId(rs.getLong("id"));
                staff.setUsername(rs.getString("username"));
                staff.setPassword(rs.getString("password"));
                staff.setEmail(rs.getString("email"));
                staff.setPhone(rs.getString("phone"));
                staff.setAddress(rs.getString("address"));
                staff.setisDeleted(rs.getBoolean("isdeleted"));
                staff.setRoleId(rs.getString("roleid"));
                staff.setCreateTime(rs.getDate("create_time"));
                staff.setUpdateTime(rs.getDate("update_time"));
                staff.setFirst_name(rs.getString("first_name"));
                staff.setLast_name(rs.getString("last_name"));
              
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return staff;
    }

    public String[] getRoleIDs() {
        ArrayList<String> roleList = new ArrayList<>();
        String query = "SELECT id FROM tb_roles";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                roleList.add(rs.getString("id"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        String[] roles = new String[roleList.size()];
        roles = roleList.toArray(roles);
        return roles;
    }
    
    public boolean insertStaffData(StaffDTO staff) {
        // Kiểm tra xem username và email đã tồn tại chưa
        if (isUsernameExists(staff.getUsername())) {
            JOptionPane.showMessageDialog(null, "Username đã tồn tại. Vui lòng chọn username khác.");
            return false;
        }

        if (isEmailExists(staff.getEmail())) {
            JOptionPane.showMessageDialog(null, "Email đã tồn tại. Vui lòng chọn email khác.");
            return false;
        }
        
        if (isPhoneExists(staff.getPhone())) {
            JOptionPane.showMessageDialog(null, "Số điện thoại đã tồn tại. Vui lòng chọn số điện thoại khác.");
            return false;
        }

        // Nếu không có trùng lặp, thực hiện thêm nhân viên vào cơ sở dữ liệu
        String query = "INSERT INTO tb_staff (id, username, password, email, phone, address, isdeleted, roleid, create_time, update_time, first_name, last_name) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setLong(1, staff.createId());
            pstm.setString(2, staff.getUsername());
            pstm.setString(3, staff.getPassword());
            pstm.setString(4, staff.getEmail());
            pstm.setString(5, staff.getPhone());
            pstm.setString(6, staff.getAddress());
            pstm.setBoolean(7, false);
            pstm.setString(8, staff.getRoleId());

            Timestamp sqlDateUpdate = new Timestamp(staff.getUpdateTime().getTime());
            Timestamp sqlDateCreate = new Timestamp(staff.getCreateTime().getTime());

            pstm.setTimestamp(9, sqlDateUpdate);
            pstm.setTimestamp(10, sqlDateCreate);
            pstm.setString(11, staff.getFirst_name());
            pstm.setString(12, staff.getLast_name());

            return pstm.executeUpdate() > 0;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    private boolean isUsernameExists(String username) {
        String query = "SELECT COUNT(*) AS count FROM tb_staff WHERE username = ? AND isdeleted = false";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setString(1, username);
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
    
    private boolean isPhoneExists(String phone) {
        String query = "SELECT COUNT(*) AS count FROM tb_staff WHERE phone = ? AND isdeleted = false";
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

    private boolean isEmailExists(String email) {
        String query = "SELECT COUNT(*) AS count FROM tb_staff WHERE email = ? AND isdeleted = false";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setString(1, email);
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

    
    public boolean updateStaffData(StaffDTO staff) {
        // Kiểm tra trùng lặp username và email trước khi cập nhật
        if (isUsernameExistsForUpdate(staff.getUsername(), staff.getId())) {
            JOptionPane.showMessageDialog(null, "Username đã tồn tại!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (isEmailExistsForUpdate(staff.getEmail(), staff.getId())) {
            JOptionPane.showMessageDialog(null, "Email đã tồn tại!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (isPhoneExistsForUpdate(staff.getPhone(), staff.getId())) {
            JOptionPane.showMessageDialog(null, "Số điện thoại đã tồn tại!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String query = "UPDATE tb_staff SET username = ?, password = ?, email = ?, phone = ?, address = ?, isdeleted = ?, roleid = ?, update_time = ?, first_name = ?, last_name = ? WHERE id = ?";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setString(1, staff.getUsername());
            pstm.setString(2, staff.getPassword());
            pstm.setString(3, staff.getEmail());
            pstm.setString(4, staff.getPhone());
            pstm.setString(5, staff.getAddress());
            pstm.setBoolean(6, staff.getisDeleted());
            pstm.setString(7, staff.getRoleId());
            Timestamp sqlDateUpdate = new Timestamp(staff.getUpdateTime().getTime());
            pstm.setTimestamp(8, sqlDateUpdate);
            pstm.setString(9, staff.getFirst_name());
            pstm.setString(10, staff.getLast_name());
            pstm.setLong(11, staff.getId());

            return pstm.executeUpdate() > 0;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    private boolean isUsernameExistsForUpdate(String username, long currentStaffId) {
        String query = "SELECT COUNT(*) AS count FROM tb_staff WHERE username = ? AND id != ? AND isdeleted = false";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setString(1, username);
            pstm.setLong(2, currentStaffId);
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

    private boolean isEmailExistsForUpdate(String email, long currentStaffId) {
        String query = "SELECT COUNT(*) AS count FROM tb_staff WHERE email = ? AND id != ? AND isdeleted = false";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setString(1, email);
            pstm.setLong(2, currentStaffId);
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
    
    private boolean isPhoneExistsForUpdate(String phone, long currentStaffId) {
        String query = "SELECT COUNT(*) AS count FROM tb_staff WHERE phone = ? AND id != ? AND isdeleted = false";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setString(1, phone);
            pstm.setLong(2, currentStaffId);
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

    public StaffDTO isExists(String username, String password) {
        String sql = "SELECT * FROM tb_staff WHERE username = ? AND password = ? AND isdeleted = false";
        
        try {
            PreparedStatement statement = Helper.ConnectDB.getInstance().getConnection().prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            
            ResultSet rs = statement.executeQuery();
            System.out.println("z");

            if (rs.next()) {
                System.out.println("a");
                StaffDTO staff = new StaffDTO();
                staff.setId(rs.getLong("id"));
                staff.setUsername(rs.getString("username"));
                staff.setPassword(rs.getString("password"));
                staff.setEmail(rs.getString("email"));
                staff.setPhone(rs.getString("phone"));
                staff.setAddress(rs.getString("address"));
                staff.setisDeleted(rs.getBoolean("isdeleted"));
                staff.setRoleId(rs.getString("roleid"));
                staff.setCreateTime(rs.getDate("create_time"));
                staff.setUpdateTime(rs.getDate("update_time"));
                staff.setFirst_name(rs.getString("first_name"));
                staff.setLast_name(rs.getString("last_name"));
                return staff;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
