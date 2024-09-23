/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.Comp;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author quang
 */
public class AvatarProduct extends JComponent{
    private Icon image;
    private int borderSize = 6;
    private int borderSpace = 5;
    
    
    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
        repaint();
    }

    public int getBorderSize() {
        return borderSize;
    }

    public void setBorderSize(int borderSize) {
        this.borderSize = borderSize;
        repaint();
    }

    public int getBorderSpace() {
        return borderSpace;
    }

    public void setBorderSpace(int borderSpace) {
        this.borderSpace = borderSpace;
        repaint();
    }


 @Override
protected void paintComponent(Graphics grphcs) {
    Graphics2D g2 = (Graphics2D) grphcs;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    if (image != null) {
        int width = getWidth();
        int height = getHeight();
        int diameter = Math.min(width, height) - (borderSize * 2 + borderSpace * 2);
        int x = (width - diameter) / 2;
        int y = (height - diameter) / 2;
        Rectangle size = getAutoSize(image, diameter);
        BufferedImage img = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2_img = img.createGraphics();
        g2_img.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Fill the entire area with the image
        g2_img.drawImage(toImage(image), 0, 0, size.width, size.height, null);
        g2_img.dispose();
        
        // Bo góc của ảnh đã fill
        Area area = new Area(new RoundRectangle2D.Double(x, y, diameter, diameter, 20, 20));  // Điều chỉnh bán kính góc bo ở đây
        g2.setClip(area);
        g2.drawImage(img, x, y, null);
        g2.setClip(null); // Reset Clip để không ảnh hưởng đến các vẽ sau này
    }
    super.paintComponent(grphcs);
}

    private Rectangle getAutoSize(Icon image, int size) {
        int w = size;
        int h = size;
        int iw = image.getIconWidth();
        int ih = image.getIconHeight();
        double xScale = (double) w / iw;
        double yScale = (double) h / ih;
        double scale = Math.max(xScale, yScale);
        int width = (int) (scale * iw);
        int height = (int) (scale * ih);
        if (width < 1) {
            width = 1;
        }
        if (height < 1) {
            height = 1;
        }
        int cw = size;
        int ch = size;
        int x = (cw - width) / 2;
        int y = (ch - height) / 2;
        return new Rectangle(new Point(x, y), new Dimension(width, height));
    }

    private Image toImage(Icon icon) {
        return ((ImageIcon) icon).getImage();
    }
}
