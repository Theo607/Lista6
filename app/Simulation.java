package app;

import javax.swing.*;
import java.awt.*;
import AnimalsGrid.*;
import Visuals.*;

public class Simulation {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WelcomePanel welcomePanel = new WelcomePanel();
            JButton startButton = welcomePanel.getStartButton();

            JFrame welcomeFrame = new JFrame("Welcome");
            welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            welcomeFrame.setSize(400, 300);
            welcomeFrame.add(welcomePanel);
            welcomeFrame.setVisible(true);

            startButton.addActionListener(e -> {
                try {
                    int[] numbers = welcomePanel.getNumbers();
                    int n = numbers[0];
                    int m = numbers[1];
                    int k = numbers[2];
                    int numHares = numbers[3];

                    Setup setup = new Setup(n, m, numHares, k);
                    System.err.println("Grid size: " + n + "x" + m);
                    System.err.println("Number of Hares: " + numHares);
                    setup.startSimulation();
                    Wolf wolf = (Wolf) setup.animals[0];

                    JFrame frame = new JFrame("Simulation");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(800, 600);
                    frame.setLayout(new BorderLayout());
                    GridPanel gridpanel = new GridPanel(setup.grid);
                    frame.add(gridpanel, BorderLayout.CENTER);
                    frame.setVisible(true);

                    // Periodically update the grid
                    new Timer(100, ev -> {
                        gridpanel.repaint();
                        if (wolf.winStatus) {
                            ((Timer) ev.getSource()).stop();
                            JOptionPane.showMessageDialog(frame, "Simulation finished!");
                        }
                    }).start();

                    welcomeFrame.dispose(); // Close the welcome window

                } catch (Exception ex) {
                    ex.printStackTrace(); // Prints the full stack trace to the console
                    JOptionPane.showMessageDialog(
                            welcomePanel,
                            "Invalid input. Exception: " + ex.getClass().getSimpleName() + "\n" + ex.getMessage());
                }
            });
        });
    }
}
