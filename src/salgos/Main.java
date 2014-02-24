package salgos;

import java.util.Arrays;
import java.util.Random;

public class Main {

    private static void sortWithTime(Comparable[] a, String algo) {
        long startTime, endTime, duration;
        startTime = System.currentTimeMillis();
 
        if (algo.equals("Merge")) {
            MergeSort.sort(a);
        } else if (algo.equals("Heap")) {
            Heapsort.sort(a);
        } else if (algo.equals("Quick")) {
            Quicksort.sort(a);
        } else {
            BubbleSort.sort(a);
        }

        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        System.out.println(String.format("Duration #%d elements, (%s): %d ms", a.length, algo, duration));
    }

    public static void main(String[] args) {
        int n = 10000;
        Integer a[] = random(n);
        Integer b[] = Arrays.copyOf(a, a.length);
        Integer c[] = Arrays.copyOf(a, a.length);
        Integer d[] = Arrays.copyOf(a, a.length);
        sortWithTime(a, "Heap");
        sortWithTime(b, "Quick");
        sortWithTime(c, "Merge");
        sortWithTime(d, "Bubble");
    }

    private static Integer[] random(int i) {
        Integer random[] = new Integer[i];
        for (int j = 0; j < i; j++)
            random[j] = new Random().nextInt(i);

        return random;
    }

}
