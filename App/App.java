package App;

import GRID.*;
import GUI.*;
import javax.swing.*;

public class App {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setTitle("Simulation");
        mainFrame.setSize(800, 600);
        WelcomePanel welcomePanel = new WelcomePanel();
        mainFrame.add(welcomePanel);
        mainFrame.setVisible(true);

        while(welcomePanel.isStarted() == false) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int width = welcomePanel.getWidthValue();
        int height = welcomePanel.getHeightValue();
        int speed = welcomePanel.getSpeedValue();
        int hare = welcomePanel.getHareValue();

        mainFrame.remove(welcomePanel);
        mainFrame.repaint();

        GridPanel gridPanel = new GridPanel(width, height);
        Rng rng = new Rng();

        Grid grid = new Grid(width, height, hare, rng);
        gridPanel.refreshGrid(grid.getCellTypes());
        



        mainFrame.setSize(width * 125 + 50, height * 125 + 250);
        mainFrame.add(gridPanel);
        mainFrame.repaint();
        mainFrame.setVisible(true);

        
    }
}