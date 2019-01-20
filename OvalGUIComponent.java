// Author       :   Alex Kourkoumelis
// Date         :   1/19/2019
// Description  :   A multi-threaded bouncing ball application.
//              :   Each mouse click in the frame adds a new random
//              :   colored ball, in a new thread, to appear in a random
//              :   speed and in a random direction on the spot that was
//              :   clicked. When the ball hits the frame, the direction
//              :   and speed are both randomized again.

import java.awt.*;

// implements Runnable for extra threads
public class OvalGUIComponent implements Runnable {
    private int x, y;   // current x and y position of the ball
    private double xv = ((Math.random() * 10)%3)+1; // randomizing the x velocity a little
    private double yv = ((Math.random() * 10)%3)+1; // and the y velocity...
    private SquarePanel panel;
    private Color color = new Color((int) (Math.random() * 0x1000000)); // wizardy to randomize the color

    OvalGUIComponent(int x, int y, SquarePanel panel) {
        this.x = x;
        this.y = y;
        this.panel = panel;
    }
    public Color getColor() {
        return color;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    @Override
    public void run() {
        panel.setOvals(this);

        while (true) {

            // if the ball is about to go off the screen in the negative x or y
            // direction, set both x and y vel to a random positive number
            if (x <= 0) {
                this.xv = ((Math.random() * 10)%3)+1;
            }
            if (y <= 0) {
                this.yv = ((Math.random() * 10)%3)+1;
            }

            // if the ball is about to go off the screen in the positive x
            // direction, randomize both x and y velocity, then reverse
            // the x velocity.
            if (x >= 780) {
                this.xv = ((Math.random() * 10)%3)+1;
                this.xv = this.xv * (-1);
            }

            // same for the y velocity
            if (y >= 780) {
                this.yv = ((Math.random() * 10)%3)+1;
                this.yv = this.yv * (-1);
            }

            // modifying the velocity
            this.x += this.xv;
            this.y += this.yv;
            panel.repaint();
            try {
                // this is to offer smoothing for fast threads
                // can be increased with fast computers, decreased with slower computers
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}