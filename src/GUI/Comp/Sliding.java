/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Comp;

import java.awt.Color;

/**
 *
 * @author quang
 */
public class Sliding extends javax.swing.JPanel  {

    /**
     * Creates new form Truot
     */
    public Sliding() {
        initComponents();
        panelBackground1.setBackground(new Color(75, 157, 248, 50));
        
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackground1 = new GUI.Comp.Swing.PanelBackground();
        panelBackground5 = new GUI.Comp.Swing.PanelBackground();

        panelBackground1.setBackground(new java.awt.Color(255, 204, 204));
        panelBackground1.setPreferredSize(new java.awt.Dimension(119, 30));
        panelBackground1.setRound(7);

        panelBackground5.setBackground(new java.awt.Color(255, 107, 39));
        panelBackground5.setPreferredSize(new java.awt.Dimension(5, 20));
        panelBackground5.setRound(5);

        javax.swing.GroupLayout panelBackground5Layout = new javax.swing.GroupLayout(panelBackground5);
        panelBackground5.setLayout(panelBackground5Layout);
        panelBackground5Layout.setHorizontalGroup(
            panelBackground5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        panelBackground5Layout.setVerticalGroup(
            panelBackground5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelBackground1Layout = new javax.swing.GroupLayout(panelBackground1);
        panelBackground1.setLayout(panelBackground1Layout);
        panelBackground1Layout.setHorizontalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelBackground5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        panelBackground1Layout.setVerticalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelBackground5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.Comp.Swing.PanelBackground panelBackground1;
    private GUI.Comp.Swing.PanelBackground panelBackground5;
    // End of variables declaration//GEN-END:variables
}
