package utils;

/**
 * Helper utilities class.
 * @author Juho Hautala
 */
public class Helpers {

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

    /**
     * Swaps given array's elements from given indices.
     * @param ary array whose elements to be swapped
     * @param i first element's index
     * @param j second element's index
     */
    public static void swap(Comparable ary[], int i, int j) {
        Comparable temp = ary[i];
        ary[i] = ary[j];
        ary[j] = temp;
    }

}
