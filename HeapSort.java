package cpsc331.assignment3;

import cpsc331.assignment3.ArrayMaxHeap;
import java.util.NoSuchElementException;
import cpsc331.collections.HeapFullException;
import java.util.ArrayList;

/**
*
* Provides an implementation of the HeapSort Algorithm
*
*/

public class HeapSort<T extends Comparable<T>> {

  /**
  *
  * @param A an ArrayList with positive length storing non-null from an ordered
  *        type&nbsp;T<br><br>
  *
  * Precondition:<br>
  * <ol style="list-style-type: lower-alpha">
  * <li> An ArrayList&nbsp;A with positive length, storing non-null values from
  *      an ordered type&nbsp;T, is given as input. 
  * </li>
  * </ol>
  * Postcondition:<br>
  * <ol style="list-style-type: lower-alpha">
  * <li> The entries of&nbsp;A have been reordered but are otherwise unchanged. </li>
  * <li> A is sorted in nondecreasing order. That is, A[h] &le; A[h+1] for every
  *      integer&nbsp;h such that 0 &le; h &le; A.size()&minus;2
  * </li>
  * </ol>
  *
  */
  
  public void sort(ArrayList<T> A) {
   ArrayMaxHeap<T> H = new ArrayMaxHeap<T>(A);
   
    int i = A.size();
    while (i > 0){
      T largest = H.deleteMax();
      A.set(H.getSize(), largest);
      i -=1;
    

    }

  }

}
