package controller;

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
        panel.getEasyMode().randomLocation(xResolution, yResolution);
        window.setLocation(panel.getEasyMode().getX(), panel.getEasyMode().getY());
    }
}
