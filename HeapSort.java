import java.util.NoSuchElementException;
import java.util.ArrayList;

/**
*
* Provides an implementation of the HeapSort Algorithm
*
*/

public class HeapSort {

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
  
  public void sort(ArrayList<Slide> A) {
   ArrayMaxHeap H = new ArrayMaxHeap(A);
   
    int i = A.size();
    while (i > 0){
      Slide largest = H.deleteMax();
      A.set(H.getSize(), largest);
      i -=1;
    

    }

  }

}
