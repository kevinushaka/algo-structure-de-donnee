package correction.lab6;

/**
 * A class for the quicksort algorithm
 */
public class QuickSort {
	
	private static final int CUTOFF = 10;
	
	/**
	 * Sort the array in place using the quicksort algorithm
	 */
	public static <AnyType extends Comparable<AnyType>> void sort(AnyType[] array) {
		sort(array,0,array.length-1);
	}

	/**
	 * Sort the portion array[lo,hi] in place using the quicksort algorithm
	 */	
	private static <AnyType extends Comparable<AnyType>> void sort(AnyType[] array, int lo, int hi) {
		if ( hi - lo < CUTOFF )
			insertion(array,lo,hi);
		else {
			int pivot = partition(array,lo,hi);
			sort(array,lo,pivot - 1);
			sort(array,pivot + 1,hi);
		}
	}

	/**
	 * Partition the portion array[lo,hi] and return the index of the pivot
	 */
	private static <AnyType extends Comparable<AnyType>> int partition(AnyType[] array, int lo, int hi) {
		swap(array,lo,median(array,lo,(lo + hi)/2,hi));
		AnyType pivot = array[lo];
		int p = lo;
		for ( int i = lo + 1; i <= hi; i++ )
			if ( array[i].compareTo(pivot) < 0 )
				swap(array,i,++p);
		swap(array,lo,p);
		return p;
	}

	/**
	 * Return the index of the median of { array[lo], array[mid], array[hi] }
	 */
	private static <AnyType extends Comparable<AnyType>> int median(AnyType[] array, int lo, int mid, int hi) {
		if ( array[lo].compareTo(array[mid]) < 0 ) {
			if ( array[mid].compareTo(array[hi]) < 0 )
				return mid;
			if ( array[lo].compareTo(array[hi]) < 0 )
				return hi;
			return lo;
		}
		else {
			if ( array[lo].compareTo(array[hi]) < 0 )
				return lo;
			if ( array[mid].compareTo(array[hi]) < 0 )
				return hi;
			return mid;				
		}				
	}
	
	/**
	 * Sort array[lo, hi] in place using the insertion sort algorithm
	 */
	private static <AnyType extends Comparable<AnyType>> void insertion(AnyType[] array, int lo, int hi) {
		for ( int i = lo + 1; i <= hi; i++ ) {
			AnyType x = array[i];
			int j = i; 
			while ( j > lo && array[j - 1].compareTo(x) > 0 ) {
				array[j] = array[j - 1];
				j = j - 1;
			}
			array[j] = x;
		}
	}
	
	/**
	 * Swap array[i] and array[j]
	 */
	private static <AnyType> void swap(AnyType[] array, int i, int j) {
		AnyType tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}
