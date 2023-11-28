import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threadList = new ArrayList<>();
        String[] texts = new String[25];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("abb", 30_000);
        }
        long startTs = System.currentTimeMillis();
        for (String text : texts) {
            threadList.add(getNewThread(text));
        }
        for (Thread thread : threadList) {
            thread.start();
        }
        for (Thread thread : threadList) {
            thread.join();
         }
        long endTs = System.currentTimeMillis();
        System.out.println("Time: " + (endTs - startTs) + "ms");
    }
    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }
    public static Thread getNewThread(String text) {
    return new Thread(
            ()-> {
                int maxSize = 0;
                for (int i = 0; i < text.length(); i++) {
                    for (int j = 0; j < text.length(); j++)
                        if (i >= j) {
                            continue;
                        }
                    boolean bFound = false;

                    for (int k = i; k < j; k++) {
                        if (text.charAt(k) == 'b') {
                            bFound = true;
                            break;
                        }
                    }
                    if (!bFound && maxSize < j - i) {
                        maxSize = j - i;
                    }
                }
            }
            System.out.println(text.substring(0, 100) + " -> " + maxSize);
    }
);
            }
}



