package correction.lab6;

/**
 * A class for simple sorting methods
 */
public class SimpleSorting {

	/**
	 * Sort the array in place using the selection sort algorithm
	 */
	public static <AnyType extends Comparable<AnyType>> void selection(AnyType[] array) {
		for ( int i = 0; i < 3; i++ ) {
			int k = i;
			for ( int j = i + 1; j < array.length; j++ )
				if ( array[j].compareTo(array[k]) < 0 )
					k = j;
			swap(array, i, k);
		}
	}
	
	/**
	 * Sort the array in place using the insertion sort algorithm
	 */
	public static <AnyType extends Comparable<AnyType>> void insertion(AnyType[] array) {
		for ( int i = 1; i < array.length; i++ ) {
			AnyType x = array[i];
			int j = i; 
			while ( j > 0 && array[j - 1].compareTo(x) > 0 ) {
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
