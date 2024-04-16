
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;

public class StopSignShape implements SceneShape 
    {
    private int x, y, size;
    private Polygon polygon;

    public StopSignShape(int x, int y, int size) 
        {
        this.x = x;
        this.y = y;
        this.size = size;
        this.polygon = createOctagon(x, y, size);
        }

    private Polygon createOctagon(int x, int y, int size) 
        {
        int r = size / 2; // Radius of circumscribed circle
        int[] xPoints = new int[8];
        int[] yPoints = new int[8];
        for (int i = 0; i < 8; i++) 
            {
            xPoints[i] = (int) (x + r * Math.cos(i * 2 * Math.PI / 8));
            yPoints[i] = (int) (y + r * Math.sin(i * 2 * Math.PI / 8));
            }
        return new Polygon(xPoints, yPoints, 8);
        }

    @Override
    public void draw(Graphics2D g2) 
        {
        g2.setColor(Color.RED);
        g2.fill(polygon);
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial", Font.BOLD, size / 4));
        FontMetrics metrics = g2.getFontMetrics();
        String label = "STOP";
        int labelWidth = metrics.stringWidth(label);
        int labelHeight = metrics.getHeight();
        g2.drawString(label, x - labelWidth / 2, y + labelHeight / 4);
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
        g2.fillRect(x - handleSize / 2, y - handleSize / 2, handleSize, handleSize);
        g2.fillRect(x + width - handleSize / 2, y - handleSize / 2, handleSize, handleSize);
        g2.fillRect(x - handleSize / 2, y + height - handleSize / 2, handleSize, handleSize);
        g2.fillRect(x + width - handleSize / 2, y + height - handleSize / 2, handleSize, handleSize);
        }

    @Override
    public Rectangle getBounds() 
        {
        return polygon.getBounds();
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


