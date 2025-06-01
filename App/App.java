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
        Start start = new Start();
        mainFrame.add(start);
        mainFrame.setVisible(true);

        while(start.isStarted() == false) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int width = start.getWidthValue();
        int height = start.getHeightValue();
        int speed = start.getSpeedValue();
        int hare = start.getHareValue();
        int refreshRate = (int)Math.floor(speed * 0.1);

        Rng rng = new Rng();
        Parameters parameters = new Parameters(width, height, speed, hare, rng);

        Field field = new Field(parameters);

        Animal[] animals = new Animal[hare+1];
        for(int i = 0; i < hare + 1; i++) {
            if(i == 0) {
                animals[i] = new Wolf(field);
            } else {
                animals[i] = new Hare(i, field);
            }
        }

        for (Animal animal : animals) {
            field.addAnimal(animal, animal.getAnimalState().getIndex());
        }

        for (Animal animal : animals) {
            animal.start();
        }

        Grid grid = new Grid(width, height);
        mainFrame.remove(start);
        mainFrame.setSize(width * 125 + 50, height * 125 + 50);
        mainFrame.add(grid);
        mainFrame.repaint();
        mainFrame.setVisible(true);


        Timer timer = new Timer(refreshRate, e -> {
            grid.refreshGrid(field.getStates(), field.getIndexes());
            grid.repaint();
        });
        timer.start();
        
    }
}