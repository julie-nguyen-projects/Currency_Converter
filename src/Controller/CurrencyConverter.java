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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

public class CurrencyConverter implements ActionListener {

    private Window window = new Window();
    private WindowChooseCurrency windowChooseCurrency;
    private ArrayList<Currency> currencies = new ArrayList<>();
    private CurrencyButton currentCurrency = new CurrencyButton();
    private RateController rateController;

    public CurrencyConverter() {
        currencies.add(new Currency("Euro"));
        currencies.add(new Currency("Pound"));
        rateController = new RateController();
        rateController.initCurrencies();
        window.displayCurrencies(currencies);
        initEvent();
        for (JButton button : window.getInputButtons()) {
            button.addActionListener(this);
        }
    }

    private void initEvent() {

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
            try {
                double result = convertCurrencyToDollar(currentCurrency.getText(), (String) getKeyFromValue(window.getCurrencyButtonMap(), currentCurrency));
                for (String currencyNameFromMap : window.getCurrencyButtonMap().keySet()) {
                    if (!currencyNameFromMap.equals(getKeyFromValue(window.getCurrencyButtonMap(), currentCurrency))) {
                        String resultToDisplay = convertDollarToCurrency(result, currencyNameFromMap);
                        CurrencyButton currencyButton = window.getCurrencyButtonMap().get(currencyNameFromMap);
                        currencyButton.setText(resultToDisplay);
                    }
                }
            }catch (Exception ignored){}
            // parcourir hashmap String , JLabel et update : utiliser dollarToCurrent


        } else if (actionEvent.getSource() instanceof ActionButton) {
            if (command.equals("+")) {
                windowChooseCurrency=WindowChooseCurrency.getInstance();
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
                currentCurrency=new CurrencyButton();
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

    private double convertCurrencyToDollar(String amount, String currencyName) {
        Currency currency = rateController.retrieveCurrencyFromJsonFile(currencyName);
            return Double.parseDouble(amount) * currency.getCurrentToDollar();
    }

    private String convertDollarToCurrency(double amount, String currencyName) {
        Currency currency = rateController.retrieveCurrencyFromJsonFile(currencyName);
        BigDecimal result = round(amount * currency.getDollarToCurrent());
        return String.valueOf(result);
    }

    private static BigDecimal round(double d) {
        BigDecimal bd = new BigDecimal(Double.toString(d));
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd;
    }

}
