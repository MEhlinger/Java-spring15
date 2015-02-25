package ps4n3Stack;

/**
 * ASSIGNMENT:  Write a stack data struct for double values, and then
 *              write a Junit test program for each method.
 * @author Marshall Ehlinger
 */
public class StackOfDouble {
    private double[] elements;
    private int size;
    public static final int DEFAULT_CAPACITY = 16;
    
    public StackOfDouble() {
        this(DEFAULT_CAPACITY);
    }
    
    public StackOfDouble(int capacity) {
        elements = new double[capacity];
    }
    
    public void push (double value) {
        // Adds double to top of stack, doubling stack size if full
        if (size >= elements.length) {
            double[] temp = new double[elements.length * 2];
            System.arraycopy(elements, 0, temp, 0, elements.length); //copy contents
            elements = temp; // change reference
        }
        elements[size++] = value;
    }
    
    public double pop() {
        // Pops last item from stack and returns ot
        if (!empty()) {
            return elements[--size];
        } else {
            return -1; // Return -1 if stack is empty
        }   
    }
    
    public double peek() {
        // Returns item from top of stack, without popping
        return elements[size-1];
    }
    
    public boolean empty() {
        // Returns true if stack is empty
        return size == 0;
    }
    
    public int getSize() {
        // Gets size of stack
        return size;
    }
}
