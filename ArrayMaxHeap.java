package cpsc331.assignment3;

import cpsc331.collections.BoundedMaxHeap;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import cpsc331.collections.HeapFullException;
import java.lang.Math;

/**
 *
 * Provides an ArrayList-based implementation of a BoundedMaxHeap<br><br>
 *
 * ArrayMaxHeapInvariant: A finite multiset of non-null values of ordered type T
 * is stored in a bounded binary MaxHeap, using an array-based representation
 * <br><br>
 * 
*/
public class ArrayMaxHeap<T extends Comparable<T>> implements BoundedMaxHeap<T> {

  // Data fields
    private final int CAPACITY;
    private int size;
    private ArrayList<T> A;

  // Returns the index of a parent of a node that has one
    //
    // Precondition: A integer i such that 1 <= i <= this.size - 1 is given as input.
    // Postcondition: If A is viewed as a representation of a binary tree with
    //   size "this.size" then the index of the parent of the node with index i is
    //   returned as output.
    private int parent(int i) {

        return (int) Math.floor((i - 1) / 2);

    }

  // Reports whether a node with a given index has a left child in the binary
    // tree represented by A
    //
    // Precondition: An integer i such that 0 <= i <= size - 1 is given as input.
    // Postcondition: If A is viewed as a representation of a binary tree with size
    //   "this.size" then true is returned if the node with index i has a left
    //   child in this binary tree, and false is returned otherwise
    private boolean hasLeft(int i) {
        int greatestPossibleIndex = size - 1;
        int possibleRightIndex = 2 * i + 1;

        return possibleRightIndex <= greatestPossibleIndex;

    }

  // Returns the index of a node that is the left child of a node with a given index
    //
    // Precondition:
    // a) An integer i such that 0 <= i <= this.size - 1 is given as input.
    // b) If A is viewed as a representation of a binary tree with size "this.size"
    //    then the node x with index i has a left child in this binary tree.
    // Postcondition: The index of the left child of x is returned as output.
    //
    private int leftChild(int i) {

        return 2 * i + 1;    // To be supplied by students

    }

  // Reports whether a node with a given index has a right child in the binary
    // tree represented by A
    //
    // Precondition: An integer i such that 0 <= i <= this.size - 1 is given as input.
    // Postcondition: If A is viewed as a representation of a binary tree with size
    //   "this.size" then true is returned if the node with index i has a right
    //   child in this binary tree, and false is returned otherwise
    private boolean hasRight(int i) {
        int greatestPossibleIndex = size - 1;
        int possibleRightIndex = 2 * i + 2;

        return possibleRightIndex <= greatestPossibleIndex;

    }

  // Returns the index of a node that is the right child of a node with a given index
    //
    // Precondition:
    // a) An integer i such that 0 <= i <= this.size - 1 is given as input.
    // b) If A is viewed as a representation of a binary tree with size "this.size"
    //    then the node x with index i has a right child in this binary tree.
    // Postcondition: The index of the right child of x is returned as output.
    //
    private int rightChild(int i) {

        return 2 * i + 2;

    }

  //
    // Implements the "bubbleUp" method needed to complete an insertion
    //
    // Precondition:
    // a) If this.A is viewed as representing a binary tree with the shape of a binary
    //    heap then all entries are non-null, so that the size of this tree is the
    //    same as the value of the data field "this.size", and this tree has  non-null
    //    values at its nodes.
    // b) The value of this.CAPACITY is an integer that is greater than or equal to the
    //    value of the data field "this.size" - and equal to the capacity of the
    //    ArrayList this.A.
    // c) An integer i such that 0 <= i <= this.size - 1 has been given as input. If x
    //    is the node with index i in the above binary tree then, for every node y
    //    in this tree except for x, both the parent and grandparent of y store values
    //    that are greater than is stored at y - if these nodes exist.
    // Postcondition:
    // a) The values stored in the first "this.size" locations of A have been reordered
    //    but not otherwise changed.
    // b) this.A now represents a BoundedMaxHeap with size "this.size"
    //
    // Note: The value of i can change - by decreasing - as this problem is being solved.
    private void bubbleUp(int i) {
        if (i !=0){
            int comparison = A.get(i).compareTo(A.get(parent(i)));
            if(comparison > 0){
                T temp = A.get(i);
                A.set(i, A.get(parent(i)));
                A.set(parent(i), temp);
                bubbleUp(parent(i));

            }
        }

    // To be supplied by students
    }

  //
    // Implements the "bubbleDown" method needed to complete a deleteMax
    //
    // Precondition:
    // a) If A is viewed as representing a binary tree with the shape of a binary
    //    heap then all entries are non-null, so that the size of this tree is the
    //    same as the value of the data field "this.size", and this tree has non-null
    //    values at its nodes.
    // b) The value of this.CAPACITY is an integer that is greater than or equal to the
    //    value of the data field "this.size" - and equal to the capacity of the
    //    ArrayList A.
    // c) An integer i such that 0 <= i <= this.size - 1 has been given as input. If x
    //    is the node with index x in the above binary tree then, for every node y
    //    in this tree except for x, both the children and grandchildren of y store
    //    values that are less than the value stored at y - if these nodes exist.
  // Postcondition:
    // a) The values stored in the first "this.size" locations of A have been reordered
    //    but not changed.
    // b) A now represents a BoundedMaxHeap with size "this.size".
    //
    // Note: The value of i can change - by increasing - as this problem is being solved.
    private void bubbleDown(int i) {

        if (hasRight(i)) {
            int compareValue = A.get(leftChild(i)).compareTo(A.get(rightChild(i)));
            int anotherCompare = A.get(rightChild(i)).compareTo(A.get(i));

            if (compareValue >= 0) {
                int nextCompare = A.get(leftChild(i)).compareTo(A.get(i));
                if (nextCompare > 0) {
                    T temp = A.get(leftChild(i));
                    A.set(leftChild(i), A.get(i));
                    A.set(i, temp);
                    bubbleDown(leftChild(i));
                }
            } else if (anotherCompare > 0) {
                T temp = A.get(rightChild(i));
                A.set(rightChild(i), A.get(i));
                A.set(i, temp);
                bubbleDown(rightChild(i));
            }
        } else if (hasLeft(i)) {
            int lastCompare = A.get(leftChild(i)).compareTo(A.get(i));
            if (lastCompare > 0) {
                T temp = A.get(leftChild(i));
                A.set(leftChild(i), A.get(i));
                A.set(i, temp);
                bubbleDown(leftChild(i));

            }

        }

    }

  //
    // Converts an array into a representation of a BoundedMaxHeap
    //
    // Precondition:
    // a) A is an ArrayList with positive integer capacity this.CAPACITY, and whose
    //    size is this this.CAPACITY, storing non-null values from some ordered type T
    // Postcondition:
    // a) The entries of A have been ordered but otherwise not changed.
    // b) A is now a representation of a BoundedMaXHeap whose size is the size (and
    //    capacity) of this ArrayList.
    private void heapify() {

        int n = size;
        int i =  (int)Math.floor(n/2);
        while (i> 0){
            bubbleDown(i-1);
            i -=1;

        }
    }

    /**
     *
     * @param capacity the capacity of the BondedMaxHeap to be created
     * @throws IllegalArgumentException if the capacity is not positive
     * <br><br>
     *
     * Constructs an empty BoundedHeapHeap with a given positive integer
     * capacity<br><br>
     *
     * Precondition:<br>
     * <ol style="list-style-type: lower-alpha">
     * <li> An integer capacity is given as input </li>
     * </ol>
     * Postcondition:<br>
     * <ol style="list-style-type: lower-alpha">
     * <li> If the input capacity is positive then an empty (array-based)
     * BondedMaxHeap with this capacity has been created. An
     * IllegalArgumentException has been thrown, and a BoundedMaxHeap has not
     * been created, otherwise. </li>
     * </ol>
     *
     */
    public ArrayMaxHeap(int capacity) throws IllegalArgumentException {

        if (capacity > 0) {

            CAPACITY = capacity;
            size = 0;
            A = new ArrayList<T>(capacity);
            int i = 0;

      // Loop Invariant:
            // 1. A positive integer capacity is given as input.
            // 2. A is an ArrayList storing values with type T.
            // 3. i is an integer such that 0 <= i <= capacity
            // 4. The current size of A is i and, for every integer j such that
            //    0 <= j < i, A[j] = null
            // Bound Function: capacity - i
            while (i < capacity) {
                A.add(null);
                i = i + 1;
            }

        } else {

            throw new IllegalArgumentException("The input capacity must be positive.");

        }

    }

    /**
     *
     * @param givenA the ArrayList to be used to create this.A
     * <br><br>
     *
     * Constructs a BoundedMaxHeap from a given ArrayList<br><br>
     *
     * Precondition:<br>
     * <ol style="list-style-type: lower-alpha">
     * <li> An ArrayList givenA, whose size is the same as its positive integer
     * capacity, storing non-null values from the ordered type T, is given as
     * input </li>
     * </ol>
     * Postcondition:<br>
     * <ol style="list-style-type: lower-alpha">
     * <li> Both this.CAPaCITY and this.size are equal to the capacity of A
     * <li> this.A is the array givenA - whose entries have been reordered, but
     * not changed, so that this represents a BoundedMaxHeap </li>
     * </ol>
     *
     */
    public ArrayMaxHeap(ArrayList<T> givenA) {

        CAPACITY = givenA.size();
        size = CAPACITY;
        A = givenA;
        heapify();

    }

  // Implementation of insert
    public void insert(T v) throws HeapFullException {
        //System.out.println("CAPACITY = " + CAPACITY);
        //System.out.println("size = " +size);
        
        if ( size< CAPACITY){//originally we had A.size() 
            
        int x = size; //originally we had A.size() if broken switch this first 
            // if (size !=0){
            //     A.set(x, v); //v will be added to the end of the arraylist at the last index (A.size() -1)
            // } else {
            A.set(size,v);
            //}    
            size += 1;
            
            if (x>=0){
                bubbleUp(x);
            }
        } else {
            throw new HeapFullException("dont do that. Bad.");
        }
        //System.out.println("A = " + A);

    // To be supplied by students
    }

  // Implementation of deleteMax
    public T deleteMax() throws NoSuchElementException {
        if (size ==0){//originally we had A.size() 
            throw new NoSuchElementException();

        }else {

            //System.out.println("A = " + A);
            int sizeVar = size;//originally we had A.size() 
            T v = A.get(size-1);//originally we had A.size() 
            size -= 1;
           //System.out.println("Size = " + size);
            if (size ==0){
                //System.out.println("A.get(size) = " + A.get(size));
                A.set(size, null);
                //System.out.println("A = " + A);
                return v;

            } else{
                T toReturn = A.get(0);
                A.set(0,v);
                A.set(size, null);
                //System.out.println("A.get(0) = " + A.get(0));
                //System.out.println("A = " + A);
                bubbleDown(0);
                //System.out.println("A = " + A);
	       	return toReturn;
            }
        
	}
        
    }

  // Implementation of getSize; supplied by instructor
    public int getSize() {
        return size;
    }

  // Implementation of getCapacity; supplied by instructor
    public int getCapacity() {
        return CAPACITY;
    }

  // Used for testing; supplied by instructor
    T valueByIndex(int indx) throws NoSuchElementException {

        if ((indx >= 0) && (indx < size)) {

            return A.get(indx);

        } else {

            throw new NoSuchElementException("There is no node with this index.");

        }

    }

    public String getArray(){
    	return A.toString();
    }
}
