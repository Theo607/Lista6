package app;

import javax.swing.*;
import AnimalsGrid.*;
import Visuals.*;

public class Simulation {
    public static void main(String[] args) {
        try {
            int n;
            int m;
            int k;
            int numHares;
            WelcomePanel welcomePanel = new WelcomePanel();
            StartButton startButton = welcomePanel.getStartButton();
            GraphicalInterface graphicalInterface = new GraphicalInterface(welcomePanel);
            if (startButton.isClicked()) {
                int[] numbers = welcomePanel.getNumbers();
                n = numbers[0];
                m = numbers[1];
                k = numbers[2];
                numHares = numbers[3];
                Setup setup = new Setup(n, m, numHares, k);
                setup.startSimulation();
                Wolf wolf = (Wolf) setup.animals[0];
                GridPanel gridpanel = new GridPanel(n, m, 20);
                while (wolf.winStatus == false) {
                    String[][] grid = setup.getGrid();
                    gridpanel.setGrid(grid);
                    graphicalInterface.updatePanel(gridpanel);
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please provide three integers.");
            return;
        }

    }
}
