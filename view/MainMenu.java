package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ViewButtonListener;

public class MainMenu {

    private JFrame window;

    private int xResolution;
    private int yResolution;

    public MainMenu(JFrame window, int xResolution, int yResolution) {
        this.window = window;
        window.setTitle("Main Menu");
        this.xResolution = xResolution;
        this.yResolution = yResolution;
    }

    public void init() {
        Container container = window.getContentPane();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.setPreferredSize(new Dimension(xResolution / 5, xResolution / 5));    // Sets size of window to 1/5 horizontal resolution by 1/5 horizontal resolution.
        window.setLocation(xResolution / 2 - xResolution / 10, yResolution / 2 - xResolution / 10); // Centers window based on size.

        JButton instructionsButton = new JButton("How To Play");
        JButton easyButton = new JButton("Easy");
        JButton normalButton = new JButton("Normal");
        JButton impossibleButton = new JButton("Impossible");
        panel.add(instructionsButton);
        panel.add(easyButton);
        panel.add(normalButton);
        panel.add(impossibleButton);

        container.add(BorderLayout.CENTER, panel);

        ViewButtonListener instructionsButtonListener = new ViewButtonListener(window, xResolution, yResolution, 2);
        instructionsButton.addActionListener(instructionsButtonListener);

        ViewButtonListener easyButtonListener = new ViewButtonListener(window, xResolution, yResolution, 1, 3);
        easyButton.addActionListener(easyButtonListener);

        ViewButtonListener normalButtonListener = new ViewButtonListener(window, xResolution, yResolution, 2, 3);
        normalButton.addActionListener(normalButtonListener);

        ViewButtonListener impossibleButtonListener = new ViewButtonListener(window, xResolution, yResolution, 3, 3);
        impossibleButton.addActionListener(impossibleButtonListener);
    }
}
