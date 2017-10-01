package Model;

public class CurrencyBuilder {

    final String name;
    final double currentToDollar;
    final double dollarToCurrent;

    public CurrencyBuilder() {
        this.name = "";
        this.currentToDollar = 0;
        this.dollarToCurrent = 0;
    }

    public CurrencyBuilder(String name) {
        this.name = name;
        this.currentToDollar = 0;
        this.dollarToCurrent = 0;
    }

    public CurrencyBuilder(String name, double currentToDollar, double dollarToCurrent) {
        this.name = name;
        this.currentToDollar = currentToDollar;
        this.dollarToCurrent = dollarToCurrent;
    }

    public Currency build() {
        return new Currency(this);
    }
}
