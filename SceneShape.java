
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
public interface SceneShape 
    {
    void draw(Graphics2D g2);
    void drawSelection(Graphics2D g2);
    Rectangle2D getBounds();
    int getX();
    int getY();
    void setPosition(int x, int y);
    }
