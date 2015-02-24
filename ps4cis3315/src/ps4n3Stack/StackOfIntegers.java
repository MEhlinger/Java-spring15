package ps4n3Stack;

/**
 *
 * @author Marshall Ehlinger
 */
public class StackOfIntegers {
    private int[] elements;
    private int size;
    public static final int DEFAULT_CAPACITY = 16;
    
    public StackOfIntegers() {
        this(DEFAULT_CAPACITY);
    }
    
    public StackOfIntegers(int capacity) {
        elements = new int[capacity];
    }
    
    public void push(int value) {
        // Adds item to stack, doubling stack size if it was full
        if (size >= elements.length) {
            int[] temp = new int[elements.length * 2];
            System.arraycopy(elements, 0, temp, 0, elements.length);
            elements = temp;
        }
        elements[size++] = value;
    }
    
    public int pop() {
        // Pops last item off stack and returns it
        if (!empty()) {
            return elements[--size];
        } else {
            return -1; // -1 Returned if stack is empty
        }
    }
    
    public int peek() {
        // Returns item on top of stack
        return elements[size - 1];
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

