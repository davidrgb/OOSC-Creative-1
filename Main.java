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

        //Random random = new Random(); //Move to model
        //int x = random.nextInt(resolution.width * 7 / 10) + resolution.width / 10;
        //int y = random.nextInt(resolution.height * 7 / 10) + resolution.height / 10;

        var mainMenu = new MainMenu(window);
        mainMenu.init(xResolution, yResolution);

        //window.setLocation(x, y); //Move to model

        /*Container cp = window.getContentPane(); //Move to view;
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));
        panel.setPreferredSize(new Dimension(resolution.width / 10, resolution.width / 10));*/

        //JButton catchMe = new JButton("Catch Me"); //Move to view

        //panel.add(catchMe); //Move to view

        //cp.add(panel); //Move to view

        window.pack();
        window.setVisible(true);

        /*while (true) { //Move to model
            try {
                x = random.nextInt(resolution.width * 7 / 10) + resolution.width / 10;
                y = random.nextInt(resolution.height * 7 / 10) + resolution.height / 10;

                window.setLocation(x, y);

                Thread.sleep(250);
            }
            catch (InterruptedException e) {
                System.out.println("INTERRUPTION");
            }
        }*/
    }
}