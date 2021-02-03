package model;

import java.util.Random;

public class Game {

    private int xLocation; // Displacement based on horizontal axis
    private int yLocation; // Displacement base on vertical axis

    private int score;

    private long interval;

    private long time;
    private double modifier;

    Random random = new Random();

    public Game(int interval, double modifier) {
        score = -1;
        this.interval = interval;
        time = interval;
        this.modifier = modifier;
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
        interval = Math.round(interval * modifier);
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
