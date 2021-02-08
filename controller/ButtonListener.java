package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.Game;

public class ButtonListener implements ActionListener {
    private JFrame window;
    private int xResolution;
    private int yResolution;
    private JButton button;
    private Game game;

    public ButtonListener(JFrame window, int xResolution, int yResolution, JButton button, Game game) {
        this.window = window;
        this.xResolution = xResolution;
        this.yResolution = yResolution;
        this.button = button;
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        game.incrementScore();
        int score = game.getScore();
        if (score != 0) game.updateScoreList();
        String buttonText = String.valueOf(score);
        button.setText("Score: " + buttonText);

        game.decreaseInterval();

        game.randomLocation(xResolution, yResolution);
        window.setLocation(game.getX(), game.getY());

        game.countdown();
    }
}
