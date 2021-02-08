package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.InstructionsView;

public class InstructionsButtonListener implements ActionListener {
    private JFrame window;
    private int xResolution;
    private int yResolution;

    public InstructionsButtonListener(JFrame window, int xResolution, int yResolution) {
        this.window = window;
        this.xResolution = xResolution;
        this.yResolution = yResolution;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        window.getContentPane().removeAll();
        var instructions = new InstructionsView(window, xResolution, yResolution);
        instructions.init();
        window.pack();
        window.revalidate();
    }
}