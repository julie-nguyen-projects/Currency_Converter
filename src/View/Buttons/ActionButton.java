package View.Buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class ActionButton extends JButton {

    private Shape shape;

    public ActionButton(String type) {
        switch (type) {
            case "x":
                this.setText("x");
                break;
            case "+":
                this.setText("+");
        }
        this.setBackground(new Color(59, 89, 182));
        this.setOpaque(false);
        this.setForeground(Color.WHITE);
        this.setPreferredSize(new Dimension(60, 60));
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
