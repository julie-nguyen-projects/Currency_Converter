package Controller;

import Model.Currency;
import View.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CurrencyConverter implements ActionListener {

    private Window window = new Window();
    private ArrayList<Currency> currencies = new ArrayList<>();
    private RateController rateController = new RateController();

    public CurrencyConverter() {
        currencies.add(new Currency("Euro"));
        currencies.add(new Currency("Pound"));

        rateController.initCurrencies();
        window.displayCurrencies(currencies);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
