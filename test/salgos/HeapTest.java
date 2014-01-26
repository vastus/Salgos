package salgos;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for Heap.
 * @author Juho Hautala
 */
public class HeapTest {

    @Test
    public void parentShouldReturnParentIndexOfGivenLeftChild() {
        assertEquals(0, Heap.parent(1));
        assertEquals(1, Heap.parent(3));
        assertEquals(2, Heap.parent(5));
    }

    @Test
    public void parentShouldReturnParentIndexOfGivenRightChild() {
        assertEquals(0, Heap.parent(2));
        assertEquals(1, Heap.parent(4));
        assertEquals(2, Heap.parent(6));
    }

    @Test
    public void parentShouldReturnNegOneWhenGivenChildIsRoot() {
        assertEquals(-1, Heap.parent(0));
    }

    @Test
    public void leftChildShouldReturnLeftChildIndexOfGivenParent() {
        int[] heap = {15, 7, 8, 11, 9, 5};
        assertEquals(1, Heap.leftChild(heap, 0));
        assertEquals(3, Heap.leftChild(heap, 1));
        assertEquals(5, Heap.leftChild(heap, 2));
    }

    @Test
    public void leftChildShouldReturnNegOneWhenParentOutOfBounds() {
        int[] heap = {15, 7, 8, 11, 9, 5};
        assertEquals(-1, Heap.leftChild(heap, -1));
        assertEquals(-1, Heap.leftChild(heap, heap.length));
    }

    @Test
    public void leftChildShouldReturnNegOneWhenNoLeftChild() {
        int[] a = {238}; int[] b = {22, 11}; int[] c = {33, 11, 22};
        assertEquals(-1, Heap.leftChild(a, 0));
        assertEquals(-1, Heap.leftChild(b, 1));
        assertEquals(-1, Heap.leftChild(c, 2));
    }

    @Test
    public void rightChildShouldReturnRightChildIndexOfGivenParent() {
        int[] heap = {15, 7, 8, 11, 9, 5, 10};
        assertEquals(2, Heap.rightChild(heap, 0));
        assertEquals(4, Heap.rightChild(heap, 1));
        assertEquals(6, Heap.rightChild(heap, 2));
    }

    @Test
    public void rightChildShouldReturnNegOneWhenParentOutOfBounds() {
        int[] heap = {15, 7, 8, 11, 9, 5};
        assertEquals(-1, Heap.rightChild(heap, -1));
        assertEquals(-1, Heap.rightChild(heap, heap.length));
    }

    @Test
    public void rightChildShouldReturnNegOneWhenNoRightChild() {
        int[] a = {238}; int[] b = {22, 11}; int[] c = {33, 11, 22, 10};
        assertEquals(-1, Heap.rightChild(a, 0));
        assertEquals(-1, Heap.rightChild(b, 1));
        assertEquals(-1, Heap.rightChild(c, 2));
    }

    @Test
    public void swapShouldSwapElementsInGivenAryAtGivenIndices() {
        int ary[] = {99, 77, 44, 11, 66};
        int expected[] = {11, 44, 77, 66, 99};
        Heap.swap(ary, 0, 3); // -> {11, 77, 44, 99, 66}
        Heap.swap(ary, 1, 2); // -> {11, 44, 77, 99, 66}
        Heap.swap(ary, 3, 4); // -> {11, 44, 77, 66, 99}
        assertArrayEquals(expected, ary);
    }

    @Test
    public void swapShouldSwapElementsWhenGivenIndicesInDifferentOrder() {
        int ary[] = {99, 77, 44, 11, 66};
        int expected[] = {11, 44, 77, 66, 99};
        Heap.swap(ary, 3, 0); // -> {11, 77, 44, 99, 66}
        Heap.swap(ary, 2, 1); // -> {11, 44, 77, 99, 66}
        Heap.swap(ary, 4, 3); // -> {11, 44, 77, 66, 99}
        assertArrayEquals(expected, ary);
    }

    @Test
    public void heapifyShouldSwapGreaterToGivenIndex() {
        int ary[] = {0, 4, 5, 3, 1, 2};
        Heap.heapify(ary, ary.length, 0);
        assertEquals(5, ary[0]);
    }

    @Test
    public void heapifyShouldSwapGreaterAndSmallerAndHeapifyGreaterIndex() {
        int ary[] = {0, 4, 5, 3, 1, 2};
        int expected[] = {5, 4, 2, 3, 1, 0};
        Heap.heapify(ary, ary.length, 0);
        assertArrayEquals(expected, ary);
    }

    @Test
    public void heapifyShouldSwapGreaterAndSmallerAndHeapifyGreaterIndexII() {
        int ary[] = {0, 8, 7, 3, 1, 5, 2};
        int expected[] = {8, 3, 7, 0, 1, 5, 2};
        Heap.heapify(ary, ary.length, 0);
        assertArrayEquals(expected, ary);
    }

    @Test
    public void heapifyShouldNotHeapifyBeyondGivenLen() {
        int ary[] = {2, 3, 7, 0, 1, 5, 8};
        int expected[] = {7, 3, 5, 0, 1, 2, 8};
        Heap.heapify(ary, (ary.length - 1), 0);
        assertArrayEquals(expected, ary);
    }

    @Test
    public void heapifyShouldNotHeapifyBeyondGivenLenII() {
        int ary[] = {2, 3, 5, 0, 1, 7, 8};
        int expected[] = {5, 3, 2, 0, 1, 7, 8};
        Heap.heapify(ary, (ary.length - 2), 0);
        assertArrayEquals(expected, ary);
    }

    @Test
    public void heapifyShouldNotHeapifyBeyondGivenLenIII() {
        int ary[] = {1, 3, 2, 0, 5, 7, 8};
        int expected[] = {3, 1, 2, 0, 5, 7, 8};
        Heap.heapify(ary, (ary.length - 3), 0);
        assertArrayEquals(expected, ary);
    }

    @Test
    public void heapifyShouldNotHeapifyBeyondGivenLenIV() {
        int ary[] = {0, 1, 2, 3, 5, 7, 8};
        int expected[] = {2, 1, 0, 3, 5, 7, 8};
        Heap.heapify(ary, (ary.length - 4), 0);
        assertArrayEquals(expected, ary);
    }

    @Test
    public void heapifyShouldNotHeapifyBeyondGivenLenV() {
        int ary[] = {0, 1, 2, 3, 5, 7, 8};
        int expected[] = {1, 0, 2, 3, 5, 7, 8};
        Heap.heapify(ary, (ary.length - 5), 0);
        assertArrayEquals(expected, ary);
    }

    @Test
    public void buildHeapShouldHeapifyFromLastParentUp() {
        int ary[] = {0, 1, 2, 3, 4, 5};
        int expected[] = {5, 4, 2, 3, 1, 0};
        Heap.buildHeap(ary);
        assertArrayEquals(expected, ary);
    }

    @Test
    public void buildHeapShouldHeapifyFromLastParentUpII() {
        int ary[] = {0, 1, 2, 3, 8, 5, 7};
        int expected[] = {8, 3, 7, 0, 1, 5, 2};
        Heap.buildHeap(ary);
        assertArrayEquals(expected, ary);
    }


}