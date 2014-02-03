package salgos;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int random[] = random(100);
        int copy[]= Arrays.copyOf(random, random.length);

        Arrays.sort(random);
        Heap.sort(copy);
        print(random);
        print(copy);

        /*
        long startTime = System.currentTimeMillis(); //nanoTime();
        Merge.sort(random);
        long endTime = System.currentTimeMillis(); //nanoTime();
        long duration = endTime - startTime;
        //System.out.println("dur oma merge: " + duration / 1000 + " ms");
        System.out.println("dur oma merge: " + duration + " ms");

        startTime = System.currentTimeMillis(); //nanoTime();
        Arrays.sort(copy);
        endTime = System.currentTimeMillis(); //nanoTime();
        duration = endTime - startTime;
        System.out.println("dur java nativ: " + duration + " ms");
        //System.out.println("dur java nativ: " + duration / 1000 + " ms");
        */


        /*
         * 
        int[] a = {45, 32, 9229, 1, 2, 1, 29, 4, 6, 3, 9, 10};
        Integer[] intAry = {45, 32, 9229, 1, 2, 1, 29, 4, 6, 3, 9, 10};
        Long[] longAry = {new Long(45), new Long(320234829), new Long(9229), new Long(-239), new Long(9999)};
        Double[] doubleAry = {5.4, 2.54, -273.15, 0d, 3.14};

        Comparable[][] gens = {intAry, longAry, doubleAry};

        System.out.println("Merge sort.");
        System.out.println(String.format("Given:  %s", Arrays.toString(a)));
        Merge.sort(a);
        System.out.println(String.format("Sorted: %s", Arrays.toString(a)));
        System.out.println("======================================================");

        for (int i = 0; i < gens.length; i++) {
            Comparable[] a = gens[i];
            System.out.println(String.format("Given:  %s", Arrays.toString(a)));
            Merge.sort(a);
            System.out.println(String.format("Sorted: %s", Arrays.toString(a)));
            System.out.println("======================================================");
        }
        */
    }

    private static void print(int[] ary) {
        System.out.println(Arrays.toString(ary));
    }

    private static int[] random(int i) {
        int random[] = new int[i];
        for (int j = 0; j < i; j++) {
            random[j] = new Random().nextInt(i);
        }
        return random;
    }

}
