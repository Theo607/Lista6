package App;

import GRID.*;
import GUI.*;
import javax.swing.*;
import java.awt.*;

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
        Rng rng = new Rng();
        Parameters parameters = new Parameters(width, height, speed, hare, rng);
        GridPanel gridPanel = new GridPanel(width, height);

        mainFrame.remove(welcomePanel);
        mainFrame.setSize(width * 125 + 50, height * 125 + 50);
        mainFrame.add(gridPanel);
        mainFrame.repaint();
        mainFrame.setVisible(true);

        int refreshRate = (int)Math.floor(speed * 0.1);
        Field field = new Field(parameters);
        
        Wolf wolf = new Wolf(parameters, field);
        Hare[] hares = new Hare[hare];
        for(int i = 0; i < hare; i++) {
            hares[i] = new Hare(parameters, field, i);
            hares[i].start(); 
        }

        Timer timer = new Timer(refreshRate, e -> {
            boolean[][] clicked = gridPanel.getClickedCells();
            for(int i = 0; i < height; i++) {
                for(int j = 0; j < width; j++) {
                    if(wolf.getPosition().getX() == j && wolf.getPosition().getY() == i) {
                        wolf.setClicked(clicked[i][j]);
                    } else if(clicked[i][j]) {
                        for(Hare hareThread : hares) {
                            if(hareThread.getPosition().getX() == j && hareThread.getPosition().getY() == i) {
                                hareThread.setClicked(clicked[i][j]);
                            }
                        }
                    }
                }
            }

            gridPanel.refreshGrid(field.getField());
            gridPanel.repaint();
        });
        timer.start();
        
    }
}