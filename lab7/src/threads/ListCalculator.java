package threads;

import java.util.List;

public class ListCalculator implements Runnable {
    ListStorage listStorage;
    Integer key;

    public ListCalculator(Integer key, ListStorage listStorage) {
        this.key = key;
        this.listStorage = listStorage;
    }

    public void run() {
        List<Integer> list = listStorage.getList(key);
        int sum = 0;
        for (Integer value : list) {
            sum += value;
        }
        int average = sum / list.size();
        listStorage.addAverageValue(average);
    }
}
