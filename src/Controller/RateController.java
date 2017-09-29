package Controller;

import Model.Constants;
import Model.Currency;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import jdk.nashorn.internal.parser.JSONParser;

import javax.xml.ws.Response;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class RateController {

    private ArrayList<Currency> currencies = new ArrayList<>();
    private static final String JSON_PATH = "../Currency_Converter/src/Rates.json";

    public void initCurrencies() {
        initEuroCurrency();
        initAustralianDollarCurrency();
        initPoundCurrency();

        try (Writer writer = new FileWriter(JSON_PATH)){
            Gson gson = new GsonBuilder().create();
            gson.toJson(currencies, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        retrieveCurrencies();
    }

    public Currency retrieveCurrencyFromJsonFile(String name) {
        List<Currency> currencies = retrieveCurrencies();
        Currency currencyToRetrieve = null;
        if (currencies != null) {
            for (Currency currency : currencies) {
                if (currency.getName().equals(name)) currencyToRetrieve = currency;
            }
        }
        return currencyToRetrieve;
    }

    private List<Currency> retrieveCurrencies() {
        Gson gson = new Gson();
        List<Currency> currencies = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(JSON_PATH));
            Type  type = new TypeToken<List<Currency>>(){}.getType();
            currencies =  gson.fromJson(br, type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return currencies;
    }

    private void initEuroCurrency () {
        Currency euro = new Currency(Constants.EURO);
        euro.setDollarToCurrent(0.85);
        euro.setCurrentToDollar(1.18);

        currencies.add(euro);
    }

    private void initAustralianDollarCurrency() {
        Currency australianDollar = new Currency(Constants.AUSTRALIAN_DOLLAR);
        australianDollar.setDollarToCurrent(1.28);
        australianDollar.setCurrentToDollar(0.78);

        currencies.add(australianDollar);
    }

    private void initPoundCurrency() {
        Currency pound = new Currency(Constants.POUND);
        pound.setDollarToCurrent(0.746212969);
        pound.setCurrentToDollar(1.3401);

        currencies.add(pound);
    }
}
