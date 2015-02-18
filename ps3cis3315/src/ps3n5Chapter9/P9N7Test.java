package ps3n5Chapter9;

/**
 *
 * @author Marshall Ehlinger
 */
public class P9N7Test {
    public static void main (String[] args) {
        P9N7Account a1 =  new P9N7Account(1122, 20000.00, 4.5);
        System.out.println(a1);
        a1.withdraw(2500);
        System.out.println(a1);
        a1.deposit(3000);
        System.out.println(a1);
    }
}
