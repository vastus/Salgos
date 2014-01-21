package salgos;

public class Merge {

    public static void sort(int[] ary) {
        // Sorted if less than 2 elements.
        if (ary.length < 2) return;

        // Divide.
        int[][] s = divide(ary);

        // Recur.
        sort(s[0]); sort(s[1]);

        // Conquer.
        merge(ary, s[0], s[1]);
    }

    /**
     * Divide the given array in two sub-arrays.
     * @param ary array to be halved
     * @return sub-arrays of ary
     */
    public static int[][] divide(int[] ary) {
        int len = ary.length;
        int mid = len / 2;
        int[] first = new int[mid];
        int[] last = new int[mid + (len %2)];

        int i = 0, j = 0, k = 0;
        while (i < first.length) first[i++] = ary[k++];
        while (j < last.length) last[j++] = ary[k++];

        return new int[][] {first, last};
    }

    /**
     * Merges given sub-arrays in ascending order
     * to the array ary being sorted.
     * @param ary array to be sorted
     * @param a first half of ary
     * @param b second half of ary
     */
    public static void merge(int[] ary, int[] a, int[] b) {
        // Loop until we've gone thru sub-arrays a and/or b.
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length)
            ary[k++] = (a[i] <= b[j]) ? a[i++] : b[j++];

        // Loop thru the remaining elements.
        while (i < a.length) ary[k++] = a[i++];
        while (j < b.length) ary[k++] = b[j++];
    }

}
