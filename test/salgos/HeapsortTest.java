package salgos;

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

import static salgos.TestHelpers.*;

/**
 * Test class for Heapsort.
 * @author Juho Hautala
 */
public class HeapsortTest {

    @Test
    public void parentShouldReturnParentIndexOfGivenLeftChild() {
        assertEquals(0, Heapsort.parent(1));
        assertEquals(1, Heapsort.parent(3));
        assertEquals(2, Heapsort.parent(5));
    }

    @Test
    public void parentShouldReturnParentIndexOfGivenRightChild() {
        assertEquals(0, Heapsort.parent(2));
        assertEquals(1, Heapsort.parent(4));
        assertEquals(2, Heapsort.parent(6));
    }

    @Test
    public void parentShouldReturnNegOneWhenGivenChildIsRoot() {
        assertEquals(-1, Heapsort.parent(0));
    }

    @Test
    public void leftChildShouldReturnLeftChildIndexOfGivenParent() {
        int[] heap = {15, 7, 8, 11, 9, 5};
        assertEquals(1, Heapsort.leftChild(heap, 0));
        assertEquals(3, Heapsort.leftChild(heap, 1));
        assertEquals(5, Heapsort.leftChild(heap, 2));
    }

    @Test
    public void leftChildShouldReturnNegOneWhenParentOutOfBounds() {
        int[] heap = {15, 7, 8, 11, 9, 5};
        assertEquals(-1, Heapsort.leftChild(heap, -1));
        assertEquals(-1, Heapsort.leftChild(heap, heap.length));
    }

    @Test
    public void leftChildShouldReturnNegOneWhenNoLeftChild() {
        int[] a = {238}; int[] b = {22, 11}; int[] c = {33, 11, 22};
        assertEquals(-1, Heapsort.leftChild(a, 0));
        assertEquals(-1, Heapsort.leftChild(b, 1));
        assertEquals(-1, Heapsort.leftChild(c, 2));
    }

    @Test
    public void rightChildShouldReturnRightChildIndexOfGivenParent() {
        int[] heap = {15, 7, 8, 11, 9, 5, 10};
        assertEquals(2, Heapsort.rightChild(heap, 0));
        assertEquals(4, Heapsort.rightChild(heap, 1));
        assertEquals(6, Heapsort.rightChild(heap, 2));
    }

    @Test
    public void rightChildShouldReturnNegOneWhenParentOutOfBounds() {
        int[] heap = {15, 7, 8, 11, 9, 5};
        assertEquals(-1, Heapsort.rightChild(heap, -1));
        assertEquals(-1, Heapsort.rightChild(heap, heap.length));
    }

    @Test
    public void rightChildShouldReturnNegOneWhenNoRightChild() {
        int[] a = {238}; int[] b = {22, 11}; int[] c = {33, 11, 22, 10};
        assertEquals(-1, Heapsort.rightChild(a, 0));
        assertEquals(-1, Heapsort.rightChild(b, 1));
        assertEquals(-1, Heapsort.rightChild(c, 2));
    }

    @Test
    public void swapShouldSwapElementsInGivenAryAtGivenIndices() {
        int ary[] = {99, 77, 44, 11, 66};
        int expected[] = {11, 44, 77, 66, 99};
        Heapsort.swap(ary, 0, 3); // -> {11, 77, 44, 99, 66}
        Heapsort.swap(ary, 1, 2); // -> {11, 44, 77, 99, 66}
        Heapsort.swap(ary, 3, 4); // -> {11, 44, 77, 66, 99}
        assertArrayEquals(expected, ary);
    }

    @Test
    public void swapShouldSwapElementsWhenGivenIndicesInDifferentOrder() {
        int ary[] = {99, 77, 44, 11, 66};
        int expected[] = {11, 44, 77, 66, 99};
        Heapsort.swap(ary, 3, 0); // -> {11, 77, 44, 99, 66}
        Heapsort.swap(ary, 2, 1); // -> {11, 44, 77, 99, 66}
        Heapsort.swap(ary, 4, 3); // -> {11, 44, 77, 66, 99}
        assertArrayEquals(expected, ary);
    }

    @Test
    public void heapifyShouldSwapGreaterToGivenIndex() {
        int ary[] = {0, 4, 5, 3, 1, 2};
        Heapsort.heapify(ary, ary.length, 0);
        assertEquals(5, ary[0]);
    }

    @Test
    public void heapifyShouldSwapGreaterAndSmallerAndHeapifyGreaterIndex() {
        int ary[] = {0, 4, 5, 3, 1, 2};
        int expected[] = {5, 4, 2, 3, 1, 0};
        Heapsort.heapify(ary, ary.length, 0);
        assertArrayEquals(expected, ary);
    }

    @Test
    public void heapifyShouldSwapGreaterAndSmallerAndHeapifyGreaterIndexII() {
        int ary[] = {0, 8, 7, 3, 1, 5, 2};
        int expected[] = {8, 3, 7, 0, 1, 5, 2};
        Heapsort.heapify(ary, ary.length, 0);
        assertArrayEquals(expected, ary);
    }

    @Test
    public void heapifyShouldNotHeapifyBeyondGivenLen() {
        int ary[] = {2, 3, 7, 0, 1, 5, 8};
        int expected[] = {7, 3, 5, 0, 1, 2, 8};
        Heapsort.heapify(ary, (ary.length - 1), 0);
        assertArrayEquals(expected, ary);
    }

    @Test
    public void heapifyShouldNotHeapifyBeyondGivenLenII() {
        int ary[] = {2, 3, 5, 0, 1, 7, 8};
        int expected[] = {5, 3, 2, 0, 1, 7, 8};
        Heapsort.heapify(ary, (ary.length - 2), 0);
        assertArrayEquals(expected, ary);
    }

    @Test
    public void heapifyShouldNotHeapifyBeyondGivenLenIII() {
        int ary[] = {1, 3, 2, 0, 5, 7, 8};
        int expected[] = {3, 1, 2, 0, 5, 7, 8};
        Heapsort.heapify(ary, (ary.length - 3), 0);
        assertArrayEquals(expected, ary);
    }

    @Test
    public void heapifyShouldNotHeapifyBeyondGivenLenIV() {
        int ary[] = {0, 1, 2, 3, 5, 7, 8};
        int expected[] = {2, 1, 0, 3, 5, 7, 8};
        Heapsort.heapify(ary, (ary.length - 4), 0);
        assertArrayEquals(expected, ary);
    }

    @Test
    public void heapifyShouldNotHeapifyBeyondGivenLenV() {
        int ary[] = {0, 1, 2, 3, 5, 7, 8};
        int expected[] = {1, 0, 2, 3, 5, 7, 8};
        Heapsort.heapify(ary, (ary.length - 5), 0);
        assertArrayEquals(expected, ary);
    }

    @Test
    public void buildHeapShouldHeapifyFromLastParentUp() {
        int ary[] = {0, 1, 2, 3, 4, 5};
        int expected[] = {5, 4, 2, 3, 1, 0};
        Heapsort.buildHeap(ary);
        assertArrayEquals(expected, ary);
    }

    @Test
    public void buildHeapShouldHeapifyFromLastParentUpII() {
        int ary[] = {0, 1, 2, 3, 8, 5, 7};
        int expected[] = {8, 3, 7, 0, 1, 5, 2};
        Heapsort.buildHeap(ary);
        assertArrayEquals(expected, ary);
    }

    @Test
    public void sortsGivenArray() {
        int ary[] = {8, 3, 7, 0, 1, 5, 2};
        int expected[] = {0, 1, 2, 3, 5, 7, 8};
        Heapsort.sort(ary);
        assertArrayEquals(expected, ary);
    }

    @Test
    public void arrayOfOneElementIsSorted() {
        int[] ary = {0};
        int[] sorted = {0};
        Heapsort.sort(ary);
        assertArrayEquals(sorted, ary);
    }

    @Test
    public void sortsArrayOfTwoElements() {
        int[] ary = {1, 0};
        int[] sorted = {0, 1};
        Heapsort.sort(ary);
        assertArrayEquals(sorted, ary);
    }

    @Test
    public void sortsArrayOfTwoElementsII() {
        int[] ary = {2, 1};
        int[] sorted = {1, 2};
        Heapsort.sort(ary);
        assertArrayEquals(sorted, ary);
    }

    @Test
    public void sortsArrayOfThreeElements() {
         int[] ary = {2, 1, 0};
         int[] sorted = {0, 1, 2};
         Heapsort.sort(ary);
         assertArrayEquals(sorted, ary);
    }

    @Test
    public void sortsIntsThatAreNotAdjacent() {
        int[] ary = {29, 12, 90, 0, -9};
        int[] sorted = {-9, 0, 12, 29, 90};
        Heapsort.sort(ary);
        assertArrayEquals(ary, sorted);
    }

    @Test
    public void sortsRandomNumbers() {
        int n = 9;
        int[] ary = new int[n];
        for (int i = 0; i < n; i++)
            ary[i] = new Random().nextInt();
        assertFalse(isAscending(ary)); // this could fail...
        Heapsort.sort(ary);
        assertTrue(isAscending(ary));
    }

    @Test
    public void sortsRandomNumbersII() {
        int n = 14;
        int[] ary = new int[n];
        for (int i = 0; i < n; i++)
            ary[i] = new Random().nextInt();
        assertFalse(isAscending(ary)); // this could fail...
        Heapsort.sort(ary);
        assertTrue(isAscending(ary));
    }

}