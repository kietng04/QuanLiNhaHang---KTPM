/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Comp.Panel;

import BUS.OrderBUS;
import BUS.TableBUS;
import DTO.OrderDTO;
import BUS.InvoicesBUS;
import DTO.InvoicesDTO;
import DTO.StaffDTO;
import DTO.TableDTO;
import GUI.Comp.DateChooser.SelectedDate;
import GUI.Comp.Dialog.DialogChiTietHoaDon;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import Helper.Format;

/**
 *
 * @author pc
 */
public class QuanLiHoaDon extends javax.swing.JPanel {
    private List<InvoicesDTO> listInvoice = new ArrayList<>();
    private InvoicesBUS invoicesBUS = new InvoicesBUS();
    private TableBUS tableBUS = new TableBUS();
    private String listInvoiceIDSelected = "";
    private DefaultTableModel model;
    private int cntOrderSelected;
    private String customerCode;
    private boolean isSelectAll = false;

    public QuanLiHoaDon() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        tbInvoice.setRowHeight(35);

        // header table nam ben trai
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tbInvoice.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.LEFT);
        txtTimKiem.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nhập mã khách hàng");
        txtTimKiem.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);
        txtDate.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Chọn ngày cần tìm");
        txtDate.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);
        render(isSelectAll);

        tbInvoice.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getColumn() == 0) { // Check if the event is from the first column
                    
                    int row = tbInvoice.getSelectedRow();
                    int row1 = e.getFirstRow();

                    listInvoice.get(row1).setIsSelected((boolean)tbInvoice.getValueAt(row, 0));
                    if (listInvoice.get(row).isIsSelected()) {
                        cntOrderSelected++;
                        customerCode = listInvoice.get(row).getOrderDTO().getCustomerCode();
                    }
                    else {
                        cntOrderSelected--;
                        customerCode = "";
                    }
//                    System.out.println(customerCode);
                    

                }
            }
        });
        
        if (!StaffDTO.staffLogging.getRoleId().equals("STAFF")) {
            btnXoa.setEnabled(true);
            
        }

    }

    public void render(boolean isSelectAll) {
        listInvoice = invoicesBUS.getInvoice();
        // listOrder = orderBUS.getAllOrder();
        model = (DefaultTableModel) tbInvoice.getModel();
        model.setRowCount(0);
        for (InvoicesDTO i : listInvoice) {
            i.setIsSelected(isSelectAll);

            model.addRow(new Object[] { i.isIsSelected(), i.getId(), i.getOrderDTO().getCustomerCode(), Format.formatNumber.format(i.getAmount()),
                    Format.formatNumber.format(i.getDiscount()), Format.formatNumber.format(i.getTotal()),
                    Format.formatDate.format(i.getCreateTime()) });
        }
        model.fireTableDataChanged();
        tbInvoice.setModel(model);
    }

    public void getOrderIDSelected() {
        listInvoiceIDSelected = "";
        for (InvoicesDTO x : listInvoice) {
            if (x.isIsSelected()) {
                listInvoiceIDSelected += x.getId() + ", ";
            }
        }
        if (!listInvoiceIDSelected.isEmpty()) {
            listInvoiceIDSelected = listInvoiceIDSelected.substring(0, listInvoiceIDSelected.length() - 2);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser = new GUI.Comp.DateChooser.DateChooser();
        pnContainer = new GUI.Comp.Swing.PanelBackground();
        panelBackground1 = new GUI.Comp.Swing.PanelBackground();
        panelBackground10 = new GUI.Comp.Swing.PanelBackground();
        panelBackground16 = new GUI.Comp.Swing.PanelBackground();
        panelBackground17 = new GUI.Comp.Swing.PanelBackground();
        pnSelectAll = new GUI.Comp.Swing.PanelBackground();
        chbSelectAll = new javax.swing.JCheckBox();
        panelBackground18 = new GUI.Comp.Swing.PanelBackground();
        txtTimKiem = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txtDate = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        panelBackground15 = new GUI.Comp.Swing.PanelBackground();
        panelBackground14 = new GUI.Comp.Swing.PanelBackground();
        panelBackground7 = new GUI.Comp.Swing.PanelBackground();
        panelBackground6 = new GUI.Comp.Swing.PanelBackground();
        panelBackground9 = new GUI.Comp.Swing.PanelBackground();
        panelBackground8 = new GUI.Comp.Swing.PanelBackground();
        btnXoa = new javax.swing.JButton();
        btnChiTiet = new javax.swing.JButton();
        panelBackground2 = new GUI.Comp.Swing.PanelBackground();
        panelBackground3 = new GUI.Comp.Swing.PanelBackground();
        panelBackground4 = new GUI.Comp.Swing.PanelBackground();
        panelBackground5 = new GUI.Comp.Swing.PanelBackground();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbInvoice = new javax.swing.JTable();

        dateChooser.setTextRefernce(txtDate);

        setPreferredSize(new java.awt.Dimension(1077, 730));

        pnContainer.setBackground(new java.awt.Color(30, 30, 30));
        pnContainer.setLayout(new java.awt.BorderLayout());

        panelBackground1.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground1.setPreferredSize(new java.awt.Dimension(1077, 75));
        panelBackground1.setLayout(new java.awt.BorderLayout(60, 0));

        panelBackground10.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground10.setPreferredSize(new java.awt.Dimension(650, 75));
        panelBackground10.setLayout(new javax.swing.BoxLayout(panelBackground10, javax.swing.BoxLayout.LINE_AXIS));

        panelBackground16.setBackground(new java.awt.Color(30, 30, 30));

        javax.swing.GroupLayout panelBackground16Layout = new javax.swing.GroupLayout(panelBackground16);
        panelBackground16.setLayout(panelBackground16Layout);
        panelBackground16Layout.setHorizontalGroup(
            panelBackground16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelBackground16Layout.setVerticalGroup(
            panelBackground16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        panelBackground10.add(panelBackground16);

        panelBackground17.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground17.setPreferredSize(new java.awt.Dimension(25, 75));

        javax.swing.GroupLayout panelBackground17Layout = new javax.swing.GroupLayout(panelBackground17);
        panelBackground17.setLayout(panelBackground17Layout);
        panelBackground17Layout.setHorizontalGroup(
            panelBackground17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        panelBackground17Layout.setVerticalGroup(
            panelBackground17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        panelBackground10.add(panelBackground17);

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

        panelBackground18.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground18.setPreferredSize(new java.awt.Dimension(30, 75));

        javax.swing.GroupLayout panelBackground18Layout = new javax.swing.GroupLayout(panelBackground18);
        panelBackground18.setLayout(panelBackground18Layout);
        panelBackground18Layout.setHorizontalGroup(
            panelBackground18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );
        panelBackground18Layout.setVerticalGroup(
            panelBackground18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        panelBackground10.add(panelBackground18);

        txtTimKiem.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtTimKiem.setMaximumSize(new java.awt.Dimension(200, 30));
        txtTimKiem.setPreferredSize(new java.awt.Dimension(250, 30));
        txtTimKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemCaretUpdate(evt);
            }
        });
        panelBackground10.add(txtTimKiem);

        jPanel2.setPreferredSize(new java.awt.Dimension(20, 75));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        panelBackground10.add(jPanel2);

        txtDate.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtDate.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        txtDate.setPreferredSize(new java.awt.Dimension(150, 30));
        txtDate.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtDateCaretUpdate(evt);
            }
        });
        panelBackground10.add(txtDate);

        jPanel1.setPreferredSize(new java.awt.Dimension(10, 75));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        panelBackground10.add(jPanel1);

        jButton1.setText("Hôm nay");
        jButton1.setMaximumSize(new java.awt.Dimension(75, 30));
        jButton1.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelBackground10.add(jButton1);

        panelBackground1.add(panelBackground10, java.awt.BorderLayout.LINE_START);

        panelBackground15.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground15.setPreferredSize(new java.awt.Dimension(200, 75));
        panelBackground15.setLayout(new javax.swing.BoxLayout(panelBackground15, javax.swing.BoxLayout.LINE_AXIS));
        panelBackground1.add(panelBackground15, java.awt.BorderLayout.CENTER);

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

        btnChiTiet.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnChiTiet.setText("Chi Tiết");
        btnChiTiet.setMaximumSize(new java.awt.Dimension(72, 35));
        btnChiTiet.setPreferredSize(new java.awt.Dimension(72, 30));
        btnChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietActionPerformed(evt);
            }
        });
        panelBackground8.add(btnChiTiet);

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
            .addGap(0, 1250, Short.MAX_VALUE)
        );
        panelBackground4Layout.setVerticalGroup(
            panelBackground4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        pnContainer.add(panelBackground4, java.awt.BorderLayout.PAGE_END);

        panelBackground5.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground5.setLayout(new java.awt.BorderLayout());

        tbInvoice.setAutoCreateRowSorter(true);
        tbInvoice.setBackground(new java.awt.Color(35, 35, 35));
        tbInvoice.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        tbInvoice.setForeground(new java.awt.Color(255, 255, 255));
        tbInvoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "aaaaaaaaaa", null, "ádasdasd", null, null, "aaaaaaaaaa"},
                {null, "aaaaaaaaaa", null, "ádasd", null, null, "aaaaaaaaaa"},
                {null, "aaaaaaaaaa", null, "ádasd", null, null, "aaaaaaaaaa"},
                {null, "aaaaaaaaaa", null, "ádasda", null, null, "aaaaaaaaaa"}
            },
            new String [] {
                "", "Mã hoá đơn", "Mã khách hàng", "Thành tiền", "Giảm giá", "Tổng tiền", "Thời gian in"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbInvoice.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbInvoice.getTableHeader().setResizingAllowed(false);
        tbInvoice.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbInvoice);
        if (tbInvoice.getColumnModel().getColumnCount() > 0) {
            tbInvoice.getColumnModel().getColumn(0).setPreferredWidth(20);
            tbInvoice.getColumnModel().getColumn(0).setMaxWidth(20);
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
            .addComponent(pnContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXoaActionPerformed
        getOrderIDSelected();
        if (!listInvoiceIDSelected.isEmpty()) {
            int choice = JOptionPane.showConfirmDialog(pnContainer, "Bạn có chắc chắn xóa không ?", "Xác nhận",
                    JOptionPane.YES_NO_OPTION);
            if (choice == 0) {
                boolean isDeleted = invoicesBUS.deleteInvoices(listInvoiceIDSelected);
                if (isDeleted) {
                    JOptionPane.showMessageDialog(pnContainer, "Xóa thành công");
                }
            } else {
                JOptionPane.showMessageDialog(pnContainer, "Xóa thất bại");
            }
            render(false);
        } else {
            JOptionPane.showMessageDialog(pnContainer, "Bạn chưa chọn hoá đơn", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }// GEN-LAST:event_btnXoaActionPerformed

    private void btnChiTietActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnChiTietActionPerformed
        getOrderIDSelected();
        if (!listInvoiceIDSelected.isEmpty()) {
            long invoiceID = Long.parseLong(listInvoiceIDSelected);
            ArrayList<OrderDTO> orderDTO = new OrderBUS().findOrderByCustomerCode(customerCode);
        
            TableDTO table = tableBUS.findTableByID(orderDTO.get(0).getTableID());
            DialogChiTietHoaDon x = new DialogChiTietHoaDon(null, true);
            x.loadForm(invoiceID, table);
            x.setVisible(true);
            render(false);
        } else {
            JOptionPane.showMessageDialog(pnContainer, "Bạn chưa chọn hoá đơn", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

    }// GEN-LAST:event_btnChiTietActionPerformed

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {// GEN-FIRST:event_txtTimKiemCaretUpdate
        txtTimKiem.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);
        TableRowSorter tableRowSorter = new TableRowSorter(tbInvoice.getModel());
        String find = txtTimKiem.getText().trim();
        
        if (!find.isEmpty()) {
            // Indices 2 => Sort theo cột 2 (Name), 3 (CustomerCode)
            tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+ find, 2));
        }
        tbInvoice.setRowSorter(tableRowSorter);
    }// GEN-LAST:event_txtTimKiemCaretUpdate

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        dateChooser.toDay();
    }// GEN-LAST:event_jButton1ActionPerformed

    private void txtDateCaretUpdate(javax.swing.event.CaretEvent evt) {// GEN-FIRST:event_txtDateCaretUpdate
        TableRowSorter tableRowSorter = new TableRowSorter(tbInvoice.getModel());
        SelectedDate selectedDate = dateChooser.getSelectedDate();
        int day = selectedDate.getDay();
        int month = selectedDate.getMonth();
        int year = selectedDate.getYear();
        String dateString = String.format("%02d/%02d/%d", day, month, year);
        if (!txtDate.getText().isEmpty()) {
            tableRowSorter.setRowFilter(RowFilter.regexFilter(dateString, 6));

        }
        tbInvoice.setRowSorter(tableRowSorter);

    }// GEN-LAST:event_txtDateCaretUpdate

    private void chbSelectAllActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_chbSelectAllActionPerformed
        isSelectAll = !isSelectAll;
        render(isSelectAll);
    }// GEN-LAST:event_chbSelectAllActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChiTiet;
    private javax.swing.JButton btnXoa;
    private javax.swing.JCheckBox chbSelectAll;
    private GUI.Comp.DateChooser.DateChooser dateChooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private GUI.Comp.Swing.PanelBackground panelBackground1;
    private GUI.Comp.Swing.PanelBackground panelBackground10;
    private GUI.Comp.Swing.PanelBackground panelBackground14;
    private GUI.Comp.Swing.PanelBackground panelBackground15;
    private GUI.Comp.Swing.PanelBackground panelBackground16;
    private GUI.Comp.Swing.PanelBackground panelBackground17;
    private GUI.Comp.Swing.PanelBackground panelBackground18;
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
    private javax.swing.JTable tbInvoice;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
