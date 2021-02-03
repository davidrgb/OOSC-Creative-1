package controller;

import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.EasyView;

public class ButtonListener implements ActionListener {
    private EasyView panel;

    public ButtonListener(EasyView panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JFrame window = panel.getWindow();
        int xResolution = panel.getXResolution();
        int yResolution = panel.getYResolution();

        panel.getEasyMode().incrementScore();
        int score = panel.getEasyMode().getScore();
        String buttonText = String.valueOf(score);
        panel.setButtonText(buttonText);

        panel.getEasyMode().decreaseInterval();
        panel.getEasyMode().setTime(panel.getEasyMode().getInterval());

        panel.getEasyMode().randomLocation(xResolution, yResolution);
        window.setLocation(panel.getEasyMode().getX(), panel.getEasyMode().getY());

        panel.countdown();
    }
}
