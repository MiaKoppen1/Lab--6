import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SceneEditor 
    {
    public static void main(String[] args) 
        {
        SwingUtilities.invokeLater(() -> 
            {
            JFrame frame = new SceneFrame();
            frame.setVisible(true);
            });
        }
    }

