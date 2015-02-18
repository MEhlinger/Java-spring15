
package ps3n5Chapter9;

/**
 *
 * @author Marshall Ehlinger
 **/
public class P9N2Test {
    public static void main (String[] args) {
        P9N2Stock s1 = new P9N2Stock("msft", "Microsoft");
        s1.setCurrentPrice(100);
        s1.setPreviousClosingPrice(50);
        
        System.out.println("Percent= " + s1.getChangePercent());
    }
}
