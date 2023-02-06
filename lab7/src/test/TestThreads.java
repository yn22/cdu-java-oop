package test;

import com.sun.jdi.IntegerType;
import threads.ListCalculator;
import threads.ListStorage;

import java.util.*;

public class TestThreads {
    Random rnd = new Random();

    public static void main(String[] args) {
        TestThreads tt = new TestThreads();
        tt.startApp();
    }

    private void startApp() {
        int n = 5;
        ListStorage listStorage = new ListStorage();
        Map<Integer, List<Integer>> map = createTestMap(n);
        map.forEach(listStorage::addList);

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Thread thread = new Thread(new ListCalculator(i, listStorage));
            threads.add(thread);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Average values: " + listStorage.getAverageValues());
    }

    private Map<Integer, List<Integer>> createTestMap(int n) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            int randomLength = rnd.nextInt(1, 10);
            for (int j = 0; j < randomLength; j++) {
                list.add(rnd.nextInt(100));
            }
            map.put(i, list);
        }
        return map;
    }
}
