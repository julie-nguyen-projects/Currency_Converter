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
        for (Currency currency : currencies) {
            if (currency.getName().equals(name)) currencyToRetrieve = currency;
        }
        return currencyToRetrieve;
    }

    private List<Currency> retrieveCurrencies() {
        Gson gson = new Gson();

        try {
            BufferedReader br = new BufferedReader(new FileReader(JSON_PATH));
            Type  type = new TypeToken<List<Currency>>(){}.getType();
            List<Currency> currencies = gson.fromJson(br, type);

            System.out.println(currencies);
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

    private static String readFile(String filename) {
        String result = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            result = sb.toString();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
