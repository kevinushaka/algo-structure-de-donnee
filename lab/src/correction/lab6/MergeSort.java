package correction.lab6;

/**
 * A class for the recursive merge sort algorithm.
 */
public class MergeSort {

	/**
	 * Sort the array using the recursive merge sort algorithm.
	 * This algorithm is not in place and needs an auxiliary array of
	 * the same size than the array to sort
	 * Complexity: THETA( n.log(n) ) where n is the size of the array
	 */
	@SuppressWarnings("unchecked")
	public static <AnyType extends Comparable<AnyType>> void sort(AnyType[] array) {
		AnyType[] tmp = (AnyType[]) new Comparable[array.length];
		sort(array,tmp,0,array.length - 1);
	}
	
	/**
	 * Sort the array in the range [lo, hi] using the portion [lo, hi]
	 * of the auxiliary array tmp
	 * Complexity: THETA( n.log(n) ) where n = hi - lo + 1
	 */
	private static <AnyType extends Comparable<AnyType>> void sort(AnyType[] array, AnyType[] tmp, int lo, int hi) {
		if ( lo < hi ) {
			int mid = (lo + hi)/2;
			sort(array,tmp,lo,mid);
			sort(array,tmp,mid + 1,hi);
			merge(array,tmp,lo,mid,hi);
			transfer(tmp,array,lo,hi);
		}
	}
	
	/**
	 * Merge array[lo, mid] and array[mid+1, hi] into tmp[lo, hi]
	 * Precondition: array[lo, mid] and array[mid+1, hi] are sorted
	 * Complexity: THETA( n ) where n = hi - lo + 1
	 */
	private static <AnyType extends Comparable<AnyType>> void merge(AnyType[] array, AnyType[] tmp, int lo, int mid, int hi) {
		int l = lo;
		int r = mid + 1;
		int m = lo;
		while ( l <= mid && r <= hi )
			if ( array[l].compareTo(array[r]) < 0 )
				tmp[m++] = array[l++];
			else
				tmp[m++] = array[r++];
		while ( l <= mid )
			tmp[m++] = array[l++];
		while ( r <= hi )
			tmp[m++] = array[r++];
	}
	
	/**
	 * Copy the elements from tmp[lo, hi] into array[lo, hi]
	 * Complexity: THETA( n ) where n = hi - lo + 1
	 */
	private static <AnyType> void transfer(AnyType[] tmp, AnyType[] array, int lo, int hi) {
		for ( int i = lo; i <= hi; i++ )
			array[i] = tmp[i];
	}
}
