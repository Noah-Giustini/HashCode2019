/**
* Exception to be on an attempt to insert an element into a bounded binary heap
* when the heap is full
*
*/

public class HeapFullException extends Exception {

 /**
 * @param message the message to be displayed
 * <br><br>
 *
 * Constructs a HeapFullException  with the specified
 * message.
 */

 public HeapFullException (String message) {
  super(message);
 };

}
