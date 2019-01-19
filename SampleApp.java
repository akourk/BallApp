import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SampleApp {

    private JFrame frame = new JFrame();
    private SquarePanel panel = new SquarePanel();
    //private OvalGUIComponent ovals = new OvalGUIComponent();
    private int i = 0;

    public SampleApp() {
        frame.setSize(800, 800);
        panel.setPreferredSize(new Dimension(800, 800));

        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getX() + ", " + e.getY());
                OvalGUIComponent oval = new OvalGUIComponent(e.getX(), e.getY(), panel);
                panel.setOvals(oval);
                oval.draw();
                frame.add(panel);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        frame.add(panel);
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        SampleApp app = new SampleApp();

    }
}
