package View;

import javax.swing.*;
import java.awt.*;


public class WindowChooseCurrency extends JFrame {

    private JPanel main = new JPanel();
    private JScrollPane jScrollPane = new JScrollPane(main);

    public WindowChooseCurrency() {
        super("Choose your currency");
        initComponent();
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.setSize(new Dimension(450, 450));
        main.setPreferredSize(new Dimension(450, 1050));
        this.add(jScrollPane);
        this.setVisible(true);
        this.setResizable(false);
    }

    private void initComponent() {
        JLabel image = new JLabel(new ImageIcon("../Currency_Converter/src/euro.png"));
        image.setPreferredSize(new Dimension(120,120));
        main.add(image);
    }
}
