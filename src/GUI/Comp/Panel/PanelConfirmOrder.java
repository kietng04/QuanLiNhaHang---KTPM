package GUI.Comp.Panel;

import Helper.MyListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelConfirmOrder extends javax.swing.JPanel {
   
    private String nameProduct;
    private int quantity = 1;
    private long price = 0;
    private long total = quantity * price;
    private boolean isDelete = false;
    
    public PanelConfirmOrder() {
        initComponents();
        serviceListener();
        setBackground(new Color(0,0,0,0));
        pnContainer.setColor(new Color(53, 53, 53));
    }

    public void insertData(String nameProduct, long price, int quantity) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity = quantity;
        this.total = price * quantity;
        update();
    }

    
    
    public void update() {
        if (quantity == 0) {
//            this.getParent().remove(this);
            isDelete = true;
            return;
            
        }
        lbNameProduct.setText(nameProduct);
        total = quantity * price;
        lbTotal.setText(Helper.Format.formatNumber.format(total) + "đ");
        tfQuantity.setText(quantity + "");
    }
    
    public void serviceListener() {
        btnDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (quantity > 0) {
                    tfQuantity.setText(--quantity + "");
                    if (quantity == 0) {
                        MyListener.getInstance().firePropertyChange("Quantity0", "", nameProduct);
                    }
                    else {
                        MyListener.getInstance().firePropertyChange("Order", nameProduct,  quantity);
                    }
                }
                update();
                System.out.println(quantity + " " + total);
                
            }
        });
        btnUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfQuantity.setText(++quantity + "");
                MyListener.getInstance().firePropertyChange("Order", nameProduct, quantity);
                update();
                System.out.println(quantity + " " + total);
            }
            
        });
        
        tfQuantity.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                quantity = Integer.parseInt(tfQuantity.getText());
                MyListener.getInstance().firePropertyChange("Order", nameProduct, quantity);
                update();
                System.out.println(quantity + " " + total);
            }
        
        
        });
        
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public long getTotal() {
        return total;
    }

    
    
    public int getQuantity() {
        return quantity;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

 
    
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnContainer = new GUI.Comp.Swing.PanelBackground();
        lbNameProduct = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        pnSpinner = new GUI.Comp.Swing.PanelBackground();
        btnDown = new javax.swing.JButton();
        btnUp = new javax.swing.JButton();
        tfQuantity = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        pnContainer.setBackground(new java.awt.Color(35, 35, 35));

        lbNameProduct.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lbNameProduct.setForeground(new java.awt.Color(255, 255, 255));
        lbNameProduct.setText("Tôm sốt Mayonese trái thơm");

        lbTotal.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lbTotal.setForeground(new java.awt.Color(255, 255, 255));
        lbTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTotal.setText("đ12.800.000");
        lbTotal.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        pnSpinner.setBackground(new java.awt.Color(53, 53, 53));

        btnDown.setBackground(new java.awt.Color(204, 204, 204));
        btnDown.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnDown.setForeground(new java.awt.Color(102, 102, 102));
        btnDown.setText("-");
        btnDown.setBorderPainted(false);

        btnUp.setBackground(new java.awt.Color(52, 188, 137));
        btnUp.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnUp.setForeground(new java.awt.Color(255, 255, 255));
        btnUp.setText("+");
        btnUp.setBorderPainted(false);

        tfQuantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfQuantity.setText("1");
        tfQuantity.setMaximumSize(new java.awt.Dimension(2147483647, 24));
        tfQuantity.setMinimumSize(new java.awt.Dimension(64, 24));
        tfQuantity.setPreferredSize(new java.awt.Dimension(64, 24));

        javax.swing.GroupLayout pnSpinnerLayout = new javax.swing.GroupLayout(pnSpinner);
        pnSpinner.setLayout(pnSpinnerLayout);
        pnSpinnerLayout.setHorizontalGroup(
            pnSpinnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSpinnerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDown, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnSpinnerLayout.setVerticalGroup(
            pnSpinnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnSpinnerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnSpinnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDown)
                    .addComponent(btnUp))
                .addGap(7, 7, 7))
            .addGroup(pnSpinnerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tfQuantity.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout pnContainerLayout = new javax.swing.GroupLayout(pnContainer);
        pnContainer.setLayout(pnContainerLayout);
        pnContainerLayout.setHorizontalGroup(
            pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnContainerLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNameProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnContainerLayout.createSequentialGroup()
                        .addComponent(pnSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        pnContainerLayout.setVerticalGroup(
            pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnContainerLayout.createSequentialGroup()
                .addComponent(lbNameProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDown;
    private javax.swing.JButton btnUp;
    private javax.swing.JLabel lbNameProduct;
    private javax.swing.JLabel lbTotal;
    private GUI.Comp.Swing.PanelBackground pnContainer;
    private GUI.Comp.Swing.PanelBackground pnSpinner;
    private javax.swing.JTextField tfQuantity;
    // End of variables declaration//GEN-END:variables
}
