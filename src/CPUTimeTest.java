// the difference in performance is caused by the fact that ArrayList supports random access, which means that we can
// directly access a specific object within the list using its index. LinkedList does not have such feature, since it
// consists of nodes that store references for the next object (node), which leads to time complexity of an element
// search to be O(n), instead of O(1) for ArrayList

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class CPUTimeTest {
    static int testNumber = 5;
    static int dataEntryNumber = 30000;
    static ArrayList<String> Al = new ArrayList<>();
    static LinkedList<String> Ll = new LinkedList<>();
    static Random rand = new Random();

    public static void main(String[] args) {
        for (int i = 0; i < testNumber; i++) {
            initialization();
            System.out.println("Test " + (i+1));
            remove();
            System.out.println();
        }
    }

    public static void initialization() {
        Al.clear();
        Ll.clear();

        for (int i = 0; i < dataEntryNumber; i++) {
            Al.add(String.valueOf(i));
            Ll.add(String.valueOf(i));
        }
    }

    public static void remove() {
        double timeRemoveArrayList = 0.0;
        double timeRemoveLinkedList = 0.0;
        double startTime, endTime;

        for (int i = 0; i < dataEntryNumber/2; i++) {
            int randIndex = rand.nextInt(Al.size());

            startTime = System.currentTimeMillis();
            Al.remove(randIndex);
            endTime = System.currentTimeMillis();
            timeRemoveArrayList += endTime-startTime;

            startTime = System.currentTimeMillis();
            Ll.remove(randIndex);
            endTime = System.currentTimeMillis();
            timeRemoveLinkedList += endTime-startTime;
        }
        double percentage = timeRemoveArrayList/timeRemoveLinkedList*100.0;
        System.out.println("Removed: " + dataEntryNumber/2);
        System.out.println("ArrayList time: " + timeRemoveArrayList/1000.0 + "sec");
        System.out.println("LinkedList time: " + timeRemoveLinkedList/1000.0 + "sec");
        System.out.printf("ArrayList's processing time is %.2f %% of LinkedList\n", percentage);

    }
}