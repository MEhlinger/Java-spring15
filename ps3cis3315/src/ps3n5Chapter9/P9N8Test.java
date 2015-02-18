package ps3n5Chapter9;

/**
 *
 * @author Marshall Ehlinger
 */

public class P9N8Test {
    public static void main (String[] args) {
        P9N8Fan f1 = new P9N8Fan();
        P9N8Fan f2 = new P9N8Fan();

        f1.setSpeed("FAST");
        f1.setColor("yellow");
        f1.setRadius(10);
        f1.setOn(true);
     
        f2.setSpeed("MEDIUM");
        f2.setColor("blue");
        f2.setRadius(5);
        f2.setOn(false);
        
        System.out.println("f1 : " + f1.toString());
        System.out.println("f2 : " + f2.toString());
        
    }
}
