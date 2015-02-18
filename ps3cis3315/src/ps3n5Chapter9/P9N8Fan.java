package ps3n5Chapter9;

/**
 *
 * @author Narshall Ehlinger
 */

public class P9N8Fan {
    // Speed constants
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;
    
    // Nonconstant variable initializations
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    
    // Accessors and Mutators
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        switch (speed) {
            case "SLOW":
                this.speed = SLOW;
                break;
            case "MEDIUM":
                this.speed = MEDIUM;
                break;
            case "FAST":
                this.speed = FAST;
                break;
            default:
                System.out.println("Speed set failed... pass SLOW, MEDIUM, or FAST.");
                break;
        }
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    // Constructors
    
    public P9N8Fan() {
        // No arg constructor
    }

    @Override
    public String toString() {
        if (isOn()) {
            return "Speed= " + this.speed + ", Color= " + this.color + ", Radius= " + this.radius;
        } else {
            return "Color= " + this.color + ", Radius= " + this.radius + ", FAN IS OFF.";
        }
    }
}
