
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * SceneFrame extends JFrame and sets up the scene component and interaction buttons.
 */
public class SceneFrame extends JFrame 
    {
    public SceneFrame() 
        {
        setTitle("Scene Editor");
        setSize(600, 300);  // Default size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the scene component where shapes will be drawn and interacted with
        SceneComponent scene = new SceneComponent();

        // Create buttons and define their actions
        JButton houseButton = new JButton("House");

        houseButton.addActionListener(new ActionListener() 
            {
            public void actionPerformed(ActionEvent event) 
                {
                scene.add(new HouseShape(20, 20, 50));
                }
            });

        JButton carButton = new JButton("Car");

        carButton.addActionListener(new ActionListener() 
            {
            public void actionPerformed(ActionEvent event) 
                {
                scene.add(new CarShape(20, 20, 50));
                }
            });

            JButton stopSignButton = new JButton("Stop Sign");

            carButton.addActionListener(new ActionListener() 
                {
                public void actionPerformed(ActionEvent event) 
                    {
                    scene.add(new StopSignShape(20, 20, 50));
                    }
                });

            JButton truckButton = new JButton("Truck");

            carButton.addActionListener(new ActionListener() 
                {
                public void actionPerformed(ActionEvent event) 
                    {
                    scene.add(new TruckShape(20, 20, 50));
                    }
                });

            JButton removeButton = new JButton("Remove");
            removeButton.addActionListener(new ActionListener() 
                {
                public void actionPerformed(ActionEvent event) 
                    {
                    System.out.println("Remove button clicked");
                    scene.removeSelected();
                    }
                });

        // Panel to hold the buttons
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(houseButton);
        buttonsPanel.add(carButton);
        buttonsPanel.add(truckButton);
        buttonsPanel.add(stopSignButton);
        buttonsPanel.add(removeButton);

        // Add the scene and buttons panel to the frame
        add(scene, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.NORTH);
        }
    }