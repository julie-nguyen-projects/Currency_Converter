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
import java.util.Map;

public class CurrencyConverter implements ActionListener {

    private Window window = new Window();
    private WindowChooseCurrency windowChooseCurrency;
    private ArrayList<Currency> currencies = new ArrayList<>();
    private CurrencyButton currentCurrency = new CurrencyButton();

    public CurrencyConverter() {
        currencies.add(new Currency("Euro"));
        currencies.add(new Currency("Pound"));
        RateController rateController = new RateController();
        rateController.initCurrencies();
        window.displayCurrencies(currencies);
        initEvent();
    }

    private void initEvent() {
        for (JButton button : window.getInputButtons()) {
            button.addActionListener(this);
        }
        for (ActionButton button : window.getActionButtonMap().values()) {
            button.addActionListener(this);
        }
        for (ActionButton button : window.getPlusButtons()) {
            button.addActionListener(this);
        }
        for (CurrencyButton currencyButton : window.getCurrencyButtonMap().values()) {
            currencyButton.addActionListener(this);
        }
        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();
        if (actionEvent.getSource() instanceof InputButton) {
            if (!command.equals("C")) {
                if (currentCurrency.getText().equals("0") && !command.equals(".")) {
                    currentCurrency.setText(command);
                } else {
                    if (currentCurrency.getText().contains(".")) {
                        if (!currentCurrency.getText().endsWith(".")) {
                            System.out.println(currentCurrency.getText());
                            if ((currentCurrency.getText().split("\\.")[1]).length() < 2) {
                                currentCurrency.setText(currentCurrency.getText() + command);
                            }
                        } else {
                            currentCurrency.setText(currentCurrency.getText() + command);
                        }
                    } else {
                        currentCurrency.setText(currentCurrency.getText() + command);
                    }
                }
            } else {
                if (currentCurrency.getText().length() == 1) {
                    currentCurrency.setText("0");
                } else {
                    currentCurrency.setText(currentCurrency.getText().substring(0, currentCurrency.getText().length() - 1));
                }
            }
        } else if (actionEvent.getSource() instanceof ActionButton) {
            if (command.equals("+")) {
                windowChooseCurrency = new WindowChooseCurrency();
                for (JButton currencyButton : windowChooseCurrency.getCurrenciesButtons()) {
                    currencyButton.addActionListener(this);
                }
            } else {
                //Suppression de ligne
                String currencyName = (String) getKeyFromValue(window.getActionButtonMap(), actionEvent.getSource());
                Currency currencyToDelete = new Currency("");
                for (Currency currency : currencies) {
                    if (currency.getName().equals(currencyName)) {
                        currencyToDelete = currency;
                    }
                }
                currencies.remove(currencyToDelete);
                window.displayCurrencies(currencies);
                initEvent();
            }
        } else if (!command.equals("")) {
            String currencyName = (String) getKeyFromValue(window.getCurrencyButtonMap(), actionEvent.getSource());
            for (Currency currency : currencies) {
                if (currency.getName().equals(currencyName)) {
                    currentCurrency = ((CurrencyButton) actionEvent.getSource());
                }
            }
        } else {
            boolean exist = false;
            for (Currency currency : currencies) {
                if (currency.getName().equals(((JButton) actionEvent.getSource()).getIcon().toString().split("/")[5].split("\\.")[0])) {
                    exist = true;
                }
            }
            if (!exist) {
                currencies.add(new Currency(((JButton) actionEvent.getSource()).getIcon().toString().split("/")[5].split("\\.")[0]));
            }
            window.displayCurrencies(currencies);
            initEvent();
            windowChooseCurrency.setVisible(false);
        }
    }

    private static Object getKeyFromValue(Map hm, Object value) {
        for (Object o : hm.keySet()) {
            if (hm.get(o).equals(value)) {
                return o;
            }
        }
        return null;
    }

}
