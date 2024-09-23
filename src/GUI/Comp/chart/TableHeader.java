package GUI.Comp.chart;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;


public class TableHeader extends JLabel {

    public TableHeader(String text) {
        super(text);
        setOpaque(true);
        setBackground(new Color(35,35,35));
        setFont(new java.awt.Font("roboto", 1, 14));
        setForeground(new Color(255,255,255));
        setBorder(new EmptyBorder(10, 5, 10, 5));
    }
}
