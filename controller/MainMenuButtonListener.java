package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.MainMenu;

public class MainMenuButtonListener implements ActionListener {
    private JFrame window;
    private int xResolution;
    private int yResolution;

    public MainMenuButtonListener(JFrame window, int xResolution, int yResolution) {
        this.window = window;
        this.xResolution = xResolution;
        this.yResolution = yResolution;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        window.getContentPane().removeAll();
        var mainMenu = new MainMenu(window, xResolution, yResolution);
        mainMenu.init();
        window.pack();
        window.revalidate();
    }
}
