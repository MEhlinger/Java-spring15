
package ps3n5Chapter9;

/**
 *
 * @author Marshall Ehlinger
 */
public class P9N1Rectangle {
    private double width = 1;
    private double height = 1;

    public P9N1Rectangle() {
        
    }
    
    public P9N1Rectangle(double w, double h) {
        width = w;
        height = h;
    }
    
    public void setWidth(double newWidth) {
        width = newWidth;
    }
    
    public void setHeight(double newHeight) {
        height = newHeight;
    }
    
    public double getWidth() {
        return width;
    }
    
    public double getHeight() {
        return height;
    }
    
    public double getArea() {
        return width * height;
    }
    
    public double getPerimeter() {
        return width + width + height + height;
    }
}