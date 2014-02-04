package salgos;

import static utils.Helpers.*;

/**
 * Class for Bubble sort.
 * @author Juho Hautala
 */
public class BubbleSort {

    /**
     * Boolean value if array needs sorting or not.
     */
    private static boolean sorting = true;

    /**
     * Sort the given array using bubble sort.
     * @param ary array to be sorted
     */
    public static void sort(int ary[]) {
        // Loop thru only once if ary
        // already in ascending sorted order.
        while (sorting) {
            sorting = false;
            for (int i = 1; i < ary.length; i++) {
                if (ary[i] < ary[(i - 1)]) {
                    // Swap needs to be done.
                    swap(ary, (i - 1), i);

                    // Continue sorting.
                    sorting = true;
                }
            }
        }
    }

}