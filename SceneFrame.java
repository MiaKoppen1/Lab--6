
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SceneFrame extends JFrame 
    {
    public SceneFrame() 
        {
        setTitle("Scene Editor");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SceneComponent scene = new SceneComponent();

        JButton houseButton = new JButton("House");
        JButton carButton = new JButton("Car");
        JButton truckButton = new JButton("Truck");
        JButton stopSignButton = new JButton("Stop Sign");
        JButton removeButton = new JButton("Remove");

         // Set up action listeners
        houseButton.addActionListener(e -> scene.add(new HouseShape(20, 20, 50)));
        carButton.addActionListener(e -> scene.add(new CarShape(20, 20, 20)));
        truckButton.addActionListener(e -> scene.add(new TruckShape(20, 20, 20)));
        stopSignButton.addActionListener(e -> scene.add(new StopSignShape(20, 20, 20)));
        removeButton.addActionListener(e -> scene.removeSelected());

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(houseButton);
        buttonsPanel.add(carButton);
        buttonsPanel.add(truckButton);
        buttonsPanel.add(stopSignButton);
        buttonsPanel.add(removeButton);

        add(scene, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.NORTH);
        }
    }
