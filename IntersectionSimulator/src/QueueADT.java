
public interface QueueADT<T> 
{
	 //adds element to the back of queue
	    public void enqueue(T element);

	 //removes element from the front of queue   
	    public T dequeue();

	 //returns element next in queue without removing   
	    public T first();

	 //returns true if queue is empty   
	    public boolean isEmpty();

	 //returns number of elements   
	    public int size();
  
	    public String toString();
}
