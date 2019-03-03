// Author       :   Alex Kourkoumelis
// Date         :   1/19/2019
// Description  :   A multi-threaded bouncing ball application.
//              :   Each mouse click in the frame adds a new random
//              :   colored ball, in a new thread, to appear in a random
//              :   speed and in a random direction on the spot that was
//              :   clicked. When the ball hits the frame, the direction
//              :   and speed are both randomized again.


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BouncingBallPanel extends JPanel {

    // keeping an ArrayList of balls (ovals)
    private ArrayList<BallRunnable> ovals = new ArrayList<>();

    public void setOvals(BallRunnable oval) {
        ovals.add(oval);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        try {
            for(int i = 0; i < ovals.size(); i++) {
                g.setColor(ovals.get(i).getColor());
                g.fillOval(ovals.get(i).getX(), ovals.get(i).getY(), 20, 20);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}