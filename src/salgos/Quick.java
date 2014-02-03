package salgos;

/**
 * Class for quick sort.
 * @author Juho Hautala
 */
public class Quick {
    
    /**
     * Sorts given array with quicksort.
     * @param ary array to be sorted
     */
    public static void sort(int[] ary) {
        if (ary.length < 2) return;
        quicksort(ary, 0, ary.length - 1);
    }
    
    /**
     * Recursive quicksort.
     * @param ary ary to be sorted
     * @param left left index
     * @param right right index
     */
    private static void quicksort(int ary[], int left, int right) {
        int i = left, j = right, pivot = ary[0];

        // Divide.
        while (i <= j) {
            while (ary[i] < pivot) i++;
            while (ary[j] > pivot) j--;

            if (i <= j) {
                swap(ary, i, j);
                i += 1;
                j -= 1;
            }
        }

        // Recur.
        if (left < j) quicksort(ary, left, j);
        if (i < right) quicksort(ary, i, right);
    }
    
    /**
     * Swaps given array's elements from given indices.
     * @param ary array whose elements to be swapped
     * @param i first element's index
     * @param j second element's index
     */
    public static void swap(int ary[], int i, int j) {
        int temp = ary[i];
        ary[i] = ary[j];
        ary[j] = temp;
    }
    
}
