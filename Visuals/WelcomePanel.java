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
    private final StartButton startButton = new StartButton("Start");

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
        startButton.setEnabled(false);

        setupFieldListeners();
    }

    private void setupFieldListeners() {
        DocumentListener listener = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { checkFields(); }
            public void removeUpdate(DocumentEvent e) { checkFields(); }
            public void changedUpdate(DocumentEvent e) { checkFields(); }
        };

        widthField.getDocument().addDocumentListener(listener);
        lengthField.getDocument().addDocumentListener(listener);
        kField.getDocument().addDocumentListener(listener);
        haresField.getDocument().addDocumentListener(listener);
    }

    private void checkFields() {
        boolean allValid = isValidInteger(widthField.getText())
                && isValidInteger(lengthField.getText())
                && isValidInteger(kField.getText())
                && isValidInteger(haresField.getText());

        startButton.setEnabled(allValid);
    }

    private boolean isValidInteger(String text) {
        try {
            Integer.parseInt(text.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int[] getNumbers() throws NumberFormatException {
        return new int[] {
            Integer.parseInt(widthField.getText().trim()),
            Integer.parseInt(lengthField.getText().trim()),
            Integer.parseInt(kField.getText().trim()),
            Integer.parseInt(haresField.getText().trim())
        };
    }

    public StartButton getStartButton() {
        return startButton;
    }
}
