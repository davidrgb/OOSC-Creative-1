package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ButtonListener;
import model.Game;

public class GameView {

    private JFrame window;
    private Game game;

    private int mode;

    private int xResolution;
    private int yResolution;

    private JButton target = new JButton("Click Me To Start");

    public GameView(JFrame window, int xResolution, int yResolution, int mode) {
        this.window = window;
        window.setTitle("");
        this.xResolution = xResolution;
        this.yResolution = yResolution;
        this.mode = mode;

        switch (mode) {
            case 1: game = new Game(5000, 0.95, this); break;
            case 2: game = new Game(3000, 0.9, this); break;
            case 3: game = new Game(1500, 0.8, this); break;
        }
    }

    public void init() {
        Container container = window.getContentPane();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));
        panel.setPreferredSize(new Dimension(xResolution / 10, xResolution / 10));
        window.setLocation(xResolution / 2 - xResolution / 20, yResolution / 2 - xResolution / 20);

        panel.add(target);

        container.add(BorderLayout.CENTER, panel);

        ButtonListener buttonListener = new ButtonListener(window, xResolution, yResolution, target, game);
        target.addActionListener(buttonListener);
    }

    public void updateTitle(String title) {
        window.setTitle(title);
    }

    public void gameOver() {
        window.getContentPane().removeAll();
        var gameOver = new GameOverView(window, xResolution, yResolution, game.getScore(), mode, game.getScoreList());
        gameOver.init();
        window.pack();
        window.revalidate();
    }
}
