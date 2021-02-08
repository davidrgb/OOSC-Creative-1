package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.GameOverView;

public class GameOverViewButtonListener implements ActionListener {
    private JFrame window;
    private int xResolution;
    private int yResolution;
    private int score;
    private int mode;
    private String scoreList;

    public GameOverViewButtonListener(JFrame window, int xResolution, int yResolution, int score, int mode, String scoreList) {
        this.window = window;
        this.xResolution = xResolution;
        this.yResolution = yResolution;
        this.score = score;
        this.mode = mode;
        this.scoreList = scoreList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        window.getContentPane().removeAll();
        var gameOverMenu = new GameOverView(window, xResolution, yResolution, score, mode, scoreList);
        gameOverMenu.init();
        window.pack();
        window.revalidate();
    }
}