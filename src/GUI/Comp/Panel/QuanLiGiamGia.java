/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Comp.Panel;

import BUS.DiscountBUS;
import DTO.DiscountDTO;
import DTO.StaffDTO;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import Helper.Format;

/**
 *
 * @author pc
 */
public class QuanLiGiamGia extends javax.swing.JPanel {
    private ArrayList<DiscountDTO> listDiscount = new ArrayList<>();
    private DiscountDTO discountSelected = new DiscountDTO();
    private DiscountBUS discountBUS = new DiscountBUS();
    private DefaultTableModel model;
    public QuanLiGiamGia() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        tbDiscount.setRowHeight(35);
        
        
//        listTable = new TableBUS().getAllData();
        // header table nam ben trai
        DefaultTableCellRenderer  renderer = (DefaultTableCellRenderer) tbDiscount.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.LEFT);
        render();
        
        if (!StaffDTO.staffLogging.getRoleId().equals("STAFF")) {
            btnThem.setEnabled(true);
            btnSua.setEnabled(true);
            btnXoa.setEnabled(true);
        }

    }

    public void render() {
        listDiscount = discountBUS.getAllData(false);
        model = (DefaultTableModel)tbDiscount.getModel();
        model.setRowCount(0);
        for (DiscountDTO x : listDiscount) {

            model.addRow(new Object[] {x.getId(), x.getName(), x.getDes(), Format.formatNumber.format(x.getMinimum()), x.getRemaining(), x.getValue(), x.getType(), Format.formatDate.format(x.getExpiredTime()) ,Format.formatDate.format(x.getUpdateTime()), Format.formatDate.format(x.getCreateTime())});
        }
        model.fireTableDataChanged();
        tbDiscount.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser = new GUI.Comp.DateChooser.DateChooser();
        pnContainer = new GUI.Comp.Swing.PanelBackground();
        panelBackground1 = new GUI.Comp.Swing.PanelBackground();
        panelBackground10 = new GUI.Comp.Swing.PanelBackground();
        panelBackground14 = new GUI.Comp.Swing.PanelBackground();
        panelBackground7 = new GUI.Comp.Swing.PanelBackground();
        panelBackground6 = new GUI.Comp.Swing.PanelBackground();
        panelBackground9 = new GUI.Comp.Swing.PanelBackground();
        panelBackground8 = new GUI.Comp.Swing.PanelBackground();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        panelBackground11 = new GUI.Comp.Swing.PanelBackground();
        panelBackground12 = new GUI.Comp.Swing.PanelBackground();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtTenChuongTrinh = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txtMoTa = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        txtDieuKien = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        txtSoLuong = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        cbxLoaiGiam = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        panelBackground13 = new GUI.Comp.Swing.PanelBackground();
        jLabel6 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        txtGiaTri = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        txtDate = new javax.swing.JTextField();
        jPanel25 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        panelBackground2 = new GUI.Comp.Swing.PanelBackground();
        panelBackground3 = new GUI.Comp.Swing.PanelBackground();
        panelBackground4 = new GUI.Comp.Swing.PanelBackground();
        panelBackground5 = new GUI.Comp.Swing.PanelBackground();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDiscount = new javax.swing.JTable();

        dateChooser.setTextRefernce(txtDate);

        setPreferredSize(new java.awt.Dimension(1077, 730));

        pnContainer.setBackground(new java.awt.Color(30, 30, 30));
        pnContainer.setLayout(new java.awt.BorderLayout());

        panelBackground1.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground1.setPreferredSize(new java.awt.Dimension(1077, 200));
        panelBackground1.setLayout(new java.awt.BorderLayout(15, 0));

        panelBackground10.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground10.setPreferredSize(new java.awt.Dimension(5, 75));
        panelBackground10.setLayout(new javax.swing.BoxLayout(panelBackground10, javax.swing.BoxLayout.LINE_AXIS));
        panelBackground1.add(panelBackground10, java.awt.BorderLayout.LINE_START);

        panelBackground14.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground14.setPreferredSize(new java.awt.Dimension(300, 75));
        panelBackground14.setLayout(new java.awt.BorderLayout());

        panelBackground7.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground7.setPreferredSize(new java.awt.Dimension(20, 75));

        javax.swing.GroupLayout panelBackground7Layout = new javax.swing.GroupLayout(panelBackground7);
        panelBackground7.setLayout(panelBackground7Layout);
        panelBackground7Layout.setHorizontalGroup(
            panelBackground7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        panelBackground7Layout.setVerticalGroup(
            panelBackground7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        panelBackground14.add(panelBackground7, java.awt.BorderLayout.LINE_END);

        panelBackground6.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground6.setPreferredSize(new java.awt.Dimension(500, 10));

        javax.swing.GroupLayout panelBackground6Layout = new javax.swing.GroupLayout(panelBackground6);
        panelBackground6.setLayout(panelBackground6Layout);
        panelBackground6Layout.setHorizontalGroup(
            panelBackground6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        panelBackground6Layout.setVerticalGroup(
            panelBackground6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        panelBackground14.add(panelBackground6, java.awt.BorderLayout.PAGE_END);

        panelBackground9.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground9.setPreferredSize(new java.awt.Dimension(500, 20));

        javax.swing.GroupLayout panelBackground9Layout = new javax.swing.GroupLayout(panelBackground9);
        panelBackground9.setLayout(panelBackground9Layout);
        panelBackground9Layout.setHorizontalGroup(
            panelBackground9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        panelBackground9Layout.setVerticalGroup(
            panelBackground9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        panelBackground14.add(panelBackground9, java.awt.BorderLayout.PAGE_START);

        panelBackground8.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground8.setLayout(new java.awt.GridLayout(3, 1, 15, 20));

        btnThem.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setEnabled(false);
        btnThem.setMaximumSize(new java.awt.Dimension(72, 35));
        btnThem.setPreferredSize(new java.awt.Dimension(72, 35));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        panelBackground8.add(btnThem);

        btnSua.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setEnabled(false);
        btnSua.setMaximumSize(new java.awt.Dimension(72, 35));
        btnSua.setPreferredSize(new java.awt.Dimension(72, 30));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        panelBackground8.add(btnSua);

        btnXoa.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnXoa.setText("Xoá");
        btnXoa.setEnabled(false);
        btnXoa.setMaximumSize(new java.awt.Dimension(72, 35));
        btnXoa.setPreferredSize(new java.awt.Dimension(72, 30));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        panelBackground8.add(btnXoa);

        panelBackground14.add(panelBackground8, java.awt.BorderLayout.CENTER);

        panelBackground1.add(panelBackground14, java.awt.BorderLayout.LINE_END);

        jPanel1.setBackground(new java.awt.Color(30, 30, 30));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 200));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(30, 30, 30));
        jPanel2.setPreferredSize(new java.awt.Dimension(557, 20));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 806, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(30, 30, 30));
        jPanel3.setPreferredSize(new java.awt.Dimension(557, 10));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 806, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        panelBackground11.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground11.setRound(35);
        panelBackground11.setLayout(new java.awt.GridLayout(3, 1));

        panelBackground12.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground12.setRound(45);
        panelBackground12.setLayout(new javax.swing.BoxLayout(panelBackground12, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("   Tên chương trình");
        panelBackground12.add(jLabel1);

        jPanel5.setBackground(new java.awt.Color(35, 35, 35));
        jPanel5.setMaximumSize(new java.awt.Dimension(15, 32767));
        jPanel5.setMinimumSize(new java.awt.Dimension(15, 100));
        jPanel5.setPreferredSize(new java.awt.Dimension(15, 90));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        panelBackground12.add(jPanel5);

        txtTenChuongTrinh.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtTenChuongTrinh.setMaximumSize(new java.awt.Dimension(150, 30));
        txtTenChuongTrinh.setMinimumSize(new java.awt.Dimension(64, 25));
        txtTenChuongTrinh.setPreferredSize(new java.awt.Dimension(71, 25));
        panelBackground12.add(txtTenChuongTrinh);

        jPanel7.setBackground(new java.awt.Color(35, 35, 35));
        jPanel7.setMaximumSize(new java.awt.Dimension(15, 32767));
        jPanel7.setMinimumSize(new java.awt.Dimension(15, 100));
        jPanel7.setPreferredSize(new java.awt.Dimension(15, 90));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelBackground12.add(jPanel7);

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mô tả");
        panelBackground12.add(jLabel2);

        jPanel6.setBackground(new java.awt.Color(35, 35, 35));
        jPanel6.setMaximumSize(new java.awt.Dimension(40, 32767));
        jPanel6.setMinimumSize(new java.awt.Dimension(30, 100));
        jPanel6.setPreferredSize(new java.awt.Dimension(30, 90));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        panelBackground12.add(jPanel6);

        txtMoTa.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtMoTa.setMaximumSize(new java.awt.Dimension(150, 30));
        txtMoTa.setMinimumSize(new java.awt.Dimension(64, 25));
        txtMoTa.setPreferredSize(new java.awt.Dimension(71, 25));
        panelBackground12.add(txtMoTa);

        jPanel11.setBackground(new java.awt.Color(35, 35, 35));
        jPanel11.setMaximumSize(new java.awt.Dimension(15, 32767));
        jPanel11.setMinimumSize(new java.awt.Dimension(15, 100));
        jPanel11.setPreferredSize(new java.awt.Dimension(15, 90));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelBackground12.add(jPanel11);

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Điều kiện");
        panelBackground12.add(jLabel3);

        jPanel23.setBackground(new java.awt.Color(35, 35, 35));
        jPanel23.setMaximumSize(new java.awt.Dimension(15, 32767));
        jPanel23.setMinimumSize(new java.awt.Dimension(15, 100));
        jPanel23.setPreferredSize(new java.awt.Dimension(15, 90));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelBackground12.add(jPanel23);

        txtDieuKien.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtDieuKien.setMaximumSize(new java.awt.Dimension(150, 30));
        txtDieuKien.setMinimumSize(new java.awt.Dimension(64, 25));
        txtDieuKien.setPreferredSize(new java.awt.Dimension(71, 25));
        panelBackground12.add(txtDieuKien);

        panelBackground11.add(panelBackground12);

        jPanel13.setBackground(new java.awt.Color(35, 35, 35));
        jPanel13.setLayout(new javax.swing.BoxLayout(jPanel13, javax.swing.BoxLayout.LINE_AXIS));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("   Số lượng");
        jPanel13.add(jLabel4);

        jPanel15.setBackground(new java.awt.Color(35, 35, 35));
        jPanel15.setMaximumSize(new java.awt.Dimension(65, 32767));
        jPanel15.setMinimumSize(new java.awt.Dimension(15, 100));
        jPanel15.setPreferredSize(new java.awt.Dimension(50, 90));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel15);

        txtSoLuong.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtSoLuong.setMaximumSize(new java.awt.Dimension(150, 30));
        txtSoLuong.setMinimumSize(new java.awt.Dimension(64, 25));
        txtSoLuong.setPreferredSize(new java.awt.Dimension(71, 25));
        jPanel13.add(txtSoLuong);

        jPanel16.setBackground(new java.awt.Color(35, 35, 35));
        jPanel16.setMaximumSize(new java.awt.Dimension(15, 32767));
        jPanel16.setMinimumSize(new java.awt.Dimension(15, 100));
        jPanel16.setPreferredSize(new java.awt.Dimension(15, 90));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel16);

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Loại giảm");
        jPanel13.add(jLabel5);

        jPanel17.setBackground(new java.awt.Color(35, 35, 35));
        jPanel17.setMaximumSize(new java.awt.Dimension(15, 32767));
        jPanel17.setMinimumSize(new java.awt.Dimension(15, 100));
        jPanel17.setPreferredSize(new java.awt.Dimension(15, 90));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel17);

        cbxLoaiGiam.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cbxLoaiGiam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "currency", "percent" }));
        cbxLoaiGiam.setMaximumSize(new java.awt.Dimension(100, 30));
        cbxLoaiGiam.setPreferredSize(new java.awt.Dimension(90, 30));
        jPanel13.add(cbxLoaiGiam);

        jPanel8.setBackground(new java.awt.Color(35, 35, 35));
        jPanel8.setMaximumSize(new java.awt.Dimension(15, 32767));
        jPanel8.setMinimumSize(new java.awt.Dimension(15, 100));
        jPanel8.setPreferredSize(new java.awt.Dimension(15, 90));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel8);

        panelBackground11.add(jPanel13);

        panelBackground13.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground13.setRound(45);
        panelBackground13.setLayout(new javax.swing.BoxLayout(panelBackground13, javax.swing.BoxLayout.LINE_AXIS));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("   Giá trị");
        panelBackground13.add(jLabel6);

        jPanel18.setBackground(new java.awt.Color(35, 35, 35));
        jPanel18.setMaximumSize(new java.awt.Dimension(83, 32767));
        jPanel18.setMinimumSize(new java.awt.Dimension(15, 100));
        jPanel18.setPreferredSize(new java.awt.Dimension(15, 90));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 83, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelBackground13.add(jPanel18);

        txtGiaTri.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtGiaTri.setMaximumSize(new java.awt.Dimension(150, 30));
        txtGiaTri.setMinimumSize(new java.awt.Dimension(64, 25));
        txtGiaTri.setPreferredSize(new java.awt.Dimension(71, 25));
        panelBackground13.add(txtGiaTri);

        jPanel19.setBackground(new java.awt.Color(35, 35, 35));
        jPanel19.setMaximumSize(new java.awt.Dimension(15, 32767));
        jPanel19.setMinimumSize(new java.awt.Dimension(15, 100));
        jPanel19.setPreferredSize(new java.awt.Dimension(15, 90));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelBackground13.add(jPanel19);

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ngày hết hạn");
        panelBackground13.add(jLabel7);

        jPanel22.setBackground(new java.awt.Color(35, 35, 35));
        jPanel22.setMaximumSize(new java.awt.Dimension(15, 32767));
        jPanel22.setMinimumSize(new java.awt.Dimension(15, 100));
        jPanel22.setPreferredSize(new java.awt.Dimension(15, 90));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        panelBackground13.add(jPanel22);

        txtDate.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtDate.setMaximumSize(new java.awt.Dimension(150, 30));
        txtDate.setMinimumSize(new java.awt.Dimension(64, 25));
        txtDate.setPreferredSize(new java.awt.Dimension(71, 25));
        panelBackground13.add(txtDate);

        jPanel25.setBackground(new java.awt.Color(35, 35, 35));
        jPanel25.setMaximumSize(new java.awt.Dimension(15, 32767));
        jPanel25.setMinimumSize(new java.awt.Dimension(15, 100));
        jPanel25.setPreferredSize(new java.awt.Dimension(15, 90));

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelBackground13.add(jPanel25);

        jPanel26.setBackground(new java.awt.Color(35, 35, 35));
        jPanel26.setMaximumSize(new java.awt.Dimension(15, 32767));
        jPanel26.setMinimumSize(new java.awt.Dimension(15, 100));
        jPanel26.setPreferredSize(new java.awt.Dimension(15, 90));

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelBackground13.add(jPanel26);

        panelBackground11.add(panelBackground13);

        jPanel1.add(panelBackground11, java.awt.BorderLayout.CENTER);

        panelBackground1.add(jPanel1, java.awt.BorderLayout.CENTER);

        pnContainer.add(panelBackground1, java.awt.BorderLayout.PAGE_START);

        panelBackground2.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground2.setPreferredSize(new java.awt.Dimension(20, 690));

        javax.swing.GroupLayout panelBackground2Layout = new javax.swing.GroupLayout(panelBackground2);
        panelBackground2.setLayout(panelBackground2Layout);
        panelBackground2Layout.setHorizontalGroup(
            panelBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        panelBackground2Layout.setVerticalGroup(
            panelBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        pnContainer.add(panelBackground2, java.awt.BorderLayout.LINE_START);

        panelBackground3.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground3.setPreferredSize(new java.awt.Dimension(20, 690));

        javax.swing.GroupLayout panelBackground3Layout = new javax.swing.GroupLayout(panelBackground3);
        panelBackground3.setLayout(panelBackground3Layout);
        panelBackground3Layout.setHorizontalGroup(
            panelBackground3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        panelBackground3Layout.setVerticalGroup(
            panelBackground3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        pnContainer.add(panelBackground3, java.awt.BorderLayout.LINE_END);

        panelBackground4.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground4.setPreferredSize(new java.awt.Dimension(1077, 20));

        javax.swing.GroupLayout panelBackground4Layout = new javax.swing.GroupLayout(panelBackground4);
        panelBackground4.setLayout(panelBackground4Layout);
        panelBackground4Layout.setHorizontalGroup(
            panelBackground4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1141, Short.MAX_VALUE)
        );
        panelBackground4Layout.setVerticalGroup(
            panelBackground4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        pnContainer.add(panelBackground4, java.awt.BorderLayout.PAGE_END);

        panelBackground5.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground5.setLayout(new java.awt.BorderLayout());

        tbDiscount.setAutoCreateRowSorter(true);
        tbDiscount.setBackground(new java.awt.Color(35, 35, 35));
        tbDiscount.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        tbDiscount.setForeground(new java.awt.Color(255, 255, 255));
        tbDiscount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"aaaaaaaaaa", "ádasdasd", null, "aaaaaaaaaa", "aaaaaaaaaa", null, "aaaaaaaaaa", null, null, null},
                {"aaaaaaaaaa", "ádasd", null, "aaaaaaaaaa", "aaaaaaaaaa", null, "aaaaaaaaaa", null, null, null},
                {"aaaaaaaaaa", "ádasd", null, "aaaaaaaaaa", "aaaaaaaaaa", null, "aaaaaaaaaa", null, null, null},
                {"aaaaaaaaaa", "ádasda", null, "aaaaaaaaaa", "aaaaaaaaaa", null, "aaaaaaaaaa", null, null, null}
            },
            new String [] {
                "Mã", "Tên chương trình", "Mô tả", "Điều kiện", "Số lượng", "Loại giảm giá", "Giá trị", "Ngày hết hạn", "Ngày sửa", "Ngày tạo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDiscount.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbDiscount.getTableHeader().setResizingAllowed(false);
        tbDiscount.getTableHeader().setReorderingAllowed(false);
        tbDiscount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDiscountMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbDiscount);

        panelBackground5.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        pnContainer.add(panelBackground5, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents


    
    
    public void refesh() {
        txtTenChuongTrinh.setText("");
        txtMoTa.setText("");
        txtDieuKien.setText("");
        txtGiaTri.setText("");
        txtSoLuong.setText("");
        txtDate.setText("");
    }
    
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int choice = JOptionPane.showConfirmDialog(pnContainer, "Bạn có chắc chắn xoá không ?", "Xác nhận", JOptionPane.OK_CANCEL_OPTION);
        if (choice != 0) {
            return;
        }
        boolean isValid = true;
        if (txtTenChuongTrinh.getText().isEmpty()) {
            isValid = false;
        }
        if (txtMoTa.getText().isEmpty()) {
            isValid = false;
        }
        if (txtDieuKien.getText().isEmpty()) {
            isValid = false;
        }
        if (txtGiaTri.getText().isEmpty()) {
            isValid = false;
        }
        if (txtSoLuong.getText().isEmpty()) {
            isValid = false;
        }
        if (txtDate.getText().isEmpty()) {
            isValid = false;
        }
        if (!isValid) {
            JOptionPane.showMessageDialog(pnContainer, "Vui lòng điền đủ thông tin", "Cảnh báo", HEIGHT);
            return;
        }

        discountSelected.setName(txtTenChuongTrinh.getText());
        discountSelected.setDes(txtMoTa.getText());
        discountSelected.setMinimum(Long.parseLong(txtDieuKien.getText()));
        discountSelected.setRemaining(Integer.parseInt(txtSoLuong.getText()));
        discountSelected.setValue(Long.parseLong(txtGiaTri.getText()));
        discountSelected.setType(cbxLoaiGiam.getSelectedItem().toString());
        discountSelected.setIsDelete(true);
        
        
        discountSelected.setUpdateTime(new Date());
        if (discountBUS.updateDiscount(discountSelected)) {
            JOptionPane.showMessageDialog(pnContainer, "Xoá thành công");
            refesh();
            render();
        }
        else {
            JOptionPane.showMessageDialog(pnContainer, "Xoá thất bại");
        }
        txtTenChuongTrinh.setEnabled(true);
        txtSoLuong.setEnabled(true);
        cbxLoaiGiam.setEnabled(true);
        txtGiaTri.setEnabled(true);
        txtDate.setEnabled(true);
        btnThem.setEnabled(true);
        txtDieuKien.setEnabled(true);
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        boolean isValid = true;
        if (txtTenChuongTrinh.getText().isEmpty()) {
            isValid = false;
        }
        if (txtMoTa.getText().isEmpty()) {
            isValid = false;
        }
        if (txtDieuKien.getText().isEmpty()) {
            isValid = false;
        }
        if (txtGiaTri.getText().isEmpty()) {
            isValid = false;
        }
        if (txtSoLuong.getText().isEmpty()) {
            isValid = false;
        }
        if (txtDate.getText().isEmpty()) {
            isValid = false;
        }
        if (!isValid) {
            JOptionPane.showMessageDialog(pnContainer, "Vui lòng điền đủ thông tin", "Cảnh báo", HEIGHT);
            return;
        }

        discountSelected.setName(txtTenChuongTrinh.getText());
        discountSelected.setDes(txtMoTa.getText());
        discountSelected.setMinimum(Long.parseLong(txtDieuKien.getText()));
        discountSelected.setRemaining(Integer.parseInt(txtSoLuong.getText()));
        discountSelected.setValue(Long.parseLong(txtGiaTri.getText()));
        discountSelected.setType(cbxLoaiGiam.getSelectedItem().toString());
        
        try {
            
            SimpleDateFormat a = new SimpleDateFormat("dd/MM/yyyy");

            Date date = a.parse(txtDate.getText());
            if (date.before(new Date())) {
                JOptionPane.showMessageDialog(pnContainer, "Không đuọc chọn ngày là quá khứ", "Cảnh báo", HEIGHT);
                return;
            }
            discountSelected.setExpiredTime(date);
        } catch (ParseException ex) {
            Logger.getLogger(QuanLiGiamGia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        discountSelected.setUpdateTime(new Date());
        if (discountBUS.updateDiscount(discountSelected)) {
            JOptionPane.showMessageDialog(pnContainer, "Sửa thành công");
            refesh();
            render();
        }
        else {
            JOptionPane.showMessageDialog(pnContainer, "Sửa thất bại");
        }
        txtTenChuongTrinh.setEnabled(true);
        txtSoLuong.setEnabled(true);
        cbxLoaiGiam.setEnabled(true);
        txtGiaTri.setEnabled(true);
        txtDate.setEnabled(true);
        btnThem.setEnabled(true);
        txtDieuKien.setEnabled(true);

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        boolean isValid = true;
        if (txtTenChuongTrinh.getText().isEmpty()) {
            isValid = false;
        }
        if (txtMoTa.getText().isEmpty()) {
            isValid = false;
        }
        if (txtDieuKien.getText().isEmpty()) {
            isValid = false;
        }
        if (txtGiaTri.getText().isEmpty()) {
            isValid = false;
        }
        if (txtSoLuong.getText().isEmpty()) {
            isValid = false;
        }
        if (txtDate.getText().isEmpty()) {
            isValid = false;
        }
        
        try {
            int value = Integer.parseInt(txtGiaTri.getText());
            int quantity = Integer.parseInt(txtSoLuong.getText());
            long condition = Long.parseLong(txtDieuKien.getText());
            if (value <= 0 || quantity <= 0 || condition <= 0) {
                isValid = false;
            }
            if (cbxLoaiGiam.getSelectedItem().toString().equals("percent")) {
                if (value > 100) {
                    isValid = false;
                }
            }
        }
        catch(NumberFormatException nfe) {
            isValid = false;
        }
        
        if (!isValid) {
            JOptionPane.showMessageDialog(pnContainer, "Vui lòng nhập đẩy đủ dữ liệu, định dạng", "Cảnh báo", HEIGHT);
            return;
        }
        DiscountDTO discount = new DiscountDTO();
        discount.createID();
        discount.setName(txtTenChuongTrinh.getText());
        discount.setDes(txtMoTa.getText());
        discount.setMinimum(Long.parseLong(txtDieuKien.getText()));
        discount.setRemaining(Integer.parseInt(txtSoLuong.getText()));
        discount.setValue(Long.parseLong(txtGiaTri.getText()));
        discount.setType(cbxLoaiGiam.getSelectedItem().toString());
        
        try {
            
            SimpleDateFormat a = new SimpleDateFormat("dd/MM/yyyy");

            Date date = a.parse(txtDate.getText());
            if (date.before(new Date())) {
                JOptionPane.showMessageDialog(pnContainer, "Không đuọc chọn ngày là quá khứ", "Cảnh báo", HEIGHT);
                return;
            }
            discount.setExpiredTime(date);
        } catch (ParseException ex) {
            Logger.getLogger(QuanLiGiamGia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        discount.setCreateTime(new Date());
        discount.setUpdateTime(new Date());
        if (discountBUS.insertDiscount(discount)) {
            JOptionPane.showMessageDialog(pnContainer, "Thêm thành công");
            refesh();
            render();
        }
        else {
            JOptionPane.showMessageDialog(pnContainer, "Thêm thất bại");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void tbDiscountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDiscountMouseClicked
        
        txtTenChuongTrinh.setEnabled(false);
        txtSoLuong.setEnabled(false);
        cbxLoaiGiam.setEnabled(false);
        txtGiaTri.setEnabled(false);
        txtDate.setEnabled(false);
        btnThem.setEnabled(false);
        txtDieuKien.setEnabled(false);
        
        
        discountSelected = listDiscount.get(tbDiscount.getSelectedRow());
        txtTenChuongTrinh.setText(discountSelected.getName());
        txtMoTa.setText(discountSelected.getDes());
        txtDieuKien.setText(discountSelected.getMinimum() + "");
        txtGiaTri.setText(discountSelected.getValue() + "");
        txtSoLuong.setText(discountSelected.getRemaining() + "");
        txtDate.setText(Helper.Format.formatDate.format(discountSelected.getExpiredTime()));
        cbxLoaiGiam.setSelectedIndex(discountSelected.getType().equals("percent") ? 1 : 0);
    }//GEN-LAST:event_tbDiscountMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbxLoaiGiam;
    private GUI.Comp.DateChooser.DateChooser dateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private GUI.Comp.Swing.PanelBackground panelBackground1;
    private GUI.Comp.Swing.PanelBackground panelBackground10;
    private GUI.Comp.Swing.PanelBackground panelBackground11;
    private GUI.Comp.Swing.PanelBackground panelBackground12;
    private GUI.Comp.Swing.PanelBackground panelBackground13;
    private GUI.Comp.Swing.PanelBackground panelBackground14;
    private GUI.Comp.Swing.PanelBackground panelBackground2;
    private GUI.Comp.Swing.PanelBackground panelBackground3;
    private GUI.Comp.Swing.PanelBackground panelBackground4;
    private GUI.Comp.Swing.PanelBackground panelBackground5;
    private GUI.Comp.Swing.PanelBackground panelBackground6;
    private GUI.Comp.Swing.PanelBackground panelBackground7;
    private GUI.Comp.Swing.PanelBackground panelBackground8;
    private GUI.Comp.Swing.PanelBackground panelBackground9;
    private GUI.Comp.Swing.PanelBackground pnContainer;
    private javax.swing.JTable tbDiscount;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtDieuKien;
    private javax.swing.JTextField txtGiaTri;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenChuongTrinh;
    // End of variables declaration//GEN-END:variables
}
