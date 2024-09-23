/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Comp.Panel;

import BUS.CategoriesBUS;
import DTO.CategoriesDTO;
import DTO.StaffDTO;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc
 */
public class QuanLiTheLoai extends javax.swing.JPanel {
    private CategoriesBUS categoriesBUS = new CategoriesBUS();
    private ArrayList<CategoriesDTO> listCategories = new ArrayList<>();
    private CategoriesDTO categoriesSelected = new CategoriesDTO();
    private DefaultTableModel model;

    public QuanLiTheLoai() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        tbTheLoai.setRowHeight(35);
        
//        listTable = new TableBUS().getAllData();
        // header table nam ben trai
        DefaultTableCellRenderer  renderer = (DefaultTableCellRenderer) tbTheLoai.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.LEFT);
        render();
        
        if (!StaffDTO.staffLogging.getRoleId().equals("STAFF")) {
            btnThem.setEnabled(true);
            btnSua.setEnabled(true);
            btnXoa.setEnabled(true);
        }

    }

    public void render() {
        listCategories = categoriesBUS.getAll();
        model = (DefaultTableModel)tbTheLoai.getModel();
        model.setRowCount(0);
        for (CategoriesDTO x : listCategories) {
            model.addRow(new Object[] {x.getId(), x.getName(), x.getDes()});
        }
        model.fireTableDataChanged();
        tbTheLoai.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnContainer = new GUI.Comp.Swing.PanelBackground();
        panelBackground1 = new GUI.Comp.Swing.PanelBackground();
        panelBackground15 = new GUI.Comp.Swing.PanelBackground();
        panelBackground2 = new GUI.Comp.Swing.PanelBackground();
        panelBackground3 = new GUI.Comp.Swing.PanelBackground();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTenTheLoai = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMoTa = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        panelBackground4 = new GUI.Comp.Swing.PanelBackground();
        panelBackground5 = new GUI.Comp.Swing.PanelBackground();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbTheLoai = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1077, 730));

        pnContainer.setBackground(new java.awt.Color(30, 30, 30));
        pnContainer.setLayout(new java.awt.BorderLayout(15, 0));

        panelBackground1.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground1.setPreferredSize(new java.awt.Dimension(1077, 20));
        panelBackground1.setLayout(new java.awt.BorderLayout());

        panelBackground15.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground15.setPreferredSize(new java.awt.Dimension(400, 20));

        javax.swing.GroupLayout panelBackground15Layout = new javax.swing.GroupLayout(panelBackground15);
        panelBackground15.setLayout(panelBackground15Layout);
        panelBackground15Layout.setHorizontalGroup(
            panelBackground15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1077, Short.MAX_VALUE)
        );
        panelBackground15Layout.setVerticalGroup(
            panelBackground15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        panelBackground1.add(panelBackground15, java.awt.BorderLayout.CENTER);

        pnContainer.add(panelBackground1, java.awt.BorderLayout.PAGE_START);

        panelBackground2.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground2.setPreferredSize(new java.awt.Dimension(5, 690));

        javax.swing.GroupLayout panelBackground2Layout = new javax.swing.GroupLayout(panelBackground2);
        panelBackground2.setLayout(panelBackground2Layout);
        panelBackground2Layout.setHorizontalGroup(
            panelBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        panelBackground2Layout.setVerticalGroup(
            panelBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );

        pnContainer.add(panelBackground2, java.awt.BorderLayout.LINE_START);

        panelBackground3.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground3.setPreferredSize(new java.awt.Dimension(350, 690));
        panelBackground3.setLayout(new java.awt.BorderLayout());

        jPanel12.setBackground(new java.awt.Color(30, 30, 30));
        jPanel12.setPreferredSize(new java.awt.Dimension(20, 690));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );

        panelBackground3.add(jPanel12, java.awt.BorderLayout.LINE_END);

        jPanel13.setBackground(new java.awt.Color(35, 35, 35));
        jPanel13.setLayout(new java.awt.GridLayout(3, 1));

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(30, 30, 30));
        jPanel4.setPreferredSize(new java.awt.Dimension(300, 35));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.setBackground(new java.awt.Color(35, 35, 35));
        jPanel5.setPreferredSize(new java.awt.Dimension(300, 120));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, java.awt.BorderLayout.PAGE_END);

        jPanel6.setBackground(new java.awt.Color(35, 35, 35));
        jPanel6.setPreferredSize(new java.awt.Dimension(35, 35));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, java.awt.BorderLayout.LINE_END);

        jPanel7.setBackground(new java.awt.Color(35, 35, 35));
        jPanel7.setPreferredSize(new java.awt.Dimension(300, 35));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7, java.awt.BorderLayout.PAGE_START);

        jPanel8.setBackground(new java.awt.Color(35, 35, 35));
        jPanel8.setPreferredSize(new java.awt.Dimension(35, 35));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel8, java.awt.BorderLayout.LINE_START);

        jPanel9.setBackground(new java.awt.Color(35, 35, 35));
        jPanel9.setLayout(new java.awt.GridLayout(2, 1, 0, 20));

        jPanel10.setBackground(new java.awt.Color(35, 35, 35));
        jPanel10.setLayout(new java.awt.BorderLayout(15, 0));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tên thể loại");
        jPanel10.add(jLabel1, java.awt.BorderLayout.LINE_START);

        txtTenTheLoai.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jPanel10.add(txtTenTheLoai, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel10);

        jPanel11.setBackground(new java.awt.Color(35, 35, 35));
        jPanel11.setLayout(new java.awt.BorderLayout(50, 0));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mô tả");
        jPanel11.add(jLabel2, java.awt.BorderLayout.LINE_START);

        txtMoTa.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jPanel11.add(txtMoTa, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel11);

        jPanel1.add(jPanel9, java.awt.BorderLayout.CENTER);

        jPanel13.add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(35, 35, 35));
        jPanel2.setLayout(new java.awt.GridLayout(3, 1, 0, 25));

        btnThem.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setEnabled(false);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel2.add(btnThem);

        btnSua.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setEnabled(false);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel2.add(btnSua);

        btnXoa.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnXoa.setText("Xoá");
        btnXoa.setEnabled(false);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel2.add(btnXoa);

        jPanel13.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(35, 35, 35));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel3);

        panelBackground3.add(jPanel13, java.awt.BorderLayout.CENTER);

        pnContainer.add(panelBackground3, java.awt.BorderLayout.LINE_END);

        panelBackground4.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground4.setPreferredSize(new java.awt.Dimension(1077, 20));

        javax.swing.GroupLayout panelBackground4Layout = new javax.swing.GroupLayout(panelBackground4);
        panelBackground4.setLayout(panelBackground4Layout);
        panelBackground4Layout.setHorizontalGroup(
            panelBackground4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1077, Short.MAX_VALUE)
        );
        panelBackground4Layout.setVerticalGroup(
            panelBackground4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        pnContainer.add(panelBackground4, java.awt.BorderLayout.PAGE_END);

        panelBackground5.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground5.setPreferredSize(new java.awt.Dimension(400, 402));
        panelBackground5.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setPreferredSize(new java.awt.Dimension(400, 402));

        tbTheLoai.setAutoCreateRowSorter(true);
        tbTheLoai.setBackground(new java.awt.Color(35, 35, 35));
        tbTheLoai.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        tbTheLoai.setForeground(new java.awt.Color(255, 255, 255));
        tbTheLoai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"aaaaaaaaaa", "ádasdasd", null},
                {"aaaaaaaaaa", "ádasd", null},
                {"aaaaaaaaaa", "ádasd", null},
                {"aaaaaaaaaa", "ádasda", null}
            },
            new String [] {
                "Mã thể loại", "Tên thể loại", "Mô tả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbTheLoai.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbTheLoai.getTableHeader().setResizingAllowed(false);
        tbTheLoai.getTableHeader().setReorderingAllowed(false);
        tbTheLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTheLoaiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbTheLoai);

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
            .addComponent(pnContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (txtTenTheLoai.getText().isEmpty() || txtMoTa.getText().isEmpty()) {
            JOptionPane.showMessageDialog(pnContainer, "Vui lòng nhập thông tin đầy đủ", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        CategoriesDTO categoriesDTO = new CategoriesDTO();
        categoriesDTO.createID();
        categoriesDTO.setName(txtTenTheLoai.getText());
        categoriesDTO.setDes(txtMoTa.getText());
        if (categoriesBUS.insertCategories(categoriesDTO)) {
            JOptionPane.showMessageDialog(pnContainer, "Thêm thành công");
            render();
            refest();
        }
        else {
            JOptionPane.showMessageDialog(pnContainer, "Thêm thất bại");
        }
        
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        categoriesSelected.setName(txtTenTheLoai.getText());
        categoriesSelected.setDes(txtMoTa.getText());
        if (categoriesBUS.updateCategories(categoriesSelected)) {
            JOptionPane.showMessageDialog(pnContainer, "Sửa thành công");
            render();
            refest();
        }
        else {
            JOptionPane.showMessageDialog(pnContainer, "Sửa thất bại");
        }
        txtTenTheLoai.setEnabled(true);
        btnThem.setEnabled(true);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int choice = JOptionPane.showConfirmDialog(pnContainer, "Bạn có chắc chắn xoá không ?", "Xác nhận", JOptionPane.OK_CANCEL_OPTION);
        if (choice != 0) {
            return;
        }
        categoriesSelected.setIsDelete(true);
        if (categoriesBUS.deleteCategories(categoriesSelected)) {
            JOptionPane.showMessageDialog(pnContainer, "Xoá thành công");
            render();
            refest();
        }
        else {
            JOptionPane.showMessageDialog(pnContainer, "Xoá thất bại");
        }
        txtTenTheLoai.setEnabled(true);
        btnThem.setEnabled(true);
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tbTheLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTheLoaiMouseClicked
        txtTenTheLoai.setEnabled(false);
        btnThem.setEnabled(false);
        
        int row = tbTheLoai.getSelectedRow();
        categoriesSelected = listCategories.get(row);
        txtTenTheLoai.setText(categoriesSelected.getName());
        txtMoTa.setText(categoriesSelected.getDes());
    }//GEN-LAST:event_tbTheLoaiMouseClicked

    public void refest() {
        txtTenTheLoai.setText("");
        txtMoTa.setText("");
    }
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private GUI.Comp.Swing.PanelBackground panelBackground1;
    private GUI.Comp.Swing.PanelBackground panelBackground15;
    private GUI.Comp.Swing.PanelBackground panelBackground2;
    private GUI.Comp.Swing.PanelBackground panelBackground3;
    private GUI.Comp.Swing.PanelBackground panelBackground4;
    private GUI.Comp.Swing.PanelBackground panelBackground5;
    private GUI.Comp.Swing.PanelBackground pnContainer;
    private javax.swing.JTable tbTheLoai;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtTenTheLoai;
    // End of variables declaration//GEN-END:variables
}
