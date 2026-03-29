package pro1.drawingModel;

import java.awt.*;

public class Line implements Drawable {

private XY start, end;

public Line (XY start, XY end)
{
    this.start = start;
    this.end = end;
}
@Override
public void draw(Graphics2D g)
{
    g.setColor(Color.blue);
    g.drawLine(start.x, start.y, end.x, end.y);
}
}
