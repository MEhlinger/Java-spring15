package ps4n4Queue;

/**
 *
 * @author Marshall Ehlinger
 */
public class QOITest {
    public static void main (String[] args) {
        QueueOfIntegers qi = new QueueOfIntegers();
        
        for (int i = 0; i < 20; i ++) {
            qi.enqueue(i);
        }
        
        System.out.println(qi.toString());
        
        while (!qi.empty()) {
            for (int i = 0; i < 3; i++) {
                qi.dequeue();
            }
            System.out.println(qi.toString());
        }
    }
}
