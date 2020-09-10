package ads.lab6;

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
        if(array.length<=1){
            tmp=(AnyType[]) new Comparable[1];
            tmp[0]=array[lo];
        }{
            AnyType[] firsthalf=(AnyType[]) new Comparable[hi-lo];
            AnyType[] secondhalf=(AnyType[]) new Comparable[hi-lo];
            int mid=hi/2;
            sort(array,firsthalf,0, mid-1);
            sort(array,secondhalf,mid,hi);
            merge(firsthalf,secondhalf,0,mid,hi);
            tmp=(AnyType[]) new Comparable[hi];
            for(int i=0;i<hi;i++)
                tmp[i]=firsthalf[i];
        }
    }

    /**
     * Merge array[lo, mid] and array[mid+1, hi] into tmp[lo, hi]
     * and copy back the result into array[lo, hi]
     * Precondition: array[lo, mid] and array[mid+1, hi] are sorted
     * Complexity: THETA( n ) where n = hi - lo + 1
     */
    private static <AnyType extends Comparable<AnyType>> void merge(AnyType[] array, AnyType[] tmp, int lo, int mid, int hi) {
            int i=0,j=0,k=0;
        AnyType[] sorted=(AnyType[]) new Comparable[hi];
            while (k++<hi){
                if(i<mid &&array[i].compareTo(tmp[j])<0) {
                    sorted[k] = array[i];
                    i++;
                }else if(j<mid){
                    sorted[k]=tmp[j];
                    j++;
                }
            }
            array=(AnyType[]) new Comparable[hi];
            for(int m=0;m<hi;m++)
                array[i]=sorted[i];
    }

    /**
     * Copy the elements from tmp[lo, hi] into array[lo, hi]
     * Complexity: THETA( n ) where n = hi - lo + 1
     */
    private static <AnyType> void transfer(AnyType[] tmp, AnyType[] array, int lo, int hi) {

    }
}