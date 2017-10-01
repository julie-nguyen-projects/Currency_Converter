package Controller;

import Model.Constants;
import Model.Currency;
import Model.CurrencyBuilder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

class RateController {
    private static final String JSON_PATH = "../Currency_Converter/src/Rates.json";

    private List<Currency> currencies = Arrays.asList(
            new CurrencyBuilder(Constants.EURO, 1.1816, 0.846311).build(),
            new CurrencyBuilder(Constants.AUSTRALIAN_DOLLAR, 0.78, 1.28).build(),
            new CurrencyBuilder(Constants.BRAZILIAN_REAL, 0.31345, 3.18717).build(),
            new CurrencyBuilder(Constants.CANADIAN_DOLLAR, 0.80210, 1.24656).build(),
            new CurrencyBuilder(Constants.DINAR, 0.00880, 112.829).build(),
            new CurrencyBuilder(Constants.DOLLAR, 1, 1).build(),
            new CurrencyBuilder(Constants.EGYPTIAN_POUND, 0.05658, 17.6160).build(),
            new CurrencyBuilder(Constants.FRANC, 0.17937, 5.57439).build(),
            new CurrencyBuilder(Constants.GOLD_OUNCE, 1284.17, 0.00078).build(),
            new CurrencyBuilder(Constants.ICELANDIC_KRONA, 0.00937, 106.198).build(),
            new CurrencyBuilder(Constants.INDIAN_RUPEE, 0.01522, 65.6029).build(),
            new CurrencyBuilder(Constants.JAPANESE_YEN, 0.00887, 112.67).build(),
            new CurrencyBuilder(Constants.MEXICAN_PESO, 0.05491, 18.2026).build(),
            new CurrencyBuilder(Constants.POUND, 1.3401, 0.746212969).build(),
            new CurrencyBuilder(Constants.QATARIAN_RIYAL, 0.26695, 3.60052).build(),
            new CurrencyBuilder(Constants.RUSSIAN_RUBLE, 0.01720, 58.0700).build(),
            new CurrencyBuilder(Constants.SOUTH_KOREAN_WON, 0.00087, 1146.15).build(),
            new CurrencyBuilder(Constants.SWEDISH_KRONA, 0.122673, 8.15178).build(),
            new CurrencyBuilder(Constants.SWISS_FRANC, 1.03246, 0.968561).build(),
            new CurrencyBuilder(Constants.VIETNAMESE_DONG, 0.0000440160, 22719).build(),
            new CurrencyBuilder(Constants.YUAN, 0.150266, 6.65488).build(),
            new CurrencyBuilder(Constants.KEBAB, 6, 0.166666667).build(),
            new CurrencyBuilder(Constants.EPITECH_YEAR, 43718.50, 0.000022874).build(),
            new CurrencyBuilder(Constants.COKE, 94.5265, 0.010579044).build()
    );

    void initCurrencies() {
        try (Writer writer = new FileWriter(JSON_PATH)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(currencies, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        retrieveCurrencies();
    }

    Currency retrieveCurrencyFromJsonFile(String name) {
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
            Type type = new TypeToken<List<Currency>>() {
            }.getType();
            currencies = gson.fromJson(br, type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return currencies;
    }
}
