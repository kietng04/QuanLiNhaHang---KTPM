/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.Comp.Dialog;

import BUS.DetailImportBillBUS;
import BUS.IngredientsBUS;
import BUS.StaffBUS;
import BUS.SupplierBUS;
import DTO.DetailImportBillDTO;
import DTO.ImportBillDTO;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import Helper.Format;

/**
 *
 * @author pc
 */
public class DialogDetailsImportBill extends javax.swing.JDialog {

    private ArrayList<DetailImportBillDTO> detailsImportList = new ArrayList<>();
    private DetailImportBillBUS importBillBUS = new DetailImportBillBUS();
    private IngredientsBUS ingredientsBUS = new IngredientsBUS();
    private DefaultTableModel model = new DefaultTableModel();
    private ImportBillDTO importBill = new ImportBillDTO();
    private SupplierBUS supplierBUS = new SupplierBUS();
    private StaffBUS staffBUS = new StaffBUS();
    
    public DialogDetailsImportBill(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        tbDetails.setRowHeight(35);
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tbDetails.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.LEFT);
    }

    public void setImportBill(ImportBillDTO importBill) {
        this.importBill = importBill;
        render();
    }
    
    public void render() {
        model = (DefaultTableModel)tbDetails.getModel();
        model.setRowCount(0);
        
        detailsImportList = importBillBUS.getDetailImportBillByBillId(importBill.getId());
        for (DetailImportBillDTO x : detailsImportList) {
            model.addRow(new Object[] {x.getId(), ingredientsBUS.getIngredientById(x.getIngredientid()).getName(), x.getPrice(), x.getQuantity()});
        }
        model.fireTableDataChanged();
        tbDetails.setModel(model);
        
        lbNcc.setText(supplierBUS.getSupplierById(importBill.getSupplierID()).getName());
        lbTenNV.setText(staffBUS.getStaffById(importBill.getUserId()).getLast_name() + " " + staffBUS.getStaffById(importBill.getUserId()).getFirst_name());
        lbNgayNhap.setText(Format.formatDate.format(importBill.getImport_date()));
        lbSoLuong.setText(importBill.getQuantity() + "");
        lbTongTien.setText(importBill.getTotal() + "");
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackground1 = new GUI.Comp.Swing.PanelBackground();
        panelBackground2 = new GUI.Comp.Swing.PanelBackground();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnDong = new javax.swing.JButton();
        lbNcc = new javax.swing.JLabel();
        lbTenNV = new javax.swing.JLabel();
        lbNgayNhap = new javax.swing.JLabel();
        lbSoLuong = new javax.swing.JLabel();
        lbTongTien = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDetails = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(35, 35, 35));

        panelBackground1.setBackground(new java.awt.Color(30, 30, 30));

        panelBackground2.setBackground(new java.awt.Color(35, 35, 35));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tên nhà cung cấp");

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tên nhân viên");

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Số lượng chi tiết");

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tổng tiền");

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Ngày nhập");

        btnDong.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnDong.setText("Đóng");
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        lbNcc.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbNcc.setForeground(new java.awt.Color(255, 255, 255));
        lbNcc.setText("Tên nhà cung cấp");

        lbTenNV.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbTenNV.setForeground(new java.awt.Color(255, 255, 255));
        lbTenNV.setText("Tên nhà cung cấp");

        lbNgayNhap.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbNgayNhap.setForeground(new java.awt.Color(255, 255, 255));
        lbNgayNhap.setText("Tên nhà cung cấp");

        lbSoLuong.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbSoLuong.setForeground(new java.awt.Color(255, 255, 255));
        lbSoLuong.setText("Tên nhà cung cấp");

        lbTongTien.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbTongTien.setForeground(new java.awt.Color(255, 255, 255));
        lbTongTien.setText("Tên nhà cung cấp");

        javax.swing.GroupLayout panelBackground2Layout = new javax.swing.GroupLayout(panelBackground2);
        panelBackground2.setLayout(panelBackground2Layout);
        panelBackground2Layout.setHorizontalGroup(
            panelBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDong, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBackground2Layout.createSequentialGroup()
                        .addGroup(panelBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(27, 27, 27)
                        .addGroup(panelBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTongTien)
                            .addComponent(lbSoLuong)
                            .addComponent(lbNgayNhap)
                            .addComponent(lbTenNV)
                            .addComponent(lbNcc))))
                .addGap(30, 30, 30))
        );
        panelBackground2Layout.setVerticalGroup(
            panelBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbNcc))
                .addGap(40, 40, 40)
                .addGroup(panelBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbTenNV))
                .addGap(40, 40, 40)
                .addGroup(panelBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbNgayNhap))
                .addGap(40, 40, 40)
                .addGroup(panelBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbSoLuong))
                .addGap(40, 40, 40)
                .addGroup(panelBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbTongTien))
                .addGap(40, 40, 40)
                .addComponent(btnDong, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        tbDetails.setBackground(new java.awt.Color(35, 35, 35));
        tbDetails.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        tbDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã chi tiết", "Tên nguyên liệu", "Giá nhập", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbDetails);

        javax.swing.GroupLayout panelBackground1Layout = new javax.swing.GroupLayout(panelBackground1);
        panelBackground1.setLayout(panelBackground1Layout);
        panelBackground1Layout.setHorizontalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(panelBackground2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBackground1Layout.setVerticalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelBackground2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        dispose();
    }//GEN-LAST:event_btnDongActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DialogDetailsImportBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogDetailsImportBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogDetailsImportBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogDetailsImportBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogDetailsImportBill dialog = new DialogDetailsImportBill(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbNcc;
    private javax.swing.JLabel lbNgayNhap;
    private javax.swing.JLabel lbSoLuong;
    private javax.swing.JLabel lbTenNV;
    private javax.swing.JLabel lbTongTien;
    private GUI.Comp.Swing.PanelBackground panelBackground1;
    private GUI.Comp.Swing.PanelBackground panelBackground2;
    private javax.swing.JTable tbDetails;
    // End of variables declaration//GEN-END:variables
}
