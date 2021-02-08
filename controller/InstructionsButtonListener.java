package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.InstructionsView;
import view.MainMenu;

public class InstructionsButtonListener implements ActionListener {
    MainMenu panel;

    public InstructionsButtonListener(MainMenu panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame window = panel.getWindow();
        int xResolution = panel.getXResolution();
        int yResolution = panel.getYResolution();

        window.getContentPane().removeAll();
        var instructions = new InstructionsView(window, xResolution, yResolution);
        instructions.init();
        window.pack();
        window.revalidate();
    }
}
