package pro1.drawingModel;
import pro1.Main;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class Group extends XY {

    Drawable[] items;
    double rotationDegrees;
    double scaleX;
    double scaleY;


public Group(Drawable[] items, int x, int y, double rotationDegrees, double scaleX, double scaleY) {
    super(x,y);
        this.items = items;
        this.rotationDegrees = rotationDegrees;
        this.scaleX = scaleX;
        this.scaleY = scaleY;


}

@Override
public void draw(Graphics2D g) {
    AffineTransform transform = g.getTransform();
    g.translate(x,y);
    g.rotate(Math.toRadians((rotationDegrees)));
    g.scale(scaleX, scaleY);
     for (var item:items)
         item.draw(g);
         //
         // Vykresli všechny items tak, aby
    // na ně bylo aplikováno x,y,rotationDegrees,scaleX,scaleY
    g.setTransform(transform);
}
}