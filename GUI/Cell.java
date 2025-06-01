package GUI;

import javax.swing.JButton;
import GRID.AnimalState;

public class Cell extends JButton {
    private AnimalState state;

    public Cell(AnimalState state) {
        if(state == null) {
            throw new IllegalArgumentException("State cannot be null");
        }

        this.state = state;
        
        setFont(new java.awt.Font("Segoe UI Emoji", java.awt.Font.PLAIN, 16));
        if(state.getType() == null) {
            setText("");
        } else {
            setText(state.getEmoji());
        }
        
        if(state.isClicked()) {
            setBackground(java.awt.Color.RED);
        } else {
            setBackground(java.awt.Color.WHITE);
        }
        
        this.addActionListener(e -> handleClick());
    }

    public void handleClick() {
        state.setClicked(!state.isClicked());
        setBackground(state.isClicked() ? java.awt.Color.RED : java.awt.Color.WHITE);
        if(state.isClicked()) {
            setBackground(java.awt.Color.RED);
        } else {
            setBackground(java.awt.Color.WHITE);
        }
    }

    public AnimalState getState() {
        return state;
    }
    
}
