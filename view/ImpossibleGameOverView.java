package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImpossibleGameOverView {
    JFrame window;

    private int xResolution;
    private int yResolution;

    private int score;

    public ImpossibleGameOverView(JFrame window, int xResolution, int yResolution, int score) {
        this.window = window;
        window.setTitle("Game Over");
        this.xResolution = xResolution;
        this.yResolution = yResolution;
        this.score = score;
    }

    public void init() {
        Container container = window.getContentPane();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.setPreferredSize(new Dimension(xResolution / 5, xResolution / 5));
        window.setLocation(xResolution / 2 - xResolution / 10, yResolution / 2 - xResolution / 10);

        JButton scoreButton = new JButton("Final Score: " + String.valueOf(score));
        JButton newGameButton = new JButton("New Game");
        JButton exitButton = new JButton("Exit to Main Menu");

        panel.add(scoreButton);
        panel.add(newGameButton);
        panel.add(exitButton);

        container.add(BorderLayout.CENTER, panel);

        exitButton.addActionListener( e -> {
            window.getContentPane().removeAll();
            var mainMenu = new MainMenu(window, xResolution, yResolution);
            mainMenu.init();
            window.pack();
            window.revalidate();
        });

        newGameButton.addActionListener( e -> {
            window.getContentPane().removeAll();
            var impossible = new ImpossibleView(window, xResolution, yResolution);
            impossible.init();
            window.pack();
            window.revalidate();
        });
    }
}