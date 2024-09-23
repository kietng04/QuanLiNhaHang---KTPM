/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.Comp.Dialog;

/**
 *
 * @author Tai
 */
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BillDetailDialog extends JDialog {
    public BillDetailDialog(JFrame parent, String title, String detailInfo) {
        super(parent, title, true);
        JTextArea textArea = new JTextArea(detailInfo);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);
        pack();
        setLocationRelativeTo(null); // Hiển thị dialog ở giữa màn hình
    }
}