package Visuals;

import java.awt.*;
import javax.swing.*;

public class GridPanel extends JPanel {
    private int cellSize;
    private int rows;
    private int cols;
    private String[][] grid;

    public GridPanel(int rows, int cols, int cellSize) {
        this.rows = rows;
        this.cols = cols;
        this.cellSize = cellSize;
        this.grid = new String[rows][cols];
        setPreferredSize(new Dimension(cols * cellSize, rows * cellSize));
    }

    public void setGrid(String[][] grid) {
        this.grid = grid;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] != null) {
                    g.drawString(grid[row][col], col * cellSize + 10, row * cellSize + 20);
                }
                g.drawRect(col * cellSize, row * cellSize, cellSize, cellSize);
            }
        }
    }
    
}
