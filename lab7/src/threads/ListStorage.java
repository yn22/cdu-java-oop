package threads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListStorage {
    private final Map<Integer, List<Integer>> map = new HashMap<>();
    private final List<Integer> averageValues = new ArrayList<>();

    public ListStorage() {
    }

    public List<Integer> getList(int i) {
        return map.get(i);
    }

    public synchronized void addList(int i, List<Integer> list) {
        map.put(i, list);
    }

    public synchronized void addAverageValue(int average) {
        averageValues.add(average);
    }

    public List<Integer> getAverageValues() {
        return averageValues;
    }
}
