import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class CPUTimeTest {
    static int testNumber = 5;
    static int dataEntryNumber = 60000;
    static ArrayList<String> Al = new ArrayList<>();
    static LinkedList<String> Ll = new LinkedList<>();
    static Random rand = new Random();

    public static void main(String[] args) {
        for (int i = 0; i < testNumber; i++) {
            initialization();
            remove();
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
        System.out.printf("ArrayList's processing time is %.2f %% of LinkedList\n", percentage);
//        System.out.printf("ArrayList's processing time is ");

    }
}