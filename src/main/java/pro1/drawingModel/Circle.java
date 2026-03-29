package pro1.drawingModel;

import java.awt.*;

public class Circle extends XY {
    private int radius;

    public Circle(int x, int y, int radius) {

    super(x,y);
    this.radius =radius;

    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.red);
        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
        g.setColor(Color.black);
        g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
        ;
    }
}



