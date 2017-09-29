package Controller;

import Model.Currency;

public class RateController {

    public void initCurrencies() {
        initEuroCurrency();
    }

    private void initEuroCurrency () {
        Currency euro = new Currency("euro");
        euro.setDollarToCurrent(0.85);
        euro.setCurrentToDollar(1.18);


    }

    public Currency retrieveCurrencyFromJsonFile(String name) {


        return new Currency("test");
    }

}
