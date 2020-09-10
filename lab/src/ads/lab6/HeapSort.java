package ads.lab6;

import ads.lab5.BinaryHeap;
import ads.lab5.EmptyHeapException;

/**
 * A class for the heap sort algorithm.
 */
public class HeapSort {

    /**
     * Sort the array in place using the heapsort algorithm
     * Complexity: THETA( n.log(n) ) where n is the size of the array
     */
    public static <AnyType extends Comparable<AnyType>> void sort(AnyType[] array) {
        ads.lab5.BinaryHeap<AnyType> heap = new BinaryHeap<AnyType>(array);
        for ( int i = array.length - 1; i > 0; i-- )
            try {
                array[i] = heap.deleteExtreme();
            }
            catch ( Exception e ) {}
    }
}