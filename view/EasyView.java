package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ButtonListener;
import model.EasyMode;

public class EasyView {

    private EasyMode easyMode = new EasyMode();
    private JFrame window;

    private int xResolution;
    private int yResolution;

    private JButton target = new JButton("Click Me To Start");
    
    public EasyView(JFrame window, int xResolution, int yResolution) {
        this.window = window;
        window.setTitle("Easy Mode");
        this.xResolution = xResolution;
        this.yResolution = yResolution;
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

    public void setButtonText(int score) {
        target.setText(String.valueOf(score));
    }
}
