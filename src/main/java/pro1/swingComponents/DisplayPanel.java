package pro1.swingComponents;

import pro1.drawingModel.Drawable;

import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JPanel {

    Drawable drawable = null;

    public DisplayPanel ()
    {
        this.setBackground(Color.WHITE);
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
        repaint();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (drawable != null)
            drawable.draw((Graphics2D) g);
    }
}