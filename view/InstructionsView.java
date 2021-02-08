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

import controller.MainMenuButtonListener;

public class InstructionsView {
    private JFrame window;
    private JTextArea instructionsArea = new JTextArea();

    private int xResolution;
    private int yResolution;

    private String instructions;
    
    public InstructionsView(JFrame window, int xResolution, int yResolution) {
        this.window = window;
        window.setTitle("How To Play");
        this.xResolution = xResolution;
        this.yResolution = yResolution;

        instructions = "The goal of the game is to click the button as quickly as possible.\n";
        instructions +=  "Each time you click the button, it will relocate to a random position on the screen.\n";
        instructions += "After it changes to a new location, you will have a limited amount of time to click the button before the game ends.\n";
        instructions += "This amount of time changes based on the difficulty you choose and decreases over the course of the game.\n";
        instructions += "After the game ends, you can check your overall game statistics by clicking the Score button.\n";
        instructions += "If you would like to play another game on the same difficulty, you can select the New Game button.\n";
        instructions += "If you would like to choose another difficulty, you can choose the Exit to Main Menu button.\n";
        instructions += "\nHave Fun!";
    }

    public void init() {
        Container container = window.getContentPane();
        var scrollPane = new JScrollPane(instructionsArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(xResolution / 3, xResolution / 10));
        window.setLocation(xResolution / 2 - xResolution / 6, yResolution / 2 - xResolution / 20);
        instructionsArea.setText(instructions);
        container.add(BorderLayout.CENTER, scrollPane);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1, 1));

        JButton mainMenuButton = new JButton("Exit to Main Menu");
        controlPanel.add(mainMenuButton);
        container.add(BorderLayout.SOUTH, controlPanel);

        MainMenuButtonListener mainMenuButtonListener = new MainMenuButtonListener(window, xResolution, yResolution);
        mainMenuButton.addActionListener(mainMenuButtonListener);
    }
}
