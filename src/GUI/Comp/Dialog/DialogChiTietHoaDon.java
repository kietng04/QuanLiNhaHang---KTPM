package GUI.Comp.Dialog;

import BUS.DetailOrderBUS;
import BUS.DiscountBUS;
import BUS.InvoicesBUS;
import BUS.OrderBUS;
import BUS.TableBUS;
import DTO.DetailOrderDTO;
import DTO.DiscountDTO;
import DTO.InvoicesDTO;
import DTO.StaffDTO;
import DTO.TableDTO;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;




public class DialogChiTietHoaDon extends javax.swing.JDialog {

    private ArrayList<DetailOrderDTO> listDetailOrder;
    private DetailOrderBUS detailOrderBUS = new DetailOrderBUS();
    private DefaultTableModel modelMonAn;
    private DefaultTableModel modelDiscount;
    private TableDTO table;
    private OrderBUS orderBUS = new OrderBUS();
    private InvoicesBUS invoicesBUS = new InvoicesBUS();
    private InvoicesDTO invoice;
    private long invoiceID;
    private DiscountBUS discountBUS = new DiscountBUS();
    private TableBUS tableBUS = new TableBUS();
    private ArrayList<DiscountDTO> listDiscount;
    private DiscountDTO discount;
    private long amount = 0;
    private long discountPrice = 0;
    private long total = 0;
   
    public DialogChiTietHoaDon(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        
        
        setLocationRelativeTo(null);
        panelBackground8.setColor(new Color(53, 53, 53));
        
        DefaultTableCellRenderer  renderer = (DefaultTableCellRenderer) tbMonAn.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.LEFT);

//        setVisible(true);
        
    }

    
    public void loadForm(long invocieid, TableDTO table) {
        this.invoiceID = invocieid;
        this.table = table;
        System.out.println(table.getName());
//        renderTableMonAn(listOrderId);
        invoice = invoicesBUS.getInvoiceByID(invocieid);
        lbBan.setText("HÓA ĐƠN " + invocieid);
        ArrayList<DetailOrderDTO> tmp = new DetailOrderBUS().findDetailByInvoice(invocieid);

        String listInvoiceID = "";
        for (DetailOrderDTO x : tmp) {
            listInvoiceID += x.getInvoiceID() + ", ";
            System.out.println(x.getInvoiceID());
        }
        if (!listInvoiceID.isEmpty()) {
            listInvoiceID = listInvoiceID.substring(0, listInvoiceID.length() - 2);
            loadInvoice(listInvoiceID);
            renderTableMonAn(listInvoiceID);
        }
    }
    
    public void loadInvoice(String listInvoiceID) {
        
        listDetailOrder = new DetailOrderBUS().mergeDetaisByIDInvoice(listInvoiceID);
        for (DetailOrderDTO x : listDetailOrder) {
            amount += x.getTotal();
            System.out.println(x.getName());
        }
        total = amount - discountPrice;
        lbThanhTien.setText(Helper.Format.formatNumber.format(amount) + "đ");
        lbTienGiam.setText(Helper.Format.formatNumber.format(discountPrice) + "đ");
        lbTongTien.setText(Helper.Format.formatNumber.format(total) + "đ");
    }
    
    /////////////////////////////////////////////////////
    public void renderTableMonAn(String listInvoiceID) {
        tbMonAn.setRowHeight(25);
        modelMonAn = (DefaultTableModel)tbMonAn.getModel();
        listDetailOrder = new DetailOrderBUS().mergeDetaisByIDInvoice(listInvoiceID);
        modelMonAn.setRowCount(0);
        for (DetailOrderDTO x : listDetailOrder) {
            modelMonAn.addRow(new Object[] {x.getItemID(), x.getName(), Helper.Format.formatNumber.format(x.getPrice()), x.getQuantity(), Helper.Format.formatNumber.format(x.getTotal())});
        }
        modelMonAn.fireTableDataChanged();
        tbMonAn.setModel(modelMonAn);  
        
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSaveDiscountID = new javax.swing.JTextField();
        background = new javax.swing.JPanel();
        pnNorth = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lbBan = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        panelBackground1 = new GUI.Comp.Swing.PanelBackground();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMonAn = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        panelBackground2 = new GUI.Comp.Swing.PanelBackground();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelBackground8 = new GUI.Comp.Swing.PanelBackground();
        jLabel3 = new javax.swing.JLabel();
        lbThanhTien = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbTienGiam = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbTongTien = new javax.swing.JLabel();
        panelBackground3 = new GUI.Comp.Swing.PanelBackground();
        btnInBill = new javax.swing.JButton();

        txtSaveDiscountID.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtSaveDiscountID.setText("0");
        txtSaveDiscountID.setMaximumSize(new java.awt.Dimension(2147483647, 35));
        txtSaveDiscountID.setMinimumSize(new java.awt.Dimension(64, 35));
        txtSaveDiscountID.setPreferredSize(new java.awt.Dimension(3, 35));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(30, 30, 30));

        background.setBackground(new java.awt.Color(30, 30, 30));
        background.setLayout(new java.awt.BorderLayout());

        pnNorth.setBackground(new java.awt.Color(30, 30, 30));
        pnNorth.setPreferredSize(new java.awt.Dimension(998, 40));
        pnNorth.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(30, 30, 30));
        jPanel2.setPreferredSize(new java.awt.Dimension(30, 229));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        pnNorth.add(jPanel2, java.awt.BorderLayout.LINE_START);

        jPanel3.setBackground(new java.awt.Color(30, 30, 30));
        jPanel3.setPreferredSize(new java.awt.Dimension(30, 229));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        pnNorth.add(jPanel3, java.awt.BorderLayout.LINE_END);

        lbBan.setBackground(new java.awt.Color(30, 30, 30));
        lbBan.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lbBan.setForeground(new java.awt.Color(255, 255, 255));
        lbBan.setText("Mã HĐ");
        lbBan.setToolTipText("");
        pnNorth.add(lbBan, java.awt.BorderLayout.CENTER);

        background.add(pnNorth, java.awt.BorderLayout.PAGE_START);

        jPanel5.setBackground(new java.awt.Color(30, 30, 30));
        jPanel5.setPreferredSize(new java.awt.Dimension(30, 550));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 555, Short.MAX_VALUE)
        );

        background.add(jPanel5, java.awt.BorderLayout.LINE_START);

        jPanel6.setBackground(new java.awt.Color(30, 30, 30));
        jPanel6.setPreferredSize(new java.awt.Dimension(30, 520));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 555, Short.MAX_VALUE)
        );

        background.add(jPanel6, java.awt.BorderLayout.LINE_END);

        jPanel7.setBackground(new java.awt.Color(30, 30, 30));
        jPanel7.setPreferredSize(new java.awt.Dimension(998, 30));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1277, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        background.add(jPanel7, java.awt.BorderLayout.PAGE_END);

        panelBackground1.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground1.setLayout(new javax.swing.BoxLayout(panelBackground1, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(750, 402));

        tbMonAn.setBackground(new java.awt.Color(35, 35, 35));
        tbMonAn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Món ăn", "Đơn giá", "Số lượng", "Thành tiên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbMonAn.setMinimumSize(new java.awt.Dimension(2147483647, 80));
        jScrollPane1.setViewportView(tbMonAn);
        if (tbMonAn.getColumnModel().getColumnCount() > 0) {
            tbMonAn.getColumnModel().getColumn(1).setResizable(false);
            tbMonAn.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbMonAn.getColumnModel().getColumn(2).setResizable(false);
            tbMonAn.getColumnModel().getColumn(2).setPreferredWidth(50);
            tbMonAn.getColumnModel().getColumn(3).setResizable(false);
            tbMonAn.getColumnModel().getColumn(3).setPreferredWidth(30);
            tbMonAn.getColumnModel().getColumn(4).setResizable(false);
            tbMonAn.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        panelBackground1.add(jScrollPane1);

        jPanel1.setBackground(new java.awt.Color(30, 30, 30));
        jPanel1.setPreferredSize(new java.awt.Dimension(30, 555));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 555, Short.MAX_VALUE)
        );

        panelBackground1.add(jPanel1);

        panelBackground2.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground2.setPreferredSize(new java.awt.Dimension(270, 555));
        panelBackground2.setLayout(new java.awt.BorderLayout(0, 10));

        jPanel4.setBackground(new java.awt.Color(30, 30, 30));
        jPanel4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jPanel4.setLayout(new java.awt.BorderLayout(0, 10));
        panelBackground2.add(jPanel4, java.awt.BorderLayout.LINE_END);

        jTabbedPane1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(100, 300));
        panelBackground2.add(jTabbedPane1, java.awt.BorderLayout.PAGE_START);

        panelBackground8.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground8.setLayout(new java.awt.GridLayout(3, 2));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Thành tiền");
        panelBackground8.add(jLabel3);

        lbThanhTien.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lbThanhTien.setForeground(new java.awt.Color(255, 255, 255));
        lbThanhTien.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbThanhTien.setText("1000000000đ");
        panelBackground8.add(lbThanhTien);

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Tiền giảm");
        panelBackground8.add(jLabel6);

        lbTienGiam.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lbTienGiam.setForeground(new java.awt.Color(255, 255, 255));
        lbTienGiam.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTienGiam.setText("1000000000đ");
        panelBackground8.add(lbTienGiam);

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Tổng tiền");
        panelBackground8.add(jLabel8);

        lbTongTien.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lbTongTien.setForeground(new java.awt.Color(255, 255, 255));
        lbTongTien.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTongTien.setText("0đ");
        panelBackground8.add(lbTongTien);

        panelBackground2.add(panelBackground8, java.awt.BorderLayout.CENTER);

        panelBackground3.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground3.setPreferredSize(new java.awt.Dimension(279, 75));
        panelBackground3.setLayout(new java.awt.BorderLayout(20, 0));

        btnInBill.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnInBill.setText("IN LẠI ");
        btnInBill.setMaximumSize(new java.awt.Dimension(75, 35));
        btnInBill.setPreferredSize(new java.awt.Dimension(100, 75));
        btnInBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInBillActionPerformed(evt);
            }
        });
        panelBackground3.add(btnInBill, java.awt.BorderLayout.CENTER);

        panelBackground2.add(panelBackground3, java.awt.BorderLayout.PAGE_END);

        panelBackground1.add(panelBackground2);

        background.add(panelBackground1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 1277, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInBillActionPerformed
        
        
        //        // Tạo hoá đơn
        invoice = new InvoicesDTO();
        invoice.setId(invoiceID);
        invoice.setAmount(amount);
        invoice.setCreateTime(new Date());
        invoice.setIsDelete(false);
        if (txtSaveDiscountID.getText().equals("0")) {
            invoice.setDiscount(0);
        }
        else {
            invoice.addDiscount(Long.parseLong(txtSaveDiscountID.getText()), discountPrice);
        }
        
        
        
        try {
            String pdfFilePath = "invoice.pdf";
            System.out.println(pdfFilePath);
            Document document = new Document(PageSize.A5);
            PdfWriter.getInstance(document, new FileOutputStream(pdfFilePath));
            document.open();
            
            
            BaseFont customBaseFont = BaseFont.createFont("font/Roboto-Italic.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font customFont = new Font(customBaseFont, 12);
            
            
            Image image = Image.getInstance("src//GUI//Comp//Icon//logo.jpg");
            image.scaleToFit(50, 50);
            
            PdfPTable tbHeader = new PdfPTable(3);
            tbHeader.setWidthPercentage(100);
            tbHeader.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
            float[] colHeader = {15f, 10f, 40f};
            tbHeader.setWidths(colHeader);
            
            tbHeader.addCell(image);
            tbHeader.addCell(new Paragraph(""));
            PdfPTable tbSubHeader = new PdfPTable(2);
            tbSubHeader.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
            float[] colSubHeader = {10f, 25f};
            tbSubHeader.setWidths(colSubHeader);
            
            tbSubHeader.addCell(new Paragraph(" "));
            tbSubHeader.addCell(new Paragraph("999 Nguyen Trai, District 5, Ho Chi Minh City"));
            tbSubHeader.addCell(new Paragraph(" "));
            tbSubHeader.addCell(new Paragraph("0399999999999"));
            tbHeader.addCell(tbSubHeader);
            
            
            // Add content to the PDF
            Paragraph header = new Paragraph("Invoice", FontFactory.getFont(FontFactory.HELVETICA,18,Font.BOLD));
            header.setAlignment(Paragraph.ALIGN_CENTER);
            Paragraph line = new Paragraph("----------------------------------------------------------", FontFactory.getFont(FontFactory.HELVETICA,18,Font.ITALIC));
            line.setAlignment(Paragraph.ALIGN_CENTER);
  
            
            
//            document.add(image);
            document.add(tbHeader);
            document.add(header);
            document.add(line);
            
            
            
            PdfPTable tbInformation = new PdfPTable(2);
            tbInformation.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
            tbInformation.setWidthPercentage(100);
            float[] colInformation = {25f,35f};
            tbInformation.setWidths(colInformation);

            // Add content to the table
            
            tbInformation.addCell(new Paragraph("Invoice ID #:"));
            tbInformation.addCell(new Paragraph(invoice.getId() + ""));
            tbInformation.addCell(new Paragraph("Date:"));
            tbInformation.addCell(new Paragraph(Helper.Format.formatDate.format(new Date()) + ""));
            tbInformation.addCell(new Paragraph("Employee:"));
            String nameStaff = StaffDTO.staffLogging.getLast_name() + " " + StaffDTO.staffLogging.getFirst_name();
            tbInformation.addCell(new Paragraph(nameStaff, customFont));
            tbInformation.addCell(new Paragraph("Table:"));
            tbInformation.addCell(new Paragraph(table.getName()));
            

            document.add(tbInformation);
            
            Paragraph line1 = new Paragraph("----------------------------------------------------------", FontFactory.getFont(FontFactory.HELVETICA,18,Font.ITALIC));
            document.add(line1);
            document.add(new Paragraph(" "));
            
            
            PdfPTable tbDetails = new PdfPTable(4);
            tbDetails.setWidthPercentage(100);
            float[] colDetails = {50f, 15f, 20f, 20f};
            tbDetails.setWidths(colDetails);
            
            
            
            
            PdfPCell cellName = new PdfPCell(new Paragraph("Name"));
            PdfPCell cellQuantity = new PdfPCell(new Paragraph("Quantity"));
            PdfPCell cellPrice = new PdfPCell(new Paragraph("Price"));
            PdfPCell cellTotal = new PdfPCell(new Paragraph("Total"));

            tbDetails.addCell(cellName);
            tbDetails.addCell(cellQuantity);
            tbDetails.addCell(cellPrice);
            tbDetails.addCell(cellTotal);
            
            for (DetailOrderDTO x : listDetailOrder) {
                Paragraph name = new Paragraph(x.getName(), customFont);
                Paragraph quantity = new Paragraph(x.getQuantity() + "", customFont);
                Paragraph price = new Paragraph(Helper.Format.formatNumber.format(x.getPrice()), customFont);
                Paragraph total = new Paragraph(Helper.Format.formatNumber.format(x.getTotal()), customFont);
                tbDetails.addCell(name);
                tbDetails.addCell(quantity);
                tbDetails.addCell(price);
                tbDetails.addCell(total);
            }
            
            
            document.add(tbDetails);
     
            document.add(new Paragraph(" "));
            
            
  
            PdfPTable tbPay = new PdfPTable(3);
            tbPay.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
            tbPay.setWidthPercentage(100);
            float[] colPay = {100f,35f,30f};
            tbPay.setWidths(colPay);

            // Add content to the table
            tbPay.addCell(new Paragraph(""));
            tbPay.addCell(new Paragraph("Sub total:"));
            tbPay.addCell(new Paragraph(Helper.Format.formatNumber.format(amount)));
            tbPay.addCell(new Paragraph(""));
            tbPay.addCell(new Paragraph("Discount:"));
            tbPay.addCell(new Paragraph(Helper.Format.formatNumber.format(discountPrice)));
            tbPay.addCell(new Paragraph(""));
            tbPay.addCell(new Paragraph("Total:"));
            tbPay.addCell(new Paragraph(Helper.Format.formatNumber.format(total)));
            

            
            // Add the table to the document
            document.add(tbPay);
            
            document.close();
            JOptionPane.showMessageDialog(rootPane, "In thành công !!");
            
            Desktop desktop = Desktop.getDesktop();
            File file = new File(pdfFilePath);
            desktop.open(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DialogChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(DialogChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DialogChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnInBillActionPerformed

    
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogChiTietHoaDon dialog = new DialogChiTietHoaDon(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel background;
    private javax.swing.JButton btnInBill;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbBan;
    private javax.swing.JLabel lbThanhTien;
    private javax.swing.JLabel lbTienGiam;
    private javax.swing.JLabel lbTongTien;
    private GUI.Comp.Swing.PanelBackground panelBackground1;
    private GUI.Comp.Swing.PanelBackground panelBackground2;
    private GUI.Comp.Swing.PanelBackground panelBackground3;
    private GUI.Comp.Swing.PanelBackground panelBackground8;
    private javax.swing.JPanel pnNorth;
    private javax.swing.JTable tbMonAn;
    private javax.swing.JTextField txtSaveDiscountID;
    // End of variables declaration//GEN-END:variables
}
