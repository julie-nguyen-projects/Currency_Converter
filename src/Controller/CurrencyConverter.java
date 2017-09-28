package Controller;

import Model.Currency;
import View.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CurrencyConverter implements ActionListener {

    private Window window = new Window();
    private ArrayList<Currency> currencies = new ArrayList<>();

    public CurrencyConverter() {
        currencies.add(new Currency("Euro"));
        currencies.add(new Currency("test"));
        window.displayCurrencies(currencies);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
