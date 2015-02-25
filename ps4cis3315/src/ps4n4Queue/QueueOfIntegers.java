package ps4n4Queue;

/**
 *
 * @author Marshall Ehlinger
 */
public class QueueOfIntegers {
    private int[] elements;
    private int size;
    public static final int DEFAULT_CAPACITY =  8;
    
    public QueueOfIntegers() {
        this(DEFAULT_CAPACITY);
    }
    
    public QueueOfIntegers(int capacity) {
        elements = new int[capacity];
    }
    
    public void enqueue(int value) {
        // Adds item to back of queue
        
        // Doubles size of queue array if full
        if (size >= elements.length) {
            int[] temp = new int[elements.length * 2];
            System.arraycopy(elements, 0, temp, 0, elements.length);
            elements = temp; // Reassign the reference variable
        }
        elements[size++] = value; // Assign value, then increment
    }
    
    public int dequeue() {
        // Removes the item from front of queue and returns it
        
        if (!empty()) {
            int firstOut = elements[0];
            size--;  
            // Now everyone shuffles foward in line
            for (int i = 1; i <= size; i++) {
                elements[i-1] = elements [i];
            }

            return firstOut;
        }
        return -1; // Return -1 if queue is empty
    }
    
    public int peek() {
        // Returns item from front of queue without removing it
        return elements[0];
    }
    
    public boolean empty() {
        return (size == 0);
    }
    
    @Override
    public String toString() {
        StringBuilder sBuild = new StringBuilder();
        for (int i = 0; i < size-1; i++) {
            sBuild.append(elements[i]).append(", ");
        }
        if (!empty()) {
            sBuild.append(elements[size-1]);
        }
        return sBuild.toString();
    }
}
