package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Timer;
import java.util.TimerTask;

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

    private static Timer timer;
    private TimerTask timerTask;

    private JButton target = new JButton("Click Me To Start");

    public GameView(JFrame window, int xResolution, int yResolution, int mode) {
        this.window = window;
        window.setTitle("");
        this.xResolution = xResolution;
        this.yResolution = yResolution;
        this.mode = mode;

        switch (mode) {
            case 1: game = new Game(5000, 0.95); break;
            case 2: game = new Game(3000, 0.9); break;
            case 3: game = new Game(1500, 0.8); break;
        }

        timer = new Timer();
    }

    public void init() {
        Container container = window.getContentPane();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));
        panel.setPreferredSize(new Dimension(xResolution / 10, xResolution / 10));
        window.setLocation(xResolution / 2 - xResolution / 20, yResolution / 2 - xResolution / 20);

        panel.add(target);

        container.add(BorderLayout.CENTER, panel);

        ButtonListener buttonListener = new ButtonListener(this);
        target.addActionListener(buttonListener);
    }
    
    public JFrame getWindow() {
        return window;
    }

    public Game getGame() {
        return game;
    }

    public int getXResolution() {
        return xResolution;
    }

    public int getYResolution() {
        return yResolution;
    }

    public void setButtonText(String buttonText) {
        target.setText("Score: " + buttonText);
    }

    public void countdown() {
        timer.cancel();
        timer = new Timer();
        timerTask = new TimerTask(){
            public void run() {
                long time = game.getTime();
                game.setTime(--time);
                double timeSeconds = time / 1000.0;
                String formattedTime = String.format("%.1f", timeSeconds);
                window.setTitle(formattedTime);
    
                if (time == 0) {
                    timer.cancel();
                    window.getContentPane().removeAll();
                    /*switch (mode) {
                        case 1: var gameOverEasy = new GameOverView(window, xResolution, yResolution, game.getScore(), mode); gameOverEasy.init(); break;
                        case 2: var gameOverNormal = new GameOverView(window, xResolution, yResolution, game.getScore(), mode); gameOverNormal.init(); break;
                        case 3: var gameOverImpossible = new GameOverView(window, xResolution, yResolution, game.getScore(), mode); gameOverImpossible.init(); break;
                    }*/
                    var gameOver = new GameOverView(window, xResolution, yResolution, game.getScore(), mode);
                    gameOver.init();
                    window.pack();
                    window.revalidate();
                }
            }
        };
        timer.scheduleAtFixedRate(timerTask, 1, 1);
    }
}
