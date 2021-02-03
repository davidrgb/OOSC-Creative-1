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
import model.EasyMode;

public class EasyView {

    private JFrame window;
    private EasyMode easyMode = new EasyMode();

    private int xResolution;
    private int yResolution;

    private static Timer timer;
    private TimerTask timerTask;

    private JButton target = new JButton("Click Me To Start");

    public EasyView(JFrame window, int xResolution, int yResolution) {
        this.window = window;
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

        ButtonListener buttonListener = new ButtonListener(this);
        target.addActionListener(buttonListener);
    }

    public EasyMode getEasyMode() {
        return easyMode;
    }

    public JFrame getWindow() {
        return window;
    }

    public int getXResolution() {
        return xResolution;
    }

    public int getYResolution() {
        return yResolution;
    }

    public void setButtonText(String buttonText) {
        target.setText(buttonText);
    }

    public void countdown() {
        timer.cancel();
        timer = new Timer();
        timerTask = new TimerTask(){
            public void run() {
                long time = easyMode.getTime();
                easyMode.setTime(--time);
                double timeSeconds = time / 1000.0;
                String formattedTime = String.format("%.3f", timeSeconds);
                window.setTitle(formattedTime);
    
                if (time == 0) {
                    timer.cancel();
                    window.getContentPane().removeAll();
                    var gameOver = new EasyGameOverView(window, xResolution, yResolution);
                    gameOver.init();
                    window.pack();
                    window.revalidate();
                }
            }
        };
        timer.scheduleAtFixedRate(timerTask, 1, 1);
    }
}
