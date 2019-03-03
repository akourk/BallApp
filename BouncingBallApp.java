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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class BouncingBallApp {

    private JFrame frame = new JFrame();
    private static BouncingBallPanel panel = new BouncingBallPanel();

    public BouncingBallApp() {

        // make a frame of size 800px by 800px
        frame.setSize(800, 800);
        panel.setPreferredSize(new Dimension(800, 800));

        // adding MouseListener
        panel.addMouseListener(new MouseListener() {

            // create a new thread with a ball (oval) on every mouse click
            // passes x and y coords of mouseclick
            @Override
            public void mouseClicked(MouseEvent e) {
                Thread ball = new Thread(new BallRunnable(e.getX(), e.getY(), panel));
                ball.start();
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        panel.addMouseMotionListener(new MouseMotionListener(){

            @Override
            public void mouseDragged(MouseEvent e) {
                Thread ball = new Thread(new BallRunnable(e.getX(), e.getY(), panel));
                ball.start();
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

        // a black background looks nice
        panel.setBackground(Color.BLACK);

        // packs the panel inside the frame and makes visible
        frame.add(panel);
        frame.setVisible(true);
        frame.pack();

        // make sure it exits on close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        BouncingBallApp app = new BouncingBallApp();

        while(true) {
            panel.repaint();
        }
    }
}
