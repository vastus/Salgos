package salgos;

/**
 * Helper methods needed in tests.
 * @author Juho Hautala
 */
public class TestHelpers {
 
    /**
     * Checks that given array is sorted in ascending order.
     * @param ary array to be checked
     * @return true if sorted in ascending order, false otherwise
     */
    protected static boolean isAscending(int[] ary) {
        for (int i = 0; i < (ary.length - 1); i++)
            if (ary[i] > ary[(i + 1)])
                return false;
        return true;
    }

    /**
     * Checks that given array is sorted in ascending order.
     * @param ary array to be checked
     * @return true if sorted in ascending order, false otherwise
     */
    protected static boolean isAscending(Comparable[] ary) {
        for (int i = 0; i < (ary.length - 1); i++)
            if (ary[i].compareTo(ary[(i + 1)]) > 0)
                return false;
        return true;
    }

}
