/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.Comp.Dialog;

import BUS.CategoriesBUS;
import BUS.DetailImportBillBUS;
import BUS.DetailsReciptBUS;
import BUS.IngredientsBUS;
import BUS.MenuItemBUS;
import BUS.MenuItemStatusBUS;
import DTO.CategoriesDTO;
import DTO.DetailImportBillDTO;
import DTO.DetailsRecipeDTO;
import DTO.IngredientsDTO;
import DTO.MenuItemDTO;
import DTO.MenuItemStatusDTO;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quang
 */
public class DialogMonAn extends javax.swing.JDialog {
    private ArrayList<IngredientsDTO> listIngredients = new ArrayList<>();
    private ArrayList<CategoriesDTO> listCate = new ArrayList<>();
    private ArrayList<MenuItemStatusDTO> listMenuItemStatus = new ArrayList<>();
    private ArrayList<DetailsRecipeDTO> listDetailsOfMenuItem = new ArrayList<>();
    private ArrayList<DetailsRecipeDTO> listDetailsOfMenuItemDeleted = new ArrayList<>();
    private MenuItemBUS menuItemBUS = new MenuItemBUS();
    private MenuItemDTO item = new MenuItemDTO();
    private DetailsReciptBUS detailsReciptBUS = new DetailsReciptBUS();
    private DefaultTableModel model;
    private String pathSource = "";
    private boolean isUpdate = false;
    private boolean isDeleted = false;
    private boolean isValid = true;
    
    private double priceImport = 0;
    
    public DialogMonAn(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        initCombobox();
        
        DefaultTableCellRenderer  renderer = (DefaultTableCellRenderer) tbIngre.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.LEFT);
    }

    public void isUpdate(boolean isUpdate) {
        this.isUpdate = isUpdate;
        txtTenMon.setEnabled(false);
        txtGiaBan.setEnabled(false);
        cbxTheLoai.setEnabled(false);
        txtLoiNhuan.setEnabled(false);
        if (isUpdate) {
            txtLoiNhuan.setEnabled(true);
        }
        else {
            txtTenMon.setEnabled(true);
        }
        
    }
    
    
    public void initCombobox() {
        listIngredients = new IngredientsBUS().getAllActiveIngredients();
//        for (IngredientsDTO x : listIngredients) {
//            listIngre += x.getId() + ", ";
//        }
//        listIngre = listIngre.substring(0, listIngre.lastIndexOf(", "));
//        System.out.println(listIngre);
        listCate = new CategoriesBUS().getAll();
        listMenuItemStatus = new MenuItemStatusBUS().getAll();
        for (IngredientsDTO x : listIngredients) {
            cbxNguyenLieu.addItem(x.getName());
        }
        for (CategoriesDTO x : listCate) {
            cbxTheLoai.addItem(x.getName());
        }
        for (MenuItemStatusDTO x : listMenuItemStatus) {
            cbxTrangThai.addItem(x.getName());
        }
    }

    public void setItem(MenuItemDTO item) {
        this.item = item;
        loadData();
    }
    
    public void loadData() {
        txtTenMon.setText(item.getName());
        txtMoTa.setText(item.getDescription());
        txtGiaBan.setText(item.getPrice() + "");
        txtLoiNhuan.setText(item.getProfit() + "");
        cbxTrangThai.setSelectedIndex(getIndexSelectedItemTrangThai(item.getStatusID()));
        cbxTheLoai.setSelectedIndex(getIndexSelectedItemTheLoai(item.getCategoryID()));   
        btnAnh.setText(item.getImage());
        if (isUpdate) {
            listDetailsOfMenuItem = new DetailsReciptBUS().readByIDItem(item.getId());
            
            //
        }
        renderTable();
        
    }
    
    public void renderTable() {
        priceImport = 0;
        model = (DefaultTableModel)tbIngre.getModel();
        model.setRowCount(0);
        for (DetailsRecipeDTO x : listDetailsOfMenuItem) {
            IngredientsDTO ingre = new IngredientsBUS().getIngredientById(x.getIngredientID());
            model.addRow(new Object[] {ingre.getName(), x.getUnit(), x.getQuantity()});  
            
            DetailImportBillDTO detail = new DetailImportBillBUS().getDetailImportBillByBillIdIngre(ingre.getId());
            priceImport += detail.getPrice() * x.getQuantity();
            
        }
//        System.out.println(listDetailsOfMenuItem.size());
        txtGiaBan.setText((long)priceImport + "");
        model.fireTableDataChanged();
        tbIngre.setModel(model);
        
    }
    
    
    public int getIndexSelectedItemTrangThai(String statusID) {
        int i = 0;
        for (MenuItemStatusDTO x : listMenuItemStatus) {
            if (x.getId().equals(statusID)) {
                break;
            }
            i++;
        }
        return i;
    }
    
    public int getIndexSelectedItemTheLoai(long cateID) {
        int i = 0;
        for (CategoriesDTO x : listCate) {
            if (x.getId() == cateID) {
                break;
            }
            i++;
        }
        return i;
    }
    
    public int getIndexSelectedItemNguyenLieu(long IngreID) {
        int i = 0;
        for (IngredientsDTO x : listIngredients) {
            if (x.getId() == IngreID) {
                break;
            }
            i++;
        }
        return i;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnContainer = new GUI.Comp.Swing.PanelBackground();
        panelBackground2 = new GUI.Comp.Swing.PanelBackground();
        panelBackground3 = new GUI.Comp.Swing.PanelBackground();
        panelBackground4 = new GUI.Comp.Swing.PanelBackground();
        panelBackground5 = new GUI.Comp.Swing.PanelBackground();
        pnCenter = new GUI.Comp.Swing.PanelBackground();
        panelBackground1 = new GUI.Comp.Swing.PanelBackground();
        panelBackground17 = new GUI.Comp.Swing.PanelBackground();
        panelBackground26 = new GUI.Comp.Swing.PanelBackground();
        panelBackground20 = new GUI.Comp.Swing.PanelBackground();
        panelBackground21 = new GUI.Comp.Swing.PanelBackground();
        jPanel1 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        panelBackground22 = new GUI.Comp.Swing.PanelBackground();
        panelBackground23 = new GUI.Comp.Swing.PanelBackground();
        panelBackground24 = new GUI.Comp.Swing.PanelBackground();
        jLabel8 = new javax.swing.JLabel();
        cbxNguyenLieu = new javax.swing.JComboBox<>();
        panelBackground58 = new GUI.Comp.Swing.PanelBackground();
        panelBackground25 = new GUI.Comp.Swing.PanelBackground();
        panelBackground60 = new GUI.Comp.Swing.PanelBackground();
        panelBackground61 = new GUI.Comp.Swing.PanelBackground();
        panelBackground62 = new GUI.Comp.Swing.PanelBackground();
        jLabel9 = new javax.swing.JLabel();
        txtDonVi = new javax.swing.JTextField();
        panelBackground75 = new GUI.Comp.Swing.PanelBackground();
        jPanel3 = new javax.swing.JPanel();
        btnSua = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        panelBackground63 = new GUI.Comp.Swing.PanelBackground();
        panelBackground64 = new GUI.Comp.Swing.PanelBackground();
        panelBackground66 = new GUI.Comp.Swing.PanelBackground();
        panelBackground67 = new GUI.Comp.Swing.PanelBackground();
        panelBackground68 = new GUI.Comp.Swing.PanelBackground();
        jLabel10 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        panelBackground76 = new GUI.Comp.Swing.PanelBackground();
        jPanel5 = new javax.swing.JPanel();
        btnXoa = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        panelBackground18 = new GUI.Comp.Swing.PanelBackground();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbIngre = new javax.swing.JTable();
        panelBackground73 = new GUI.Comp.Swing.PanelBackground();
        btnLuu = new javax.swing.JButton();
        panelBackground6 = new GUI.Comp.Swing.PanelBackground();
        panelBackground19 = new GUI.Comp.Swing.PanelBackground();
        panelBackground7 = new GUI.Comp.Swing.PanelBackground();
        panelBackground8 = new GUI.Comp.Swing.PanelBackground();
        panelBackground9 = new GUI.Comp.Swing.PanelBackground();
        panelBackground10 = new GUI.Comp.Swing.PanelBackground();
        panelBackground11 = new GUI.Comp.Swing.PanelBackground();
        jLabel1 = new javax.swing.JLabel();
        txtTenMon = new javax.swing.JTextField();
        panelBackground27 = new GUI.Comp.Swing.PanelBackground();
        panelBackground12 = new GUI.Comp.Swing.PanelBackground();
        panelBackground13 = new GUI.Comp.Swing.PanelBackground();
        panelBackground14 = new GUI.Comp.Swing.PanelBackground();
        panelBackground15 = new GUI.Comp.Swing.PanelBackground();
        panelBackground16 = new GUI.Comp.Swing.PanelBackground();
        jLabel2 = new javax.swing.JLabel();
        txtMoTa = new javax.swing.JTextField();
        panelBackground28 = new GUI.Comp.Swing.PanelBackground();
        panelBackground29 = new GUI.Comp.Swing.PanelBackground();
        panelBackground30 = new GUI.Comp.Swing.PanelBackground();
        panelBackground31 = new GUI.Comp.Swing.PanelBackground();
        panelBackground32 = new GUI.Comp.Swing.PanelBackground();
        panelBackground33 = new GUI.Comp.Swing.PanelBackground();
        jLabel3 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        panelBackground34 = new GUI.Comp.Swing.PanelBackground();
        panelBackground35 = new GUI.Comp.Swing.PanelBackground();
        panelBackground36 = new GUI.Comp.Swing.PanelBackground();
        panelBackground37 = new GUI.Comp.Swing.PanelBackground();
        panelBackground38 = new GUI.Comp.Swing.PanelBackground();
        panelBackground39 = new GUI.Comp.Swing.PanelBackground();
        jLabel4 = new javax.swing.JLabel();
        txtLoiNhuan = new javax.swing.JTextField();
        panelBackground40 = new GUI.Comp.Swing.PanelBackground();
        panelBackground41 = new GUI.Comp.Swing.PanelBackground();
        panelBackground42 = new GUI.Comp.Swing.PanelBackground();
        panelBackground43 = new GUI.Comp.Swing.PanelBackground();
        panelBackground44 = new GUI.Comp.Swing.PanelBackground();
        panelBackground45 = new GUI.Comp.Swing.PanelBackground();
        jLabel5 = new javax.swing.JLabel();
        cbxTrangThai = new javax.swing.JComboBox<>();
        panelBackground46 = new GUI.Comp.Swing.PanelBackground();
        panelBackground47 = new GUI.Comp.Swing.PanelBackground();
        panelBackground48 = new GUI.Comp.Swing.PanelBackground();
        panelBackground49 = new GUI.Comp.Swing.PanelBackground();
        panelBackground50 = new GUI.Comp.Swing.PanelBackground();
        panelBackground51 = new GUI.Comp.Swing.PanelBackground();
        jLabel6 = new javax.swing.JLabel();
        cbxTheLoai = new javax.swing.JComboBox<>();
        panelBackground52 = new GUI.Comp.Swing.PanelBackground();
        panelBackground53 = new GUI.Comp.Swing.PanelBackground();
        panelBackground54 = new GUI.Comp.Swing.PanelBackground();
        panelBackground55 = new GUI.Comp.Swing.PanelBackground();
        panelBackground56 = new GUI.Comp.Swing.PanelBackground();
        panelBackground57 = new GUI.Comp.Swing.PanelBackground();
        jLabel7 = new javax.swing.JLabel();
        btnAnh = new javax.swing.JButton();
        panelBackground69 = new GUI.Comp.Swing.PanelBackground();
        panelBackground70 = new GUI.Comp.Swing.PanelBackground();
        panelBackground71 = new GUI.Comp.Swing.PanelBackground();
        panelBackground72 = new GUI.Comp.Swing.PanelBackground();
        panelBackground74 = new GUI.Comp.Swing.PanelBackground();
        lbAnh = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnContainer.setBackground(new java.awt.Color(30, 30, 30));
        pnContainer.setLayout(new java.awt.BorderLayout());

        panelBackground2.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground2.setPreferredSize(new java.awt.Dimension(15, 511));

        javax.swing.GroupLayout panelBackground2Layout = new javax.swing.GroupLayout(panelBackground2);
        panelBackground2.setLayout(panelBackground2Layout);
        panelBackground2Layout.setHorizontalGroup(
            panelBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground2Layout.setVerticalGroup(
            panelBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );

        pnContainer.add(panelBackground2, java.awt.BorderLayout.LINE_START);

        panelBackground3.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground3.setPreferredSize(new java.awt.Dimension(1020, 15));

        javax.swing.GroupLayout panelBackground3Layout = new javax.swing.GroupLayout(panelBackground3);
        panelBackground3.setLayout(panelBackground3Layout);
        panelBackground3Layout.setHorizontalGroup(
            panelBackground3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1071, Short.MAX_VALUE)
        );
        panelBackground3Layout.setVerticalGroup(
            panelBackground3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        pnContainer.add(panelBackground3, java.awt.BorderLayout.PAGE_END);

        panelBackground4.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground4.setPreferredSize(new java.awt.Dimension(15, 511));

        javax.swing.GroupLayout panelBackground4Layout = new javax.swing.GroupLayout(panelBackground4);
        panelBackground4.setLayout(panelBackground4Layout);
        panelBackground4Layout.setHorizontalGroup(
            panelBackground4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground4Layout.setVerticalGroup(
            panelBackground4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );

        pnContainer.add(panelBackground4, java.awt.BorderLayout.LINE_END);

        panelBackground5.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground5.setPreferredSize(new java.awt.Dimension(1020, 15));

        javax.swing.GroupLayout panelBackground5Layout = new javax.swing.GroupLayout(panelBackground5);
        panelBackground5.setLayout(panelBackground5Layout);
        panelBackground5Layout.setHorizontalGroup(
            panelBackground5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1071, Short.MAX_VALUE)
        );
        panelBackground5Layout.setVerticalGroup(
            panelBackground5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        pnContainer.add(panelBackground5, java.awt.BorderLayout.PAGE_START);

        pnCenter.setBackground(new java.awt.Color(30, 30, 30));
        pnCenter.setLayout(new java.awt.BorderLayout(30, 0));

        panelBackground1.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground1.setPreferredSize(new java.awt.Dimension(500, 511));
        panelBackground1.setLayout(new java.awt.BorderLayout(0, 15));

        panelBackground17.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground17.setPreferredSize(new java.awt.Dimension(400, 200));
        panelBackground17.setLayout(new java.awt.GridLayout(3, 1));

        panelBackground26.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground26.setLayout(new java.awt.BorderLayout());

        panelBackground20.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground20.setPreferredSize(new java.awt.Dimension(15, 88));

        javax.swing.GroupLayout panelBackground20Layout = new javax.swing.GroupLayout(panelBackground20);
        panelBackground20.setLayout(panelBackground20Layout);
        panelBackground20Layout.setHorizontalGroup(
            panelBackground20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground20Layout.setVerticalGroup(
            panelBackground20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        panelBackground26.add(panelBackground20, java.awt.BorderLayout.LINE_START);

        panelBackground21.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground21.setPreferredSize(new java.awt.Dimension(100, 88));
        panelBackground21.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(35, 35, 35));
        jPanel1.setPreferredSize(new java.awt.Dimension(15, 50));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        panelBackground21.add(jPanel1, java.awt.BorderLayout.LINE_END);

        btnThem.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        panelBackground21.add(btnThem, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(35, 35, 35));
        jPanel2.setPreferredSize(new java.awt.Dimension(15, 36));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        panelBackground21.add(jPanel2, java.awt.BorderLayout.LINE_START);

        panelBackground26.add(panelBackground21, java.awt.BorderLayout.LINE_END);

        panelBackground22.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground22.setPreferredSize(new java.awt.Dimension(500, 15));

        javax.swing.GroupLayout panelBackground22Layout = new javax.swing.GroupLayout(panelBackground22);
        panelBackground22.setLayout(panelBackground22Layout);
        panelBackground22Layout.setHorizontalGroup(
            panelBackground22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        panelBackground22Layout.setVerticalGroup(
            panelBackground22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelBackground26.add(panelBackground22, java.awt.BorderLayout.PAGE_END);

        panelBackground23.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground23.setPreferredSize(new java.awt.Dimension(500, 15));

        javax.swing.GroupLayout panelBackground23Layout = new javax.swing.GroupLayout(panelBackground23);
        panelBackground23.setLayout(panelBackground23Layout);
        panelBackground23Layout.setHorizontalGroup(
            panelBackground23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        panelBackground23Layout.setVerticalGroup(
            panelBackground23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelBackground26.add(panelBackground23, java.awt.BorderLayout.PAGE_START);

        panelBackground24.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground24.setLayout(new java.awt.BorderLayout(15, 0));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nguyên liệu");
        panelBackground24.add(jLabel8, java.awt.BorderLayout.LINE_START);

        cbxNguyenLieu.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cbxNguyenLieu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxNguyenLieuItemStateChanged(evt);
            }
        });
        panelBackground24.add(cbxNguyenLieu, java.awt.BorderLayout.CENTER);

        panelBackground26.add(panelBackground24, java.awt.BorderLayout.CENTER);

        panelBackground17.add(panelBackground26);

        panelBackground58.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground58.setLayout(new java.awt.BorderLayout());

        panelBackground25.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground25.setPreferredSize(new java.awt.Dimension(15, 88));

        javax.swing.GroupLayout panelBackground25Layout = new javax.swing.GroupLayout(panelBackground25);
        panelBackground25.setLayout(panelBackground25Layout);
        panelBackground25Layout.setHorizontalGroup(
            panelBackground25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground25Layout.setVerticalGroup(
            panelBackground25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        panelBackground58.add(panelBackground25, java.awt.BorderLayout.LINE_START);

        panelBackground60.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground60.setPreferredSize(new java.awt.Dimension(500, 15));

        javax.swing.GroupLayout panelBackground60Layout = new javax.swing.GroupLayout(panelBackground60);
        panelBackground60.setLayout(panelBackground60Layout);
        panelBackground60Layout.setHorizontalGroup(
            panelBackground60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        panelBackground60Layout.setVerticalGroup(
            panelBackground60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelBackground58.add(panelBackground60, java.awt.BorderLayout.PAGE_END);

        panelBackground61.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground61.setPreferredSize(new java.awt.Dimension(500, 15));

        javax.swing.GroupLayout panelBackground61Layout = new javax.swing.GroupLayout(panelBackground61);
        panelBackground61.setLayout(panelBackground61Layout);
        panelBackground61Layout.setHorizontalGroup(
            panelBackground61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        panelBackground61Layout.setVerticalGroup(
            panelBackground61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelBackground58.add(panelBackground61, java.awt.BorderLayout.PAGE_START);

        panelBackground62.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground62.setLayout(new java.awt.BorderLayout(15, 0));

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Đơn vị tính");
        jLabel9.setPreferredSize(new java.awt.Dimension(70, 17));
        panelBackground62.add(jLabel9, java.awt.BorderLayout.LINE_START);

        txtDonVi.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtDonVi.setEnabled(false);
        panelBackground62.add(txtDonVi, java.awt.BorderLayout.CENTER);

        panelBackground58.add(panelBackground62, java.awt.BorderLayout.CENTER);

        panelBackground75.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground75.setPreferredSize(new java.awt.Dimension(100, 88));
        panelBackground75.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(35, 35, 35));
        jPanel3.setPreferredSize(new java.awt.Dimension(15, 50));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        panelBackground75.add(jPanel3, java.awt.BorderLayout.LINE_END);

        btnSua.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        panelBackground75.add(btnSua, java.awt.BorderLayout.CENTER);

        jPanel4.setBackground(new java.awt.Color(35, 35, 35));
        jPanel4.setPreferredSize(new java.awt.Dimension(15, 36));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        panelBackground75.add(jPanel4, java.awt.BorderLayout.LINE_START);

        panelBackground58.add(panelBackground75, java.awt.BorderLayout.LINE_END);

        panelBackground17.add(panelBackground58);

        panelBackground63.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground63.setLayout(new java.awt.BorderLayout());

        panelBackground64.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground64.setPreferredSize(new java.awt.Dimension(15, 88));

        javax.swing.GroupLayout panelBackground64Layout = new javax.swing.GroupLayout(panelBackground64);
        panelBackground64.setLayout(panelBackground64Layout);
        panelBackground64Layout.setHorizontalGroup(
            panelBackground64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground64Layout.setVerticalGroup(
            panelBackground64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        panelBackground63.add(panelBackground64, java.awt.BorderLayout.LINE_START);

        panelBackground66.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground66.setPreferredSize(new java.awt.Dimension(500, 15));

        javax.swing.GroupLayout panelBackground66Layout = new javax.swing.GroupLayout(panelBackground66);
        panelBackground66.setLayout(panelBackground66Layout);
        panelBackground66Layout.setHorizontalGroup(
            panelBackground66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        panelBackground66Layout.setVerticalGroup(
            panelBackground66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelBackground63.add(panelBackground66, java.awt.BorderLayout.PAGE_END);

        panelBackground67.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground67.setPreferredSize(new java.awt.Dimension(500, 15));

        javax.swing.GroupLayout panelBackground67Layout = new javax.swing.GroupLayout(panelBackground67);
        panelBackground67.setLayout(panelBackground67Layout);
        panelBackground67Layout.setHorizontalGroup(
            panelBackground67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        panelBackground67Layout.setVerticalGroup(
            panelBackground67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelBackground63.add(panelBackground67, java.awt.BorderLayout.PAGE_START);

        panelBackground68.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground68.setLayout(new java.awt.BorderLayout(15, 0));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Số lượng");
        jLabel10.setPreferredSize(new java.awt.Dimension(70, 17));
        panelBackground68.add(jLabel10, java.awt.BorderLayout.LINE_START);

        txtSoLuong.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtSoLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoLuongKeyReleased(evt);
            }
        });
        panelBackground68.add(txtSoLuong, java.awt.BorderLayout.CENTER);

        panelBackground63.add(panelBackground68, java.awt.BorderLayout.CENTER);

        panelBackground76.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground76.setPreferredSize(new java.awt.Dimension(100, 88));
        panelBackground76.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(35, 35, 35));
        jPanel5.setPreferredSize(new java.awt.Dimension(15, 50));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        panelBackground76.add(jPanel5, java.awt.BorderLayout.LINE_END);

        btnXoa.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        panelBackground76.add(btnXoa, java.awt.BorderLayout.CENTER);

        jPanel6.setBackground(new java.awt.Color(35, 35, 35));
        jPanel6.setPreferredSize(new java.awt.Dimension(15, 36));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        panelBackground76.add(jPanel6, java.awt.BorderLayout.LINE_START);

        panelBackground63.add(panelBackground76, java.awt.BorderLayout.LINE_END);

        panelBackground17.add(panelBackground63);

        panelBackground1.add(panelBackground17, java.awt.BorderLayout.PAGE_START);

        panelBackground18.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground18.setLayout(new java.awt.BorderLayout(0, 25));

        tbIngre.setBackground(new java.awt.Color(35, 35, 35));
        tbIngre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tên nguyên liệu", "Đơn vị tính", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbIngre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbIngreMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbIngre);

        panelBackground18.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        panelBackground73.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground73.setPreferredSize(new java.awt.Dimension(500, 50));
        panelBackground73.setLayout(new java.awt.BorderLayout(40, 0));

        btnLuu.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });
        panelBackground73.add(btnLuu, java.awt.BorderLayout.CENTER);

        panelBackground18.add(panelBackground73, java.awt.BorderLayout.PAGE_END);

        panelBackground1.add(panelBackground18, java.awt.BorderLayout.CENTER);

        pnCenter.add(panelBackground1, java.awt.BorderLayout.LINE_END);

        panelBackground6.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground6.setLayout(new java.awt.GridLayout(4, 2));

        panelBackground19.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground19.setLayout(new java.awt.BorderLayout());

        panelBackground7.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground7.setPreferredSize(new java.awt.Dimension(15, 49));

        javax.swing.GroupLayout panelBackground7Layout = new javax.swing.GroupLayout(panelBackground7);
        panelBackground7.setLayout(panelBackground7Layout);
        panelBackground7Layout.setHorizontalGroup(
            panelBackground7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground7Layout.setVerticalGroup(
            panelBackground7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        panelBackground19.add(panelBackground7, java.awt.BorderLayout.LINE_START);

        panelBackground8.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground8.setPreferredSize(new java.awt.Dimension(15, 49));

        javax.swing.GroupLayout panelBackground8Layout = new javax.swing.GroupLayout(panelBackground8);
        panelBackground8.setLayout(panelBackground8Layout);
        panelBackground8Layout.setHorizontalGroup(
            panelBackground8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground8Layout.setVerticalGroup(
            panelBackground8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        panelBackground19.add(panelBackground8, java.awt.BorderLayout.LINE_END);

        panelBackground9.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground9.setPreferredSize(new java.awt.Dimension(454, 60));

        javax.swing.GroupLayout panelBackground9Layout = new javax.swing.GroupLayout(panelBackground9);
        panelBackground9.setLayout(panelBackground9Layout);
        panelBackground9Layout.setHorizontalGroup(
            panelBackground9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );
        panelBackground9Layout.setVerticalGroup(
            panelBackground9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        panelBackground19.add(panelBackground9, java.awt.BorderLayout.PAGE_END);

        panelBackground10.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground10.setPreferredSize(new java.awt.Dimension(454, 15));

        javax.swing.GroupLayout panelBackground10Layout = new javax.swing.GroupLayout(panelBackground10);
        panelBackground10.setLayout(panelBackground10Layout);
        panelBackground10Layout.setHorizontalGroup(
            panelBackground10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );
        panelBackground10Layout.setVerticalGroup(
            panelBackground10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelBackground19.add(panelBackground10, java.awt.BorderLayout.PAGE_START);

        panelBackground11.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground11.setLayout(new java.awt.BorderLayout(15, 0));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tên món");
        jLabel1.setPreferredSize(new java.awt.Dimension(65, 17));
        panelBackground11.add(jLabel1, java.awt.BorderLayout.LINE_START);

        txtTenMon.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        panelBackground11.add(txtTenMon, java.awt.BorderLayout.CENTER);

        panelBackground19.add(panelBackground11, java.awt.BorderLayout.CENTER);

        panelBackground6.add(panelBackground19);

        panelBackground27.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground27.setLayout(new java.awt.BorderLayout());

        panelBackground12.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground12.setPreferredSize(new java.awt.Dimension(15, 49));

        javax.swing.GroupLayout panelBackground12Layout = new javax.swing.GroupLayout(panelBackground12);
        panelBackground12.setLayout(panelBackground12Layout);
        panelBackground12Layout.setHorizontalGroup(
            panelBackground12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground12Layout.setVerticalGroup(
            panelBackground12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        panelBackground27.add(panelBackground12, java.awt.BorderLayout.LINE_START);

        panelBackground13.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground13.setPreferredSize(new java.awt.Dimension(15, 49));

        javax.swing.GroupLayout panelBackground13Layout = new javax.swing.GroupLayout(panelBackground13);
        panelBackground13.setLayout(panelBackground13Layout);
        panelBackground13Layout.setHorizontalGroup(
            panelBackground13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground13Layout.setVerticalGroup(
            panelBackground13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        panelBackground27.add(panelBackground13, java.awt.BorderLayout.LINE_END);

        panelBackground14.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground14.setPreferredSize(new java.awt.Dimension(454, 60));

        javax.swing.GroupLayout panelBackground14Layout = new javax.swing.GroupLayout(panelBackground14);
        panelBackground14.setLayout(panelBackground14Layout);
        panelBackground14Layout.setHorizontalGroup(
            panelBackground14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );
        panelBackground14Layout.setVerticalGroup(
            panelBackground14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        panelBackground27.add(panelBackground14, java.awt.BorderLayout.PAGE_END);

        panelBackground15.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground15.setPreferredSize(new java.awt.Dimension(454, 15));

        javax.swing.GroupLayout panelBackground15Layout = new javax.swing.GroupLayout(panelBackground15);
        panelBackground15.setLayout(panelBackground15Layout);
        panelBackground15Layout.setHorizontalGroup(
            panelBackground15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );
        panelBackground15Layout.setVerticalGroup(
            panelBackground15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelBackground27.add(panelBackground15, java.awt.BorderLayout.PAGE_START);

        panelBackground16.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground16.setLayout(new java.awt.BorderLayout(15, 0));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mô tả");
        jLabel2.setPreferredSize(new java.awt.Dimension(65, 17));
        panelBackground16.add(jLabel2, java.awt.BorderLayout.LINE_START);

        txtMoTa.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        panelBackground16.add(txtMoTa, java.awt.BorderLayout.CENTER);

        panelBackground27.add(panelBackground16, java.awt.BorderLayout.CENTER);

        panelBackground6.add(panelBackground27);

        panelBackground28.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground28.setLayout(new java.awt.BorderLayout());

        panelBackground29.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground29.setPreferredSize(new java.awt.Dimension(15, 49));

        javax.swing.GroupLayout panelBackground29Layout = new javax.swing.GroupLayout(panelBackground29);
        panelBackground29.setLayout(panelBackground29Layout);
        panelBackground29Layout.setHorizontalGroup(
            panelBackground29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground29Layout.setVerticalGroup(
            panelBackground29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        panelBackground28.add(panelBackground29, java.awt.BorderLayout.LINE_START);

        panelBackground30.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground30.setPreferredSize(new java.awt.Dimension(15, 49));

        javax.swing.GroupLayout panelBackground30Layout = new javax.swing.GroupLayout(panelBackground30);
        panelBackground30.setLayout(panelBackground30Layout);
        panelBackground30Layout.setHorizontalGroup(
            panelBackground30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground30Layout.setVerticalGroup(
            panelBackground30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        panelBackground28.add(panelBackground30, java.awt.BorderLayout.LINE_END);

        panelBackground31.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground31.setPreferredSize(new java.awt.Dimension(454, 60));

        javax.swing.GroupLayout panelBackground31Layout = new javax.swing.GroupLayout(panelBackground31);
        panelBackground31.setLayout(panelBackground31Layout);
        panelBackground31Layout.setHorizontalGroup(
            panelBackground31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );
        panelBackground31Layout.setVerticalGroup(
            panelBackground31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        panelBackground28.add(panelBackground31, java.awt.BorderLayout.PAGE_END);

        panelBackground32.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground32.setPreferredSize(new java.awt.Dimension(454, 15));

        javax.swing.GroupLayout panelBackground32Layout = new javax.swing.GroupLayout(panelBackground32);
        panelBackground32.setLayout(panelBackground32Layout);
        panelBackground32Layout.setHorizontalGroup(
            panelBackground32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );
        panelBackground32Layout.setVerticalGroup(
            panelBackground32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelBackground28.add(panelBackground32, java.awt.BorderLayout.PAGE_START);

        panelBackground33.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground33.setLayout(new java.awt.BorderLayout(15, 0));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Giá bán");
        jLabel3.setPreferredSize(new java.awt.Dimension(65, 17));
        panelBackground33.add(jLabel3, java.awt.BorderLayout.LINE_START);

        txtGiaBan.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtGiaBan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGiaBanKeyReleased(evt);
            }
        });
        panelBackground33.add(txtGiaBan, java.awt.BorderLayout.CENTER);

        panelBackground28.add(panelBackground33, java.awt.BorderLayout.CENTER);

        panelBackground6.add(panelBackground28);

        panelBackground34.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground34.setLayout(new java.awt.BorderLayout());

        panelBackground35.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground35.setPreferredSize(new java.awt.Dimension(15, 49));

        javax.swing.GroupLayout panelBackground35Layout = new javax.swing.GroupLayout(panelBackground35);
        panelBackground35.setLayout(panelBackground35Layout);
        panelBackground35Layout.setHorizontalGroup(
            panelBackground35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground35Layout.setVerticalGroup(
            panelBackground35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        panelBackground34.add(panelBackground35, java.awt.BorderLayout.LINE_START);

        panelBackground36.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground36.setPreferredSize(new java.awt.Dimension(15, 49));

        javax.swing.GroupLayout panelBackground36Layout = new javax.swing.GroupLayout(panelBackground36);
        panelBackground36.setLayout(panelBackground36Layout);
        panelBackground36Layout.setHorizontalGroup(
            panelBackground36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground36Layout.setVerticalGroup(
            panelBackground36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        panelBackground34.add(panelBackground36, java.awt.BorderLayout.LINE_END);

        panelBackground37.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground37.setPreferredSize(new java.awt.Dimension(454, 60));

        javax.swing.GroupLayout panelBackground37Layout = new javax.swing.GroupLayout(panelBackground37);
        panelBackground37.setLayout(panelBackground37Layout);
        panelBackground37Layout.setHorizontalGroup(
            panelBackground37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );
        panelBackground37Layout.setVerticalGroup(
            panelBackground37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        panelBackground34.add(panelBackground37, java.awt.BorderLayout.PAGE_END);

        panelBackground38.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground38.setPreferredSize(new java.awt.Dimension(454, 15));

        javax.swing.GroupLayout panelBackground38Layout = new javax.swing.GroupLayout(panelBackground38);
        panelBackground38.setLayout(panelBackground38Layout);
        panelBackground38Layout.setHorizontalGroup(
            panelBackground38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );
        panelBackground38Layout.setVerticalGroup(
            panelBackground38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelBackground34.add(panelBackground38, java.awt.BorderLayout.PAGE_START);

        panelBackground39.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground39.setLayout(new java.awt.BorderLayout(15, 0));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Lợi nhuận");
        panelBackground39.add(jLabel4, java.awt.BorderLayout.LINE_START);

        txtLoiNhuan.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtLoiNhuan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtLoiNhuanMouseExited(evt);
            }
        });
        txtLoiNhuan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLoiNhuanKeyReleased(evt);
            }
        });
        panelBackground39.add(txtLoiNhuan, java.awt.BorderLayout.CENTER);

        panelBackground34.add(panelBackground39, java.awt.BorderLayout.CENTER);

        panelBackground6.add(panelBackground34);

        panelBackground40.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground40.setLayout(new java.awt.BorderLayout());

        panelBackground41.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground41.setPreferredSize(new java.awt.Dimension(15, 49));

        javax.swing.GroupLayout panelBackground41Layout = new javax.swing.GroupLayout(panelBackground41);
        panelBackground41.setLayout(panelBackground41Layout);
        panelBackground41Layout.setHorizontalGroup(
            panelBackground41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground41Layout.setVerticalGroup(
            panelBackground41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        panelBackground40.add(panelBackground41, java.awt.BorderLayout.LINE_START);

        panelBackground42.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground42.setPreferredSize(new java.awt.Dimension(15, 49));

        javax.swing.GroupLayout panelBackground42Layout = new javax.swing.GroupLayout(panelBackground42);
        panelBackground42.setLayout(panelBackground42Layout);
        panelBackground42Layout.setHorizontalGroup(
            panelBackground42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground42Layout.setVerticalGroup(
            panelBackground42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        panelBackground40.add(panelBackground42, java.awt.BorderLayout.LINE_END);

        panelBackground43.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground43.setPreferredSize(new java.awt.Dimension(454, 60));

        javax.swing.GroupLayout panelBackground43Layout = new javax.swing.GroupLayout(panelBackground43);
        panelBackground43.setLayout(panelBackground43Layout);
        panelBackground43Layout.setHorizontalGroup(
            panelBackground43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );
        panelBackground43Layout.setVerticalGroup(
            panelBackground43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        panelBackground40.add(panelBackground43, java.awt.BorderLayout.PAGE_END);

        panelBackground44.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground44.setPreferredSize(new java.awt.Dimension(454, 15));

        javax.swing.GroupLayout panelBackground44Layout = new javax.swing.GroupLayout(panelBackground44);
        panelBackground44.setLayout(panelBackground44Layout);
        panelBackground44Layout.setHorizontalGroup(
            panelBackground44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );
        panelBackground44Layout.setVerticalGroup(
            panelBackground44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelBackground40.add(panelBackground44, java.awt.BorderLayout.PAGE_START);

        panelBackground45.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground45.setLayout(new java.awt.BorderLayout(15, 0));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Trạng thái");
        panelBackground45.add(jLabel5, java.awt.BorderLayout.LINE_START);

        cbxTrangThai.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        panelBackground45.add(cbxTrangThai, java.awt.BorderLayout.CENTER);

        panelBackground40.add(panelBackground45, java.awt.BorderLayout.CENTER);

        panelBackground6.add(panelBackground40);

        panelBackground46.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground46.setLayout(new java.awt.BorderLayout());

        panelBackground47.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground47.setPreferredSize(new java.awt.Dimension(15, 49));

        javax.swing.GroupLayout panelBackground47Layout = new javax.swing.GroupLayout(panelBackground47);
        panelBackground47.setLayout(panelBackground47Layout);
        panelBackground47Layout.setHorizontalGroup(
            panelBackground47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground47Layout.setVerticalGroup(
            panelBackground47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        panelBackground46.add(panelBackground47, java.awt.BorderLayout.LINE_START);

        panelBackground48.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground48.setPreferredSize(new java.awt.Dimension(15, 49));

        javax.swing.GroupLayout panelBackground48Layout = new javax.swing.GroupLayout(panelBackground48);
        panelBackground48.setLayout(panelBackground48Layout);
        panelBackground48Layout.setHorizontalGroup(
            panelBackground48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground48Layout.setVerticalGroup(
            panelBackground48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        panelBackground46.add(panelBackground48, java.awt.BorderLayout.LINE_END);

        panelBackground49.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground49.setPreferredSize(new java.awt.Dimension(454, 60));

        javax.swing.GroupLayout panelBackground49Layout = new javax.swing.GroupLayout(panelBackground49);
        panelBackground49.setLayout(panelBackground49Layout);
        panelBackground49Layout.setHorizontalGroup(
            panelBackground49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );
        panelBackground49Layout.setVerticalGroup(
            panelBackground49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        panelBackground46.add(panelBackground49, java.awt.BorderLayout.PAGE_END);

        panelBackground50.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground50.setPreferredSize(new java.awt.Dimension(454, 15));

        javax.swing.GroupLayout panelBackground50Layout = new javax.swing.GroupLayout(panelBackground50);
        panelBackground50.setLayout(panelBackground50Layout);
        panelBackground50Layout.setHorizontalGroup(
            panelBackground50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );
        panelBackground50Layout.setVerticalGroup(
            panelBackground50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelBackground46.add(panelBackground50, java.awt.BorderLayout.PAGE_START);

        panelBackground51.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground51.setLayout(new java.awt.BorderLayout(15, 0));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Thể loại");
        jLabel6.setPreferredSize(new java.awt.Dimension(60, 17));
        panelBackground51.add(jLabel6, java.awt.BorderLayout.LINE_START);

        cbxTheLoai.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        panelBackground51.add(cbxTheLoai, java.awt.BorderLayout.CENTER);

        panelBackground46.add(panelBackground51, java.awt.BorderLayout.CENTER);

        panelBackground6.add(panelBackground46);

        panelBackground52.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground52.setLayout(new java.awt.BorderLayout());

        panelBackground53.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground53.setPreferredSize(new java.awt.Dimension(15, 49));

        javax.swing.GroupLayout panelBackground53Layout = new javax.swing.GroupLayout(panelBackground53);
        panelBackground53.setLayout(panelBackground53Layout);
        panelBackground53Layout.setHorizontalGroup(
            panelBackground53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground53Layout.setVerticalGroup(
            panelBackground53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        panelBackground52.add(panelBackground53, java.awt.BorderLayout.LINE_START);

        panelBackground54.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground54.setPreferredSize(new java.awt.Dimension(15, 49));

        javax.swing.GroupLayout panelBackground54Layout = new javax.swing.GroupLayout(panelBackground54);
        panelBackground54.setLayout(panelBackground54Layout);
        panelBackground54Layout.setHorizontalGroup(
            panelBackground54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground54Layout.setVerticalGroup(
            panelBackground54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        panelBackground52.add(panelBackground54, java.awt.BorderLayout.LINE_END);

        panelBackground55.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground55.setPreferredSize(new java.awt.Dimension(454, 60));

        javax.swing.GroupLayout panelBackground55Layout = new javax.swing.GroupLayout(panelBackground55);
        panelBackground55.setLayout(panelBackground55Layout);
        panelBackground55Layout.setHorizontalGroup(
            panelBackground55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );
        panelBackground55Layout.setVerticalGroup(
            panelBackground55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        panelBackground52.add(panelBackground55, java.awt.BorderLayout.PAGE_END);

        panelBackground56.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground56.setPreferredSize(new java.awt.Dimension(454, 15));

        javax.swing.GroupLayout panelBackground56Layout = new javax.swing.GroupLayout(panelBackground56);
        panelBackground56.setLayout(panelBackground56Layout);
        panelBackground56Layout.setHorizontalGroup(
            panelBackground56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );
        panelBackground56Layout.setVerticalGroup(
            panelBackground56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelBackground52.add(panelBackground56, java.awt.BorderLayout.PAGE_START);

        panelBackground57.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground57.setLayout(new java.awt.BorderLayout(15, 0));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ảnh");
        jLabel7.setPreferredSize(new java.awt.Dimension(65, 17));
        panelBackground57.add(jLabel7, java.awt.BorderLayout.LINE_START);

        btnAnh.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnAnh.setText("Chọn ảnh");
        btnAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnhActionPerformed(evt);
            }
        });
        panelBackground57.add(btnAnh, java.awt.BorderLayout.CENTER);

        panelBackground52.add(panelBackground57, java.awt.BorderLayout.CENTER);

        panelBackground6.add(panelBackground52);

        panelBackground69.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground69.setLayout(new java.awt.BorderLayout());

        panelBackground70.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground70.setPreferredSize(new java.awt.Dimension(15, 49));

        javax.swing.GroupLayout panelBackground70Layout = new javax.swing.GroupLayout(panelBackground70);
        panelBackground70.setLayout(panelBackground70Layout);
        panelBackground70Layout.setHorizontalGroup(
            panelBackground70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground70Layout.setVerticalGroup(
            panelBackground70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );

        panelBackground69.add(panelBackground70, java.awt.BorderLayout.LINE_START);

        panelBackground71.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground71.setPreferredSize(new java.awt.Dimension(15, 49));

        javax.swing.GroupLayout panelBackground71Layout = new javax.swing.GroupLayout(panelBackground71);
        panelBackground71.setLayout(panelBackground71Layout);
        panelBackground71Layout.setHorizontalGroup(
            panelBackground71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        panelBackground71Layout.setVerticalGroup(
            panelBackground71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );

        panelBackground69.add(panelBackground71, java.awt.BorderLayout.LINE_END);

        panelBackground72.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground72.setPreferredSize(new java.awt.Dimension(454, 15));

        javax.swing.GroupLayout panelBackground72Layout = new javax.swing.GroupLayout(panelBackground72);
        panelBackground72.setLayout(panelBackground72Layout);
        panelBackground72Layout.setHorizontalGroup(
            panelBackground72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );
        panelBackground72Layout.setVerticalGroup(
            panelBackground72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelBackground69.add(panelBackground72, java.awt.BorderLayout.PAGE_END);

        panelBackground74.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground74.setLayout(new java.awt.BorderLayout());

        lbAnh.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lbAnh.setForeground(new java.awt.Color(255, 255, 255));
        lbAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelBackground74.add(lbAnh, java.awt.BorderLayout.CENTER);

        panelBackground69.add(panelBackground74, java.awt.BorderLayout.CENTER);

        panelBackground6.add(panelBackground69);

        pnCenter.add(panelBackground6, java.awt.BorderLayout.CENTER);

        pnContainer.add(pnCenter, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnContainer, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnhActionPerformed
        String regex = "^.+\\.(jpg|jpeg|png|gif|bmp)$";
        JFileChooser file = new JFileChooser();
        file.showOpenDialog(pnContainer);
        pathSource = file.getSelectedFile().getAbsolutePath();
        String nameFile = pathSource.substring(pathSource.lastIndexOf("\\") + 1);
        if (nameFile.matches(regex)) {
            btnAnh.setText(nameFile);
            Path sourceFile = Paths.get(pathSource);
            Path destinationFile = Paths.get(System.getProperty("user.dir") + "/src/GUI/ImageProduct/" + nameFile);

            try {
                Files.copy(sourceFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                Logger.getLogger(DialogMonAn.class.getName()).log(Level.SEVERE, null, ex);
            }

            

        }
        else {
            JOptionPane.showMessageDialog(pnContainer, "File bạn chọn không phải là ẢNH");
        }
        
    }//GEN-LAST:event_btnAnhActionPerformed

    private void tbIngreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbIngreMouseClicked
        int row = tbIngre.getSelectedRow();
        DetailsRecipeDTO detailSelected = listDetailsOfMenuItem.get(row);
        txtSoLuong.setText(detailSelected.getQuantity() + "");
        txtDonVi.setText(detailSelected.getUnit());
        cbxNguyenLieu.setSelectedIndex(getIndexSelectedItemNguyenLieu(detailSelected.getIngredientID()));
    }//GEN-LAST:event_tbIngreMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (txtSoLuong.getText().isEmpty()) {
            JOptionPane.showMessageDialog(pnContainer, "Vui lòng nhập số lượng");
            return;
        }
        DetailsRecipeDTO detailsRecipeDTO = new DetailsRecipeDTO();
        detailsRecipeDTO.createID();
        detailsRecipeDTO.setQuantity(Integer.parseInt(txtSoLuong.getText()));
        detailsRecipeDTO.setUnit(txtDonVi.getText());
        
        int indexIngredientSelected = cbxNguyenLieu.getSelectedIndex();
        
        detailsRecipeDTO.setIngredientID(listIngredients.get(indexIngredientSelected).getId());
        detailsRecipeDTO.setItemid(item.getId());
        
        for (DetailsRecipeDTO x : listDetailsOfMenuItem) {
            if (x.getIngredientID() == detailsRecipeDTO.getIngredientID()) {
                JOptionPane.showMessageDialog(pnContainer, "Nguyên liệu này đã tồn tại vui lòng thử lại");
                return;
            }
        }
        listDetailsOfMenuItem.add(detailsRecipeDTO);
        System.out.println(listDetailsOfMenuItem.size());
        renderTable();
        txtSoLuong.setText("");
        
    }//GEN-LAST:event_btnThemActionPerformed

    private void cbxNguyenLieuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxNguyenLieuItemStateChanged
        IngredientsDTO ingre = listIngredients.get(cbxNguyenLieu.getSelectedIndex());
        txtDonVi.setText(ingre.getUnit());
    }//GEN-LAST:event_cbxNguyenLieuItemStateChanged

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int row = tbIngre.getSelectedRow();
        DetailsRecipeDTO detailsRecipe = listDetailsOfMenuItem.get(row);
        detailsRecipe.setQuantity(Integer.parseInt(txtSoLuong.getText()));
        

//        if (detailsReciptBUS.updateDetail(detailsRecipe)) {
//            System.out.println("Thanh cong");
//        }
//        else {
//            System.out.println("Tach");
//        }
        renderTable();
        txtSoLuong.setText("");
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row = tbIngre.getSelectedRow();
        DetailsRecipeDTO detailsRecipe = listDetailsOfMenuItem.get(row);
        detailsRecipe.setIsDelete(true);
        listDetailsOfMenuItem.remove(detailsRecipe);
        listDetailsOfMenuItemDeleted.add(detailsRecipe);
        
//        detailsReciptBUS.updateDetail(detailsRecipe);
        isDeleted = true;
        renderTable();
        txtSoLuong.setText("");
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        
        if (txtTenMon.getText().isEmpty()) {
            isValid = false;
        }
        if (txtMoTa.getText().isEmpty()) {
            isValid = false;
        }
        if (txtTenMon.getText().isEmpty()) {
            isValid = false;
        }
        if (btnAnh.getText().equals("Open")) {
            isValid = false;
        }
        if (listDetailsOfMenuItem.size() == 0) {
            isValid = false;
        }
        if (!isValid) {
            JOptionPane.showMessageDialog(pnContainer, "Dữ liệu thiếu hoặc sai");
            return;
        }
        
        boolean isSuccess = true;
        if (isUpdate) {
            
           
            
            
            
            
            
            
            item.setName(txtTenMon.getText());
            item.setDescription(txtMoTa.getText());
            item.setImage(btnAnh.getText());
            item.setPrice(Long.parseLong(txtGiaBan.getText()));
            item.setProfit(Long.parseLong(txtLoiNhuan.getText()));
            item.setIsDelete(false);
            item.setStatusID(listMenuItemStatus.get(cbxTrangThai.getSelectedIndex()).getId());
            item.setCategoryID(listCate.get(cbxTheLoai.getSelectedIndex()).getId());
            item.setUpdateTime(new Date());
            
            if (menuItemBUS.updateData(item) == false) {
                isSuccess = false;
            }
            System.out.println(isSuccess);
            for (DetailsRecipeDTO x : listDetailsOfMenuItem) {
                DetailsRecipeDTO tmp = detailsReciptBUS.findDetailsByIngreNItem(x.getIngredientID(), x.getItemid());
                // Null la chua co
                if (tmp == null) {
                    if (detailsReciptBUS.insertDetail(x) == false) {
                        isSuccess = false;
                    }
                }
                else {
                    if (detailsReciptBUS.updateDetail(x) == false) {
                    isSuccess = false;
                    }
                }
            }
            System.out.println(isSuccess);
            if (isDeleted) {
                for (DetailsRecipeDTO x : listDetailsOfMenuItemDeleted) {
                    if (detailsReciptBUS.updateDetail(x) == false) {
                        isSuccess = false;
                    }
                }
                System.out.println(isSuccess);
            }
            
        }
        else {
            
           
            
            
            MenuItemDTO itemNew = new MenuItemDTO();
            itemNew.createID();
            itemNew.setName(txtTenMon.getText());
            itemNew.setDescription(txtMoTa.getText());
            itemNew.setImage(btnAnh.getText());
            
            
            itemNew.setPrice((long)priceImport);
            itemNew.setProfit(0);
            itemNew.setIsDelete(false);
            itemNew.setStatusID(listMenuItemStatus.get(cbxTrangThai.getSelectedIndex()).getId());
            itemNew.setCategoryID(listCate.get(cbxTheLoai.getSelectedIndex()).getId());
            itemNew.setUpdateTime(new Date());
            itemNew.setCreateTime(new Date());

            if (menuItemBUS.insertData(itemNew) == false) {
                isSuccess = false;
            }

            for (DetailsRecipeDTO x : listDetailsOfMenuItem) {
                x.setItemid(itemNew.getId());
                if (detailsReciptBUS.insertDetail(x) == false) {
                    isSuccess = false;
                }
            }
            
        }
        if (isSuccess) {
                JOptionPane.showMessageDialog(pnContainer, "Lưu thành công");
            }
        else {
            JOptionPane.showMessageDialog(pnContainer, "Lưu thất bại");
        }
        dispose();
        
        
    }//GEN-LAST:event_btnLuuActionPerformed

    private void txtGiaBanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiaBanKeyReleased
//        if (txtGiaBan.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(pnContainer, "Giá bán không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
//            isValid = false;
//        }
//        else {
//            try {
//                long price = Long.parseLong(txtGiaBan.getText());
//            }
//            catch(NumberFormatException nfe) {
//                JOptionPane.showMessageDialog(pnContainer, "Giá bán phải là kí tự số", "Lỗi", JOptionPane.ERROR_MESSAGE);
//                isValid = false;
//            }
//        }
    }//GEN-LAST:event_txtGiaBanKeyReleased

    private void txtLoiNhuanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoiNhuanKeyReleased
        
        
    }//GEN-LAST:event_txtLoiNhuanKeyReleased

    private void txtSoLuongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuongKeyReleased
        if (txtSoLuong.getText().isEmpty()) {
            JOptionPane.showMessageDialog(pnContainer, "Số lượng không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
        else {
            try {
                int quantity = Integer.parseInt(txtSoLuong.getText());
            }
            catch(NumberFormatException nfe) {
                JOptionPane.showMessageDialog(pnContainer, "Số lượng phải là kí tự số", "Lỗi", JOptionPane.ERROR_MESSAGE);
                isValid = false;
            }
        }
    }//GEN-LAST:event_txtSoLuongKeyReleased

    private void txtLoiNhuanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtLoiNhuanMouseExited
        if (txtLoiNhuan.getText().isEmpty()) {
            txtGiaBan.setText((long)priceImport + "");
            JOptionPane.showMessageDialog(pnContainer, "Lợi nhuận không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
            
        }
        else {
            
            try {
                priceImport += Double.parseDouble(txtLoiNhuan.getText());
                txtGiaBan.setText((long)priceImport + "");
            }
            catch(NumberFormatException nfe) {
                JOptionPane.showMessageDialog(pnContainer, "Lợi nhuận phải là kí tự số", "Lỗi", JOptionPane.ERROR_MESSAGE);
                isValid = false;
            }
        }
    }//GEN-LAST:event_txtLoiNhuanMouseExited

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
            java.util.logging.Logger.getLogger(DialogMonAn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogMonAn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogMonAn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogMonAn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogMonAn dialog = new DialogMonAn(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAnh;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbxNguyenLieu;
    private javax.swing.JComboBox<String> cbxTheLoai;
    private javax.swing.JComboBox<String> cbxTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbAnh;
    private GUI.Comp.Swing.PanelBackground panelBackground1;
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
    private GUI.Comp.Swing.PanelBackground panelBackground27;
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
    private GUI.Comp.Swing.PanelBackground panelBackground46;
    private GUI.Comp.Swing.PanelBackground panelBackground47;
    private GUI.Comp.Swing.PanelBackground panelBackground48;
    private GUI.Comp.Swing.PanelBackground panelBackground49;
    private GUI.Comp.Swing.PanelBackground panelBackground5;
    private GUI.Comp.Swing.PanelBackground panelBackground50;
    private GUI.Comp.Swing.PanelBackground panelBackground51;
    private GUI.Comp.Swing.PanelBackground panelBackground52;
    private GUI.Comp.Swing.PanelBackground panelBackground53;
    private GUI.Comp.Swing.PanelBackground panelBackground54;
    private GUI.Comp.Swing.PanelBackground panelBackground55;
    private GUI.Comp.Swing.PanelBackground panelBackground56;
    private GUI.Comp.Swing.PanelBackground panelBackground57;
    private GUI.Comp.Swing.PanelBackground panelBackground58;
    private GUI.Comp.Swing.PanelBackground panelBackground6;
    private GUI.Comp.Swing.PanelBackground panelBackground60;
    private GUI.Comp.Swing.PanelBackground panelBackground61;
    private GUI.Comp.Swing.PanelBackground panelBackground62;
    private GUI.Comp.Swing.PanelBackground panelBackground63;
    private GUI.Comp.Swing.PanelBackground panelBackground64;
    private GUI.Comp.Swing.PanelBackground panelBackground66;
    private GUI.Comp.Swing.PanelBackground panelBackground67;
    private GUI.Comp.Swing.PanelBackground panelBackground68;
    private GUI.Comp.Swing.PanelBackground panelBackground69;
    private GUI.Comp.Swing.PanelBackground panelBackground7;
    private GUI.Comp.Swing.PanelBackground panelBackground70;
    private GUI.Comp.Swing.PanelBackground panelBackground71;
    private GUI.Comp.Swing.PanelBackground panelBackground72;
    private GUI.Comp.Swing.PanelBackground panelBackground73;
    private GUI.Comp.Swing.PanelBackground panelBackground74;
    private GUI.Comp.Swing.PanelBackground panelBackground75;
    private GUI.Comp.Swing.PanelBackground panelBackground76;
    private GUI.Comp.Swing.PanelBackground panelBackground8;
    private GUI.Comp.Swing.PanelBackground panelBackground9;
    private GUI.Comp.Swing.PanelBackground pnCenter;
    private GUI.Comp.Swing.PanelBackground pnContainer;
    private javax.swing.JTable tbIngre;
    private javax.swing.JTextField txtDonVi;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtLoiNhuan;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenMon;
    // End of variables declaration//GEN-END:variables
}
