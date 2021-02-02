package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenu {

    private JFrame window;

    public MainMenu(JFrame window) {
        this.window = window;
        window.setTitle("Main Menu");
    }

    public void init(Dimension resolution) {
        Container container = window.getContentPane();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.setPreferredSize(new Dimension(resolution.width / 5, resolution.width / 5));
        window.setLocation(resolution.width / 10, resolution.width / 10);

        JButton easyButton = new JButton("Easy");
        JButton normalButton = new JButton("Normal");
        JButton impossibleButton = new JButton("Impossible");
        panel.add(easyButton);
        panel.add(normalButton);
        panel.add(impossibleButton);

        container.add(panel);
    }
    
}
