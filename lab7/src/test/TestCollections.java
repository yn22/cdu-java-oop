package test;

import java.util.*;

public class TestCollections {
    public static void main(String[] args) {
        TestCollections test = new TestCollections();
        test.test1();
    }

    private void test1() {
        Random random = new Random();
        Collection<Integer> vectorCollection = new Vector<>();
        for (int i = 0; i < 15; i++) {
            vectorCollection.add(random.nextInt(10));
        }
        System.out.println("Collection vector");
        for (Integer i : vectorCollection) {
            System.out.printf("%d ", i);
        }

        Collection<Integer> treeSetCollection = new TreeSet<>(vectorCollection);
        System.out.println("\nCollection treeSet");
        treeSetCollection.forEach(i -> System.out.printf("%d ", i));

        Collection<Integer> stackCollection = new Stack<>();
        stackCollection.addAll(vectorCollection);
        System.out.println("\nCollection stack");
        stackCollection.forEach(i -> System.out.printf("%d ", i));

        Collection<Integer> arrayListCollection = new ArrayList<>(vectorCollection);
        System.out.println("\nCollection arrayList");
        arrayListCollection.forEach(i -> System.out.printf("%d ", i));

        Collection<Integer> linkedListCollection = new LinkedList<>(vectorCollection);
        System.out.println("\nCollection linkedList");
        linkedListCollection.forEach(i -> System.out.printf("%d ", i));

        Collection<Integer> ArrayDequeCollection = new ArrayDeque<>(vectorCollection);
        System.out.println("\nCollection ArrayDeque");
        ArrayDequeCollection.forEach(i -> System.out.printf("%d ", i));

        Collection<Integer> priorityQueueCollection = new PriorityQueue<>(vectorCollection);
        System.out.println("\nCollection priorityQueue");
        priorityQueueCollection.forEach(i -> System.out.printf("%d ", i));

        Collection<Integer> hashSetCollection = new HashSet<>(vectorCollection);
        System.out.println("\nCollection hashSet");
        hashSetCollection.forEach(i -> System.out.printf("%d ", i));

        Collection<Integer> linkedHashSetCollection = new LinkedHashSet<>(vectorCollection);
        System.out.println("\nCollection linkedHashSet");
        linkedHashSetCollection.forEach(i -> System.out.printf("%d ", i));
    }
}
