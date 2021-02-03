package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameOverView {
    JFrame window;

    private int xResolution;
    private int yResolution;

    private int score;

    private int mode;

    public GameOverView(JFrame window, int xResolution, int yResolution, int score, int mode) {
        this.window = window;
        window.setTitle("Game Over");
        this.xResolution = xResolution;
        this.yResolution = yResolution;
        this.score = score;
        this.mode = mode;
    }

    public void init() {
        Container container = window.getContentPane();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.setPreferredSize(new Dimension(xResolution / 5, xResolution / 5));
        window.setLocation(xResolution / 2 - xResolution / 10, yResolution / 2 - xResolution / 10);

        JButton scoreButton = new JButton("Final Score: " + String.valueOf(score));
        JButton newGameButton = new JButton("New Game");
        JButton exitButton = new JButton("Exit to Main Menu");

        panel.add(scoreButton);
        panel.add(newGameButton);
        panel.add(exitButton);

        container.add(BorderLayout.CENTER, panel);

        exitButton.addActionListener( e -> {
            window.getContentPane().removeAll();
            var mainMenu = new MainMenu(window, xResolution, yResolution);
            mainMenu.init();
            window.pack();
            window.revalidate();
        });

        newGameButton.addActionListener( e -> {
            window.getContentPane().removeAll();
            /*switch (mode) {
                case 1: var easy = new EasyView(window, xResolution, yResolution); easy.init(); break;
                case 2: var normal = new NormalView(window, xResolution, yResolution); normal.init(); break;
                case 3: var impossible = new ImpossibleView(window, xResolution, yResolution); impossible.init(); break;
            }*/
            var game = new GameView(window, xResolution, yResolution, mode);
            game.init();
            window.pack();
            window.revalidate();
        });
    }
}
