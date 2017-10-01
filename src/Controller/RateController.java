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
        initBrazilianRealCurrency();
        initCanadianDollarCurrency();
        initDinarCurrency();
        initDollarCurrency();
        initEgyptianPoundCurrency();
        initFrancCurrency();
        initGoldOunce();
        initIcelandicKronaCurrency();
        initIndianRupeeCurrency();
        initJapaneseYenCurrency();
        initMexicanPesoCurrency();
        initPoundCurrency();
        initQatarianRiyalCurrency();
        initRussianRubleCurrency();
        initSouthKoreanWonCurrency();
        initSwedishKronaCurrency();
        initSwissFrancCurrency();
        initVietnameseDongCurrency();
        initYuanCurrency();
        initKebabCurrency();
        initEpitechYearCurrency();
        initCokeCurrency();

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

    private void initBrazilianRealCurrency() {
        Currency newCurrency = new Currency(Constants.BRAZILIAN_REAL);
        newCurrency.setDollarToCurrent(3.18717);
        newCurrency.setCurrentToDollar(0.31345);

        currencies.add(newCurrency);
    }

    private void initCanadianDollarCurrency() {
        Currency newCurrency = new Currency(Constants.CANADIAN_DOLLAR);
        newCurrency.setDollarToCurrent(1.24656);
        newCurrency.setCurrentToDollar(0.80210);

        currencies.add(newCurrency);
    }

    private void initDinarCurrency() {
        Currency newCurrency = new Currency(Constants.DINAR);
        newCurrency.setDollarToCurrent(112.829);
        newCurrency.setCurrentToDollar(0.00880);

        currencies.add(newCurrency);
    }

    private void initDollarCurrency() {
        Currency newCurrency = new Currency(Constants.DOLLAR);
        newCurrency.setDollarToCurrent(1);
        newCurrency.setCurrentToDollar(1);

        currencies.add(newCurrency);
    }

    private void initEgyptianPoundCurrency() {
        Currency newCurrency = new Currency(Constants.EGYPTIAN_POUND);
        newCurrency.setDollarToCurrent(17.6160);
        newCurrency.setCurrentToDollar(0.05658);

        currencies.add(newCurrency);
    }

    private void initFrancCurrency() {
        Currency newCurrency = new Currency(Constants.FRANC);
        newCurrency.setDollarToCurrent(5.57439);
        newCurrency.setCurrentToDollar(0.17937);

        currencies.add(newCurrency);
    }

    private void initGoldOunce() {
        Currency newCurrency = new Currency(Constants.GOLD_OUNCE);
        newCurrency.setDollarToCurrent(0.00078);
        newCurrency.setCurrentToDollar(1284.17);

        currencies.add(newCurrency);
    }

    private void initIcelandicKronaCurrency() {
        Currency newCurrency = new Currency(Constants.ICELANDIC_KRONA);
        newCurrency.setDollarToCurrent(106.198);
        newCurrency.setCurrentToDollar(0.00937);

        currencies.add(newCurrency);
    }

    private void initIndianRupeeCurrency() {
        Currency newCurrency = new Currency(Constants.INDIAN_RUPEE);
        newCurrency.setDollarToCurrent(65.6029);
        newCurrency.setCurrentToDollar(0.01522);

        currencies.add(newCurrency);
    }

    private void initJapaneseYenCurrency() {
        Currency newCurrency = new Currency(Constants.JAPANESE_YEN);
        newCurrency.setDollarToCurrent(112.67);
        newCurrency.setCurrentToDollar(0.00887);

        currencies.add(newCurrency);
    }

    private void initMexicanPesoCurrency() {
        Currency newCurrency = new Currency(Constants.MEXICAN_PESO);
        newCurrency.setDollarToCurrent(18.2026);
        newCurrency.setCurrentToDollar(0.05491);

        currencies.add(newCurrency);
    }

    private void initPoundCurrency() {
        Currency pound = new Currency(Constants.POUND);
        pound.setDollarToCurrent(0.746212969);
        pound.setCurrentToDollar(1.3401);

        currencies.add(pound);
    }

    private void initQatarianRiyalCurrency() {
        Currency newCurrency = new Currency(Constants.QATARIAN_RIYAL);
        newCurrency.setDollarToCurrent(3.60052);
        newCurrency.setCurrentToDollar(0.26695);

        currencies.add(newCurrency);
    }

    private void initRussianRubleCurrency() {
        Currency newCurrency = new Currency(Constants.RUSSIAN_RUBLE);
        newCurrency.setDollarToCurrent(58.0700);
        newCurrency.setCurrentToDollar(0.01720);

        currencies.add(newCurrency);
    }

    private void initSouthKoreanWonCurrency() {
        Currency newCurrency = new Currency(Constants.SOUTH_KOREAN_WON);
        newCurrency.setDollarToCurrent(1146.15);
        newCurrency.setCurrentToDollar(0.00087);

        currencies.add(newCurrency);
    }

    private void initSwedishKronaCurrency() {
        Currency newCurrency = new Currency(Constants.SWEDISH_KRONA);
        newCurrency.setDollarToCurrent(8.15178);
        newCurrency.setCurrentToDollar(0.122673);

        currencies.add(newCurrency);
    }

    private void initSwissFrancCurrency() {
        Currency newCurrency = new Currency(Constants.SWISS_FRANC);
        newCurrency.setDollarToCurrent(0.968561);
        newCurrency.setCurrentToDollar(1.03246);

        currencies.add(newCurrency);
    }

    private void initVietnameseDongCurrency() {
        Currency newCurrency = new Currency(Constants.VIETNAMESE_DONG);
        newCurrency.setDollarToCurrent(22719);
        newCurrency.setCurrentToDollar(0.0000440160);

        currencies.add(newCurrency);
    }

    private void initYuanCurrency() {
        Currency newCurrency = new Currency(Constants.YUAN);
        newCurrency.setDollarToCurrent(6.65488);
        newCurrency.setCurrentToDollar(0.150266);

        currencies.add(newCurrency);
    }

    private void initKebabCurrency() {
        Currency newCurrency = new Currency(Constants.KEBAB);
        newCurrency.setDollarToCurrent(0.166666667);
        newCurrency.setCurrentToDollar(6);

        currencies.add(newCurrency);
    }

    private void initEpitechYearCurrency() {
        Currency newCurrency = new Currency(Constants.EPITECH_YEAR);
        newCurrency.setDollarToCurrent(0.000022874);
        newCurrency.setCurrentToDollar(43718.50);

        currencies.add(newCurrency);
    }

    private void initCokeCurrency() {
        Currency newCurrency = new Currency(Constants.COKE);
        newCurrency.setDollarToCurrent(0.010579044);
        newCurrency.setCurrentToDollar(94.5265);

        currencies.add(newCurrency);
    }


}
