/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Comp.Panel;

import BUS.DetailImportBillBUS;
import BUS.DetailsReciptBUS;
import BUS.MenuItemBUS;
import DTO.DetailImportBillDTO;
import DTO.DetailsRecipeDTO;
import DTO.MenuItemDTO;
import DTO.StaffDTO;
import GUI.Comp.Dialog.DialogMonAn;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author pc
 */
public class QuanLiMonAn extends javax.swing.JPanel {
    private ArrayList<MenuItemDTO> listItem;
    private MenuItemBUS menuItemBUS = new MenuItemBUS();
    int cntRowSelected = 0;
    private DefaultTableModel model;
    private boolean isSelectAll = false;
    
    public QuanLiMonAn() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        tbMonAn.setRowHeight(35);
        
        // header table nam ben trai
        DefaultTableCellRenderer  renderer = (DefaultTableCellRenderer) tbMonAn.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.LEFT);
        txtTimKiem.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Tìm món ăn");
        render(isSelectAll, true);
        
        tbMonAn.getModel().addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                if (e.getColumn() == 0) { 

                    // Lay row cua table ban dau
                    int row = tbMonAn.getSelectedRow();
                    int row1 = e.getFirstRow();
                    listItem.get(row1).setIsSelected((boolean)tbMonAn.getValueAt(row, 0));
                    cntRowSelected += listItem.get(row).isIsSelected() ? 1 : -1;
   
                }
            }
        });
        
        if (!StaffDTO.staffLogging.getRoleId().equals("STAFF")) {
            btnThem.setEnabled(true);
            btnSua.setEnabled(true);
            btnXoa.setEnabled(true);
        }

    }

    public void render(boolean isSelectAll, boolean isUpdateProduct) {
        listItem = menuItemBUS.getAllData();
        model = (DefaultTableModel)tbMonAn.getModel();
        model.setRowCount(0);
        for (MenuItemDTO x : listItem) {
            x.setIsSelected(isSelectAll);
//            CategoriesDTO cate = new CategoriesBUS().findCategoriByID(x.getCategoryID());
//            MenuItemStatusDTO status = new MenuItemStatusBUS().findItemStatusByID(x.getStatusID());
            
            if (isUpdateProduct) {
                ArrayList<DetailsRecipeDTO> listDetails = new DetailsReciptBUS().readByIDItem(x.getId());
//            System.out.println(listDetails.size() + " " + x.getName());
                double price = 0;
                for (DetailsRecipeDTO detail : listDetails) {
                    DetailImportBillDTO detail_import = new DetailImportBillBUS().getDetailImportBillByBillIdIngre(detail.getIngredientID());
                    price += detail_import.getPrice() *  detail.getQuantity();
                }
                price += x.getProfit();
                x.setPrice((long)price);
                menuItemBUS.updateData(x);
            }
            
            
            model.addRow(new Object[] {x.isIsSelected(), x.getId(), x.getName(), Helper.Format.formatNumber.format(x.getPrice()), Helper.Format.formatNumber.format(x.getProfit()), x.getMenuItemStatusDTO().getName(), x.getCategoriesDTO().getName(),Helper.Format.formatDate.format(x.getUpdateTime()), Helper.Format.formatDate.format(x.getCreateTime())});
            
        }
        model.fireTableDataChanged();
        tbMonAn.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnContainer = new GUI.Comp.Swing.PanelBackground();
        panelBackground1 = new GUI.Comp.Swing.PanelBackground();
        panelBackground10 = new GUI.Comp.Swing.PanelBackground();
        panelBackground16 = new GUI.Comp.Swing.PanelBackground();
        pnSelectAll = new GUI.Comp.Swing.PanelBackground();
        chbSelectAll = new javax.swing.JCheckBox();
        panelBackground17 = new GUI.Comp.Swing.PanelBackground();
        txtTimKiem = new javax.swing.JTextField();
        panelBackground14 = new GUI.Comp.Swing.PanelBackground();
        panelBackground7 = new GUI.Comp.Swing.PanelBackground();
        panelBackground6 = new GUI.Comp.Swing.PanelBackground();
        panelBackground9 = new GUI.Comp.Swing.PanelBackground();
        panelBackground8 = new GUI.Comp.Swing.PanelBackground();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        panelBackground2 = new GUI.Comp.Swing.PanelBackground();
        panelBackground3 = new GUI.Comp.Swing.PanelBackground();
        panelBackground4 = new GUI.Comp.Swing.PanelBackground();
        panelBackground5 = new GUI.Comp.Swing.PanelBackground();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbMonAn = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1077, 730));

        pnContainer.setBackground(new java.awt.Color(30, 30, 30));
        pnContainer.setLayout(new java.awt.BorderLayout());

        panelBackground1.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground1.setPreferredSize(new java.awt.Dimension(1077, 75));
        panelBackground1.setLayout(new java.awt.BorderLayout());

        panelBackground10.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground10.setPreferredSize(new java.awt.Dimension(300, 75));
        panelBackground10.setLayout(new javax.swing.BoxLayout(panelBackground10, javax.swing.BoxLayout.LINE_AXIS));

        panelBackground16.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground16.setPreferredSize(new java.awt.Dimension(45, 75));

        javax.swing.GroupLayout panelBackground16Layout = new javax.swing.GroupLayout(panelBackground16);
        panelBackground16.setLayout(panelBackground16Layout);
        panelBackground16Layout.setHorizontalGroup(
            panelBackground16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        panelBackground16Layout.setVerticalGroup(
            panelBackground16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        panelBackground10.add(panelBackground16);

        pnSelectAll.setBackground(new java.awt.Color(35, 35, 35));
        pnSelectAll.setMaximumSize(new java.awt.Dimension(100, 30));

        chbSelectAll.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        chbSelectAll.setForeground(new java.awt.Color(255, 255, 255));
        chbSelectAll.setText("Select All");
        chbSelectAll.setPreferredSize(new java.awt.Dimension(85, 21));
        chbSelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbSelectAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnSelectAllLayout = new javax.swing.GroupLayout(pnSelectAll);
        pnSelectAll.setLayout(pnSelectAllLayout);
        pnSelectAllLayout.setHorizontalGroup(
            pnSelectAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 85, Short.MAX_VALUE)
            .addGroup(pnSelectAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnSelectAllLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(chbSelectAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnSelectAllLayout.setVerticalGroup(
            pnSelectAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
            .addGroup(pnSelectAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnSelectAllLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(chbSelectAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        panelBackground10.add(pnSelectAll);

        panelBackground17.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground17.setPreferredSize(new java.awt.Dimension(50, 75));

        javax.swing.GroupLayout panelBackground17Layout = new javax.swing.GroupLayout(panelBackground17);
        panelBackground17.setLayout(panelBackground17Layout);
        panelBackground17Layout.setHorizontalGroup(
            panelBackground17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        panelBackground17Layout.setVerticalGroup(
            panelBackground17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        panelBackground10.add(panelBackground17);

        txtTimKiem.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtTimKiem.setMaximumSize(new java.awt.Dimension(200, 30));
        txtTimKiem.setPreferredSize(new java.awt.Dimension(300, 30));
        txtTimKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemCaretUpdate(evt);
            }
        });
        panelBackground10.add(txtTimKiem);

        panelBackground1.add(panelBackground10, java.awt.BorderLayout.LINE_START);

        panelBackground14.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground14.setPreferredSize(new java.awt.Dimension(500, 75));
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
            .addGap(0, 55, Short.MAX_VALUE)
        );

        panelBackground14.add(panelBackground7, java.awt.BorderLayout.LINE_END);

        panelBackground6.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground6.setPreferredSize(new java.awt.Dimension(500, 10));

        javax.swing.GroupLayout panelBackground6Layout = new javax.swing.GroupLayout(panelBackground6);
        panelBackground6.setLayout(panelBackground6Layout);
        panelBackground6Layout.setHorizontalGroup(
            panelBackground6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        panelBackground6Layout.setVerticalGroup(
            panelBackground6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        panelBackground14.add(panelBackground6, java.awt.BorderLayout.PAGE_END);

        panelBackground9.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground9.setPreferredSize(new java.awt.Dimension(500, 10));

        javax.swing.GroupLayout panelBackground9Layout = new javax.swing.GroupLayout(panelBackground9);
        panelBackground9.setLayout(panelBackground9Layout);
        panelBackground9Layout.setHorizontalGroup(
            panelBackground9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        panelBackground9Layout.setVerticalGroup(
            panelBackground9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        panelBackground14.add(panelBackground9, java.awt.BorderLayout.PAGE_START);

        panelBackground8.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground8.setLayout(new java.awt.GridLayout(1, 0, 15, 0));

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
            .addGap(0, 619, Short.MAX_VALUE)
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
            .addGap(0, 619, Short.MAX_VALUE)
        );

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
        panelBackground5.setLayout(new java.awt.BorderLayout());

        tbMonAn.setAutoCreateRowSorter(true);
        tbMonAn.setBackground(new java.awt.Color(35, 35, 35));
        tbMonAn.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        tbMonAn.setForeground(new java.awt.Color(255, 255, 255));
        tbMonAn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "aaaaaaaaaa", "ádasdasd", "aaaaaaaaaa", "aaaaaaaaaa", null, "aaaaaaaaaa", null, null},
                {null, "aaaaaaaaaa", "ádasd", "aaaaaaaaaa", "aaaaaaaaaa", null, "aaaaaaaaaa", null, null},
                {null, "aaaaaaaaaa", "ádasd", "aaaaaaaaaa", "aaaaaaaaaa", null, "aaaaaaaaaa", null, null},
                {null, "aaaaaaaaaa", "ádasda", "aaaaaaaaaa", "aaaaaaaaaa", null, "aaaaaaaaaa", null, null}
            },
            new String [] {
                "", "Mã món ăn", "Tên món ăn", "Giá bán", "Lợi nhuận", "Trạng thái", "Thể loại", "Ngày sửa", "Ngày tạo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbMonAn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbMonAn.getTableHeader().setResizingAllowed(false);
        tbMonAn.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbMonAn);
        if (tbMonAn.getColumnModel().getColumnCount() > 0) {
            tbMonAn.getColumnModel().getColumn(0).setPreferredWidth(20);
            tbMonAn.getColumnModel().getColumn(0).setMaxWidth(20);
            tbMonAn.getColumnModel().getColumn(1).setPreferredWidth(170);
            tbMonAn.getColumnModel().getColumn(1).setMaxWidth(170);
            tbMonAn.getColumnModel().getColumn(2).setPreferredWidth(200);
            tbMonAn.getColumnModel().getColumn(2).setMaxWidth(200);
        }

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

    private void chbSelectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbSelectAllActionPerformed
        isSelectAll = !isSelectAll;
        if (isSelectAll) {
            cntRowSelected = listItem.size();
        }
        else {
            cntRowSelected = 0;

        }
        render(isSelectAll, false);
    }//GEN-LAST:event_chbSelectAllActionPerformed


    
    
    
    
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String listID = "";
        for (MenuItemDTO x : listItem) {
            if (x.isIsSelected()) {
                if (x.getStatusID().equals("SANSANG")) {
                    JOptionPane.showMessageDialog(pnContainer, "Không thể xoá vì món ăn đang bán");
                    return;
                }
                listID += x.getId() + ", ";
            }
        }
        if (listID.isEmpty()) {
            JOptionPane.showMessageDialog(pnContainer, "Bạn vui lòng chọn Món Ăn cần xoá");
            return;
        }
        listID = listID.substring(0, listID.length() - 2);
        int choice = JOptionPane.showConfirmDialog(pnContainer, "Bạn có chắc chắn xóa không ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (choice == 0) {
            if (menuItemBUS.deleteData(listID)) {
                JOptionPane.showMessageDialog(pnContainer, "Xóa thành công");
                listItem = menuItemBUS.getAllData();
//                render(false);
            }
            else {
                JOptionPane.showMessageDialog(pnContainer, "Xóa thất bại");
            }
        }
        render(false, false);
        cntRowSelected = 0;
      
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (cntRowSelected > 1) {
            JOptionPane.showMessageDialog(pnContainer, "Chỉ sửa được 1 bàn. Vui lòng thao tác lại");
        }
        else {
            MenuItemDTO itemSelected = new MenuItemDTO();
            for (MenuItemDTO x : listItem) {
                if (x.isIsSelected()) {
                    itemSelected = x;
                    break;
                }
            }
            DialogMonAn x = new DialogMonAn(null, true);
            x.isUpdate(true);
            x.setItem(itemSelected);
            x.setVisible(true);
            System.out.println(itemSelected.getId());
        }
        render(false, false);
        cntRowSelected = 0;
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        DialogMonAn x = new DialogMonAn(null, true);
        x.isUpdate(false);
        x.setVisible(true);
        render(false, false);

    }//GEN-LAST:event_btnThemActionPerformed

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemCaretUpdate
        txtTimKiem.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);
        TableRowSorter tableRowSorter = new TableRowSorter(tbMonAn.getModel());
        String find = txtTimKiem.getText().trim();
        if (!find.isEmpty()) {
//          Indices 2 => Sort theo cột 2 (Name)
            tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + find, 2));
        }
        tbMonAn.setRowSorter(tableRowSorter);
    }//GEN-LAST:event_txtTimKiemCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JCheckBox chbSelectAll;
    private javax.swing.JScrollPane jScrollPane2;
    private GUI.Comp.Swing.PanelBackground panelBackground1;
    private GUI.Comp.Swing.PanelBackground panelBackground10;
    private GUI.Comp.Swing.PanelBackground panelBackground14;
    private GUI.Comp.Swing.PanelBackground panelBackground16;
    private GUI.Comp.Swing.PanelBackground panelBackground17;
    private GUI.Comp.Swing.PanelBackground panelBackground2;
    private GUI.Comp.Swing.PanelBackground panelBackground3;
    private GUI.Comp.Swing.PanelBackground panelBackground4;
    private GUI.Comp.Swing.PanelBackground panelBackground5;
    private GUI.Comp.Swing.PanelBackground panelBackground6;
    private GUI.Comp.Swing.PanelBackground panelBackground7;
    private GUI.Comp.Swing.PanelBackground panelBackground8;
    private GUI.Comp.Swing.PanelBackground panelBackground9;
    private GUI.Comp.Swing.PanelBackground pnContainer;
    private GUI.Comp.Swing.PanelBackground pnSelectAll;
    private javax.swing.JTable tbMonAn;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
