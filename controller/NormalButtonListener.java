package controller;

import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.NormalView;

public class NormalButtonListener implements ActionListener {
    private NormalView panel;

    public NormalButtonListener(NormalView panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JFrame window = panel.getWindow();
        int xResolution = panel.getXResolution();
        int yResolution = panel.getYResolution();

        panel.getNormalMode().incrementScore();
        int score = panel.getNormalMode().getScore();
        String buttonText = String.valueOf(score);
        panel.setButtonText(buttonText);

        panel.getNormalMode().decreaseInterval();
        panel.getNormalMode().setTime(panel.getNormalMode().getInterval());

        panel.getNormalMode().randomLocation(xResolution, yResolution);
        window.setLocation(panel.getNormalMode().getX(), panel.getNormalMode().getY());

        panel.countdown();
    }
}
