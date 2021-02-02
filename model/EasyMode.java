package model;

import java.awt.Dimension;

import java.util.Random;

public class EasyMode {

    private int xLocation; // Displacement based on horizontal axis
    private int yLocation; // Displacement base on vertical axis

    Random random = new Random(); //Move to model

    public void randomLocation(int xResolution, int yResolution) {
        xLocation = random.nextInt(xResolution * 7 / 10) + xResolution / 10;
        yLocation = random.nextInt(yResolution * 7 / 10) + yResolution / 10;
    }

    public int getX() {
        return xLocation;
    }

    public int getY() {
        return yLocation;
    }
}
