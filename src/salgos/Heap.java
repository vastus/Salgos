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
            //System.out.println(len-i);
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
        //int len = a.length;
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
    
    
    
    
    
    /*
    public static void heapSort(int[] a){
        int count = a.length;
        
        //first place a in max-heap order
        heapivai(a, count);
        
        int end = count - 1;
        while(end > 0){
            //swap the root(maximum value) of the heap with the
            //last element of the heap
            int tmp = a[end];
            a[end] = a[0];
            a[0] = tmp;
            //put the heap back in max-heap order
            siftDown(a, 0, end - 1);
            //decrement the size of the heap so that the previous
            //max value will stay in its proper place
            end--;
        }
    }
    
    public static void heapivai(int[] a, int count){
        //start is assigned the index in a of the last parent node
        int start = (count - 2) / 2; //binary heap
        
        while(start >= 0){
            //sift down the node at index start to the proper place
            //such that all nodes below the start index are in heap
            //order
            siftDown(a, start, count - 1);
            start--;
        }
        //after sifting down the root all nodes/elements are in heap order
    }
    
    public static void siftDown(int[] a, int start, int end){
        //System.out.println("in siftDown");
        //end represents the limit of how far down the heap to sift
        int root = start;
        
        while((root * 2 + 1) <= end){      //While the root has at least one child
            int child = root * 2 + 1;           //root*2+1 points to the left child
            //if the child has a sibling and the child's value is less than its sibling's...
            if(child + 1 <= end && a[child] < a[child + 1])
                child = child + 1;           //... then point to the right child instead
            if(a[root] < a[child]){     //out of max-heap order
                int tmp = a[root];
                a[root] = a[child];
                a[child] = tmp;
                root = child;                //repeat to continue sifting down the child now
            }else
                return;
        }
    }
    
    
    */
    
    
    
    
}
