/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Comp;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author quang
 */
public class Card extends javax.swing.JPanel {

    public Card() {
        initComponents();
        init();
    }

    private void init() {
        setOpaque(false);
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        int radius = 15; // This is the radius of the rounded corners
        int borderSize = 3; // This is the size of the border
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Color a = new Color(255, 102, 0, 255);
        Color b = new Color(0, 51, 51, 255);
        g2.setPaint(new GradientPaint(0, 0, a, getWidth(), 0, b));

        // Draw gradient on each edge
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius); // Fill the entire panel with rounded corners

        g2.setPaint(getBackground()); // Set the paint color to the background color of the panel

        // Draw over the inner part of the panel, effectively creating a border
        g2.fillRoundRect(borderSize, borderSize, getWidth() - 2 * borderSize, getHeight() - 2 * borderSize, radius, radius);

        g2.dispose();
    }

    public void setValue(int value) {
        lbValues.setText(value + "");
    }
    public void setTitle(String title) {
        lbTable.setText(title);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbValues = new javax.swing.JLabel();
        lbTable = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(200, 66));

        lbValues.setFont(new java.awt.Font("sansserif", 1, 25)); // NOI18N
        lbValues.setForeground(new java.awt.Color(128, 128, 128));
        lbValues.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbValues.setText("45");

        lbTable.setFont(new java.awt.Font("sansserif", 3, 18)); // NOI18N
        lbTable.setForeground(new java.awt.Color(128, 128, 128));
        lbTable.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTable.setText("TỔNG BÀN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lbValues, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTable)
                    .addComponent(lbValues))
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbTable;
    private javax.swing.JLabel lbValues;
    // End of variables declaration//GEN-END:variables
}
