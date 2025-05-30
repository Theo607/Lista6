package GUI;

import javax.swing.*;
import java.awt.*;

public class GridCell extends JButton {
    private String cellType;
    private Boolean isClicked;

    public GridCell(String cellType) {
        this.cellType = cellType == null ? "" : cellType;
        setPreferredSize(new Dimension(50, 50));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));

        if (cellType.equals("Wolf")) {
            setText("\uD83D\uDC3A");
            this.isClicked = false;
        } else if(cellType.equals("Hare")) {
            setText("\uD83D\uDC07");
            this.isClicked = false;
        } else if(cellType.equals("WolfClicked")) {
            setText("\uD83D\uDC3A");
            setBackground(Color.RED);
            this.isClicked = true;
        } else if(cellType.equals("HareClicked")) {
            setText("\uD83D\uDC07");
            setBackground(Color.RED);
            this.isClicked = true;
        } else {
            setText("");
            setBackground(Color.WHITE);
            this.isClicked = false;
        }

        this.addActionListener(e -> handleClick());
    }

    public Boolean isClicked() {
        return isClicked;
    }

    public String getCellType() {
        return cellType;
    }
    public void handleClick() {
        isClicked = !isClicked;
        if (cellType.equals("Wolf")) {
            setCellType("WolfClicked");
            setBackground(Color.RED);
        } else if(cellType.equals("Hare")) {
            setCellType("HareClicked");
        } else if(cellType.equals("WolfClicked")) {
            setCellType("Wolf");
            setBackground(Color.RED);
        } else if(cellType.equals("HareClicked")) {
            setCellType("Hare");
        }
    }

    public void setCellType(String cellType) {
        this.cellType = cellType == null ? "" : cellType;
        setText("");
        setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
        if(cellType == null || cellType.isEmpty()) {
            setText("");
            setBackground(Color.WHITE);
            return;
        }
        if (cellType.equals("Wolf")) {
            setText("\uD83D\uDC3A");
            setBackground(Color.WHITE);
        } else if(cellType.equals("Hare")) {
            setText("\uD83D\uDC07");
            setBackground(Color.WHITE);
        } else if(cellType.equals("WolfClicked")) {
            setText("\uD83D\uDC3A");
            setBackground(Color.RED);
        } else if(cellType.equals("HareClicked")) {
            setText("\uD83D\uDC07");
            setBackground(Color.RED);
        } else {
            setText("");
            setBackground(Color.WHITE);
        }
    }
}
