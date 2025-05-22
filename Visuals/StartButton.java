package Visuals;

import javax.swing.*;

public class StartButton extends JButton {

    private boolean clicked = false;

    public StartButton(String text) {
        super(text);
        clicked = false;

        // Add action listener to set clicked true when pressed
        addActionListener(e -> {
            clicked = true;
            System.out.println("StartButton was clicked!");
        });
    }

    // Check if clicked
    public boolean isClicked() {
        return clicked;
    }

    // Reset clicked state (optional)
    public void resetClicked() {
        clicked = false;
    }
}
