/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Comp.Panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import com.formdev.flatlaf.FlatClientProperties;
import com.raven.swing.PanelBackground;
import BUS.StaffBUS;
import DTO.StaffDTO;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author vuled
 */
public class QuanLi_Staff extends javax.swing.JPanel {
    private ArrayList<StaffDTO> listStaff;
    private StaffBUS staffBUS = new StaffBUS();
    private DefaultTableModel model;
    private boolean isSelectAll = false;
    int cntTableSelected = 0;
    private javax.swing.JTable tbStaff;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnXoa;
    private javax.swing.JTextField searchField;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JComboBox cmbRoleID;
    private GUI.Comp.Swing.PanelBackground pnContainer;

    public QuanLi_Staff() {
    	initComponents();
        setBackground(new Color(35, 35, 35));
        tbStaff.setRowHeight(35);
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tbStaff.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.LEFT);
        
        searchField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nhập nhân viên cần tìm");

        renderStaff(isSelectAll);

        tbStaff.getModel().addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                if (e.getColumn() == 0) {
                    int row = tbStaff.getSelectedRow();
                    int initialRow = e.getFirstRow();
                    listStaff.get(initialRow).setisDeleted(!listStaff.get(initialRow).getisDeleted());
                    cntTableSelected += !listStaff.get(initialRow).getisDeleted() ? -1 : 1;
                    btnSua.setEnabled(cntTableSelected == 1);
                }
            }
        });
        tbStaff.getColumnModel().removeColumn(tbStaff.getColumnModel().getColumn(0));
        
        
    }
    
    
  
    
    
    public void renderStaff(boolean isSelectAll) {
        listStaff = new StaffBUS().getAllData();
        DefaultTableModel model = (DefaultTableModel) tbStaff.getModel();
        model.setRowCount(0); 
        for (StaffDTO staff : listStaff) {
            String fullName = staff.getLast_name() + " " + staff.getFirst_name();
            model.addRow(new Object[]{
                isSelectAll, 
                staff.getId(),
                fullName,
                staff.getUsername(),
                staff.getPassword(), 
                staff.getEmail(),
                staff.getPhone(),
                staff.getAddress(),
                staff.getRoleId(),
                staff.getUpdateTime(),
                staff.getCreateTime() 
            });
        }

        model.fireTableDataChanged();
        tbStaff.setModel(model);
    }
    
    


private void renderFilteredStaff(ArrayList<StaffDTO> filteredList) {
    DefaultTableModel model = (DefaultTableModel) tbStaff.getModel();
    model.setRowCount(0);

    for (StaffDTO staff : filteredList) {
    	String fullName = staff.getLast_name() + " " + staff.getFirst_name();
        model.addRow(new Object[]{
            isSelectAll,
            staff.getId(),
            fullName,
            staff.getUsername(),
            staff.getPassword(),
            staff.getEmail(),
            staff.getPhone(),
            staff.getAddress(),
            staff.getRoleId(),
            staff.getUpdateTime(),
            staff.getCreateTime()
        });
    }

    model.fireTableDataChanged();
    tbStaff.setModel(model);
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {


        
        setLayout(new BorderLayout());
        
        
        JPanel panel_north = new JPanel();
        PanelBackground panel_center = new PanelBackground();
        JPanel panel_south = new JPanel();
        JPanel panel_west = new JPanel();
        JPanel panel_east = new JPanel();
        
        panel_north.setPreferredSize(new Dimension(25,25));
        panel_south.setPreferredSize(new Dimension(25,25));
        panel_west.setPreferredSize(new Dimension(25,25));
        panel_east.setPreferredSize(new Dimension(25,25));
        
        panel_west.setBackground(new Color(30,30,30));
        panel_east.setBackground(new Color(30,30,30));
        panel_north.setBackground(new Color(30,30,30));
        panel_south.setBackground(new Color(30,30,30));
        panel_center.setBackground(new Color(30,30,30));
        
        add(panel_center, BorderLayout.CENTER);
        add(panel_north, BorderLayout.NORTH);
        add(panel_south, BorderLayout.SOUTH);
        add(panel_east, BorderLayout.EAST);
        add(panel_west, BorderLayout.WEST);
        
        
        panel_center.setLayout(new BorderLayout());
        
        PanelBackground panel_top = new PanelBackground();
        PanelBackground panel_mid = new PanelBackground();
        PanelBackground panel_bot = new PanelBackground();
        
        PanelBackground interactSection = new PanelBackground();
        interactSection.setBackground(new Color(30,30,30));
        
        interactSection.setPreferredSize(new Dimension(800, 250));
        interactSection.setLayout(new BorderLayout());
        interactSection.add(panel_bot, BorderLayout.CENTER);
        
        panel_top.setPreferredSize(new Dimension(800, 50));
        panel_mid.setPreferredSize(new Dimension(800, 300));
        panel_bot.setPreferredSize(new Dimension(800, 200));
        
        panel_top.setBackground(new Color(35,35,35));
        panel_bot.setBackground(new Color(35,35,35));
        panel_mid.setBackground(new Color(30, 30, 30));
        panel_center.add(interactSection, BorderLayout.NORTH);
        panel_center.add(panel_mid, BorderLayout.CENTER);
        
        //search panel
        JLabel searchLabel = new JLabel("Tìm kiếm:");
        searchLabel.setForeground(Color.white);
        searchField = new JTextField();
        searchField.setBackground(new Color(35, 35, 35));
        searchField.setForeground(Color.white);
        searchField.setPreferredSize(new Dimension(200, 25));

        // Tạo flow layout cho panel_top và thêm label và textfield vào
        panel_top.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel_top.add(searchLabel);
        panel_top.add(searchField);
        panel_top.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        //Table
        tbStaff = new javax.swing.JTable();
        JScrollPane jScrollPane2 = new javax.swing.JScrollPane();

        tbStaff.setAutoCreateRowSorter(true);
        tbStaff.setBackground(new java.awt.Color(35, 35, 35));
        tbStaff.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        tbStaff.setForeground(new java.awt.Color(255, 255, 255));
        tbStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "aaaaaaaaaa", "ádasdasd", null, "aaaaaaaaaa", "aaaaaaaaaa", null, "aaaaaaaaaa"},
                {null, "aaaaaaaaaa", "ádasd", null, "aaaaaaaaaa", "aaaaaaaaaa", null, "aaaaaaaaaa"},
                {null, "aaaaaaaaaa", "ádasd", null, "aaaaaaaaaa", "aaaaaaaaaa", null, "aaaaaaaaaa"},
                {null, "aaaaaaaaaa", "ádasda", null, "aaaaaaaaaa", "aaaaaaaaaa", null, "aaaaaaaaaa"}
            },
            new String [] {
                    "", "Mã nhân viên","Họ tên", "Username", "Password", "Email", "SDT", "Địa chỉ", "Chức vụ", "Ngày tạo", "Ngày sửa"
                }
            ) {
        	Class[] types = new Class [] {
        		    java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
        		};
                boolean[] canEdit = new boolean [] {
                	    true, false, false, false, false, false, false, false, false, false, false
                	};

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
        tbStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbStaff.getTableHeader().setResizingAllowed(false);
        tbStaff.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbStaff);
        if (tbStaff.getColumnModel().getColumnCount() > 0) {
        	tbStaff.getColumnModel().getColumn(1).setPreferredWidth(150);  // Mã nhân viên
        	tbStaff.getColumnModel().getColumn(2).setPreferredWidth(200);  // Họ tên
        	tbStaff.getColumnModel().getColumn(3).setPreferredWidth(100);  // Username
        	tbStaff.getColumnModel().getColumn(5).setPreferredWidth(200);  // Email
        	tbStaff.getColumnModel().getColumn(6).setPreferredWidth(100);  // SDT
        	tbStaff.getColumnModel().getColumn(7).setPreferredWidth(100);  // Địa chỉ
        	tbStaff.getColumnModel().getColumn(8).setPreferredWidth(50);   // Chức vụ
        	tbStaff.getColumnModel().getColumn(9).setPreferredWidth(100);  // Ngày tạo
        	tbStaff.getColumnModel().getColumn(10).setPreferredWidth(100); // Ngày sửa

        }

        // Thêm JScrollPane chứa tbStaff vào panel_mid
        panel_mid.setLayout(new GridBagLayout());
        GridBagConstraints gbc1 = new GridBagConstraints();

        // Đặt hướng căn giữa cho panel_mid
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.weightx = 1.0;
        gbc1.weighty = 1.0;
        gbc1.fill = GridBagConstraints.BOTH;
        panel_mid.add(jScrollPane2, gbc1);
        panel_mid.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        
        //Update panel
        panel_bot.setLayout(new BorderLayout());
        
        PanelBackground staffInfo_panel_left = new PanelBackground();
        JPanel staffInfo_panel_center = new JPanel();
        PanelBackground staffInfo_panel_right = new PanelBackground();
        
        staffInfo_panel_center.setBackground(new Color(35,35,35));
        staffInfo_panel_left.setBackground(new Color(35,35,35));
        staffInfo_panel_right.setBackground(new Color(35,35,35));
        
        staffInfo_panel_center.setPreferredSize(new Dimension(350, 200));
        staffInfo_panel_left.setPreferredSize(new Dimension(350, 200));
        staffInfo_panel_right.setPreferredSize(new Dimension(150, 200));
        
        panel_bot.add(panel_top, BorderLayout.NORTH);
        panel_bot.add(staffInfo_panel_center, BorderLayout.CENTER);
        panel_bot.add(staffInfo_panel_left, BorderLayout.WEST);
        panel_bot.add(staffInfo_panel_right, BorderLayout.EAST);
        
        jScrollPane2.setPreferredSize(new Dimension(1250, 450));
        //Btn panel
        JButton btnThem = new JButton("Thêm");
//        btnThem.setBackground(new Color(146, 227, 118));
        JButton btnSua = new JButton("Sửa");
//        btnSua.setBackground(new Color(112, 179, 230));
        JButton btnXoa = new JButton("Xóa");
//        btnXoa.setBackground(new Color(235, 82, 82));

        
        
        btnThem.setForeground(Color.white);
        btnSua.setForeground(Color.white);
        btnXoa.setForeground(Color.white);

        Dimension buttonSize = new Dimension(100, 30);
        btnThem.setPreferredSize(buttonSize);
        btnSua.setPreferredSize(buttonSize);
        btnXoa.setPreferredSize(buttonSize);

        PanelBackground buttonPanel = new PanelBackground();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setBackground(new Color(35,35,35));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        buttonPanel.add(btnThem, gbc);

        gbc.gridy = 1;
        buttonPanel.add(btnSua, gbc);
        
        gbc.gridy = 2;
        buttonPanel.add(btnXoa, gbc);

        staffInfo_panel_right.setBackground(new Color(35,35,35));
        staffInfo_panel_right.setLayout(new GridBagLayout());
        staffInfo_panel_right.add(buttonPanel, gbc);
        //Info left

        JLabel lblUpperUsername = new JLabel("Tên nhân viên:");
        lblUpperUsername.setForeground(Color.white);
        JTextField txtUpperUsername = new JTextField();

        // Thiết lập kích thước cho TextField
        Dimension textFieldSizeUpper = new Dimension(200, 30);
        txtUpperUsername.setPreferredSize(textFieldSizeUpper);

        // GridBagConstrains cho lblUpperUsername
        GridBagConstraints gbcUpperUsername = new GridBagConstraints();
        gbcUpperUsername.gridx = 0;
        gbcUpperUsername.gridy = 0;
        gbcUpperUsername.anchor = GridBagConstraints.WEST;
        gbcUpperUsername.insets = new Insets(5, 5, 5, 5);

        // Thêm lblUpperUsername và txtUpperUsername vào staffInfo_panel_left
        staffInfo_panel_left.setLayout(new GridBagLayout());
        staffInfo_panel_left.add(lblUpperUsername, gbcUpperUsername);
        gbcUpperUsername.gridy = 1;
        staffInfo_panel_left.add(txtUpperUsername, gbcUpperUsername);
        
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setForeground(Color.white);
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setForeground(Color.white);
        
        // textfields
        JTextField txtUsername = new JTextField();
        JTextField txtPassword = new JTextField();

        Dimension textFieldSize = new Dimension(200, 30);
        txtUsername.setPreferredSize(textFieldSize);
        txtPassword.setPreferredSize(textFieldSize);

        GridBagConstraints gbcLeft = new GridBagConstraints();
        gbcLeft.gridx = 0;
        gbcLeft.gridy = 0;
        gbcLeft.anchor = GridBagConstraints.WEST;
        gbcLeft.insets = new Insets(5, 5, 5, 5); 

        staffInfo_panel_left.setLayout(new GridBagLayout());


        gbcLeft.gridx = 0;
        gbcLeft.gridy++;
        staffInfo_panel_left.add(lblUsername, gbcLeft);
        gbcLeft.gridx = 1;
        staffInfo_panel_left.add(txtUsername, gbcLeft);

        gbcLeft.gridx = 0;
        gbcLeft.gridy++;
        staffInfo_panel_left.add(lblPassword, gbcLeft);
        gbcLeft.gridx = 1;
        staffInfo_panel_left.add(txtPassword, gbcLeft);
        
        //Info right
        GridBagConstraints gbcCenter = new GridBagConstraints();
        gbcCenter.gridx = 0;
        gbcCenter.gridy = 0;
        gbcCenter.anchor = GridBagConstraints.WEST;
        gbcCenter.insets = new Insets(5, 5, 5, 5); 

        staffInfo_panel_center.setLayout(new GridBagLayout());

        // Label và Textfield cho Email
        JLabel Email_lbl = new JLabel("Email:");
        Email_lbl.setForeground(Color.white);
        staffInfo_panel_center.add(Email_lbl, gbcCenter);
        gbcCenter.gridx = 1;
        JTextField txtEmail = new JTextField(20); 
        staffInfo_panel_center.add(txtEmail, gbcCenter);
        // Label và Textfield cho SĐT
        gbcCenter.gridx = 0; 
        gbcCenter.gridy++; 
        JLabel SDT_lbl = new JLabel("SDT:"); 
        SDT_lbl.setForeground(Color.white);
        staffInfo_panel_center.add(SDT_lbl, gbcCenter);
        gbcCenter.gridx = 1;
        JTextField txtSDT = new JTextField(20); 
        staffInfo_panel_center.add(txtSDT, gbcCenter);

        gbcCenter.gridx = 0; 
        gbcCenter.gridy++; 
        JLabel DiaChi_lbl = new JLabel("Địa chỉ:"); 
        DiaChi_lbl.setForeground(Color.white);
        staffInfo_panel_center.add(DiaChi_lbl, gbcCenter);
        gbcCenter.gridx = 1; 
        JTextField txtAddress = new JTextField(20); 
        staffInfo_panel_center.add(txtAddress, gbcCenter);

        // Label và JComboBox cho RoleID
        gbcCenter.gridx = 0; 
        gbcCenter.gridy++; 
        JLabel RoleID_lbl = new JLabel("RoleID:"); 
        RoleID_lbl.setForeground(Color.white);
        staffInfo_panel_center.add(RoleID_lbl, gbcCenter);
        gbcCenter.gridx = 1; 
        String[] roles = staffBUS.getRoleIDs();
        JComboBox<String> cmbRoleID = new JComboBox<>(roles);
        staffInfo_panel_center.add(cmbRoleID, gbcCenter);
        
        Dimension textFieldSize1 = new Dimension(200, 30);

     // Áp dụng cho các JTextField trong panel_left
     txtUsername.setPreferredSize(textFieldSize1);
     txtPassword.setPreferredSize(textFieldSize1);
     txtEmail.setPreferredSize(textFieldSize1);
     txtSDT.setPreferredSize(textFieldSize1);
     txtAddress.setPreferredSize(textFieldSize1);
     searchField.setPreferredSize(textFieldSize1);
        
     tbStaff.addMouseListener(new MouseAdapter() {
    	    @Override
    	    public void mouseClicked(MouseEvent e) {
                txtUsername.setEnabled(false);
                txtUpperUsername.setEnabled(false);
                btnThem.setEnabled(false);
                
    	        int selectedRow = tbStaff.getSelectedRow();
    	        if (selectedRow != -1) {
    	            DefaultTableModel model = (DefaultTableModel) tbStaff.getModel();
    	            String hoten = model.getValueAt(selectedRow, 2).toString();
    	            String username = model.getValueAt(selectedRow, 3).toString();
    	            String password = model.getValueAt(selectedRow, 4).toString();
    	            String email = model.getValueAt(selectedRow, 5).toString();
    	            String phone = model.getValueAt(selectedRow, 6).toString();
    	            String address = model.getValueAt(selectedRow, 7).toString();
    	            String roleId = model.getValueAt(selectedRow, 8).toString();
    	            
    	            // Hiển thị thông tin trên các textfield
    	            txtUpperUsername.setText(hoten);
    	            txtUsername.setText(username);
    	            txtPassword.setText(password);
    	            txtEmail.setText(email);
    	            txtSDT.setText(phone);
    	            txtAddress.setText(address);
    	            cmbRoleID.setSelectedItem(roleId);
    	            
    	        }
    	    }
    	});

	      
        
     btnThem.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        if (txtUpperUsername.getText().isEmpty() || txtUsername.getText().isEmpty() || txtPassword.getText().isEmpty() || 
    	            txtEmail.getText().isEmpty() || txtSDT.getText().isEmpty() || txtAddress.getText().isEmpty() || cmbRoleID.getSelectedItem() == null) {                    
    	            JOptionPane.showMessageDialog(pnContainer, "Vui lòng điền đầy đủ thông tin.");
    	        } else {
    	            int choice = JOptionPane.showConfirmDialog(pnContainer, "Bạn có chắc chắn thêm không ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
    	            if (choice == 0) {
    	                String emailPattern = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
    	                String phonePattern = "^[0-9]{10}$";
    	                
    	                String upperUsername = txtUpperUsername.getText(); 
    	                String[] nameParts = upperUsername.split("\\s+(?=[^\\s]+$)"); 
    	                    	                
    	                String lastName = nameParts[0];
    	                String firstName = nameParts.length > 1 ? nameParts[1] : "";
    	                
    	                String username = txtUsername.getText();
    	                String password = txtPassword.getText();
    	                String email = txtEmail.getText();
    	                String phone = txtSDT.getText();
    	                String address = txtAddress.getText();
    	                String roleId = cmbRoleID.getSelectedItem().toString();
    	                Date currentDate = new Date(System.currentTimeMillis());
    	                
    	                if (!email.matches(emailPattern)) {
    	                    JOptionPane.showMessageDialog(pnContainer, "Email không hợp lệ. Vui lòng nhập email có định dạng @gmail.com.", "Lỗi", JOptionPane.ERROR_MESSAGE);
    	                    return;
    	                }
    	                if (!phone.matches(phonePattern)) {
    	                    JOptionPane.showMessageDialog(pnContainer, "Số điện thoại không hợp lệ. Vui lòng nhập số điện thoại gồm 10 chữ số.", "Lỗi", JOptionPane.ERROR_MESSAGE);
    	                    return;
    	                }

    	                StaffDTO newStaff = new StaffDTO();
    	                newStaff.createId();
    	                newStaff.setFirst_name(firstName);
    	                newStaff.setLast_name(lastName);
    	                
    	                newStaff.setUsername(username);
    	                newStaff.setPassword(password);
    	                newStaff.setEmail(email);
    	                newStaff.setPhone(phone);
    	                newStaff.setAddress(address);
    	                newStaff.setisDeleted(false);
    	                newStaff.setRoleId(roleId);
    	                newStaff.setCreateTime(currentDate);
    	                newStaff.setUpdateTime(currentDate);                                 
    	                
    	                boolean isInserted = staffBUS.insertStaff(newStaff);
    	                if (isInserted) {
    	                    JOptionPane.showMessageDialog(null, "Thêm nhân viên mới thành công!");
    	                    renderStaff(isSelectAll);
    	                } else {
    	                    JOptionPane.showMessageDialog(null, "Không thể thêm mới nhân viên.");
    	                }
    	            }
    	        }
    	    }
    	});


        
        btnXoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tbStaff.getSelectedRow();
                if (selectedRow != -1) {
                    int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa nhân viên này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
                    if (choice == JOptionPane.YES_OPTION) {
                        StaffDTO staffSelected = listStaff.get(selectedRow);
                        staffSelected.setisDeleted(true);
                        boolean isUpdated = staffBUS.updateStaff(staffSelected);
                        if (isUpdated) {
                            JOptionPane.showMessageDialog(null, "Xóa nhân viên thành công!");
                            renderStaff(isSelectAll);
                        } else {
                            JOptionPane.showMessageDialog(null, "Không thể xóa nhân viên.");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên cần xóa.");
                }
                txtUsername.setEnabled(true);
                txtUpperUsername.setEnabled(true);
                btnThem.setEnabled(true);
                
            }
        });

        
        btnSua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tbStaff.getSelectedRow();
                if (selectedRow != -1) {
                    if (txtUpperUsername.getText().isEmpty() || txtUsername.getText().isEmpty() || txtPassword.getText().isEmpty() || 
                        txtEmail.getText().isEmpty() || txtSDT.getText().isEmpty() || txtAddress.getText().isEmpty() || cmbRoleID.getSelectedItem() == null) {
                        JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin.");
                        return;
                    }
                    String emailPattern = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
                    String phonePattern = "^[0-9]{10}$";
                    StaffDTO staffSelected = listStaff.get(selectedRow);
                    
                    String upperUsername = txtUpperUsername.getText();
                    String[] nameParts = upperUsername.split("\\s+(?=[^\\s]+$)"); 
                    
                    String firstName = nameParts[0];
                    String lastName = nameParts.length > 1 ? nameParts[1] : "";
                    
                    
                    
                    staffSelected.setFirst_name(firstName);
                    staffSelected.setLast_name(lastName);
                    
                    staffSelected.setUsername(txtUsername.getText());
                    staffSelected.setPassword(txtPassword.getText());
                    staffSelected.setEmail(txtEmail.getText());
                    staffSelected.setPhone(txtSDT.getText());
                    staffSelected.setAddress(txtAddress.getText());
                    staffSelected.setRoleId(cmbRoleID.getSelectedItem().toString());
                    if (!txtEmail.getText().matches(emailPattern)) {
	                    JOptionPane.showMessageDialog(pnContainer, "Email không hợp lệ. Vui lòng nhập email có định dạng @gmail.com.", "Lỗi", JOptionPane.ERROR_MESSAGE);
	                    return;
	                }
	                if (!txtSDT.getText().matches(phonePattern)) {
	                    JOptionPane.showMessageDialog(pnContainer, "Số điện thoại không hợp lệ. Vui lòng nhập số điện thoại gồm 10 chữ số.", "Lỗi", JOptionPane.ERROR_MESSAGE);
	                    return;
	                }

                    boolean isUpdated = staffBUS.updateStaff(staffSelected);
                    if (isUpdated) {
                        JOptionPane.showMessageDialog(null, "Cập nhật thông tin nhân viên thành công!");                       
                        renderStaff(isSelectAll);
                    } else {
                        JOptionPane.showMessageDialog(null, "Không thể cập nhật thông tin nhân viên.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên cần cập nhật.");
                }
                txtUsername.setEnabled(true);
                txtUpperUsername.setEnabled(true);
                btnThem.setEnabled(true);
            }
        });


        


        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search();
            }

            private void search() {
                searchField.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);
                TableRowSorter tableRowSorter = new TableRowSorter(tbStaff.getModel());
                String find = searchField.getText().trim();
                if (!find.isEmpty()) {
        //          Indices 2 => Sort theo cột 2 (Name)
                    tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + find, 2));
                }
                tbStaff.setRowSorter(tableRowSorter);
            }
        });


        
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
    
}




