package View.Buttons;

import javax.swing.*;

public class ActionButton extends JButton {

    public ActionButton(String type) {
        switch (type){
            case "x":
                this.setText("x");
                break;
            case "+" :
                this.setText("+");
        }
    }
}
