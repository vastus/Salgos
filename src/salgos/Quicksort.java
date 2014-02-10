package salgos;

import static utils.Helpers.*;

/**
 * Class for Quicksort.
 * @author Juho Hautala
 */
public class Quicksort {

    /**
     * Sorts given array with quicksort.
     * @param ary array to be sorted
     */
    public static void sort(int a[]) {
        sort(a, 0, (a.length - 1));
    }

    /**
     * Recursive quicksort.
     * @param a array to be sorted
     * @param left left index
     * @param right right index
     */
    private static void sort(int a[], int left, int right) { 
        if (right <= left) return;
        int j = partition(a, left, right);
        sort(a, left, j-1);
        sort(a, j+1, right);
    }

    /**
     * Partition the given array with left and right indices.
     * @param a array to be partiotioned
     * @param left start index
     * @param right end index
     * @return index where elements to its left are LTE and
     * elements to its right are GTE
     */
    private static int partition(int a[], int left, int right) {
        int i = left, j = right + 1, pivot = a[left];

        while (true) {
            while (a[++i] < pivot)
                if (i == right) break;

            while (pivot < a[--j])
                if (j == left) break;

            if (i >= j) break;
            swap(a, i, j);
        }

        swap(a, left, j);
        return j;
    }

}
