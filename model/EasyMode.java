package model;

import java.util.Random;
//import java.util.Timer;
//import java.util.TimerTask;

//import javax.swing.JFrame;

public class EasyMode {

    private int xLocation; // Displacement based on horizontal axis
    private int yLocation; // Displacement base on vertical axis

    private int score;

    private long interval;

    //private Timer timer;

    private long time;

    Random random = new Random();

    public EasyMode() {
        score = 0;
        interval = 5000; // 5 seconds / 5000 milliseconds after first decreaseTime call
        time = interval;
        //timer = new Timer();
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
        interval = Math.round(interval * 0.95);
    }

    /*public void countdown() {
        timer.scheduleAtFixedRate(new TimerTask(){
            public void run() {
                time--;
                if (time == 0) {
                    System.out.println("TIMER ELAPSED");
                    timer.cancel();
                    window.getContentPane().removeAll();
                    var easy = new EasyView(window, xResolution, yResolution);
                    easy.init();
                    window.pack();
                    window.revalidate();
                }
            }
        }, 0, 1);
    }*/

    /*public Timer getTimer() {
        return timer;
    }*/

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
