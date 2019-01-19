import javax.swing.*;

public class OvalGUIComponent {
    private int x, y;
    private JPanel panel;

    OvalGUIComponent(int x, int y, JPanel panel) {
        this.x = x;
        this.y = y;
        this.panel = panel;
    }

    public void draw() {
        panel.repaint();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
