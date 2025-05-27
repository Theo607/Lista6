package GUI;

import javax.swing.*;
import java.awt.*;

public class GridCell extends JButton {
    private String cellType;

    public GridCell(String cellType) {
        this.cellType = cellType;
        setPreferredSize(new Dimension(50, 50));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));

        if (cellType.equals("wolf")) {
            setText("\uD83D\uDC3A");
        } else if(cellType.equals("hare")) {
            setText("\uD83D\uDC07");
        } else if(cellType.equals("wolfClicked")) {
            setText("\uD83D\uDC3A");
            setBackground(Color.RED);
        } else if(cellType.equals("hareClicked")) {
            setText("\uD83D\uDC07");
            setBackground(Color.RED);
        } else {
            setText("");
            setBackground(Color.WHITE);
        }

        this.addActionListener(e -> handleClick());
    }

    public void handleClick() {
        if (cellType.equals("wolf")) {
            setCellType("wolfClicked");
        } else if(cellType.equals("hare")) {
            setCellType("hareClicked");
        } else if(cellType.equals("wolfClicked")) {
            setCellType("wolf");
        } else if(cellType.equals("hareClicked")) {
            setCellType("hare");
        }
    }

    public void setCellType(String cellType) {
        this.cellType = cellType;
        setText("");
        setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
        if (cellType.equals("wolf")) {
            setText("\uD83D\uDC3A");
            setBackground(Color.WHITE);
        } else if(cellType.equals("hare")) {
            setText("\uD83D\uDC07");
            setBackground(Color.WHITE);
        } else if(cellType.equals("wolfClicked")) {
            setText("\uD83D\uDC3A");
            setBackground(Color.RED);
        } else if(cellType.equals("hareClicked")) {
            setText("\uD83D\uDC07");
            setBackground(Color.RED);
        } else {
            setText("");
            setBackground(Color.WHITE);
        }
    }
}
