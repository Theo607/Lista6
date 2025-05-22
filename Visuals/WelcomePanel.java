package Visuals;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class WelcomePanel extends JPanel {
    private final JTextField widthField = new JTextField();
    private final JTextField lengthField = new JTextField();
    private final JTextField kField = new JTextField();
    private final JTextField haresField = new JTextField();
    private final JButton startButton = new JButton("Start");

    public WelcomePanel() {
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("Width:"));
        add(widthField);

        add(new JLabel("Length:"));
        add(lengthField);

        add(new JLabel("K:"));
        add(kField);

        add(new JLabel("Hares:"));
        add(haresField);

        add(new JLabel());
        add(startButton);

    }

    public int[] getNumbers() throws NumberFormatException {
        int n = Integer.parseInt(widthField.getText().trim());
        int m = Integer.parseInt(lengthField.getText().trim());
        int k = Integer.parseInt(kField.getText().trim());
        int hares = Integer.parseInt(haresField.getText().trim());
        return new int[] { n, m, k, hares };
    }

    public JButton getStartButton() {
        return startButton;
    }
}
