package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.ScoreView;

public class ScoreViewButtonListener implements ActionListener {
    private JFrame window;
    private int xResolution;
    private int yResolution;
    private int score;
    private int mode;
    private String scoreList;

    public ScoreViewButtonListener(JFrame window, int xResolution, int yResolution, int score, int mode, String scoreList) {
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
        var scoreView = new ScoreView(window, xResolution, yResolution, score, mode, scoreList);
        scoreView.init();
        window.pack();
        window.revalidate();
    }
}
