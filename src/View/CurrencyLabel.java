package View;

import javax.swing.*;
import java.awt.*;

public class CurrencyLabel extends JLabel {

    public CurrencyLabel(String currency) {
        super(new ImageIcon("../Currency_Converter/src/View/Images/" + currency + ".jpg"));
        this.setSize(new Dimension(60, 60));
        this.setPreferredSize(new Dimension(60, 60));
    }
}
