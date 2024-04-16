import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;  // Import statement for ArrayList

import javax.swing.JComponent;

public class SceneComponent extends JComponent 
    {
    private ArrayList<SceneShape> shapes;
    private SceneShape selectedShape;
    private boolean dragging;
    private int prevX, prevY;

    public SceneComponent() 
        {
        shapes = new ArrayList<>();
        selectedShape = null;
        dragging = false;

        setBackground(Color.WHITE);
        setOpaque(true);

        MouseAdapter mouseAdapter = new MouseAdapter() 
            {
            @Override
            public void mousePressed(MouseEvent e) 
                {
                SceneShape prevSelected = selectedShape;
                selectedShape = null;
                for (int i = shapes.size() - 1; i >= 0; i--) 
                    {
                    SceneShape shape = shapes.get(i);
                    if (shape.getBounds().contains(e.getPoint())) 
                        {
                        selectedShape = shape;
                        if (selectedShape != prevSelected) 
                            {
                            repaint();
                            }
                        prevX = e.getX();
                        prevY = e.getY();
                        dragging = true;
                        break;
                        }
                    }
                if (selectedShape == null) 
                    {
                    repaint();
                    }
                }

            @Override
            public void mouseDragged(MouseEvent e) 
                {
                if (dragging && selectedShape != null) 
                    {
                    int deltaX = e.getX() - prevX;
                    int deltaY = e.getY() - prevY;
                    selectedShape.setPosition(selectedShape.getX() + deltaX, selectedShape.getY() + deltaY);
                    prevX = e.getX();
                    prevY = e.getY();
                    repaint();
                    }
                }

            @Override
            public void mouseReleased(MouseEvent e) 
                {
                dragging = false;
                }
            };
        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
        }

    @Override
    protected void paintComponent(Graphics g) 
        {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (SceneShape shape : shapes) 
            {
            shape.draw(g2);
            if (shape.equals(selectedShape)) 
                {
                shape.drawSelection(g2);
                }
            }
        }

    public void add(SceneShape shape) 
        {
        shapes.add(shape);
        repaint();
        }

    public void removeSelected() 
        {
        if (selectedShape != null) 
            {
            shapes.remove(selectedShape);
            selectedShape = null;
            repaint();
            }
        }
    }
