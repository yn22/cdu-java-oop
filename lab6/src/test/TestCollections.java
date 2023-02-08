package test;

import java.util.*;

public class TestCollections {
    public static void main(String[] args) {
        TestCollections test = new TestCollections();
        test.test4();
    }

    private void test1() {
        Random random = new Random();
        Collection<Integer> vectorCollection = new Vector<>();
        for (int i = 0; i < 15; i++) {
            vectorCollection.add(random.nextInt(10));
        }
        System.out.println("Collection vector");
        vectorCollection.forEach(i -> System.out.printf("%d ", i));

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

    private void test2() {
        Random random = new Random();
        Collection<Integer> c1 = new ArrayList<>();
        Collection<Integer> c2 = new LinkedHashSet<>();
        Collection<Integer> c3 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            c1.add(random.nextInt(10));
            c2.add(random.nextInt(10));
        }

        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);

        c3.addAll(c1);
        c3.removeAll(c2);
        System.out.println("c3 = c1 - c2 " + c3);

        c3.clear();
        c3.addAll(c2);
        c3.removeAll(c1);
        System.out.println("c3 = c2 - c1" + c3);

        c3.clear();
        c3.addAll(c1);
        c3.retainAll(c2);
        System.out.println("c3 = c1 * c2" + c3);
    }

    private void test3() {
        Random random = new Random();
        Collection<Integer> c1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            c1.add(random.nextInt(10));
        }

        Collection<Integer> c2 = new LinkedHashSet<>(c1);

        boolean b1 = c1.containsAll(c2);

        System.out.println("c1.containsAll(c2) = " + b1);

        Collection<Integer> c3 = new TreeSet<>(c1);
        boolean b2 = c1.containsAll(c3);

        System.out.println("c1.containsAll(c3) = " + b2);
    }

    private void test4() {
        Random random = new Random();
        Collection<Integer> c1 = new ArrayDeque<>();

        Collections.addAll(c1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Collections.addAll(c1, new Integer[]{3, 7, 12});
        System.out.println("c1 = " + c1);
        System.out.println("frequency 3 = " + Collections.frequency(c1, 3));
        System.out.println("max = " + Collections.max(c1));
        System.out.println("min = " + Collections.min(c1));

        List<Integer> l1 = new ArrayList<>(c1);
        Collections.swap(l1, 2, 6);
        System.out.println("swap 2 and 6 = " + l1);

        Collections.sort(l1);
        System.out.println("sort = " + l1);

        System.out.println("binarySearch 3 = " + Collections.binarySearch(l1, 3));
        Collections.sort(l1, (a, b) -> b - a);
        System.out.println("sort reverse = " + l1);

        System.out.println("binarySearch 3 = " + Collections.binarySearch(l1, 3, (a, b) -> b - a));

        Collections.reverse(l1);
        System.out.println("reverse = " + l1);

        Collections.rotate(l1, 3);
        System.out.println("rotate 3 = " + l1);

        Collections.shuffle(l1);
        System.out.println("shuffle = " + l1);

        Collections.replaceAll(l1, 3, 33);
        System.out.println("replace 3 to 33 = " + l1);

        Collections.fill(l1, 0);
        System.out.println("fill 0 = " + l1);

        Stack<Integer> stack = new Stack<>();
    }
}
