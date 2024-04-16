import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class TruckShape implements SceneShape 
    {
    private int x, y, width;
    private Rectangle2D.Double body;
    private Rectangle2D.Double cargo;
    private Ellipse2D.Double frontWheel;
    private Ellipse2D.Double rearWheel;

    public TruckShape(int x, int y, int width) 
        {
        this.x = x;
        this.y = y;
        this.width = width;
        // Main body of the truck
        this.body = new Rectangle2D.Double(x, y + width / 6, width, width / 3);
        // Cargo area
        this.cargo = new Rectangle2D.Double(x + width * 0.5, y, width * 0.5, width / 3);
        // Wheels
        int wheelRadius = width / 6;
        this.frontWheel = new Ellipse2D.Double(x + width * 0.1, y + width * 2 / 3 * 0.5, wheelRadius, wheelRadius);
        this.rearWheel = new Ellipse2D.Double(x + width * 0.7, y + width * 2 / 3 * 0.5, wheelRadius, wheelRadius);
        }

    @Override
    public void draw(Graphics2D g2) 
        {
        g2.setColor(Color.BLUE);
        g2.fill(body);
        g2.fill(cargo);
        g2.setColor(Color.BLACK);
        g2.fill(frontWheel);
        g2.fill(rearWheel);
        }

    @Override
    public void drawSelection(Graphics2D g2) 
        {
        g2.setColor(Color.BLACK);
        Rectangle bounds = getBounds();
        int handleSize = 6;
        int x = bounds.x;
        int y = bounds.y;
        int width = bounds.width;
        int height = bounds.height;
        // Draw selection handles at each corner
        g2.fillRect(x - handleSize / 2, y - handleSize / 2, handleSize, handleSize);
        g2.fillRect(x + width - handleSize / 2, y - handleSize / 2, handleSize, handleSize);
        g2.fillRect(x - handleSize / 2, y + height - handleSize / 2, handleSize, handleSize);
        g2.fillRect(x + width - handleSize / 2, y + height - handleSize / 2, handleSize, handleSize);
        }

    @Override
    public Rectangle getBounds() 
        {
        // The bounds are calculated to include the body and cargo
        return new Rectangle(x, y, width, width / 2);
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

