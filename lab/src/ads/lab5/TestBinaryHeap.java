package ads.lab5;

import ads.util.TestClass;
import java.util.Scanner;

/**
 * A class for interactive testing of binary heap
 */
public class TestBinaryHeap extends TestClass<TestBinaryHeap> {

    private BinaryHeap<Integer> heap;
    private Scanner input;

    public TestBinaryHeap() {
        heap = new BinaryHeap<Integer>(128);
        input = new Scanner(System.in);
    }

    public void size() {
        System.out.println(heap.size());
    }

    public void isEmpty() {
        if ( heap.isEmpty() )
            System.out.println("heap is empty");
        else
            System.out.println("heap is not empty");
    }

    public void extreme() throws EmptyHeapException {
        System.out.println(heap.extreme());
    }

    public void deleteExtreme() throws EmptyHeapException {
        Integer x = heap.deleteExtreme();
        System.out.println(x);
    }

    public void add() throws FullHeapException {
        System.out.print("Enter an integer: ");
        int x = input.nextInt();
        heap.add(x);
    }

    public void display(){
        System.out.print(heap.toStringAsTab());
    }

    public void addAll() throws FullHeapException {
        System.out.print("Enter an array: ");
        String numbers = input.nextLine();
        String newNumbers[]=numbers.split(" ");
        for(int i=0;i<newNumbers.length;i++){
            heap.add(Integer.parseInt(newNumbers[i]));
        }
    }
    //10 12 1 14 6 5 8 3 9 7 4 11 13 2
    public void buildHeap() throws FullHeapException {
        System.out.print("Enter an array: ");
        String numbers = input.nextLine();
        String newNumbers[]=numbers.split(" ");
        Integer[] A=new Integer[newNumbers.length];
        for(int i=0;i<newNumbers.length;i++){
            A[i]=Integer.parseInt(newNumbers[i]);
        }
        heap = new BinaryHeap<Integer>(A);
    }
    public void deleteMin(){
        System.out.print("Enter an integer: ");
        heap.deleteMin();
    }

    public static void main(String[] args) {
        TestBinaryHeap test = new TestBinaryHeap();
       test.tester();
    }

}