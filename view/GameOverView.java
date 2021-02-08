package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ViewButtonListener;

public class GameOverView {
    JFrame window;

    private int xResolution;
    private int yResolution;

    private int score;
    private String scoreList;

    private int mode;

    public GameOverView(JFrame window, int xResolution, int yResolution, int score, int mode, String scoreList) {
        this.window = window;
        window.setTitle("Game Over");
        this.xResolution = xResolution;
        this.yResolution = yResolution;
        this.score = score;
        this.scoreList = scoreList;
        this.mode = mode;
    }

    public void init() {
        Container container = window.getContentPane();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.setPreferredSize(new Dimension(xResolution / 5, xResolution / 5));
        window.setLocation(xResolution / 2 - xResolution / 10, yResolution / 2 - xResolution / 10);

        JButton scoreButton = new JButton("Final Score: " + String.valueOf(score));
        JButton newGameButton = new JButton("New Game");
        JButton mainMenuButton = new JButton("Exit to Main Menu");

        panel.add(scoreButton);
        panel.add(newGameButton);
        panel.add(mainMenuButton);

        container.add(BorderLayout.CENTER, panel);

        ViewButtonListener scoreViewButtonListener = new ViewButtonListener(window, xResolution, yResolution, score, mode, scoreList, 5);
        scoreButton.addActionListener(scoreViewButtonListener);

        ViewButtonListener newGameButtonListener = new ViewButtonListener(window, xResolution, yResolution, mode, 3);
        newGameButton.addActionListener(newGameButtonListener);

        ViewButtonListener mainMenuButtonListener = new ViewButtonListener(window, xResolution, yResolution, 1);
        mainMenuButton.addActionListener(mainMenuButtonListener);
    }
}
