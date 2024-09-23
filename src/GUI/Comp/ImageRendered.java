/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.Comp;

import java.awt.Component;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author quang
 */
public class ImageRendered extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
         URL imagePath = getClass().getResource("/GUI/ImageProduct/" + value.toString());
         ImageIcon imageIcon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
         return new JLabel(imageIcon);
    }

   
    
}
    

    
    
//    public ImageIcon createImage(String urlImage) {
//        try {
//            URL url = new URL(urlImage);
//            Image image = new ImageIcon(url).getImage();
//            Image scaleImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
//            return new ImageIcon(scaleImage);
//        }
//        catch(Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    

