package salgos;

/**
 * Class for heap sort.
 * @author Juho Hautala
 */
public class Heap {
 
    public static void sort(int a[]) {
        buildHeap(a);

        for (int i = 1; i < a.length; i++) {
            swap(a, 0, a.length - i);
            heapify(a, a.length - i, 0);
        }
    }

    public static void buildHeap(int a[]) {
        for (int i = parent(a.length - 1); -1 < i; i--) {
            heapify(a, a.length, i);
        }
    }
 
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
 
    public static int parent(int child) {
        return (child / 2) + (child % 2) - 1;
    }
 
    public static int leftChild(int heap[], int parent) {
        return child(heap, parent, 1);
    }
 
    public static int rightChild(int heap[], int parent) {
        return child(heap, parent, 2);
    }
 
    private static int child(int heap[], int parent, int offset) {
        int child = (2 * parent + offset);
        if (0 < child && child < heap.length)
            return child;
        
        return -1;
    }
 
    public static void swap(int ary[], int i, int j) {
        int temp = ary[i];
        ary[i] = ary[j];
        ary[j] = temp;
    }
 
}
