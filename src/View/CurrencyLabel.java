package View;

import javax.swing.*;
import java.awt.*;

class CurrencyLabel extends JLabel {

    CurrencyLabel(String currency) {
        super(new ImageIcon("../Currency_Converter/src/View/Images/" + currency + "60.jpg"));
        this.setSize(new Dimension(60, 60));
        this.setPreferredSize(new Dimension(60, 60));
    }
}