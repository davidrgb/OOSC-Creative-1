package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.GameViewButtonListener;
import controller.MainMenuButtonListener;
import controller.ScoreViewButtonListener;

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
        JButton exitButton = new JButton("Exit to Main Menu");

        panel.add(scoreButton);
        panel.add(newGameButton);
        panel.add(exitButton);

        container.add(BorderLayout.CENTER, panel);

        ScoreViewButtonListener scoreViewButtonListener = new ScoreViewButtonListener(window, xResolution, yResolution, score, mode, scoreList);
        scoreButton.addActionListener(scoreViewButtonListener);

        MainMenuButtonListener mainMenuButtonListener = new MainMenuButtonListener(window, xResolution, yResolution);
        exitButton.addActionListener(mainMenuButtonListener);

        GameViewButtonListener gameViewButtonListener = new GameViewButtonListener(window, xResolution, yResolution, mode);
        newGameButton.addActionListener(gameViewButtonListener);
    }
}
