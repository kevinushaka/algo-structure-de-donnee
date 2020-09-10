package ads.lab5;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * A class for binary heap implementation
 */
public class BinaryHeap<AnyType extends Comparable<? super AnyType>> {

    private AnyType[] A; // to store the heap
    private int size;    // the number of elements in the heap

    // comparator to choose
    private Comparator<AnyType> c = new Comparator<AnyType>() {
        public int compare(AnyType e1, AnyType e2) {
            return e1.compareTo(e2);
        }
    };

    ///////////// Constructors

    /**
     * Build a heap of capacity n.
     * The elements are ordered according to the
     * natural order on AnyType.
     * The heap is empty.
     * Complexity: THETA(1)
     */
    @SuppressWarnings("unchecked")
    public BinaryHeap(int n) {
        A = (AnyType[]) new Comparable[n];
        size = 0;
    }

    /**
     * Build a heap of capacity n.
     * The elements are ordered according to c.
     * The heap is empty.
     * Complexity: THETA(1)
     */
    @SuppressWarnings("unchecked")
    public BinaryHeap(int n, Comparator<AnyType> c) {
        this.A = (AnyType[]) new Comparable[n];
        this.size = 0;
        this.c = c;
    }

    /**
     * Build a heap based on array A.
     * The elements are ordered according to the
     * natural order on AnyType.
     * The heap is full
     */
    public BinaryHeap(AnyType[] A)  {
        this.A = A;
        this.size = A.length;
        buildHeap();
    }

    /**
     * Build a heap based on array A.
     * The elements are ordered according to c.
     * The heap is full
     */
    public BinaryHeap(AnyType[] A, Comparator<AnyType> c) {
        this.A = A;
        this.size = A.length;
        this.c = c;
        buildHeap();
    }

    ///////////// Private methods

    /**
     * Swap values in the array
     * at indexes i and j.
     * Complexity: THETA(1)
     */
    private void swap(int i, int j) {
        AnyType tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    /**
     * Return the number of the left
     * node of node number n.
     * Complexity: THETA(1)
     */
    private int left(int n) {
        return 2*n + 1;
    }

    /**
     * Return the number of the right
     * node of node number n.
     * Complexity: THETA(1)
     */
    private int right(int n) {
        return 2*(n + 1);
    }

    /**
     * Return the number of the parent
     * node of node number n.
     * Complexity: THETA(1)
     */
    private int parent(int n) {
        return (n - 1)/2;
    }

    /**
     * Percolate down the element à node number n
     * Complexity: O(log(size))
     */
    private void percolateDown(int n) {
        for(int i=n;i<size;){
            int right=right(i);
            int left=left(i);
            if( left<size &&right<size){
                if(A[i].compareTo(A[left])>0 && (A[left].compareTo(A[right])<0)
                ){
                    swap(i,left);
                    i=left;
                }
                else if (A[i].compareTo(A[right])>0 ){
                    swap(i,right);
                    i=right;
                }
                else
                    return;
            }
            else if(left<size){
                if (A[i].compareTo(A[left])>0 ){
                    swap(i,left);
                    i=left;
                }
            }
            else if(right<size){
                if(A[i].compareTo(A[right])>0) {
                    swap(i,right);
                    i=right;
                }
            }
            else {return;}
        }
    }

    /**
     * Percolate up the element à node number n
     * Complexity: O(log(size))
     */
    private void percolateUp(int n) {
        for(int i=n;i>0;i=parent(i)){
            if(A[i].compareTo(A[parent(i)])<0){
                swap(i,parent(i));
            }
        }
    }

    /**
     * Arrange the elements in A such
     * that it has the heap property.
     * Complexity: O(size)
     */
    //12 5 11 3 10 2 9 4 8 1 7 6
    private void buildHeap() {
        for(int i = size/2; i>=0; i--) {
            int right=right(i);
            int left=left(i);
            if(right<size)
                if(this.A[i].compareTo(A[right])>0){
                    percolateDown(i);
                }
            if(left<size)
                if(this.A[i].compareTo(A[left])>0){
                    percolateDown(i);
                }

        }
    }

    ///////////// Public methods

    /**
     * Return the size of the heap
     * (the number of elements in the heap).
     * Complexity: THETA(1)
     */
    public int size() {
        return size;
    }

    /**
     * Check if the heap is empty.
     * Complexity: THETA(1)
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return the extreme element.
     * Complexity: THETA(1)
     */
    public AnyType extreme() throws EmptyHeapException {
        if(size>1)
            return A[0];
        else
            throw  new EmptyHeapException();
    }

    /**
     * Return and delete the extreme element.
     * Complexity: O(log(size))
     */
    public AnyType deleteExtreme() throws EmptyHeapException {
        if ( size == 0 )
            throw new EmptyHeapException();
        AnyType extreme = A[0];
        A[0] = A[--size];
        if ( size > 0 )
            percolateDown(0);
        return extreme;
    }

    /**
     * Add a new element in the heap
     * Complexity: O(log(size))
     */
    public void add(AnyType e) throws FullHeapException {
        if(size>=A.length)
        {
            throw new FullHeapException();
        }
        A[size]=e;
        percolateUp(size);
        size++;
    }

    ///////////// Part 3: deleting in the heap

    /**
     * Delete the element e from the heap.
     * Complexity: O(size)
     */
    public void delete(AnyType e) {
        this.size--;
        AnyType[] ATmp=A;
        for(int i=0;i<A.length;i++)
            if(!A[i].equals(e))
                ATmp[i]=A[i];

        A= ATmp;
        buildHeap();
    }

    /**
     * Delete all the elements e from the heap.
     * Complexity: O(size)
     */
    public void deleteAll(AnyType e) {

    }

    public AnyType deleteMin(){
        if(size==0)
            return null;
        A[0]=A[size-1];
        size--;
        percolateDown(0);
        return A[0];
    }
    //10 12 1 14 6 5 8 15 3 9 7 4 11 13 2


    public String toStringAsTab(){
        StringBuilder Astr=new StringBuilder();
        Astr.append("[");
        for(int i=0;i<size;i++){
            Astr.append(A[i]);
            if (i < size -1
            ) {
                Astr.append(", ");
            }
        }
        Astr.append("]");
        return Astr.toString();
    }

    public static List<Integer> read(String inputString) {
        List<Integer> list = new LinkedList<Integer>();
        Scanner input = new Scanner(inputString).useDelimiter("\\,\\s*");
        while ( input.hasNextInt() )
            list.add(input.nextInt());
        input.close();
        return list;
    }
}