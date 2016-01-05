public class Node <T1 extends Comparable<T1>>
{
	protected T1 info;
	protected Node<T1> next;
	protected Node<T1> previous;
	
	/** Node constructor.
	 *  Sets next and previous node
	 *  pointers to null.
	 */
	public Node()
	{
		next = null;
		previous = null;
	}
	
	/** Node constructor
	 *  @param value of Node.
	 */
	public Node (T1 value)
	{
		info = value;
		next = null;
		previous = null;
	}
	
	/** Grap element of node.
	 *  @return info contents of node.
	 */
	public T1 getInfo()
	{
		return info;
	}
	
	
	/** Check the next pointer of a node.
	 *  @return next Node.
	 */
	public Node<T1> getNext()
	{
		return next;
	}
	
	/** Check the previous pointer of a node.
	 *  @return previous Node.
	 */
	public Node<T1> getPrevious()
	{
		return previous;
	}
	
	/** Insert a node after.
	 *  @param value value to insert
	 */
	public void insertAfter(T1 value)
	{
		Node<T1> temp = new Node<T1>(value);
		temp.next = next;
		temp.previous = this;
		temp.next.previous = temp;
		next = temp;
	}
	
	/** Insert element to before.
	 *  @param value value to insert
	 */
	public void insertBefore(T1 value)
	{
		Node<T1> temp = new Node<T1>(value);
		temp.next = this;
		temp.previous = previous;
		temp.previous.next = temp;
		previous = temp;
	}
	
	/** Connect the dummy Nodes.
	 *  @param n Node needed to connect.
	 */
	public void connectNodes(Node<T1> n)
	{
		next = n;
		n.previous = this;
	}
	
	/** Insert element in order.
	 *  @param value value to insert
	 */
	public void insertInOrder(T1 value)
	{
		if (next == null || info.compareTo(value) > 0)
		{
			insertBefore(value);
		}
		else
		{
			next.insertInOrder(value);
		}
	}
	
	/** Remove selected value node.
	 *  @param value value to remove.
	 */
	public boolean remove(T1 value)
	{
		if (info.compareTo(value) > 0 ||
		    info.compareTo(value) < 0)
		{
			next.remove(value);
		}
	
	   if (searchUnorderedList(value) == true)
	   { 
		  this.previous.next = this.next;
		  this.next.previous = this.previous;
		  
		  return true;
	   }
	  	  return false;  
    }

	/** Search a list assuming list is in order. 
	 *  @param value value to search for.
	 *  @return return if value was found.
	 */
	public boolean searchOrderedList(T1 value)
	{
		if (next == null || info.compareTo(value) > 0)
		{
			return false;
		}
		else if (info.compareTo(value) == 0)
		{
			return true;
		}
		else
		{
			return next.searchOrderedList(value);
		}
	}

	/** Search a list assuming list is not in order. 
	 *  @param value value to search for.
	 *  @return return if value was found.
	 */
	public boolean searchUnorderedList(T1 value)
	{
		if (next == null)
		{
			return false;
		}
		else if (info.compareTo(value) == 0)
		{
			return true;
		}
		else
		{
			return next.searchUnorderedList(value);
		}
	}
	
	/** Input the correct String.
	 *  @return String.
	 */
	public String toString()
	{
		String result = "";
		
		while (next != null)
		{
	        result += next.info + " "; 
			next = next.next;
			
			if (next.next == null || next == null )
			{
			  return result;	
			}
		}
		
	    return result;
	} 
}
