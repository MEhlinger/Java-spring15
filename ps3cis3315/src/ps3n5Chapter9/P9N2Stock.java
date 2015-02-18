
package ps3n5Chapter9;

/**
 *
 * @author Marshall Ehlinger
 */
public class P9N2Stock {
    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;

    public P9N2Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }
    
    public double getChangePercent() {
        return(100 * (currentPrice - previousClosingPrice) / previousClosingPrice);
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreviousClosingPrice() {
        return previousClosingPrice;
    }

    public void setPreviousClosingPrice(double previousClosingPrice) {
        this.previousClosingPrice = previousClosingPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Override
    public String toString() {
        return "P9N2Stock{" + "symbol=" + symbol + ", name=" + name + ", previousClosingPrice=" + previousClosingPrice + ", currentPrice=" + currentPrice + '}';
    }
    
    
}
