
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public interface SceneShape 
    {
    void draw(Graphics2D g2);

    void drawSelection(Graphics2D g2);

    Rectangle2D getBounds();
    }
/**
 * The SceneShape interface should be implemented by all graphical shapes
 * that are to be part of the scene editor. It defines the basic methods required
 * for drawing the shape and indicating selection state, as well as obtaining the
 * bounding box of the shape.
 */