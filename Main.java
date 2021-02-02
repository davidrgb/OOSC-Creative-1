import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import view.MainMenu;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
        final int xResolution = resolution.width;
        final int yResolution = resolution.height;

        var mainMenu = new MainMenu(window);
        mainMenu.init(xResolution, yResolution);

        window.pack();
        window.setVisible(true);
    }
}