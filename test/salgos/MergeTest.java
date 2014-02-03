package salgos;

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

import static salgos.TestHelpers.*;

/**
 * Test class for Merge.
 * @author Juho Hautala
 */
public class MergeTest {

    @Test
    public void arrayOfOneElementIsSorted() {
        int[] ary = {0};
        int[] sorted = {0};
        Merge.sort(ary);
        assertArrayEquals(sorted, ary);
    }

    @Test
    public void sortsArrayOfTwoElements() {
        int[] ary = {1, 0};
        int[] sorted = {0, 1};
        Merge.sort(ary);
        assertArrayEquals(sorted, ary);
    }

    @Test
    public void sortsArrayOfTwoElementsII() {
        int[] ary = {2, 1};
        int[] sorted = {1, 2};
        Merge.sort(ary);
        assertArrayEquals(sorted, ary);
    }

    @Test
    public void sortsArrayOfThreeElements() {
         int[] ary = {2, 1, 0};
         int[] sorted = {0, 1, 2};
         Merge.sort(ary);
         assertArrayEquals(sorted, ary);
    }

    @Test
    public void sortsIntsThatAreNotAdjacent() {
        int[] ary = {29, 12, 90, 0, -9};
        int[] sorted = {-9, 0, 12, 29, 90};
        Merge.sort(ary);
        assertArrayEquals(ary, sorted);
    }

    @Test
    public void sortsRandomNumbers() {
        int n = 9;
        int[] ary = new int[n];
        for (int i = 0; i < n; i++)
            ary[i] = new Random().nextInt();
        assertFalse(isAscending(ary)); // this could fail...
        Merge.sort(ary);
        assertTrue(isAscending(ary));
    }

    @Test
    public void sortsRandomNumbersII() {
        int n = 14;
        int[] ary = new int[n];
        for (int i = 0; i < n; i++)
            ary[i] = new Random().nextInt();
        assertFalse(isAscending(ary)); // this could fail...
        Merge.sort(ary);
        assertTrue(isAscending(ary));
    }
    
    @Test
    public void divideShouldReturn2DAryOfLen2() {
        int[] ary = {0, 1};
        int[][] subs = Merge.divide(ary);
        assertEquals(2, subs.length);
    }
 
    @Test
    public void divideReturns2DAryWhereElemLenIsHalfOfAryLenWhenEvenI() {
        int[] ary = {0, 1};
        int[][] subs = Merge.divide(ary);
        assertEquals(1, subs[0].length);
        assertEquals(1, subs[1].length);
    }
 
    @Test
    public void divideReturns2DAryWhereElemLenIsHalfOfAryLenWhenEvenII() {
        int[] ary = {23, 49, 2, 99};
        int[][] subs = Merge.divide(ary);
        assertEquals(2, subs[0].length);
        assertEquals(2, subs[1].length);
    }

    @Test
    public void divideReturns2DAryWhereFirstHalfIsFloorOfHalfOfAryLenWhenOdd() {
        int[] ary = {3, 2, 1};
        int[][] subs = Merge.divide(ary);
        assertEquals(1, subs[0].length);
    }

    @Test
    public void divideReturns2DAryWhereLastHalfIsCeilOfHalfOfAryLenWhenOdd() {
        int[] ary = {3, 2, 1};
        int[][] subs = Merge.divide(ary);
        assertEquals(2, subs[1].length);
    }

    @Test
    public void divideReturns2DAryOfRightSizeWhenAryLenIsOdd() {
        int[] ary = {23, 83, 6, 11, 4820};
        int[][] subs = Merge.divide(ary);
        assertEquals(2, subs[0].length);
        assertEquals(3, subs[1].length);
    }

    @Test
    public void divideReturnsSubArysOfAryWhenEven() {
        int[] ary = {99, 1};
        int[][] subs = Merge.divide(ary);
        int[] first = {99};
        int[] last = {1};
        assertArrayEquals(first, subs[0]);
        assertArrayEquals(last, subs[1]);
    }

    @Test
    public void divideReturnsSubArysOfAryWhenEvenII() {
        int[] ary = {99, 2389, 1, 13478};
        int[][] subs = Merge.divide(ary);
        int[] first = {99, 2389};
        int[] last = {1, 13478};
        assertArrayEquals(first, subs[0]);
        assertArrayEquals(last, subs[1]);
    }

    @Test
    public void divideReturnsSubArysOfAryWhenOdd() {
        int[] ary = {99, 0, 1};
        int[][] subs = Merge.divide(ary);
        int[] first = {99};
        int[] last = {0, 1};
        assertArrayEquals(first, subs[0]);
        assertArrayEquals(last, subs[1]);
    }

    @Test
    public void divideReturnsSubArysOfAryWhenOddII() {
        int[] ary = {99, 0, 1, 7, 32, 329, 138};
        int[][] subs = Merge.divide(ary);
        int[] first = {99, 0, 1};
        int[] last = {7, 32, 329, 138};
        assertArrayEquals(first, subs[0]);
        assertArrayEquals(last, subs[1]);
    }

    @Test
    public void mergeSortsTwoArysOfSizeOneToGivenAryWhenAryLenEven() {
        int[] ary = {1, 0};
        int[] first = {1};
        int[] last = {0};
        int[] sorted = {0, 1};
        Merge.merge(ary, first, last);
        assertArrayEquals(sorted, ary);
    }

    @Test
    public void mergeComparesAndMergesFirstElemsWhenOdd() {
        int[] ary = {2, 1, 0};
        int[] first = {2};
        int[] last = {1, 0};
        int[] expected = {1, 0, 2};
        Merge.merge(ary, first, last);
        assertArrayEquals(expected, ary);
    }

    @Test
    public void mergeComparesAndMergesFirstElemsWhenEven() {
        int[] ary = {99, 11, 55, 77};
        int[] first = {99, 11};
        int[] last = {55, 77};
        int[] expected = {55, 77, 99, 11};
        Merge.merge(ary, first, last);
        assertArrayEquals(expected, ary);
    }
    
}