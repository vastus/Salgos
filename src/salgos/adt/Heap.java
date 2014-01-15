package salgos.adt;

/**
 * Interface for a binary-tree-heap.
 * @author Juho Hautala
 */
public interface Heap<E> {

    /**
     * Adds given element to heap.
     * @param element the element to be added
     * @return true if the element was added
     */
    boolean add(E element);

    /**
     * Retrieves the head of this heap w/o removing it.
     * @return head, or null if heap is empty
     */
    E peek();

    /**
     * Retrieves and removes the head of this heap.
     * @return head, or null if heap is empty
     */
    E poll();

}
