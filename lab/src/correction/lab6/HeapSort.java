package correction.lab6;

import ads.graph.Edge;
import correction.lab5.BinaryHeap;

import java.util.Comparator;

/**
 * A class for the heap sort algorithm.
 */
public class HeapSort {
	
	/**
	 * Sort the array in place using the heapsort algorithm
	 * Complexity: THETA( n.log(n) ) where n is the size of the array
	 */	
	public static <AnyType extends Comparable<AnyType>> void sort(AnyType[] array) {
		//minHeap
		Comparator<AnyType> c = new Comparator<AnyType>() {
			@Override
			public int compare(AnyType e2, AnyType e1) {
				return e1.compareTo(e2);
			}
		};
		BinaryHeap<AnyType> heap = new BinaryHeap<AnyType>(array,c);
		for ( int i = array.length - 1; i > 0; i-- )
			try {
				array[i] = heap.deleteExtreme();
			}
			catch ( Exception e ) {}

		//[23, 25, 34, 45, 43, 17, 12, 2]
	}
}
