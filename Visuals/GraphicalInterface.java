package Visuals;

import java.awt.*;
import javax.swing.*;

public class GraphicalInterface extends JFrame{
    private JPanel panel;

    public GraphicalInterface(JPanel input) {
        setTitle("Simulation");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = input;

        add(panel);
        repaint();
        revalidate();
        setVisible(true);
    }
    
    public void updatePanel(JPanel newPanel) {
        remove(panel);
        panel = newPanel;
        add(panel);
        revalidate();
        repaint();
    }
}
