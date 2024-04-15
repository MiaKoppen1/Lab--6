
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class HouseShape implements SceneShape 
    {
    private int x, y, width;
    private Rectangle2D bounds;

    public HouseShape(int x, int y, int width) 
        {
        this.x = x;
        this.y = y;
        this.width = width;
        this.bounds = new Rectangle2D.Double(x, y, width, width); // Assuming height equals width
        }

    @Override
    public void draw(Graphics2D g2) 
        {
        // Draw the main part of the house
        g2.draw(new Rectangle2D.Double(x, y + width / 2.0, width, width / 2.0));
        // Draw the roof
        g2.draw(new RoundRectangle2D.Double(x, y, width, width / 2.0, 10, 10));
        System.out.println("Drawing House at (" + x + ", " + y + ")");
        }

    @Override
    public void drawSelection(Graphics2D g2) 
        {
        // Draw a selection indicator (e.g., a dashed rectangle)
        float dash1[] = {10.0f};
        g2.setStroke(new java.awt.BasicStroke(1.0f, java.awt.BasicStroke.CAP_BUTT, java.awt.BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f));
        g2.draw(new Rectangle2D.Double(x - 5, y - 5, width + 10, width + 10));
        System.out.println("Drawing Selection for House at (" + x + ", " + y + ")");
        }

    @Override
    public Rectangle2D getBounds() 
        {
        return bounds;
        }
    }
