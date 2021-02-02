import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();

        Random random = new Random();
        int x = random.nextInt(resolution.width);
        int y = random.nextInt(resolution.height);

        window.setLocation(x, y);

        Container cp = window.getContentPane();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));
        panel.setPreferredSize(new Dimension(resolution.width / 10, resolution.width / 10));

        JButton catchMe = new JButton("Catch Me");

        panel.add(catchMe);

        cp.add(panel);

        window.pack();
        window.setVisible(true);
    }
}