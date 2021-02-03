package model;

import java.util.Random;

public class NormalMode {

    private int xLocation; // Displacement based on horizontal axis
    private int yLocation; // Displacement base on vertical axis

    private int score;

    private long interval;

    private long time;

    Random random = new Random();

    public NormalMode() {
        score = 0;
        interval = 3000; // 5 seconds / 5000 milliseconds
        time = interval;
    }

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

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        ++score;
    }

    public void decreaseInterval() {
        interval = Math.round(interval * 0.9);
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getInterval() {
        return interval;
    }
}
