package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.GameOverView;
import view.GameView;
import view.InstructionsView;
import view.MainMenu;
import view.ScoreView;

public class ViewButtonListener implements ActionListener{
    private JFrame window;
    private int xResolution;
    private int yResolution;
    private int score;
    private int mode;
    private String scoreList;

    private int viewType; // 1 - Main Menu, 2 - Instructions, 3 - Game View, 4 - Game Over View, 5 - Score View

    public ViewButtonListener(JFrame window, int xResolution, int yResolution, int viewType) {
        this.window = window;
        this.xResolution = xResolution;
        this.yResolution = yResolution;
        this.viewType = viewType;
    }

    public ViewButtonListener(JFrame window, int xResolution, int yResolution, int mode, int viewType) {
        this.window = window;
        this.xResolution = xResolution;
        this.yResolution = yResolution;
        this.mode = mode;
        this.viewType = viewType;
    }

    public ViewButtonListener(JFrame window, int xResolution, int yResolution, int score, int mode, String scoreList, int viewType) {
        this.window = window;
        this.xResolution = xResolution;
        this.yResolution = yResolution;
        this.score = score;
        this.mode = mode;
        this.scoreList = scoreList;
        this.viewType = viewType;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        window.getContentPane().removeAll();
        switch (viewType) {
            case 1:
                var mainMenu = new MainMenu(window, xResolution, yResolution);
                mainMenu.init();
                window.pack();
                window.revalidate();
                break;
            case 2:
                var instructions = new InstructionsView(window, xResolution, yResolution);
                instructions.init();
                window.pack();
                window.revalidate();
                break;
            case 3:
                var gameView = new GameView(window, xResolution, yResolution, mode);
                gameView.init();
                window.pack();
                window.revalidate();
                break;
            case 4:
                var gameOverView = new GameOverView(window, xResolution, yResolution, score, mode, scoreList);
                gameOverView.init();
                window.pack();
                window.revalidate();
                break;
            case 5:
                var scoreView = new ScoreView(window, xResolution, yResolution, score, mode, scoreList);
                scoreView.init();
                window.pack();
                window.revalidate();
                break;
        }
    }
}
