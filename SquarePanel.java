import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SquarePanel extends JPanel {

    private ArrayList<OvalGUIComponent> ovals = new ArrayList<>();

    public void setOvals(OvalGUIComponent oval) {
        ovals.add(oval);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        try {
            for(int i = 0; i < ovals.size(); i++) {
                g.fillOval(ovals.get(i).getX(), ovals.get(i).getY(), 20, 20);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}

//JPanel panelImg = new JPanel() {
//    public void paintComponent(Graphics g) {
//        g.drawOval(X, Y, r, r);
//    }
//}
