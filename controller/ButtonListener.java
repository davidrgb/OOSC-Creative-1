package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.GameView;

public class ButtonListener implements ActionListener {
    private GameView panel;

    public ButtonListener(GameView panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame window = panel.getWindow();
        int xResolution = panel.getXResolution();
        int yResolution = panel.getYResolution();

        panel.getGame().incrementScore();
        if (panel.getGame().getScore() != 0) panel.getGame().updateScoreList();
        int score = panel.getGame().getScore();
        String buttonText = String.valueOf(score);
        panel.setButtonText(buttonText);

        panel.getGame().decreaseInterval();
        panel.getGame().setTime(panel.getGame().getInterval());

        panel.getGame().randomLocation(xResolution, yResolution);
        window.setLocation(panel.getGame().getX(), panel.getGame().getY());

        panel.countdown();
    }
}
