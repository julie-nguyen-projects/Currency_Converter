package Model;

public class Currency {

    private String name;
    private double currentToDollar;
    private double dollarToCurrent;

    public String getName() {
        return name;
    }

    public double getCurrentToDollar() {
        return currentToDollar;
    }

    public double getDollarToCurrent() {
        return dollarToCurrent;
    }

    protected Currency(CurrencyBuilder currencyBuilder) {
        this.name = currencyBuilder.name;
        this.currentToDollar = currencyBuilder.currentToDollar;
        this.dollarToCurrent = currencyBuilder.dollarToCurrent;
    }



}
