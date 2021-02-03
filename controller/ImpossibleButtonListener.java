package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.ImpossibleView;

public class ImpossibleButtonListener implements ActionListener {
    private ImpossibleView panel;

    public ImpossibleButtonListener(ImpossibleView panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JFrame window = panel.getWindow();
        int xResolution = panel.getXResolution();
        int yResolution = panel.getYResolution();

        panel.getImpossibleMode().incrementScore();
        int score = panel.getImpossibleMode().getScore();
        String buttonText = String.valueOf(score);
        panel.setButtonText(buttonText);

        panel.getImpossibleMode().decreaseInterval();
        panel.getImpossibleMode().setTime(panel.getImpossibleMode().getInterval());

        panel.getImpossibleMode().randomLocation(xResolution, yResolution);
        window.setLocation(panel.getImpossibleMode().getX(), panel.getImpossibleMode().getY());

        panel.countdown();
    }
}
