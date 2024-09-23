package GUI.Comp.Dialog;

import BUS.TableBUS;
import BUS.TableStatusBUS;
import DTO.TableDTO;
import DTO.TableStatusDTO;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;


public class DialogActionTable extends javax.swing.JDialog {
    private TableDTO table = new TableDTO();
    private TableBUS tableBUS  = new TableBUS();
    private boolean isUpdate;
    private ArrayList<TableStatusDTO> listStatus;
    
    public DialogActionTable(java.awt.Frame parent, boolean modal, boolean enable) {
        
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
       
        cbxTrangThai.setEnabled(enable);
        initCombobox();
        
        // Set visible phai de cuoi cung

    }
    
    public void initCombobox() {
        listStatus = new TableStatusBUS().getAll();
        for (TableStatusDTO x : listStatus) {
            cbxTrangThai.addItem(x.getName());
        }
        
    }
    
    public void setAction(boolean isUpdate) {
        this.isUpdate = isUpdate;
        if (isUpdate) {
            jLabel5.setText("SỦA THÔNG TIN BÀN");
            btnThem.setText("SỬA");
            txtIDTable.setText(table.getId() + "");
            txtNameTable.setText(table.getName());
            txtNameTable.setEnabled(false);
            
        }
        else {
             txtIDTable.setText(table.createID() + "");
        }
        
    }
    
//    public void setIDTable(long id, boolean isUpdate) {
//        if (isUpdate) {
//            table = tableBUS.findTableByID(id);
//            
//        }
//        txtIDTable.setText(id + "");
//        setVisible(true);
//    }

    public void setTable(TableDTO table) {
        this.table = table;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackground2 = new GUI.Comp.Swing.PanelBackground();
        panelBackground3 = new GUI.Comp.Swing.PanelBackground();
        panelBackground4 = new GUI.Comp.Swing.PanelBackground();
        panelBackground5 = new GUI.Comp.Swing.PanelBackground();
        panelBackground6 = new GUI.Comp.Swing.PanelBackground();
        pnCenter = new GUI.Comp.Swing.PanelBackground();
        jLabel5 = new javax.swing.JLabel();
        panelBackground7 = new GUI.Comp.Swing.PanelBackground();
        jLabel6 = new javax.swing.JLabel();
        panelBackground10 = new GUI.Comp.Swing.PanelBackground();
        panelBackground11 = new GUI.Comp.Swing.PanelBackground();
        panelBackground12 = new GUI.Comp.Swing.PanelBackground();
        txtIDTable = new javax.swing.JTextField();
        panelBackground13 = new GUI.Comp.Swing.PanelBackground();
        jLabel7 = new javax.swing.JLabel();
        panelBackground14 = new GUI.Comp.Swing.PanelBackground();
        panelBackground15 = new GUI.Comp.Swing.PanelBackground();
        panelBackground16 = new GUI.Comp.Swing.PanelBackground();
        txtNameTable = new javax.swing.JTextField();
        panelBackground21 = new GUI.Comp.Swing.PanelBackground();
        jLabel9 = new javax.swing.JLabel();
        panelBackground22 = new GUI.Comp.Swing.PanelBackground();
        panelBackground23 = new GUI.Comp.Swing.PanelBackground();
        panelBackground24 = new GUI.Comp.Swing.PanelBackground();
        cbxTrangThai = new javax.swing.JComboBox<>();
        panelBackground25 = new GUI.Comp.Swing.PanelBackground();
        btnThem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelBackground2.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground2.setLayout(new java.awt.BorderLayout());

        panelBackground3.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground3.setPreferredSize(new java.awt.Dimension(15, 288));

        javax.swing.GroupLayout panelBackground3Layout = new javax.swing.GroupLayout(panelBackground3);
        panelBackground3.setLayout(panelBackground3Layout);
        panelBackground3Layout.setHorizontalGroup(
            panelBackground3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground3Layout.setVerticalGroup(
            panelBackground3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 373, Short.MAX_VALUE)
        );

        panelBackground2.add(panelBackground3, java.awt.BorderLayout.LINE_START);

        panelBackground4.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground4.setPreferredSize(new java.awt.Dimension(15, 288));

        javax.swing.GroupLayout panelBackground4Layout = new javax.swing.GroupLayout(panelBackground4);
        panelBackground4.setLayout(panelBackground4Layout);
        panelBackground4Layout.setHorizontalGroup(
            panelBackground4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground4Layout.setVerticalGroup(
            panelBackground4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 373, Short.MAX_VALUE)
        );

        panelBackground2.add(panelBackground4, java.awt.BorderLayout.LINE_END);

        panelBackground5.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground5.setPreferredSize(new java.awt.Dimension(358, 15));

        javax.swing.GroupLayout panelBackground5Layout = new javax.swing.GroupLayout(panelBackground5);
        panelBackground5.setLayout(panelBackground5Layout);
        panelBackground5Layout.setHorizontalGroup(
            panelBackground5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 358, Short.MAX_VALUE)
        );
        panelBackground5Layout.setVerticalGroup(
            panelBackground5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelBackground2.add(panelBackground5, java.awt.BorderLayout.PAGE_END);

        panelBackground6.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground6.setPreferredSize(new java.awt.Dimension(358, 15));

        javax.swing.GroupLayout panelBackground6Layout = new javax.swing.GroupLayout(panelBackground6);
        panelBackground6.setLayout(panelBackground6Layout);
        panelBackground6Layout.setHorizontalGroup(
            panelBackground6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 358, Short.MAX_VALUE)
        );
        panelBackground6Layout.setVerticalGroup(
            panelBackground6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelBackground2.add(panelBackground6, java.awt.BorderLayout.PAGE_START);

        pnCenter.setBackground(new java.awt.Color(35, 35, 35));
        pnCenter.setLayout(new java.awt.GridLayout(6, 1));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("THÊM BÀN");
        pnCenter.add(jLabel5);

        panelBackground7.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground7.setLayout(new java.awt.BorderLayout(15, 0));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ID Bàn");
        jLabel6.setPreferredSize(new java.awt.Dimension(65, 17));
        panelBackground7.add(jLabel6, java.awt.BorderLayout.LINE_START);

        panelBackground10.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground10.setPreferredSize(new java.awt.Dimension(328, 15));

        javax.swing.GroupLayout panelBackground10Layout = new javax.swing.GroupLayout(panelBackground10);
        panelBackground10.setLayout(panelBackground10Layout);
        panelBackground10Layout.setHorizontalGroup(
            panelBackground10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );
        panelBackground10Layout.setVerticalGroup(
            panelBackground10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelBackground7.add(panelBackground10, java.awt.BorderLayout.PAGE_END);

        panelBackground11.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground11.setPreferredSize(new java.awt.Dimension(328, 15));

        javax.swing.GroupLayout panelBackground11Layout = new javax.swing.GroupLayout(panelBackground11);
        panelBackground11.setLayout(panelBackground11Layout);
        panelBackground11Layout.setHorizontalGroup(
            panelBackground11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );
        panelBackground11Layout.setVerticalGroup(
            panelBackground11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelBackground7.add(panelBackground11, java.awt.BorderLayout.PAGE_START);

        panelBackground12.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground12.setPreferredSize(new java.awt.Dimension(15, 188));

        javax.swing.GroupLayout panelBackground12Layout = new javax.swing.GroupLayout(panelBackground12);
        panelBackground12.setLayout(panelBackground12Layout);
        panelBackground12Layout.setHorizontalGroup(
            panelBackground12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground12Layout.setVerticalGroup(
            panelBackground12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        panelBackground7.add(panelBackground12, java.awt.BorderLayout.LINE_END);

        txtIDTable.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtIDTable.setForeground(new java.awt.Color(255, 255, 255));
        txtIDTable.setEnabled(false);
        panelBackground7.add(txtIDTable, java.awt.BorderLayout.CENTER);

        pnCenter.add(panelBackground7);

        panelBackground13.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground13.setLayout(new java.awt.BorderLayout(15, 0));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tên bàn");
        jLabel7.setPreferredSize(new java.awt.Dimension(65, 17));
        panelBackground13.add(jLabel7, java.awt.BorderLayout.LINE_START);

        panelBackground14.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground14.setPreferredSize(new java.awt.Dimension(328, 15));

        javax.swing.GroupLayout panelBackground14Layout = new javax.swing.GroupLayout(panelBackground14);
        panelBackground14.setLayout(panelBackground14Layout);
        panelBackground14Layout.setHorizontalGroup(
            panelBackground14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelBackground14Layout.setVerticalGroup(
            panelBackground14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelBackground13.add(panelBackground14, java.awt.BorderLayout.PAGE_END);

        panelBackground15.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground15.setPreferredSize(new java.awt.Dimension(328, 15));

        javax.swing.GroupLayout panelBackground15Layout = new javax.swing.GroupLayout(panelBackground15);
        panelBackground15.setLayout(panelBackground15Layout);
        panelBackground15Layout.setHorizontalGroup(
            panelBackground15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelBackground15Layout.setVerticalGroup(
            panelBackground15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelBackground13.add(panelBackground15, java.awt.BorderLayout.PAGE_START);

        panelBackground16.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground16.setPreferredSize(new java.awt.Dimension(15, 188));

        javax.swing.GroupLayout panelBackground16Layout = new javax.swing.GroupLayout(panelBackground16);
        panelBackground16.setLayout(panelBackground16Layout);
        panelBackground16Layout.setHorizontalGroup(
            panelBackground16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelBackground16Layout.setVerticalGroup(
            panelBackground16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelBackground13.add(panelBackground16, java.awt.BorderLayout.LINE_END);

        txtNameTable.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtNameTable.setForeground(new java.awt.Color(255, 255, 255));
        txtNameTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameTableActionPerformed(evt);
            }
        });
        panelBackground13.add(txtNameTable, java.awt.BorderLayout.CENTER);

        pnCenter.add(panelBackground13);

        panelBackground21.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground21.setLayout(new java.awt.BorderLayout(15, 0));

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Trạng thái");
        panelBackground21.add(jLabel9, java.awt.BorderLayout.LINE_START);

        panelBackground22.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground22.setPreferredSize(new java.awt.Dimension(328, 15));

        javax.swing.GroupLayout panelBackground22Layout = new javax.swing.GroupLayout(panelBackground22);
        panelBackground22.setLayout(panelBackground22Layout);
        panelBackground22Layout.setHorizontalGroup(
            panelBackground22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );
        panelBackground22Layout.setVerticalGroup(
            panelBackground22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelBackground21.add(panelBackground22, java.awt.BorderLayout.PAGE_END);

        panelBackground23.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground23.setPreferredSize(new java.awt.Dimension(328, 15));

        javax.swing.GroupLayout panelBackground23Layout = new javax.swing.GroupLayout(panelBackground23);
        panelBackground23.setLayout(panelBackground23Layout);
        panelBackground23Layout.setHorizontalGroup(
            panelBackground23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );
        panelBackground23Layout.setVerticalGroup(
            panelBackground23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelBackground21.add(panelBackground23, java.awt.BorderLayout.PAGE_START);

        panelBackground24.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground24.setPreferredSize(new java.awt.Dimension(15, 188));

        javax.swing.GroupLayout panelBackground24Layout = new javax.swing.GroupLayout(panelBackground24);
        panelBackground24.setLayout(panelBackground24Layout);
        panelBackground24Layout.setHorizontalGroup(
            panelBackground24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground24Layout.setVerticalGroup(
            panelBackground24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        panelBackground21.add(panelBackground24, java.awt.BorderLayout.LINE_END);

        cbxTrangThai.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cbxTrangThai.setForeground(new java.awt.Color(255, 255, 255));
        panelBackground21.add(cbxTrangThai, java.awt.BorderLayout.CENTER);

        pnCenter.add(panelBackground21);

        panelBackground25.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground25.setMaximumSize(new java.awt.Dimension(32767, 25));
        panelBackground25.setMinimumSize(new java.awt.Dimension(0, 25));
        panelBackground25.setPreferredSize(new java.awt.Dimension(328, 25));

        javax.swing.GroupLayout panelBackground25Layout = new javax.swing.GroupLayout(panelBackground25);
        panelBackground25.setLayout(panelBackground25Layout);
        panelBackground25Layout.setHorizontalGroup(
            panelBackground25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );
        panelBackground25Layout.setVerticalGroup(
            panelBackground25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        pnCenter.add(panelBackground25);

        btnThem.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnThem.setText("THÊM");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        pnCenter.add(btnThem);

        panelBackground2.add(pnCenter, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground2, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        Date currentDate = new Date();

        table.setName(txtNameTable.getText());
       
        table.setStatusID(listStatus.get(cbxTrangThai.getSelectedIndex()).getId());
        table.setCreateTime(currentDate);
        table.setUpdateTime(currentDate);
        
        
        if (isUpdate) {
            boolean check = tableBUS.updateTable(table);
            if (check) {
                JOptionPane.showMessageDialog(rootPane, "Sửa thành công");
                this.dispose();
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "Sửa thất bại");
            }
        }
        else {
            boolean check = tableBUS.insertTable(table);
            if (check) {
                JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
                this.dispose();
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại");
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtNameTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameTableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameTableActionPerformed

 
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
            java.util.logging.Logger.getLogger(DialogActionTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogActionTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogActionTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogActionTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogActionTable dialog = new DialogActionTable(new javax.swing.JFrame(), true, false);
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
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cbxTrangThai;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private GUI.Comp.Swing.PanelBackground panelBackground10;
    private GUI.Comp.Swing.PanelBackground panelBackground11;
    private GUI.Comp.Swing.PanelBackground panelBackground12;
    private GUI.Comp.Swing.PanelBackground panelBackground13;
    private GUI.Comp.Swing.PanelBackground panelBackground14;
    private GUI.Comp.Swing.PanelBackground panelBackground15;
    private GUI.Comp.Swing.PanelBackground panelBackground16;
    private GUI.Comp.Swing.PanelBackground panelBackground2;
    private GUI.Comp.Swing.PanelBackground panelBackground21;
    private GUI.Comp.Swing.PanelBackground panelBackground22;
    private GUI.Comp.Swing.PanelBackground panelBackground23;
    private GUI.Comp.Swing.PanelBackground panelBackground24;
    private GUI.Comp.Swing.PanelBackground panelBackground25;
    private GUI.Comp.Swing.PanelBackground panelBackground3;
    private GUI.Comp.Swing.PanelBackground panelBackground4;
    private GUI.Comp.Swing.PanelBackground panelBackground5;
    private GUI.Comp.Swing.PanelBackground panelBackground6;
    private GUI.Comp.Swing.PanelBackground panelBackground7;
    private GUI.Comp.Swing.PanelBackground pnCenter;
    private javax.swing.JTextField txtIDTable;
    private javax.swing.JTextField txtNameTable;
    // End of variables declaration//GEN-END:variables
}
