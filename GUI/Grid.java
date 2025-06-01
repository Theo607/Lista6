package GUI;

import javax.swing.*;
import java.awt.*;

import GRID.AnimalState;
import GRID.Position;

public class Grid extends JPanel {
    
    private Cell[][] gridCells;

    public Grid(int width, int height) {
        setLayout(new GridLayout(height, width));
        gridCells = new Cell[height][width];

        AnimalState emptyState = new AnimalState(-1, "");
        gridCells = new Cell[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                gridCells[i][j] = new Cell(emptyState);
                add(gridCells[i][j]);
            }
        }
        
        setPreferredSize(new Dimension(width * 50, height * 50));
    }

    public void refreshGrid(AnimalState[] states, int[][] indexes) {
        if (states == null || states.length != gridCells.length * gridCells[0].length) {
            throw new IllegalArgumentException("States array length does not match grid dimensions.");
        }

        this.removeAll();
        
        AnimalState emptyState = new AnimalState(-1, "");

        for(int i = 0; i < gridCells.length; i++) {
            for (int j = 0; j < gridCells[i].length; j++) {
                int index = indexes[i][j];
                if (index >= 0 && index < states.length) {
                    gridCells[i][j] = new Cell(states[index]);
                } else {
                    gridCells[i][j] = new Cell(emptyState);
                }
                add(gridCells[i][j]);
            }
        }
        revalidate();
        repaint();
    }

}
