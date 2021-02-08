package model;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import view.GameView;

public class Game {

    private GameView panel;

    private int xLocation; // Displacement based on horizontal axis
    private int yLocation; // Displacement base on vertical axis

    private int score;
    private String scoreList;

    private long interval;

    private long time;
    private double modifier;

    private static Timer timer;
    private TimerTask timerTask;

    Random random = new Random();

    public Game(int interval, double modifier, GameView panel) {
        score = -1;
        scoreList = "";
        this.interval = interval;
        time = interval;
        this.modifier = modifier;
        this.panel = panel;

        timer = new Timer();
    }

    public void randomLocation(int xResolution, int yResolution) {
        xLocation = random.nextInt(xResolution * 7 / 10) + xResolution / 10; // Generates random horizontal location
        yLocation = random.nextInt(yResolution * 7 / 10) + yResolution / 10; // Generates random vertical location
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
        if (time != 0) ++score;
    }

    public void decreaseInterval() {
        interval = Math.round(interval * modifier);
        time = interval;
    }

    /*public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }*/

    /*public long getInterval() {
        return interval;
    }*/

    public void updateScoreList() {
        double elapsedTimeSeconds = (interval - time) / 1000.0;
        String formattedElapsedTime = String.format("%.3f", elapsedTimeSeconds);
        String formattedTimeRemaining = String.format("%.3f", time / 1000.0);
        if (time != 0) scoreList = scoreList + "Score: " + score + " | Elapsed Time: " + formattedElapsedTime + " | Remaining Time: " + formattedTimeRemaining + "\n";
    }

    public String getScoreList() {
        return scoreList;
    }

    public void countdown() {
        timer.cancel();
        timer = new Timer();
        timerTask = new TimerTask(){
            public void run() {
                --time;
                double timeSeconds = time / 1000.0;
                String formattedTime = String.format("%.1f", timeSeconds);
                panel.updateTitle(formattedTime);
    
                if (time == 0) {
                    timer.cancel();
                    panel.gameOver();
                }
            }
        };
        timer.scheduleAtFixedRate(timerTask, 1, 1);
    }
}
