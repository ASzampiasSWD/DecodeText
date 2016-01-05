public class LinkedList <T1 extends Comparable<T1>>
{
	protected int length;
	protected Node<T1> front;
	protected Node<T1> rear;
	
	/** LinkedList() constructor.
	 */ 
	public LinkedList()
	{
		length = 0;
		front = new Node<T1>();
		rear = new Node<T1>();
		//connect the front and rear together
		front.connectNodes(rear);
	}
	
	/** Insert element to front 
	 *  @param value value to insert
	 */
	public void insertFront(T1 value)
	{
		front.insertAfter(value);
		length++;
	}
	
	/** Insert element to back 
	 *  @param value value to insert
	 */
	public void insertBack(T1 value)
	{
		rear.insertBefore(value);
		length++;
	}
	
	/** Insert element in order 
	 *  @param value value to insert
	 */
	public void insertInOrder(T1 value)
	{
		front.getNext().insertInOrder(value);
		length++;
	}
	
	/** Search the ordered list 
	 *  @param value value to insert
	 *  @return if value was found.
	 */
	public boolean searchOrderedList(T1 value)
	{
		return front.getNext().searchOrderedList(value);
	}
	
	/** Search the unordered list 
	 *  @param value value to insert
	 *  @return if value was found.
	 */
	public boolean searchUnorderedList(T1 value)
	{
		return front.getNext().searchUnorderedList(value);
	}
	
	/** Call the toString() function.
	 *  @return string.
	 */
	public String toString()
	{
		return front.toString();
	}
	
	/** Remove an element.
	 *  @param value value to insert.
	 *  @return if element was removed.
	 */
	public boolean remove(T1 value)
	{
		return front.getNext().remove(value);
	}
}
