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

    public Currency(String name) {
        this.name = name;
    }



}
