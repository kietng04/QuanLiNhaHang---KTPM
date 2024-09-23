/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.Comp.Dialog;

import BUS.DetailOrderBUS;
import BUS.DetailsReciptBUS;
import BUS.IngredientsBUS;
import BUS.OrderBUS;
import DTO.DetailOrderDTO;
import DTO.DetailsRecipeDTO;
import DTO.IngredientsDTO;
import DTO.OrderDTO;
import DTO.StaffDTO;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc
 */
public class DetailsOrder extends javax.swing.JDialog {
    private DefaultTableModel model;
    private long orderID;
    private DetailOrderBUS detailOrderBUS  = new DetailOrderBUS();
    private OrderBUS orderBUS = new OrderBUS();
    private ArrayList<DetailOrderDTO> listDetailsOrder;
    private int row;
    private boolean isValid = true;
    private int distance = 0;
    
    public DetailsOrder(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        tbMonAn.setRowHeight(25);
        // header table nam ben trai
        DefaultTableCellRenderer  renderer = (DefaultTableCellRenderer) tbMonAn.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.LEFT);
        
        
        if (!StaffDTO.staffLogging.getRoleId().equals("STAFF")) {
            btnXoa.setEnabled(true);
            btnCapNhat.setEnabled(true);
            btnLuu.setEnabled(true);
        }
    }

    // true => lấy data từ db lên
    // false => lấy data hiện đang có trong listDetailsOrder
    public void render(boolean getFormDB) {
        model = (DefaultTableModel)tbMonAn.getModel();
        model.setRowCount(0);
        if (getFormDB) {
            listDetailsOrder = detailOrderBUS.findDetailByOrder(orderID);
        }
        for (DetailOrderDTO x : listDetailsOrder) {
            if (!x.isIsDelete()) {
                model.addRow(new Object[] {x.getId(), x.getName(), x.getQuantity(), Helper.Format.formatNumber.format(x.getTotal())});
            }
        }
    }
    
    public void insertOrderID(long orderID) {
        this.orderID = orderID;
    }
    
    public void refresh() {
         txtIDMonAn.setText("");
        txtTenMon.setText("");
        txtSoLuong.setText("");
        lbThanhTien.setText("0");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnContainer = new GUI.Comp.Swing.PanelBackground();
        panelBackground2 = new GUI.Comp.Swing.PanelBackground();
        panelBackground3 = new GUI.Comp.Swing.PanelBackground();
        panelBackground4 = new GUI.Comp.Swing.PanelBackground();
        panelBackground5 = new GUI.Comp.Swing.PanelBackground();
        panelBackground6 = new GUI.Comp.Swing.PanelBackground();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMonAn = new javax.swing.JTable();
        panelBackground7 = new GUI.Comp.Swing.PanelBackground();
        panelBackground8 = new GUI.Comp.Swing.PanelBackground();
        panelBackground9 = new GUI.Comp.Swing.PanelBackground();
        panelBackground10 = new GUI.Comp.Swing.PanelBackground();
        panelBackground11 = new GUI.Comp.Swing.PanelBackground();
        panelBackground12 = new GUI.Comp.Swing.PanelBackground();
        panelBackground13 = new GUI.Comp.Swing.PanelBackground();
        jLabel1 = new javax.swing.JLabel();
        txtIDMonAn = new javax.swing.JTextField();
        panelBackground14 = new GUI.Comp.Swing.PanelBackground();
        panelBackground15 = new GUI.Comp.Swing.PanelBackground();
        panelBackground16 = new GUI.Comp.Swing.PanelBackground();
        panelBackground17 = new GUI.Comp.Swing.PanelBackground();
        panelBackground18 = new GUI.Comp.Swing.PanelBackground();
        panelBackground19 = new GUI.Comp.Swing.PanelBackground();
        jLabel2 = new javax.swing.JLabel();
        txtTenMon = new javax.swing.JTextField();
        panelBackground20 = new GUI.Comp.Swing.PanelBackground();
        panelBackground21 = new GUI.Comp.Swing.PanelBackground();
        panelBackground22 = new GUI.Comp.Swing.PanelBackground();
        panelBackground23 = new GUI.Comp.Swing.PanelBackground();
        panelBackground24 = new GUI.Comp.Swing.PanelBackground();
        panelBackground25 = new GUI.Comp.Swing.PanelBackground();
        jLabel3 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        panelBackground32 = new GUI.Comp.Swing.PanelBackground();
        panelBackground33 = new GUI.Comp.Swing.PanelBackground();
        panelBackground34 = new GUI.Comp.Swing.PanelBackground();
        panelBackground35 = new GUI.Comp.Swing.PanelBackground();
        panelBackground36 = new GUI.Comp.Swing.PanelBackground();
        panelBackground37 = new GUI.Comp.Swing.PanelBackground();
        lbThanhTien = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        panelBackground38 = new GUI.Comp.Swing.PanelBackground();
        panelBackground39 = new GUI.Comp.Swing.PanelBackground();
        panelBackground40 = new GUI.Comp.Swing.PanelBackground();
        panelBackground41 = new GUI.Comp.Swing.PanelBackground();
        panelBackground42 = new GUI.Comp.Swing.PanelBackground();
        panelBackground43 = new GUI.Comp.Swing.PanelBackground();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        panelBackground26 = new GUI.Comp.Swing.PanelBackground();
        jSeparator1 = new javax.swing.JSeparator();
        panelBackground28 = new GUI.Comp.Swing.PanelBackground();
        panelBackground29 = new GUI.Comp.Swing.PanelBackground();
        panelBackground30 = new GUI.Comp.Swing.PanelBackground();
        panelBackground31 = new GUI.Comp.Swing.PanelBackground();
        panelBackground44 = new GUI.Comp.Swing.PanelBackground();
        panelBackground45 = new GUI.Comp.Swing.PanelBackground();
        btnLuu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnContainer.setBackground(new java.awt.Color(30, 30, 30));
        pnContainer.setLayout(new java.awt.BorderLayout());

        panelBackground2.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground2.setPreferredSize(new java.awt.Dimension(20, 445));

        javax.swing.GroupLayout panelBackground2Layout = new javax.swing.GroupLayout(panelBackground2);
        panelBackground2.setLayout(panelBackground2Layout);
        panelBackground2Layout.setHorizontalGroup(
            panelBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        panelBackground2Layout.setVerticalGroup(
            panelBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
        );

        pnContainer.add(panelBackground2, java.awt.BorderLayout.LINE_START);

        panelBackground3.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground3.setPreferredSize(new java.awt.Dimension(755, 20));

        javax.swing.GroupLayout panelBackground3Layout = new javax.swing.GroupLayout(panelBackground3);
        panelBackground3.setLayout(panelBackground3Layout);
        panelBackground3Layout.setHorizontalGroup(
            panelBackground3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1236, Short.MAX_VALUE)
        );
        panelBackground3Layout.setVerticalGroup(
            panelBackground3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        pnContainer.add(panelBackground3, java.awt.BorderLayout.PAGE_END);

        panelBackground4.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground4.setPreferredSize(new java.awt.Dimension(20, 525));

        javax.swing.GroupLayout panelBackground4Layout = new javax.swing.GroupLayout(panelBackground4);
        panelBackground4.setLayout(panelBackground4Layout);
        panelBackground4Layout.setHorizontalGroup(
            panelBackground4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        panelBackground4Layout.setVerticalGroup(
            panelBackground4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
        );

        pnContainer.add(panelBackground4, java.awt.BorderLayout.LINE_END);

        panelBackground5.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground5.setPreferredSize(new java.awt.Dimension(755, 20));

        javax.swing.GroupLayout panelBackground5Layout = new javax.swing.GroupLayout(panelBackground5);
        panelBackground5.setLayout(panelBackground5Layout);
        panelBackground5Layout.setHorizontalGroup(
            panelBackground5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1236, Short.MAX_VALUE)
        );
        panelBackground5Layout.setVerticalGroup(
            panelBackground5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        pnContainer.add(panelBackground5, java.awt.BorderLayout.PAGE_START);

        panelBackground6.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground6.setLayout(new java.awt.GridLayout(1, 2, 20, 0));

        tbMonAn.setBackground(new java.awt.Color(35, 35, 35));
        tbMonAn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã món ăn", "Tên món ăn", "Số lượng", "Thành tiền"
            }
        ));
        tbMonAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMonAnMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbMonAn);
        if (tbMonAn.getColumnModel().getColumnCount() > 0) {
            tbMonAn.getColumnModel().getColumn(1).setPreferredWidth(170);
            tbMonAn.getColumnModel().getColumn(1).setMaxWidth(170);
            tbMonAn.getColumnModel().getColumn(2).setPreferredWidth(80);
            tbMonAn.getColumnModel().getColumn(2).setMaxWidth(80);
        }

        panelBackground6.add(jScrollPane1);

        panelBackground7.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground7.setLayout(new java.awt.GridLayout(7, 1));

        panelBackground8.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground8.setPreferredSize(new java.awt.Dimension(499, 25));
        panelBackground8.setLayout(new java.awt.BorderLayout(15, 0));

        panelBackground9.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground9.setPreferredSize(new java.awt.Dimension(499, 15));

        javax.swing.GroupLayout panelBackground9Layout = new javax.swing.GroupLayout(panelBackground9);
        panelBackground9.setLayout(panelBackground9Layout);
        panelBackground9Layout.setHorizontalGroup(
            panelBackground9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        panelBackground9Layout.setVerticalGroup(
            panelBackground9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelBackground8.add(panelBackground9, java.awt.BorderLayout.PAGE_START);

        panelBackground10.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground10.setPreferredSize(new java.awt.Dimension(499, 15));

        javax.swing.GroupLayout panelBackground10Layout = new javax.swing.GroupLayout(panelBackground10);
        panelBackground10.setLayout(panelBackground10Layout);
        panelBackground10Layout.setHorizontalGroup(
            panelBackground10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        panelBackground10Layout.setVerticalGroup(
            panelBackground10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelBackground8.add(panelBackground10, java.awt.BorderLayout.PAGE_END);

        panelBackground11.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground11.setPreferredSize(new java.awt.Dimension(15, 42));

        javax.swing.GroupLayout panelBackground11Layout = new javax.swing.GroupLayout(panelBackground11);
        panelBackground11.setLayout(panelBackground11Layout);
        panelBackground11Layout.setHorizontalGroup(
            panelBackground11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground11Layout.setVerticalGroup(
            panelBackground11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        panelBackground8.add(panelBackground11, java.awt.BorderLayout.LINE_START);

        panelBackground12.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground12.setPreferredSize(new java.awt.Dimension(15, 42));

        javax.swing.GroupLayout panelBackground12Layout = new javax.swing.GroupLayout(panelBackground12);
        panelBackground12.setLayout(panelBackground12Layout);
        panelBackground12Layout.setHorizontalGroup(
            panelBackground12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground12Layout.setVerticalGroup(
            panelBackground12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        panelBackground8.add(panelBackground12, java.awt.BorderLayout.LINE_END);

        panelBackground13.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground13.setLayout(new java.awt.BorderLayout(15, 0));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mã món ăn");
        jLabel1.setPreferredSize(new java.awt.Dimension(100, 22));
        panelBackground13.add(jLabel1, java.awt.BorderLayout.LINE_START);

        txtIDMonAn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtIDMonAn.setEnabled(false);
        panelBackground13.add(txtIDMonAn, java.awt.BorderLayout.CENTER);

        panelBackground8.add(panelBackground13, java.awt.BorderLayout.CENTER);

        panelBackground7.add(panelBackground8);

        panelBackground14.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground14.setPreferredSize(new java.awt.Dimension(499, 25));
        panelBackground14.setLayout(new java.awt.BorderLayout(15, 0));

        panelBackground15.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground15.setPreferredSize(new java.awt.Dimension(499, 15));

        javax.swing.GroupLayout panelBackground15Layout = new javax.swing.GroupLayout(panelBackground15);
        panelBackground15.setLayout(panelBackground15Layout);
        panelBackground15Layout.setHorizontalGroup(
            panelBackground15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        panelBackground15Layout.setVerticalGroup(
            panelBackground15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelBackground14.add(panelBackground15, java.awt.BorderLayout.PAGE_START);

        panelBackground16.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground16.setPreferredSize(new java.awt.Dimension(499, 15));

        javax.swing.GroupLayout panelBackground16Layout = new javax.swing.GroupLayout(panelBackground16);
        panelBackground16.setLayout(panelBackground16Layout);
        panelBackground16Layout.setHorizontalGroup(
            panelBackground16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        panelBackground16Layout.setVerticalGroup(
            panelBackground16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelBackground14.add(panelBackground16, java.awt.BorderLayout.PAGE_END);

        panelBackground17.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground17.setPreferredSize(new java.awt.Dimension(15, 42));

        javax.swing.GroupLayout panelBackground17Layout = new javax.swing.GroupLayout(panelBackground17);
        panelBackground17.setLayout(panelBackground17Layout);
        panelBackground17Layout.setHorizontalGroup(
            panelBackground17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground17Layout.setVerticalGroup(
            panelBackground17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        panelBackground14.add(panelBackground17, java.awt.BorderLayout.LINE_START);

        panelBackground18.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground18.setPreferredSize(new java.awt.Dimension(15, 42));

        javax.swing.GroupLayout panelBackground18Layout = new javax.swing.GroupLayout(panelBackground18);
        panelBackground18.setLayout(panelBackground18Layout);
        panelBackground18Layout.setHorizontalGroup(
            panelBackground18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground18Layout.setVerticalGroup(
            panelBackground18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        panelBackground14.add(panelBackground18, java.awt.BorderLayout.LINE_END);

        panelBackground19.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground19.setLayout(new java.awt.BorderLayout(15, 0));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tên món ăn");
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 22));
        panelBackground19.add(jLabel2, java.awt.BorderLayout.LINE_START);

        txtTenMon.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtTenMon.setEnabled(false);
        panelBackground19.add(txtTenMon, java.awt.BorderLayout.CENTER);

        panelBackground14.add(panelBackground19, java.awt.BorderLayout.CENTER);

        panelBackground7.add(panelBackground14);

        panelBackground20.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground20.setPreferredSize(new java.awt.Dimension(499, 25));
        panelBackground20.setLayout(new java.awt.BorderLayout(15, 0));

        panelBackground21.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground21.setPreferredSize(new java.awt.Dimension(499, 15));

        javax.swing.GroupLayout panelBackground21Layout = new javax.swing.GroupLayout(panelBackground21);
        panelBackground21.setLayout(panelBackground21Layout);
        panelBackground21Layout.setHorizontalGroup(
            panelBackground21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        panelBackground21Layout.setVerticalGroup(
            panelBackground21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelBackground20.add(panelBackground21, java.awt.BorderLayout.PAGE_START);

        panelBackground22.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground22.setPreferredSize(new java.awt.Dimension(499, 15));

        javax.swing.GroupLayout panelBackground22Layout = new javax.swing.GroupLayout(panelBackground22);
        panelBackground22.setLayout(panelBackground22Layout);
        panelBackground22Layout.setHorizontalGroup(
            panelBackground22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        panelBackground22Layout.setVerticalGroup(
            panelBackground22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelBackground20.add(panelBackground22, java.awt.BorderLayout.PAGE_END);

        panelBackground23.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground23.setPreferredSize(new java.awt.Dimension(15, 42));

        javax.swing.GroupLayout panelBackground23Layout = new javax.swing.GroupLayout(panelBackground23);
        panelBackground23.setLayout(panelBackground23Layout);
        panelBackground23Layout.setHorizontalGroup(
            panelBackground23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground23Layout.setVerticalGroup(
            panelBackground23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        panelBackground20.add(panelBackground23, java.awt.BorderLayout.LINE_START);

        panelBackground24.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground24.setPreferredSize(new java.awt.Dimension(15, 42));

        javax.swing.GroupLayout panelBackground24Layout = new javax.swing.GroupLayout(panelBackground24);
        panelBackground24.setLayout(panelBackground24Layout);
        panelBackground24Layout.setHorizontalGroup(
            panelBackground24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground24Layout.setVerticalGroup(
            panelBackground24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        panelBackground20.add(panelBackground24, java.awt.BorderLayout.LINE_END);

        panelBackground25.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground25.setLayout(new java.awt.BorderLayout(15, 0));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Số lượng");
        jLabel3.setPreferredSize(new java.awt.Dimension(100, 22));
        panelBackground25.add(jLabel3, java.awt.BorderLayout.LINE_START);

        txtSoLuong.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtSoLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoLuongKeyReleased(evt);
            }
        });
        panelBackground25.add(txtSoLuong, java.awt.BorderLayout.CENTER);

        panelBackground20.add(panelBackground25, java.awt.BorderLayout.CENTER);

        panelBackground7.add(panelBackground20);

        panelBackground32.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground32.setPreferredSize(new java.awt.Dimension(499, 25));
        panelBackground32.setLayout(new java.awt.BorderLayout(15, 0));

        panelBackground33.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground33.setPreferredSize(new java.awt.Dimension(499, 15));

        javax.swing.GroupLayout panelBackground33Layout = new javax.swing.GroupLayout(panelBackground33);
        panelBackground33.setLayout(panelBackground33Layout);
        panelBackground33Layout.setHorizontalGroup(
            panelBackground33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        panelBackground33Layout.setVerticalGroup(
            panelBackground33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelBackground32.add(panelBackground33, java.awt.BorderLayout.PAGE_START);

        panelBackground34.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground34.setPreferredSize(new java.awt.Dimension(499, 15));

        javax.swing.GroupLayout panelBackground34Layout = new javax.swing.GroupLayout(panelBackground34);
        panelBackground34.setLayout(panelBackground34Layout);
        panelBackground34Layout.setHorizontalGroup(
            panelBackground34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        panelBackground34Layout.setVerticalGroup(
            panelBackground34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelBackground32.add(panelBackground34, java.awt.BorderLayout.PAGE_END);

        panelBackground35.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground35.setPreferredSize(new java.awt.Dimension(15, 42));

        javax.swing.GroupLayout panelBackground35Layout = new javax.swing.GroupLayout(panelBackground35);
        panelBackground35.setLayout(panelBackground35Layout);
        panelBackground35Layout.setHorizontalGroup(
            panelBackground35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground35Layout.setVerticalGroup(
            panelBackground35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        panelBackground32.add(panelBackground35, java.awt.BorderLayout.LINE_START);

        panelBackground36.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground36.setPreferredSize(new java.awt.Dimension(15, 42));

        javax.swing.GroupLayout panelBackground36Layout = new javax.swing.GroupLayout(panelBackground36);
        panelBackground36.setLayout(panelBackground36Layout);
        panelBackground36Layout.setHorizontalGroup(
            panelBackground36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground36Layout.setVerticalGroup(
            panelBackground36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        panelBackground32.add(panelBackground36, java.awt.BorderLayout.LINE_END);

        panelBackground37.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground37.setLayout(new java.awt.BorderLayout(15, 0));

        lbThanhTien.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbThanhTien.setForeground(new java.awt.Color(255, 255, 255));
        lbThanhTien.setText("0");
        lbThanhTien.setPreferredSize(new java.awt.Dimension(100, 16));
        panelBackground37.add(lbThanhTien, java.awt.BorderLayout.CENTER);

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Thành tiền");
        jLabel5.setPreferredSize(new java.awt.Dimension(100, 16));
        panelBackground37.add(jLabel5, java.awt.BorderLayout.LINE_START);

        panelBackground32.add(panelBackground37, java.awt.BorderLayout.CENTER);

        panelBackground7.add(panelBackground32);

        panelBackground38.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground38.setPreferredSize(new java.awt.Dimension(499, 25));
        panelBackground38.setLayout(new java.awt.BorderLayout(15, 0));

        panelBackground39.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground39.setPreferredSize(new java.awt.Dimension(499, 15));

        javax.swing.GroupLayout panelBackground39Layout = new javax.swing.GroupLayout(panelBackground39);
        panelBackground39.setLayout(panelBackground39Layout);
        panelBackground39Layout.setHorizontalGroup(
            panelBackground39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        panelBackground39Layout.setVerticalGroup(
            panelBackground39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelBackground38.add(panelBackground39, java.awt.BorderLayout.PAGE_START);

        panelBackground40.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground40.setPreferredSize(new java.awt.Dimension(499, 15));

        javax.swing.GroupLayout panelBackground40Layout = new javax.swing.GroupLayout(panelBackground40);
        panelBackground40.setLayout(panelBackground40Layout);
        panelBackground40Layout.setHorizontalGroup(
            panelBackground40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        panelBackground40Layout.setVerticalGroup(
            panelBackground40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelBackground38.add(panelBackground40, java.awt.BorderLayout.PAGE_END);

        panelBackground41.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground41.setPreferredSize(new java.awt.Dimension(15, 42));

        javax.swing.GroupLayout panelBackground41Layout = new javax.swing.GroupLayout(panelBackground41);
        panelBackground41.setLayout(panelBackground41Layout);
        panelBackground41Layout.setHorizontalGroup(
            panelBackground41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground41Layout.setVerticalGroup(
            panelBackground41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        panelBackground38.add(panelBackground41, java.awt.BorderLayout.LINE_START);

        panelBackground42.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground42.setPreferredSize(new java.awt.Dimension(15, 42));

        javax.swing.GroupLayout panelBackground42Layout = new javax.swing.GroupLayout(panelBackground42);
        panelBackground42.setLayout(panelBackground42Layout);
        panelBackground42Layout.setHorizontalGroup(
            panelBackground42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground42Layout.setVerticalGroup(
            panelBackground42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        panelBackground38.add(panelBackground42, java.awt.BorderLayout.LINE_END);

        panelBackground43.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground43.setLayout(new java.awt.GridLayout(1, 2, 25, 0));

        btnCapNhat.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.setEnabled(false);
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });
        panelBackground43.add(btnCapNhat);

        btnXoa.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setEnabled(false);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        panelBackground43.add(btnXoa);

        panelBackground38.add(panelBackground43, java.awt.BorderLayout.CENTER);

        panelBackground7.add(panelBackground38);

        panelBackground26.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground26.setLayout(new java.awt.BorderLayout());
        panelBackground26.add(jSeparator1, java.awt.BorderLayout.SOUTH);

        panelBackground7.add(panelBackground26);

        panelBackground28.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground28.setPreferredSize(new java.awt.Dimension(499, 25));
        panelBackground28.setLayout(new java.awt.BorderLayout(50, 0));

        panelBackground29.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground29.setPreferredSize(new java.awt.Dimension(499, 15));

        javax.swing.GroupLayout panelBackground29Layout = new javax.swing.GroupLayout(panelBackground29);
        panelBackground29.setLayout(panelBackground29Layout);
        panelBackground29Layout.setHorizontalGroup(
            panelBackground29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        panelBackground29Layout.setVerticalGroup(
            panelBackground29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelBackground28.add(panelBackground29, java.awt.BorderLayout.PAGE_START);

        panelBackground30.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground30.setPreferredSize(new java.awt.Dimension(499, 15));

        javax.swing.GroupLayout panelBackground30Layout = new javax.swing.GroupLayout(panelBackground30);
        panelBackground30.setLayout(panelBackground30Layout);
        panelBackground30Layout.setHorizontalGroup(
            panelBackground30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        panelBackground30Layout.setVerticalGroup(
            panelBackground30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelBackground28.add(panelBackground30, java.awt.BorderLayout.PAGE_END);

        panelBackground31.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground31.setPreferredSize(new java.awt.Dimension(15, 42));

        javax.swing.GroupLayout panelBackground31Layout = new javax.swing.GroupLayout(panelBackground31);
        panelBackground31.setLayout(panelBackground31Layout);
        panelBackground31Layout.setHorizontalGroup(
            panelBackground31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground31Layout.setVerticalGroup(
            panelBackground31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        panelBackground28.add(panelBackground31, java.awt.BorderLayout.LINE_START);

        panelBackground44.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground44.setPreferredSize(new java.awt.Dimension(15, 42));

        javax.swing.GroupLayout panelBackground44Layout = new javax.swing.GroupLayout(panelBackground44);
        panelBackground44.setLayout(panelBackground44Layout);
        panelBackground44Layout.setHorizontalGroup(
            panelBackground44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground44Layout.setVerticalGroup(
            panelBackground44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        panelBackground28.add(panelBackground44, java.awt.BorderLayout.LINE_END);

        panelBackground45.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground45.setLayout(new java.awt.BorderLayout(15, 0));

        btnLuu.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.setEnabled(false);
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });
        panelBackground45.add(btnLuu, java.awt.BorderLayout.CENTER);

        panelBackground28.add(panelBackground45, java.awt.BorderLayout.CENTER);

        panelBackground7.add(panelBackground28);

        panelBackground6.add(panelBackground7);

        pnContainer.add(panelBackground6, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnContainer, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        boolean isSuccess = true;
        long total = 0;
        int  cnt = 0;
        for (DetailOrderDTO x : listDetailsOrder) {
            if (detailOrderBUS.updateDetails(x)) {
                cnt++;
            }
            total += x.getTotal();
        }
        OrderDTO order = orderBUS.findOrderByID(orderID);
        order.setTotal(total);
        
        // Cập nhật lại nguyên liệu
        if (distance > 0) {
            System.out.println("xcxcx");
            DetailOrderDTO detail = new DetailOrderDTO();
            detail = listDetailsOrder.get(row);
            ArrayList<DetailsRecipeDTO> listDetailRecipe = new DetailsReciptBUS().readByIDItem(detail.getItemID());
            for (DetailsRecipeDTO detailRecipe : listDetailRecipe) {
                IngredientsDTO ingredientsDTO = new IngredientsBUS().getIngredientById(detailRecipe.getIngredientID());
                int newQuantity = ingredientsDTO.getQuantity() + distance;
                ingredientsDTO.setQuantity(newQuantity);
                System.out.println(new IngredientsBUS().updateIngredient(ingredientsDTO));
            }
        }
        
        if (orderBUS.updateTotal(order) && cnt == listDetailsOrder.size()) {
            JOptionPane.showMessageDialog(pnContainer, "Đã lưu thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            
        }
        else {
            JOptionPane.showMessageDialog(pnContainer, "Lưu thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
            
        }
        dispose();
    }//GEN-LAST:event_btnLuuActionPerformed

    private void tbMonAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMonAnMouseClicked
        row = tbMonAn.getSelectedRow();
        txtIDMonAn.setText(listDetailsOrder.get(row).getId() + "");
        txtTenMon.setText(listDetailsOrder.get(row).getName());
        txtSoLuong.setText(listDetailsOrder.get(row).getQuantity()+ "");
        lbThanhTien.setText(Helper.Format.formatNumber.format(listDetailsOrder.get(row).getTotal()));
    }//GEN-LAST:event_tbMonAnMouseClicked

    private void txtSoLuongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuongKeyReleased
        String quantity = txtSoLuong.getText();
        if (quantity.isEmpty()) {
            JOptionPane.showMessageDialog(pnContainer, "Số lượng không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
        else {
            try {
                lbThanhTien.setText(Helper.Format.formatNumber.format(Long.parseLong(quantity) * listDetailsOrder.get(row).getPrice()));
                isValid = true;
            }
            catch(NumberFormatException nfe) {
                JOptionPane.showMessageDialog(pnContainer, "Số lượng phải là kí tự số", "Lỗi", JOptionPane.ERROR_MESSAGE);
                isValid = false;
            }
        }
    }//GEN-LAST:event_txtSoLuongKeyReleased

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        if (isValid) {
            DetailOrderDTO detail = new DetailOrderDTO();
            detail = listDetailsOrder.get(row);
            int quantityNew = Integer.parseInt(txtSoLuong.getText());
            if (quantityNew <= 0) {
                JOptionPane.showMessageDialog(pnContainer, "Số lượng phải > 0");
                return;
            }
            if (quantityNew < detail.getQuantity()) {
                distance = detail.getQuantity() - quantityNew;
            }
            detail.setQuantity(quantityNew);
            detail.setTotal(quantityNew * detail.getPrice());
            listDetailsOrder.set(row, detail);
            refresh();
            render(false);
            
            
        }
        else {
            JOptionPane.showMessageDialog(pnContainer, "Sai định dạng số lượng. Không thể cập nhật", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (isValid) {
            DetailOrderDTO detail = new DetailOrderDTO();
            detail = listDetailsOrder.get(row);
            
            detail.setIsDelete(true);
            listDetailsOrder.set(row, detail);
            refresh();
            render(false);
            
        }
        else {
            JOptionPane.showMessageDialog(pnContainer, "Sai định dạng số lượng. Không thể cập nhật", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

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
            java.util.logging.Logger.getLogger(DetailsOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetailsOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetailsOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetailsOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DetailsOrder dialog = new DetailsOrder(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbThanhTien;
    private GUI.Comp.Swing.PanelBackground panelBackground10;
    private GUI.Comp.Swing.PanelBackground panelBackground11;
    private GUI.Comp.Swing.PanelBackground panelBackground12;
    private GUI.Comp.Swing.PanelBackground panelBackground13;
    private GUI.Comp.Swing.PanelBackground panelBackground14;
    private GUI.Comp.Swing.PanelBackground panelBackground15;
    private GUI.Comp.Swing.PanelBackground panelBackground16;
    private GUI.Comp.Swing.PanelBackground panelBackground17;
    private GUI.Comp.Swing.PanelBackground panelBackground18;
    private GUI.Comp.Swing.PanelBackground panelBackground19;
    private GUI.Comp.Swing.PanelBackground panelBackground2;
    private GUI.Comp.Swing.PanelBackground panelBackground20;
    private GUI.Comp.Swing.PanelBackground panelBackground21;
    private GUI.Comp.Swing.PanelBackground panelBackground22;
    private GUI.Comp.Swing.PanelBackground panelBackground23;
    private GUI.Comp.Swing.PanelBackground panelBackground24;
    private GUI.Comp.Swing.PanelBackground panelBackground25;
    private GUI.Comp.Swing.PanelBackground panelBackground26;
    private GUI.Comp.Swing.PanelBackground panelBackground28;
    private GUI.Comp.Swing.PanelBackground panelBackground29;
    private GUI.Comp.Swing.PanelBackground panelBackground3;
    private GUI.Comp.Swing.PanelBackground panelBackground30;
    private GUI.Comp.Swing.PanelBackground panelBackground31;
    private GUI.Comp.Swing.PanelBackground panelBackground32;
    private GUI.Comp.Swing.PanelBackground panelBackground33;
    private GUI.Comp.Swing.PanelBackground panelBackground34;
    private GUI.Comp.Swing.PanelBackground panelBackground35;
    private GUI.Comp.Swing.PanelBackground panelBackground36;
    private GUI.Comp.Swing.PanelBackground panelBackground37;
    private GUI.Comp.Swing.PanelBackground panelBackground38;
    private GUI.Comp.Swing.PanelBackground panelBackground39;
    private GUI.Comp.Swing.PanelBackground panelBackground4;
    private GUI.Comp.Swing.PanelBackground panelBackground40;
    private GUI.Comp.Swing.PanelBackground panelBackground41;
    private GUI.Comp.Swing.PanelBackground panelBackground42;
    private GUI.Comp.Swing.PanelBackground panelBackground43;
    private GUI.Comp.Swing.PanelBackground panelBackground44;
    private GUI.Comp.Swing.PanelBackground panelBackground45;
    private GUI.Comp.Swing.PanelBackground panelBackground5;
    private GUI.Comp.Swing.PanelBackground panelBackground6;
    private GUI.Comp.Swing.PanelBackground panelBackground7;
    private GUI.Comp.Swing.PanelBackground panelBackground8;
    private GUI.Comp.Swing.PanelBackground panelBackground9;
    private GUI.Comp.Swing.PanelBackground pnContainer;
    private javax.swing.JTable tbMonAn;
    private javax.swing.JTextField txtIDMonAn;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenMon;
    // End of variables declaration//GEN-END:variables
}
