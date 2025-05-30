package GUI;

import javax.swing.*;
import java.awt.*;

public class GridPanel extends JPanel {
    
    private GridCell[][] gridCells;
    private boolean[][] clickedCells;

    public GridPanel(int width, int height) {
        setLayout(new GridLayout(height, width));
        gridCells = new GridCell[height][width];
        clickedCells = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                gridCells[i][j] = new GridCell("");
                add(gridCells[i][j]);
                clickedCells[i][j] = gridCells[i][j].isClicked(); // Initialize clicked cells to false
            }
        }
        
        setPreferredSize(new Dimension(width * 50, height * 50));
    }

    public void refreshGrid(String[][] cellTypes) {
        if (cellTypes.length != gridCells.length || cellTypes[0].length != gridCells[0].length) {
            throw new IllegalArgumentException("Cell types array dimensions do not match grid dimensions.");
        }

        this.removeAll();

        for (int i = 0; i < gridCells.length; i++) {
            for (int j = 0; j < gridCells[i].length; j++) {
                gridCells[i][j].setCellType(cellTypes[i][j]);
                add(gridCells[i][j]);
                clickedCells[i][j] = gridCells[i][j].isClicked(); // Update clicked cells state
            }
        }

        repaint();
    }

    public boolean[][] getClickedCells() {
        return clickedCells;
    }

}
