

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;


// car shape that implements the SceneShape interface.
public class CarShape implements SceneShape 
    {
    private int x, y, width;

    public CarShape(int x, int y, int width) 
        {
        this.x = x;
        this.y = y;
        this.width = width;   
        }

    @Override
    public void draw(Graphics2D g2) 
        {
        Rectangle2D.Double body = new Rectangle2D.Double(x, y + width / 6, width - 1, width / 6);
        Ellipse2D.Double frontTire = new Ellipse2D.Double(x + width / 6, y + width / 3, width / 6, width / 6);
        Ellipse2D.Double rearTire = new Ellipse2D.Double(x + width * 2 / 3, y + width / 3, width / 6, width / 6);
        // Build the roof and add it to the car body
        Point2D.Double r1 = new Point2D.Double(x + width / 6, y + width / 6);
        Point2D.Double r2 = new Point2D.Double(x + width / 3, y);
        Point2D.Double r3 = new Point2D.Double(x + width * 2 / 3, y);
        Point2D.Double r4 = new Point2D.Double(x + width * 5 / 6, y + width / 6);
        Line2D.Double frontWindshield = new Line2D.Double(r1, r2);
        Line2D.Double roofTop = new Line2D.Double(r2, r3);
        Line2D.Double rearWindshield = new Line2D.Double(r3, r4);

        g2.draw(body);
        g2.draw(frontTire);
        g2.draw(rearTire);
        g2.draw(frontWindshield);
        g2.draw(roofTop);
        g2.draw(rearWindshield);
        }

    @Override
    public Rectangle2D getBounds() 
        {
        return new Rectangle2D.Double(x, y, width, width / 2);
        }

        @Override
        public void drawSelection(Graphics2D g2) {
            Rectangle2D bounds = getBounds();
            g2.setColor(Color.GREEN);
            drawGrabbers(g2, bounds);
        }
        
        private void drawGrabbers(Graphics2D g2, Rectangle2D r) {
            double x1 = r.getX();
            double y1 = r.getY();
            double x2 = x1 + r.getWidth();
            double y2 = y1 + r.getHeight();
            final int SIZE = 8;  // Increased size for visibility
            g2.setColor(Color.BLACK);
            g2.fill(new Rectangle2D.Double(x1 - SIZE / 2, y1 - SIZE / 2, SIZE, SIZE));
            g2.fill(new Rectangle2D.Double(x2 - SIZE / 2, y1 - SIZE / 2, SIZE, SIZE));
            g2.fill(new Rectangle2D.Double(x1 - SIZE / 2, y2 - SIZE / 2, SIZE, SIZE));
            g2.fill(new Rectangle2D.Double(x2 - SIZE / 2, y2 - SIZE / 2, SIZE, SIZE));
        }
        
    @Override
    public int getX() 
        {
        return x;
        }

    @Override
    public void setPosition(int newX, int newY) 
        {
        this.y = newY;
        this.x = newX;
        }

   

    @Override
    public int getY() 
        {
        return y;
        }
    }

   
