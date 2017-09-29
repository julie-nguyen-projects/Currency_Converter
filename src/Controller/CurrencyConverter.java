package Controller;

import Model.Currency;
import View.Buttons.ActionButton;
import View.Buttons.CurrencyButton;
import View.Buttons.InputButton;
import View.Window;
import View.WindowChooseCurrency;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter implements ActionListener {

    private Window window = new Window();
    private WindowChooseCurrency windowChooseCurrency;
    private ArrayList<Currency> currencies = new ArrayList<>();
    private CurrencyButton currentCurrency = new CurrencyButton();
    private RateController rateController = new RateController();

    public CurrencyConverter() {
        currencies.add(new Currency("Euro"));
        currencies.add(new Currency("Pound"));

        rateController.initCurrencies();
        window.displayCurrencies(currencies);
        initEvent();
    }

    private void initEvent() {
        for (JButton button : window.getInputButtons()) {
            button.addActionListener(this);
        }
        for (ActionButton button: window.getActionButtonMap().values()){
            button.addActionListener(this);
        }
        for (ActionButton button:window.getPlusButtons()){
            button.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();
        if (actionEvent.getSource() instanceof InputButton){
            currentCurrency.setText(currentCurrency.getText()+command);
        }else if (actionEvent.getSource() instanceof ActionButton){
            if (command.equals("+")){
                windowChooseCurrency=new WindowChooseCurrency();
                for (JButton currencyButton : windowChooseCurrency.getCurrenciesButtons()){
                    currencyButton.addActionListener(this);
                }
            }else{
                //TODO
            }
        }else if (command!=""){
            //TODO
        }else{
            System.out.println((((JButton) actionEvent.getSource()).getIcon()));
        }
    }
}
