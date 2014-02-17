package salgos;

import java.util.Arrays;
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

import static salgos.TestHelpers.*;


/**
 * Test class for BubbleSort.
 * @author Juho Hautala
 */
public class BubbleSortTest {
    private void p(int a[]) {
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void sortsArrayOfTwoElements() {
        int[] ary = {1, 0};
        int[] sorted = {0, 1};
        BubbleSort.sort(ary);
        assertArrayEquals(sorted, ary);
    }

    @Test
    public void sortsArrayOfTwoElementsII() {
        int[] ary = {2, 1};
        int[] sorted = {1, 2};
        BubbleSort.sort(ary);
        assertArrayEquals(sorted, ary);
    }

    @Test
    public void sortsArrayOfThreeElements() {
         int[] ary = {2, 1, 0};
         int[] sorted = {0, 1, 2};
         BubbleSort.sort(ary);
         assertArrayEquals(sorted, ary);
    }

    @Test
    public void sortsIntsThatAreNotAdjacent() {
        int[] ary = {29, 12, 90, 0, -9};
        int[] sorted = {-9, 0, 12, 29, 90};
        BubbleSort.sort(ary);
        assertArrayEquals(ary, sorted);
    }

    @Test
    public void sortsRandomNumbers() {
        int n = 9;
        int[] ary = new int[n];
        for (int i = 0; i < n; i++)
            ary[i] = new Random().nextInt();
        assertFalse(isAscending(ary)); // this could fail...
        BubbleSort.sort(ary);
        assertTrue(isAscending(ary));
    }

    @Test
    public void sortsRandomNumbersII() {
        int n = 14;
        int[] ary = new int[n];
        for (int i = 0; i < n; i++)
            ary[i] = new Random().nextInt();
        assertFalse(isAscending(ary)); // this could fail...
        BubbleSort.sort(ary);
        assertTrue(isAscending(ary));
    }

}