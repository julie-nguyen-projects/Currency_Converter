package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class WindowChooseCurrency extends JFrame {

    private JPanel main = new JPanel();
    private ArrayList<JButton> currenciesButtons = new ArrayList<>();

    public WindowChooseCurrency() {
        super("Choose your currency");
        initComponent();
        JScrollPane jScrollPane = new JScrollPane(main);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.setSize(new Dimension(415, 410));
        main.setPreferredSize(new Dimension(390, 1005));
        this.add(jScrollPane);
        this.setVisible(true);
        this.setResizable(false);
    }

    public ArrayList<JButton> getCurrenciesButtons() {
        return currenciesButtons;
    }

    private void initComponent() {
        String[] strings = {"Australian dollar", "Brazilian real", "Canadian dollar", "Cocaine", "Dinar", "Dollar", "Egyptian pound", "Epitech", "Euro",
                "Franc", "Gold ounce", "Icelandic krona", "Indian rupee", "Japanese yen", "Kebab", "Mexican peso", "Pound", "Quatarian rial",
                "Russian ruble", "South-korean won", "Swedish krona", "Swiss franc", "Vietnamese dong", "Yuan"};
        JButton image;
        for (String string : strings) {
            image = new JButton(new ImageIcon("../Currency_Converter/src/View/Images/" + string + ".jpg"));
            image.setPreferredSize(new Dimension(120, 120));
            image.setText("");
            currenciesButtons.add(image);
            main.add(image);
        }
    }
}
