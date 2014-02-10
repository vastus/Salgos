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
        Integer[] ary = {0};
        Integer[] sorted = {0};
        Quicksort.sort(ary);
        assertArrayEquals(sorted, ary);
    }

    @Test
    public void sortsArrayOfTwoElements() {
        Integer[] ary = {1, 0};
        Integer[] sorted = {0, 1};
        Quicksort.sort(ary);
        assertArrayEquals(sorted, ary);
    }

    @Test
    public void sortsArrayOfTwoElementsII() {
        Integer[] ary = {2, 1};
        Integer[] sorted = {1, 2};
        Quicksort.sort(ary);
        assertArrayEquals(sorted, ary);
    }

    @Test
    public void sortsArrayOfThreeElements() {
         Integer[] ary = {2, 1, 0};
         Integer[] sorted = {0, 1, 2};
         Quicksort.sort(ary);
         assertArrayEquals(sorted, ary);
    }

    @Test
    public void sortsIntsThatAreNotAdjacent() {
        Integer[] ary = {29, 12, 90, 0, -9};
        Integer[] sorted = {-9, 0, 12, 29, 90};
        Quicksort.sort(ary);
        assertArrayEquals(ary, sorted);
    }

    @Test
    public void sortsRandomNumbers() {
        int n = 9;
        Integer[] ary = new Integer[n];
        for (int i = 0; i < n; i++)
            ary[i] = new Random().nextInt();
        assertFalse(isAscending(ary)); // this could fail...
        Quicksort.sort(ary);
        assertTrue(isAscending(ary));
    }

    @Test
    public void sortsRandomNumbersII() {
        int n = 14;
        Integer[] ary = new Integer[n];
        for (int i = 0; i < n; i++)
            ary[i] = new Random().nextInt();
        assertFalse(isAscending(ary)); // this could fail...
        Quicksort.sort(ary);
        assertTrue(isAscending(ary));
    }
}