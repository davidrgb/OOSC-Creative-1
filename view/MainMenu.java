package view;

import java.awt.BorderLayout;
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

    public void init(int xResolution, int yResolution) {
        Container container = window.getContentPane();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.setPreferredSize(new Dimension(xResolution / 5, xResolution / 5));
        window.setLocation(xResolution / 2 - xResolution / 10, yResolution / 2 - xResolution / 10);

        JButton easyButton = new JButton("Easy");
        JButton normalButton = new JButton("Normal");
        JButton impossibleButton = new JButton("Impossible");
        panel.add(easyButton);
        panel.add(normalButton);
        panel.add(impossibleButton);

        container.add(BorderLayout.CENTER, panel);

        easyButton.addActionListener( e -> {
            window.getContentPane().removeAll();
            var easy = new EasyView(window, xResolution, yResolution);
            easy.init();
            window.pack();
            window.revalidate();
        });
    }
    
}
