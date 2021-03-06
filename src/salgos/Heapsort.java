package salgos;

import static utils.Helpers.*;

/**
 * Class for Heapsort.
 * @author Juho Hautala
 */
public class Heapsort {
 
    /**
     * Sorts the given array.
     * @param a array to be sorted
     */
    public static void sort(int a[]) {
        buildHeap(a);

        for (int i = 1; i < a.length; i++) {
            swap(a, 0, a.length - i);
            heapify(a, a.length - i, 0);
        }
    }

    /**
     * Sorts the given array.
     * @param a array to be sorted
     */
    public static void sort(Comparable a[]) {
        buildHeap(a);

        for (int i = 1; i < a.length; i++) {
            swap(a, 0, a.length - i);
            heapify(a, a.length - i, 0);
        }
    }

    /**
     * Builds a heap from the given array.
     * Calls heapify for last parent node the tree up to the root.
     * @param a array to be converted
     */
    public static void buildHeap(int a[]) {
        for (int i = parent(a.length - 1); -1 < i; i--) {
            heapify(a, a.length, i);
        }
    }

    /**
     * Builds a heap from the given array.
     * Calls heapify for last parent node the tree up to the root.
     * @param a array to be converted
     */
    public static void buildHeap(Comparable a[]) {
        for (int i = parent(a.length - 1); -1 < i; i--) {
            heapify(a, a.length, i);
        }
    }
 
    /**
     * Heapifies the given array.
     * @param a array to heapify
     * @param len heapify only elements that are less than len
     * @param i start node
     */
    public static void heapify(int a[], int len, int i) {
        if (i < 0) return;
 
        int l = (2 * i + 1);
        int r = l + 1;
        int greater;

        if (r < len) { // We have both children.
            greater = (a[l] < a[r]) ? r : l;
 
            // Compare if i needs to be swapped.
            if (a[i] < a[greater]) {
                swap(a, i, greater);
                heapify(a, len, greater);
            }
        }

        if (l == (len - 1) && a[i] < a[l])
            swap(a, i, l);
    }
    /**
     * Heapifies the given array.
     * @param a array to heapify
     * @param len heapify only elements that are less than len
     * @param i start node
     */
    public static void heapify(Comparable a[], int len, int i) {
        if (i < 0) return;
 
        int l = (2 * i + 1);
        int r = l + 1;
        int greater;

        if (r < len) { // We have both children.
            // greater = (a[l] < a[r]) ? r : l;
            greater = (a[l].compareTo(a[r]) < 0) ? r : l;
 
            // Compare if i needs to be swapped.
            if (a[i].compareTo(a[greater]) < 0) {
                swap(a, i, greater);
                heapify(a, len, greater);
            }
        }

        if (l == (len - 1) && (a[i].compareTo(a[l]) < 0))
            swap(a, i, l);
    }
 
    /**
     * Parent node's index of given child.
     * @param child calculate parent of this given child
     * @return parent node's index
     */
    public static int parent(int child) {
        return (child / 2) + (child % 2) - 1;
    }
 
    /**
     * Left child's node index of given parent.
     * @param heap heap array where parent is
     * @param parent parent node's index
     * @return left child's node index or -1 if none or out of bounds
     */
    public static int leftChild(int heap[], int parent) {
        return child(heap, parent, 1);
    }
 
    /**
     * Right child's node index of given parent.
     * @param heap heap array where parent is
     * @param parent parent node's index
     * @return right child's node index or -1 if none or out of bounds
     */
    public static int rightChild(int heap[], int parent) {
        return child(heap, parent, 2);
    }
 
    /**
     * Calculates given parent's child w/ offset (left or right)
     * @param heap heap array where parent is
     * @param parent parent node's index
     * @param offset offset of child (left = 1, right = 2)
     * @return child node's index of -1 if none or out of bounds
     */
    private static int child(int heap[], int parent, int offset) {
        int child = (2 * parent + offset);
        if (0 < child && child < heap.length)
            return child;
        
        return -1;
    }
 
}
