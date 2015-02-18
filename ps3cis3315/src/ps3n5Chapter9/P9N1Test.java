

package ps3n5Chapter9;

/**
 *
 * @author Marshall Ehlinger
 */
public class P9N1Test {
    public static void main (String[] args) {
        P9N1Rectangle r1 = new P9N1Rectangle();
        P9N1Rectangle r2 = new P9N1Rectangle(4, 40);

        r1.setWidth(5);
        r1.setHeight(6);
        
        System.out.println("r1 width = " + r1.getWidth());
        System.out.println("r1 height = " + r1.getHeight());
        System.out.println("r1 perimeter = " + r1.getPerimeter());
        System.out.println("r1 area = " + r1.getArea()+ "\n");
        
        System.out.println("r2 width = " + r2.getWidth());
        System.out.println("r2 height = " + r2.getHeight());
        System.out.println("r2 perimeter = " + r2.getPerimeter());
        System.out.println("r2 area = " + r2.getArea());
    }
}
