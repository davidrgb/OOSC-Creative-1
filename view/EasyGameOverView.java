package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EasyGameOverView {
    JFrame window;

    private int xResolution;
    private int yResolution;

    public EasyGameOverView(JFrame window, int xResolution, int yResolution) {
        this.window = window;
        window.setTitle("Game Over");
        this.xResolution = xResolution;
        this.yResolution = yResolution;
    }

    public void init() {
        Container container = window.getContentPane();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        panel.setPreferredSize(new Dimension(xResolution / 10, xResolution / 10));
        window.setLocation(xResolution / 2 - xResolution / 20, yResolution / 2 - xResolution / 20);

        JButton exitButton = new JButton("Exit to Main Menu");
        JButton newGameButton = new JButton("New Game");

        panel.add(exitButton);
        panel.add(newGameButton);

        container.add(BorderLayout.CENTER, panel);
    }
}
