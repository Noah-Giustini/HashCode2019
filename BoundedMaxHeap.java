import java.util.NoSuchElementException;

public interface BoundedMaxHeap<T extends Comparable<T>> {

  /**
  *
  * @param v the value to be inserted into this binary MaxHeap
  * @throws HeapFullException if this bounded MaxHeap is already full
  * <br><br>
  *
  * Precondition:<br>
  * <ol style="list-style-type: lower-alpha">
  * <li> The BoundedMaxHeap Invariant is satisfied.</li>
  * <li> A value v with type T has been given as input. </li>
  * </ol>
  * Postcondition:<br>
  * <ol style="List-style-type: lower-alpha">
  * <li> The BoundedMaxHeap Invariant is satisfied. </li>
  * <li> If this BoundedMaxHeap is not already full then a copy of the value v
  *      has been inserted into the multiset represented by this binary MaxHeap, and
  *      no other changes have been made. A HeapFullException is thrown, and this
  *      bounded MaxHeap is not changed, otherwise. </li>
  * </ol>
  *
  */
  
  public void insert (T v) throws HeapFullException;
  
  /**
  *
  * @return the value that was deleted from this BoundedMaxHeap
  * @throws NoSuchElementException if this BoundedMaxHeap was already empty
  * <br><br>
  *
  * Precondition:<br>
  * <ol style="list-style-type: lower-alpha">
  * <li> The BoundedMaxHeap Invariant is satisfied. </li>
  * </ol>
  * Postcondition:<br>
  * <ol style="list-style-type: lower-alpha">
  * <li> The MaxHeap Invariant is satisfied. </li>
  * <li> If this MinHeap was not empty then a copy of the largest element is removed
  *      from the multiset represented by this MaxHeap and returned as output, and no
  *      other changes to this multiset have been made. A NoSuChElementException is
  *      thrown if this heap was already empty, an it is not changed. </li>
  * </ol>
  *  
  */
  
  public T deleteMax () throws NoSuchElementException;
  
  /**
  *
  * @return the current size of this MaxHeap
  * <br><br>
  *
  * Precondition:<br>
  * <ol style="list-style-type: lower-alpha">
  * <li> The BoundedMaxHeap Invariant is satisfied. </li>
  * </ol>
  * Postcondition:<br>
  * <ol style="list-style-type: lower-alpha">
  * <li> This BoundedMaxHeap has not changed, so the BoundedMaxHeap Invariant is still
  *      satisfied. <li>
  * <li> The size of this BoundedMaxHeap has been returned as output. </li>
  * </ol>
  *
  */
  
  public int getSize();
  
  /**
  *
  * @return the capacity of this BoundedMaxHeap
  * <br><br>
  *
  * Precondition:<br>
  * <ol style="list-style-type: lower-alpha">
  * <li> The BoundedMaxHeap Invariant is satisfied. </li>
  * </ol>
  * Postcondition:<br>
  * <ol style="list-style-type: lower-alpha">
  * <li> This BoundedMaxHeap has not changed, so the BoundedMaxHeap Invariant is still
  *      satisfied. </li>
  * <li> The capacity of this BoundedMaxHeap has been returned as output. </li>
  * </ol>
  *
  */
  
  public int getCapacity();

}