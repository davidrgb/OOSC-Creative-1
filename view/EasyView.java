package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EasyView {
    private JFrame window;
    
    public EasyView(JFrame window) {
        this.window = window;
        window.setTitle("Easy Mode");
    }

    public void init(Dimension resolution) {
        Container container = window.getContentPane();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));
        panel.setPreferredSize(new Dimension(resolution.width / 10, resolution.width / 10));
        window.setLocation(resolution.width / 2 - resolution.width / 20, resolution.height / 2 - resolution.width / 20);

        JButton target = new JButton("Click Me To Start");
        panel.add(target);

        container.add(BorderLayout.CENTER, panel);
    }
}
