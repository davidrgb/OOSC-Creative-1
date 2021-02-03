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

import controller.ImpossibleButtonListener;
import model.ImpossibleMode;

public class ImpossibleView {

    private JFrame window;
    private ImpossibleMode impossibleMode = new ImpossibleMode();

    private int xResolution;
    private int yResolution;

    private static Timer timer;
    private TimerTask timerTask;

    private JButton target = new JButton("Click Me To Start");

    public ImpossibleView(JFrame window, int xResolution, int yResolution) {
        this.window = window;
        window.setTitle("");
        this.xResolution = xResolution;
        this.yResolution = yResolution;

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

        ImpossibleButtonListener buttonListener = new ImpossibleButtonListener(this);
        target.addActionListener(buttonListener);
    }
    
    public JFrame getWindow() {
        return window;
    }

    public ImpossibleMode getImpossibleMode() {
        return impossibleMode;
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
                long time = impossibleMode.getTime();
                impossibleMode.setTime(--time);
                double timeSeconds = time / 1000.0;
                String formattedTime = String.format("%.1f", timeSeconds);
                window.setTitle(formattedTime);
    
                if (time == 0) {
                    timer.cancel();
                    window.getContentPane().removeAll();
                    var gameOver = new ImpossibleGameOverView(window, xResolution, yResolution, impossibleMode.getScore());
                    gameOver.init();
                    window.pack();
                    window.revalidate();
                }
            }
        };
        timer.scheduleAtFixedRate(timerTask, 1, 1);
    }
}