package View;

import javax.swing.*;
import java.awt.*;


public class WindowChooseCurrency extends JFrame {

    private JPanel main = new JPanel();

    public WindowChooseCurrency() {
        super("Choose your currency");
        initComponent();
        JScrollPane jScrollPane = new JScrollPane(main);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.setSize(new Dimension(415, 450));
        main.setPreferredSize(new Dimension(390, 1050));
        this.add(jScrollPane);
        this.setVisible(true);
        this.setResizable(false);
    }

    private void initComponent() {
        JButton image = new JButton(new ImageIcon("../Currency_Converter/src/View/Images/test.jpg"));
        image.setPreferredSize(new Dimension(120, 120));
        main.add(image);
        image = new JButton(new ImageIcon("../Currency_Converter/src/View/Images/test.jpg"));
        image.setPreferredSize(new Dimension(120, 120));
        main.add(image);
        image = new JButton(new ImageIcon("../Currency_Converter/src/View/Images/test.jpg"));
        image.setPreferredSize(new Dimension(120, 120));
        main.add(image);
        image = new JButton(new ImageIcon("../Currency_Converter/src/View/Images/test.jpg"));
        image.setPreferredSize(new Dimension(120, 120));
        main.add(image);
        image = new JButton(new ImageIcon("../Currency_Converter/src/View/Images/test.jpg"));
        image.setPreferredSize(new Dimension(120, 120));
        main.add(image);
        image = new JButton(new ImageIcon("../Currency_Converter/src/View/Images/test.jpg"));
        image.setPreferredSize(new Dimension(120, 120));
        main.add(image);
        image = new JButton(new ImageIcon("../Currency_Converter/src/View/Images/test.jpg"));
        image.setPreferredSize(new Dimension(120, 120));
        main.add(image);
        image = new JButton(new ImageIcon("../Currency_Converter/src/View/Images/test.jpg"));
        image.setPreferredSize(new Dimension(120, 120));
        main.add(image);
        image = new JButton(new ImageIcon("../Currency_Converter/src/View/Images/test.jpg"));
        image.setPreferredSize(new Dimension(120, 120));
        main.add(image);
        image = new JButton(new ImageIcon("../Currency_Converter/src/View/Images/test.jpg"));
        image.setPreferredSize(new Dimension(120, 120));
        main.add(image);
    }
}
