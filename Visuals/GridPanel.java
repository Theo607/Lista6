package Visuals;

import java.awt.*;
import javax.swing.*;
import AnimalsGrid.*;

public class GridPanel extends JPanel {
    private Grid grid;
    public GridPanel(Grid grid) {
        this.grid = grid;
        this.setLayout(new GridLayout(grid.width, grid.height));
        for (int i = 0; i < grid.width; i++) {
            for (int j = 0; j < grid.height; j++) {
                JLabel label = new JLabel(grid.who(new Position(i, j)));
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                this.add(label);
            }
        }
        repaint();
    }
    public void updateGrid(Grid grid) {
        this.grid = grid;
        repaint();
    }
}
