package ads.lab4;

import java.util.*;

/**
 * A class for binary search tree with rank
 */
public class RankedBST<AnyType extends Comparable<? super AnyType>> {

    // The tree root
    private BinaryNode<AnyType> root;

    /**
     * Construct the tree.
     */
    public RankedBST( ) {

    }

    /////////////// isEmpty

    /**
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( ) {
        return true;
    }

    /////////////// makeEmpty

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty( ) {

    }

    /////////////// rank

    /**
     * Return the rank of x in the tree
     * @param x the element
     * @return the rank of x in the tree
     * if x is in the tree, 0 otherwise
     */
    public int rank(AnyType x) {
        return 0;
    }

    private int rank(BinaryNode<AnyType> t, AnyType x) {
        return 0;
    }

    /////////////// element

    /**
     * Return the element of rank r in the tree
     * @param r the rank
     * @return the element of rank r in the tree
     * if such element exists, null otherwise
     */
    public AnyType element(int r) {
        return null;
    }

    private AnyType element(BinaryNode<AnyType> t, int r) {
        return null;
    }

    /////////////// contains

    /**
     * Find an item in the tree.
     * @param x the item to search for.
     * @return true if not found.
     */
    public boolean contains( AnyType x ) {
        return false;
    }

    /**
     * Internal method to find an item in a subtree.
     * @param x is item to search for.
     * @param t the node that roots the subtree.
     * @return node containing the matched item.
     */
    private boolean contains( AnyType x, BinaryNode<AnyType> t ) {
        return false;
    }

    /////////////// insert

    /**
     * Insert into the tree; duplicates are ignored.
     * @param x the item to insert.
     */
    public void insert( AnyType x ) {

    }

    /**
     * Internal method to insert into a subtree.
     * @param x the item to insert.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<AnyType> insert( AnyType x, BinaryNode<AnyType> t ) {
        return null;
    }

    /////////////// remove

    /**
     * Remove from the tree. Nothing is done if x is not found.
     * @param x the item to remove.
     */
    public void remove( AnyType x ) {

    }

    /**
     * Internal method to remove from a subtree.
     * @param x the item to remove.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<AnyType> remove( AnyType x, BinaryNode<AnyType> t ) {
        return null;
    }

    /**
     * Internal method to find the smallest item in a subtree.
     * @param t the node that roots the subtree.
     * @return node containing the smallest item.
     */
    private BinaryNode<AnyType> findMin( BinaryNode<AnyType> t ) {
        return null;
    }

    ////////////////////////////////////////////////////
    // Convenience method to print a tree
    ////////////////////////////////////////////////////

    public void display() {
        display(root,"","");
    }

    private void display(BinaryNode<AnyType> t, String r, String p) {
        if ( t == null ) {
            System.out.println(r);
        }
        else {
            String rs = t.element.toString();
            rs = "(" + t.sizeOfLeft + ")" + rs;
            System.out.println(r + rs);
            if ( t.left != null || t.right != null ) {
                String rr = p + '|' + makeString('_',rs.length()) + ' ';
                display(t.right,rr, p + '|' + makeString(' ',rs.length() + 1));
                System.out.println(p + '|');
                display(t.left,rr, p + makeString(' ',rs.length() + 2));
            }
        }
    }

    private String makeString(char c, int k) {
        String s = "";
        for ( int i = 0; i < k; i++ ) {
            s += c;
        }
        return s;
    }

    ////////////////////////////////////////////////////
    // Inner class BinaryNode<AnyType>
    ////////////////////////////////////////////////////

    // Basic node stored in unbalanced binary search trees
    private static class BinaryNode<AnyType> {
        // Constructors
        BinaryNode( AnyType theElement ) {
            element  = theElement;
            left     = null;
            right    = null;
            sizeOfLeft = 0;
        }

        AnyType element;            // The data in the node
        BinaryNode<AnyType> left;   // Left child
        BinaryNode<AnyType> right;  // Right child

        int sizeOfLeft; // The size of the left subtree
    }

    ////////////////////////////////////////////////////
    // Convenience methods to build a list of integer from a string
    ////////////////////////////////////////////////////

    private static List<Integer> read(String inputString) {
        List<Integer> list = new LinkedList<Integer>();
        Scanner input = new Scanner(inputString);
        while ( input.hasNextInt() )
            list.add(input.nextInt());
        input.close();
        return list;
    }

    /**
     * A short main for quick testing
     */
    public static void main( String [ ] args ) throws EmptyTreeException {
        List<Integer> list = read("50 30 70 20 40 80 60");
        RankedBST<Integer> bst = new RankedBST<Integer>();
        for ( Integer n : list )
            bst.insert(n);
        bst.display();
        System.out.println("Rank of 60: " + bst.rank(60));
        System.out.println("Element of rank 6: " + bst.element(6));
    }
}