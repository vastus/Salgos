package salgos;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] ary = {45, 32, 9229, 1, 2, 1, 29, 4, 6, 3, 9, 10};

        System.out.println("Merge sort.");
        System.out.println(String.format("Given:  %s", Arrays.toString(ary)));
        Merge.sort(ary);
        System.out.println(String.format("Sorted: %s", Arrays.toString(ary)));
    }

}
