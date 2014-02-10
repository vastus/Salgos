package salgos;

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

import static salgos.TestHelpers.*;

/**
 * Test class for Quicksort.
 * @author Juho Hautala
 */
public class QuicksortTest {

    @Test
    public void arrayOfOneElementIsSorted() {
        int[] ary = {0};
        int[] sorted = {0};
        Quicksort.sort(ary);
        assertArrayEquals(sorted, ary);
    }

    @Test
    public void sortsArrayOfTwoElements() {
        int[] ary = {1, 0};
        int[] sorted = {0, 1};
        Quicksort.sort(ary);
        assertArrayEquals(sorted, ary);
    }

    @Test
    public void sortsArrayOfTwoElementsII() {
        int[] ary = {2, 1};
        int[] sorted = {1, 2};
        Quicksort.sort(ary);
        assertArrayEquals(sorted, ary);
    }

    @Test
    public void sortsArrayOfThreeElements() {
         int[] ary = {2, 1, 0};
         int[] sorted = {0, 1, 2};
         Quicksort.sort(ary);
         assertArrayEquals(sorted, ary);
    }

    @Test
    public void sortsIntsThatAreNotAdjacent() {
        int[] ary = {29, 12, 90, 0, -9};
        int[] sorted = {-9, 0, 12, 29, 90};
        Quicksort.sort(ary);
        assertArrayEquals(ary, sorted);
    }

    @Test
    public void sortsRandomNumbers() {
        int n = 9;
        int[] ary = new int[n];
        for (int i = 0; i < n; i++)
            ary[i] = new Random().nextInt();
        assertFalse(isAscending(ary)); // this could fail...
        Quicksort.sort(ary);
        assertTrue(isAscending(ary));
    }

    @Test
    public void sortsRandomNumbersII() {
        int n = 14;
        int[] ary = new int[n];
        for (int i = 0; i < n; i++)
            ary[i] = new Random().nextInt();
        assertFalse(isAscending(ary)); // this could fail...
        Quicksort.sort(ary);
        assertTrue(isAscending(ary));
    }
    
}