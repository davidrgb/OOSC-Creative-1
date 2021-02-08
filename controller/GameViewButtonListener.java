package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.GameView;

public class GameViewButtonListener implements ActionListener {
    private JFrame window;
    private int xResolution;
    private int yResolution;
    private int mode;

    public GameViewButtonListener(JFrame window, int xResolution, int yResolution, int mode) {
        this.window = window;
        this.xResolution = xResolution;
        this.yResolution = yResolution;
        this.mode = mode;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        window.getContentPane().removeAll();
        var mainMenu = new GameView(window, xResolution, yResolution, mode);
        mainMenu.init();
        window.pack();
        window.revalidate();
    }
}
