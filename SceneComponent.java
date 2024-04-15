

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JComponent;

/**
 * SceneComponent manages a list of SceneShapes and handles drawing and user interactions.
 */
public class SceneComponent extends JComponent 
    {
    private ArrayList<SceneShape> shapes;
    private SceneShape selectedShape;

    public SceneComponent() 
        {
        shapes = new ArrayList<>();
        selectedShape = null;

        setBackground(Color.WHITE); // Set a different color to confirm component visibility
        setOpaque(true); // Make sure the component is opaque to show background
    // Other initialization code...
        
        // Mouse listener to handle shape selection
        MouseAdapter mouseAdapter = new MouseAdapter() 
            {
            @Override
            public void mouseClicked(MouseEvent e) 
                {
                boolean found = false; // flag to track if a shape is found
                for (int i = shapes.size() - 1; i >= 0; i--) 
                    {
                    SceneShape shape = shapes.get(i);
                    if (shape.getBounds().contains(e.getPoint())) 
                        {
                        selectedShape = shape;
                        found = true;
                        break;
                        }
                    }
                if (!found) 
                    {
                    selectedShape = null;
                    System.out.println("No shape found at click location");  // Debugging statement
                    }
                    repaint();
                }
            };
             // Add the mouse listener to this component
        this.addMouseListener(mouseAdapter);
        }
           /**
     * Adds a new shape to the component.
     * @param shape the shape to be added
     */
    public void add(SceneShape shape) 
        {
        shapes.add(shape);
        repaint();
        }


// Removes the shape from the component.

public void removeSelected() 
    {
    if (selectedShape != null) 
        {
        System.out.println("Removing selected shape");
        shapes.remove(selectedShape);
        selectedShape = null;
        repaint();
        } 
        else 
            {
            System.out.println("No shape selected to remove");
            }
        }

@Override
protected void paintComponent(Graphics g) 
    {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    System.out.println("Painting component with " + shapes.size() + " shapes");
    for (SceneShape shape : shapes) 
        {
        shape.draw(g2);
        if (shape.equals(selectedShape)) 
            {
            System.out.println("Drawing selection for a shape");
            shape.drawSelection(g2);
            }
        }
    }
}
    
