package correction.lab5;

import java.util.Comparator;

public class MainBinaryHeap {

    public static void main(String[] args) throws EmptyHeapException {
        BinaryHeap<Integer> anyTypeBinaryHeap=new BinaryHeap<>(19);
        anyTypeBinaryHeap.setSize(15);
        anyTypeBinaryHeap.setA(new Integer[]{94,92,74,68,87,57,55,47,19,28,79,23,21,16,49});
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer e2, Integer e1) {
                return e2.compareTo(e1);
            }
        };
        anyTypeBinaryHeap.setC(c);
        for(int i=0;i<11;i++){
            System.out.print(anyTypeBinaryHeap.deleteExtreme()+" ");
        }
        System.out.println("-----");
        for(int i=0; i< anyTypeBinaryHeap.getSize();i++){
            System.out.println(anyTypeBinaryHeap.getA()[i]);
        }
    }
}
