package View.Buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class InputButton extends JButton {

    private Shape shape;

    public InputButton(String text) {
        super(text);
        this.setPreferredSize(new Dimension(50, 50));
        this.setOpaque(false);
        this.setBackground(Color.GRAY);
        this.setForeground(Color.WHITE);
    }

    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } else {
            g.setColor(getBackground());
        }
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
    }

    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 40, 40);
        }
        return shape.contains(x, y);
    }
}
