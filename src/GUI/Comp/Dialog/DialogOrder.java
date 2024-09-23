package GUI.Comp.Dialog;

import BUS.DetailsReciptBUS;
import BUS.IngredientsBUS;
import GUI.Comp.Panel.PanelTableBooking;
import BUS.MenuItemBUS;
import BUS.OrderBUS;
import BUS.TableBUS;
import DTO.DetailOrderDTO;
import DTO.DetailsRecipeDTO;
import DTO.IngredientsDTO;
import DTO.MenuItemDTO;
import DTO.OrderDTO;
import DTO.StaffDTO;
import DTO.TableDTO;
import Helper.MyListener;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DialogOrder extends javax.swing.JDialog implements PropertyChangeListener {
    private long totalPrice = 0;
    // bao nhiêu bàn được chọn để gọi món
    private int totalSelected = 0;
    // Trạng thái của bàn,bàn đầu tiên đc chọn là bàn trống thì chỉ đuọc selected các bàn khác là trống => ngược lại
    private boolean isValidSelected = true;
    // Danh sách hiển thị
    private ArrayList<MenuItemDTO> listMenuItem = new ArrayList<>();
    private ArrayList<DetailOrderDTO> listDetailOrder = new ArrayList<>();
    private ArrayList<TableDTO> listTable = new ArrayList<>();
    
    private MenuItemBUS menuItemBUS = new MenuItemBUS();
    private TableBUS tableBUS = new TableBUS();
    private String note = "";
    
    // danh sách những bàn đã chọn
    private ArrayList<TableDTO> listTableSelected = new ArrayList<>();
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("AddItem")) {
            int index = (int) evt.getNewValue();
            test(index);
        }
        if (evt.getPropertyName().equals("Quantity0")) {
            String nameProduct = (String) evt.getNewValue();
            check(nameProduct);
            lbShowTien.setText(Helper.Format.formatNumber.format(totalPrice) + "đ");
        }
//        if (evt.getPropertyName().equals("Order")) {            
//            totalPrice += (Long)evt.getNewValue();
//            lbShowTien.setText(Helper.Format.formatNumber.format(totalPrice) + "đ");
//            for (DetailOrderDTO x : listDetailOrder) {
//                if (x.getName().equals(evt.getOldValue())) {
//                    if ((long)evt.getNewValue() > 0) {
//                        x.setQuantity(x.getQuantity() + 1);
//                    }
//                    else {
//                        x.setQuantity(x.getQuantity() - 1);
//                        
//                    }
//                    System.out.println(evt.getOldValue() + " " + x.getQuantity());
//                }
//            }
//        }

          if (evt.getPropertyName().equals("Order")) {            
            totalPrice = 0;
            for (DetailOrderDTO x : listDetailOrder) {
                if (x.getName().equals(evt.getOldValue())) {
                    x.setQuantity((Integer)evt.getNewValue());
                    x.setTotal(x.getQuantity() * x.getPrice());
                    
                    System.out.println(evt.getOldValue() + " " + x.getQuantity() + " " + x.getTotal());
                }
                totalPrice += x.getTotal();
                
            }
            lbShowTien.setText(Helper.Format.formatNumber.format(totalPrice) + "đ");
        }  
            



        if (evt.getPropertyName().equals("SelectedTable")) {
            TableDTO table = listTable.get(getTable((String)evt.getOldValue()));
            PanelTableBooking pnTable = table.getPnTableBooking();
            
            if (table.getStatusID().equals("DANGSUACHUA")) {
                JOptionPane.showMessageDialog(rootPane, "Bàn đang sửa chữa");
                return;
            }
            
            if (listTableSelected.size() == 0) {
                totalSelected += 1;
                pnTable.setSelected(true);
                listTableSelected.add(table);
            } 
            else {
                TableDTO tableHeadList = listTableSelected.get(0);
                PanelTableBooking pnTableHead = tableHeadList.getPnTableBooking();
                if (pnTableHead.isIsEmpty() == pnTable.isIsEmpty()) {
                    if (findTableSelected(table.getName())) {
                        totalSelected -= 1;
                        pnTable.setSelected(false);
                        listTableSelected.remove(table);
                    }
                    else {
                        totalSelected += 1;
                        pnTable.setSelected(true);
                        listTableSelected.add(table);
                    }
                }
                else {
                    int choice = JOptionPane.showOptionDialog(rootPane, "Bạn có chắc chắn không ? Có thể sẽ mất hết những bàn đang chọn", "Xác nhận", JOptionPane.OK_CANCEL_OPTION, HEIGHT, null, null, null);
                    if (choice == 0) {
                        for(TableDTO x : listTable) {
                            x.getPnTableBooking().setSelected(false);
                        }
                        listTableSelected.removeAll(listTableSelected);
                        totalSelected += 1;
                        pnTable.setSelected(true);
                        listTableSelected.add(table);
                    }
                }

                
            }

            lbTotalSelected.setText(listTableSelected.size() + "");
        }
        
    }
    
    public boolean findTableSelected(String nameTable) {
        for (TableDTO x : listTableSelected) {
            if (x.getName().equals(nameTable)) {
                return true;
            }
        }
        return false;
    }

   
    public DialogOrder(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        addMenuItem();
        addTable();
        MyListener.getInstance().addPropertyChangeListener(this);
        
        

    }
    public void addTable() {
        listTable = tableBUS.getAllData();
        int height = 100 * listTable.size();
        int width = pnContainerTable.getWidth();
        pnContainerTable.setPreferredSize(new Dimension(width, height));
        for (int i = 0; i < listTable.size(); i++) {
            TableDTO item = listTable.get(i);
            pnContainerTable.add(item.createTableBooking());
        }
    }
    public void addMenuItem() {
        listMenuItem = menuItemBUS.getAllData();
        int height = 135 * listMenuItem.size();
        int width = pnOrder.getWidth();
        pnOrder.setPreferredSize(new Dimension(width, height));
        for (int i = 0; i < listMenuItem.size(); i++) {
            MenuItemDTO item = listMenuItem.get(i);
//            System.out.println(item.getName() + " " + item.getStatusID());
            String statusOld = item.getStatusID();
            pnOrder.add(item.createCart(i));
            String statusNew = item.getStatusID();
            if (!statusOld.equals(statusNew)) {
                menuItemBUS.updateData(item);
            }
           
        }
        
        System.out.println(listMenuItem.size());
    }

    public void updatePrice() {
        long total = 0;
        for (int i = 0; i < listDetailOrder.size(); i++) {
            DetailOrderDTO detailOrderDTO = listDetailOrder.get(i);
            detailOrderDTO.rerender();
            total += detailOrderDTO.getTotal();
        }
        lbShowTien.setText(total + " đ");
    }

    //===================================================================//
    // Nếu panel món ăn đã tồn tại ở checkout thì không thêm vào 
    // Ngược lại thì thêm vào
    // chức năng khác => render lại panel
    public void addCheckoutItem() {
        pnCheckout.removeAll();
        int height = 90 * listDetailOrder.size();
        int width = pnCheckout.getWidth();
        pnCheckout.setPreferredSize(new Dimension(width, height));
        for (int i = 0; i < listDetailOrder.size(); i++) {
            DetailOrderDTO detailOrderDTO = listDetailOrder.get(i);
            if (detailOrderDTO.getQuantity() != 0) {
                pnCheckout.add(detailOrderDTO.createCartOrder());
                System.out.println(detailOrderDTO.getItemID() + " zzzz");
            }
        }
        pnCheckout.revalidate();
        pnCheckout.repaint();
    }

    public void check(String name) {
        for (int i = listDetailOrder.size() - 1; i >= 0; i--) {
            DetailOrderDTO detailOrderDTO = listDetailOrder.get(i);
            detailOrderDTO.rerender();
            if (detailOrderDTO.getName().equals(name)) {
                totalPrice -= detailOrderDTO.getPrice();
                listDetailOrder.remove(i);
            }
        }
        addCheckoutItem();
    }

    public void test(int index) {
        boolean isExists = false;
        MenuItemDTO item = listMenuItem.get(index);
        if (item.getStatusID().equals("TAMHET")) {
           
            JOptionPane.showMessageDialog(rootPane, "Sản phẩm tạm hết vui lòng chọn món khác !");
            return;
        }
        for (DetailOrderDTO x : listDetailOrder) {
            x.rerender();
            if (x.getName().equals(item.getName())) {
                x.setQuantity(x.getQuantity() + 1);
                totalPrice += x.getPrice();
                lbShowTien.setText(Helper.Format.formatNumber.format(totalPrice) + "đ");
                isExists = true;
                
            }
        }

        if (!isExists) {
            DetailOrderDTO detailOrderDTO = new DetailOrderDTO(item.getPrice(), item.getProfit(), item.getId(), 1, item.getName(), false);
            listDetailOrder.add(detailOrderDTO);
            totalPrice += detailOrderDTO.getPrice();
            lbShowTien.setText(Helper.Format.formatNumber.format(totalPrice) + "đ");
        }
        addCheckoutItem();
    }
 
    public int getTable(String nameTable) {
        int i = 0;
        for(TableDTO x : listTable) {
            if (x.getName().equals(nameTable)) {
                return i;
            }
            i++;
        }
        return -1;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMapData = new javax.swing.JTextField();
        pnContainer = new GUI.Comp.Swing.PanelBackground();
        panelBackground3 = new GUI.Comp.Swing.PanelBackground();
        panelBackground4 = new GUI.Comp.Swing.PanelBackground();
        panelBackground5 = new GUI.Comp.Swing.PanelBackground();
        panelBackground6 = new GUI.Comp.Swing.PanelBackground();
        pnCenter = new GUI.Comp.Swing.PanelBackground();
        jScrollPane2 = new javax.swing.JScrollPane();
        pnOrder = new GUI.Comp.Swing.PanelBackground();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelBackground1 = new GUI.Comp.Swing.PanelBackground();
        jScrollPane3 = new javax.swing.JScrollPane();
        pnCheckout = new GUI.Comp.Swing.PanelBackground();
        btnOrder = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lbShowTien = new javax.swing.JLabel();
        lbTitleTongTien = new javax.swing.JLabel();
        panelBackground2 = new GUI.Comp.Swing.PanelBackground();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnContainerTable = new GUI.Comp.Swing.PanelBackground();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        lbTotalSelected = new javax.swing.JLabel();
        panelBackground7 = new GUI.Comp.Swing.PanelBackground();
        btnXacNhan = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        txtMapData.setText("0");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(30, 30, 30));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });

        pnContainer.setBackground(new java.awt.Color(30, 30, 30));
        pnContainer.setLayout(new java.awt.BorderLayout());

        panelBackground3.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground3.setPreferredSize(new java.awt.Dimension(15, 644));

        javax.swing.GroupLayout panelBackground3Layout = new javax.swing.GroupLayout(panelBackground3);
        panelBackground3.setLayout(panelBackground3Layout);
        panelBackground3Layout.setHorizontalGroup(
            panelBackground3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground3Layout.setVerticalGroup(
            panelBackground3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 644, Short.MAX_VALUE)
        );

        pnContainer.add(panelBackground3, java.awt.BorderLayout.LINE_START);

        panelBackground4.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground4.setPreferredSize(new java.awt.Dimension(15, 644));

        javax.swing.GroupLayout panelBackground4Layout = new javax.swing.GroupLayout(panelBackground4);
        panelBackground4.setLayout(panelBackground4Layout);
        panelBackground4Layout.setHorizontalGroup(
            panelBackground4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground4Layout.setVerticalGroup(
            panelBackground4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 644, Short.MAX_VALUE)
        );

        pnContainer.add(panelBackground4, java.awt.BorderLayout.LINE_END);

        panelBackground5.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground5.setPreferredSize(new java.awt.Dimension(897, 15));

        javax.swing.GroupLayout panelBackground5Layout = new javax.swing.GroupLayout(panelBackground5);
        panelBackground5.setLayout(panelBackground5Layout);
        panelBackground5Layout.setHorizontalGroup(
            panelBackground5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
        );
        panelBackground5Layout.setVerticalGroup(
            panelBackground5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        pnContainer.add(panelBackground5, java.awt.BorderLayout.PAGE_START);

        panelBackground6.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground6.setPreferredSize(new java.awt.Dimension(897, 15));

        javax.swing.GroupLayout panelBackground6Layout = new javax.swing.GroupLayout(panelBackground6);
        panelBackground6.setLayout(panelBackground6Layout);
        panelBackground6Layout.setHorizontalGroup(
            panelBackground6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
        );
        panelBackground6Layout.setVerticalGroup(
            panelBackground6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        pnContainer.add(panelBackground6, java.awt.BorderLayout.PAGE_END);

        pnCenter.setBackground(new java.awt.Color(30, 30, 30));
        pnCenter.setLayout(new java.awt.GridLayout(1, 2, 15, 0));

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(400, 700));

        pnOrder.setBackground(new java.awt.Color(35, 35, 35));
        pnOrder.setPreferredSize(new java.awt.Dimension(450, 580));
        pnOrder.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));
        jScrollPane2.setViewportView(pnOrder);

        pnCenter.add(jScrollPane2);

        jTabbedPane1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N

        panelBackground1.setBackground(new java.awt.Color(35, 35, 35));

        jScrollPane3.setBackground(new java.awt.Color(255, 153, 153));
        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnCheckout.setBackground(new java.awt.Color(35, 35, 35));
        pnCheckout.setPreferredSize(new java.awt.Dimension(345, 420));
        pnCheckout.setRound(0);
        java.awt.FlowLayout flowLayout2 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10);
        flowLayout2.setAlignOnBaseline(true);
        pnCheckout.setLayout(flowLayout2);
        jScrollPane3.setViewportView(pnCheckout);

        btnOrder.setBackground(new java.awt.Color(242, 242, 242));
        btnOrder.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnOrder.setForeground(new java.awt.Color(102, 102, 102));
        btnOrder.setText("ĐẶT MÓN");
        btnOrder.setBorderPainted(false);
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });

        lbShowTien.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lbShowTien.setForeground(new java.awt.Color(255, 255, 255));
        lbShowTien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbShowTien.setText("0 đ");

        lbTitleTongTien.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lbTitleTongTien.setForeground(new java.awt.Color(255, 255, 255));
        lbTitleTongTien.setText("Tổng tiền");

        javax.swing.GroupLayout panelBackground1Layout = new javax.swing.GroupLayout(panelBackground1);
        panelBackground1.setLayout(panelBackground1Layout);
        panelBackground1Layout.setHorizontalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBackground1Layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackground1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackground1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbTitleTongTien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                .addComponent(lbShowTien, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        panelBackground1Layout.setVerticalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbShowTien)
                    .addComponent(lbTitleTongTien))
                .addGap(18, 18, 18)
                .addComponent(btnOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("Giỏ hàng", panelBackground1);

        panelBackground2.setBackground(new java.awt.Color(35, 35, 35));

        jScrollPane1.setBackground(new java.awt.Color(35, 35, 35));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setMinimumSize(new java.awt.Dimension(370, 585));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(370, 585));

        pnContainerTable.setBackground(new java.awt.Color(35, 35, 35));
        pnContainerTable.setMinimumSize(new java.awt.Dimension(370, 95));
        pnContainerTable.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));
        jScrollPane1.setViewportView(pnContainerTable);

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Đã chọn");

        lbTotalSelected.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbTotalSelected.setForeground(new java.awt.Color(255, 255, 255));
        lbTotalSelected.setText("0");

        javax.swing.GroupLayout panelBackground2Layout = new javax.swing.GroupLayout(panelBackground2);
        panelBackground2.setLayout(panelBackground2Layout);
        panelBackground2Layout.setHorizontalGroup(
            panelBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBackground2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lbTotalSelected)
                        .addGap(32, 339, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBackground2Layout.setVerticalGroup(
            panelBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbTotalSelected))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Bàn", panelBackground2);

        panelBackground7.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground7.setLayout(new java.awt.BorderLayout(0, 50));

        btnXacNhan.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.setPreferredSize(new java.awt.Dimension(104, 75));
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });
        panelBackground7.add(btnXacNhan, java.awt.BorderLayout.PAGE_END);

        jTextArea1.setBackground(new java.awt.Color(35, 35, 35));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        panelBackground7.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Ghi chú", panelBackground7);

        pnCenter.add(jTabbedPane1);

        pnContainer.add(pnCenter, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
//        pnCheckout.repaint();
    }//GEN-LAST:event_formMouseEntered

    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderActionPerformed
        if (listTableSelected.size() == 0 || listDetailOrder.size() == 0) {
            JOptionPane.showMessageDialog(pnContainerTable, "Bạn chưa chọn Món Ăn hoặc Bàn");
            return;
        }

        //        System.out.println("---------------");

        ArrayList<DetailsRecipeDTO> listDetailRecipe = new ArrayList<>();

        int size = listTableSelected.size();

        for (DetailOrderDTO x : listDetailOrder) {
            listDetailRecipe = new DetailsReciptBUS().readByIDItem(x.getItemID());
            for (DetailsRecipeDTO detailRecipe : listDetailRecipe) {
                IngredientsDTO ingredientsDTO = new IngredientsBUS().getIngredientById(detailRecipe.getIngredientID());
                if (detailRecipe.getQuantity() * size * x.getQuantity() > ingredientsDTO.getQuantity()) {
                    JOptionPane.showMessageDialog(pnContainer, "Món " + x.getName() + " Không đủ số lượng");
                    return;
                }
            }
        }
        for (DetailOrderDTO x : listDetailOrder) {
            listDetailRecipe = new DetailsReciptBUS().readByIDItem(x.getItemID());
            for (DetailsRecipeDTO detailRecipe : listDetailRecipe) {
                IngredientsDTO ingredientsDTO = new IngredientsBUS().getIngredientById(detailRecipe.getIngredientID());
                int newQuantity = ingredientsDTO.getQuantity() - (detailRecipe.getQuantity() * size * x.getQuantity());
                ingredientsDTO.setQuantity(newQuantity);
                new IngredientsBUS().updateIngredient(ingredientsDTO);
            }
        }

        Date date = new Date();

        boolean isSingle = listTableSelected.size() == 1 ? true : false;
        boolean isOrderMore = listTableSelected.get(0).getStatusID().equals("DANGSUDUNG") ? true : false;

        OrderDTO order = new OrderDTO();
        String customerCode = order.createCustomerCode(isSingle);

        OrderBUS orderBUS = new OrderBUS();

        // Update customer vào tb_table
        TableBUS tableBUS = new TableBUS();
        for (TableDTO table : listTableSelected) {
            if (isOrderMore) {
                OrderDTO multiOrder = new OrderDTO();
                multiOrder.createID();

                multiOrder.setStaffID(StaffDTO.staffLogging.getId());
                multiOrder.setTableID(table.getId());
                multiOrder.setCustomerCode(table.getCustomerCode());
                multiOrder.setIsDelete(false);
                multiOrder.setUpdateTime(date);
                multiOrder.setCreateTime(date);
                multiOrder.setNote(note);
                //          Thêm chi tiết cho order
                for (DetailOrderDTO detail : listDetailOrder) {
                    multiOrder.insertDetailOrder(detail);
                    detail.createID();
                    try {
                        Thread.sleep(1);
                    }
                    catch (InterruptedException ex) {
                        Logger.getLogger(DialogOrder.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                orderBUS.insertOrder(multiOrder);
            }
            else {
                table.setCustomerCode(customerCode);
                table.setStatusID("DANGSUDUNG");
                table.setUpdateTime(date);
                tableBUS.updateTable(table);

                OrderDTO multiOrder = new OrderDTO();
                multiOrder.createID();
                multiOrder.setStaffID(StaffDTO.staffLogging.getId());
                multiOrder.setTableID(table.getId());
                multiOrder.setCustomerCode(customerCode);
                multiOrder.setIsDelete(false);
                multiOrder.setUpdateTime(date);
                multiOrder.setCreateTime(date);
                multiOrder.setNote(note);

                //          Thêm chi tiết cho order
                for (DetailOrderDTO detail : listDetailOrder) {
                    multiOrder.insertDetailOrder(detail);
                    detail.createID();
                    try {
                        Thread.sleep(1);
                    }
                    catch (InterruptedException ex) {
                        Logger.getLogger(DialogOrder.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                orderBUS.insertOrder(multiOrder);
            }
        }

        JOptionPane.showMessageDialog(rootPane, "Gọi món thành công !!");
        // Sau khi goi mon xong thi close dialog order
        dispose();
    }//GEN-LAST:event_btnOrderActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        note = jTextArea1.getText();
        JOptionPane.showMessageDialog(rootPane, "Lưu ghi chú thành công");
    }//GEN-LAST:event_btnXacNhanActionPerformed

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
            java.util.logging.Logger.getLogger(DialogOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogOrder dialog = new DialogOrder(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnOrder;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lbShowTien;
    private javax.swing.JLabel lbTitleTongTien;
    private javax.swing.JLabel lbTotalSelected;
    private GUI.Comp.Swing.PanelBackground panelBackground1;
    private GUI.Comp.Swing.PanelBackground panelBackground2;
    private GUI.Comp.Swing.PanelBackground panelBackground3;
    private GUI.Comp.Swing.PanelBackground panelBackground4;
    private GUI.Comp.Swing.PanelBackground panelBackground5;
    private GUI.Comp.Swing.PanelBackground panelBackground6;
    private GUI.Comp.Swing.PanelBackground panelBackground7;
    private GUI.Comp.Swing.PanelBackground pnCenter;
    private GUI.Comp.Swing.PanelBackground pnCheckout;
    private GUI.Comp.Swing.PanelBackground pnContainer;
    private GUI.Comp.Swing.PanelBackground pnContainerTable;
    private GUI.Comp.Swing.PanelBackground pnOrder;
    private javax.swing.JTextField txtMapData;
    // End of variables declaration//GEN-END:variables
}
