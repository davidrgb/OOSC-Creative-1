package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.ViewButtonListener;

public class ScoreView {
    private JFrame window;
    private JTextArea scoreArea = new JTextArea();

    private int xResolution;
    private int yResolution;

    private int score;
    private String scoreList;

    private int mode;
    
    public ScoreView(JFrame window, int xResolution, int yResolution, int score, int mode, String scoreList) {
        this.window = window;
        window.setTitle("Score Overview");
        this.xResolution = xResolution;
        this.yResolution = yResolution;
        this.score = score;
        this.scoreList = scoreList;
        this.mode = mode;
    }

    public void init() {
        Container container = window.getContentPane();
        var scrollPane = new JScrollPane(scoreArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(xResolution / 5, xResolution / 5));
        scoreArea.setText(scoreList);
        container.add(BorderLayout.CENTER, scrollPane);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1, 1));

        JButton gameOverMenuButton = new JButton("Exit to Game Over Menu");
        controlPanel.add(gameOverMenuButton);
        container.add(BorderLayout.SOUTH, controlPanel);

        ViewButtonListener gameOverMenuButtonListener = new ViewButtonListener(window, xResolution, yResolution, score, mode, scoreList, 4);
        gameOverMenuButton.addActionListener(gameOverMenuButtonListener);
    }
}
