
public class LinkedQueue<T> implements QueueADT<T>
{
    private int count;
    
    private LinearNode<T> head, tail;

   
    public LinkedQueue()
    {
        count = 0;
        head = tail = null;
    }

    public void enqueue(T element)
    {
        LinearNode<T> node = new LinearNode<T>(element);

        if (isEmpty())
            head = node;
        else
            tail.setNext(node);

        tail = node;
        count++;
    }

    public T dequeue() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("queue");

        T result = head.getElement();
        head = head.getNext();
        count--;

        if (isEmpty())
            tail = null;

        return result;
    }

    public T first() throws EmptyCollectionException
    {
       if(!isEmpty())
           return(head.getElement());
       else
           throw new EmptyCollectionException("Nothing to peek");

    }

    public boolean isEmpty()
    {
       return(count == 0);
    }

    public int size()
    {
       return(count);
    }

    public String toString()
    {
       String queueString = "";
       try
       {
           LinearNode<T> elem = head;
           T elem2 = elem.getElement();      

           for(int i = count; i > 0; i--)
           {
               queueString += (elem2);
                              
               if(i > 1)
               {
                   queueString += "\n";
                   elem = elem.getNext();
                   elem2 = elem.getElement();
               }
           }
      
       }
      
       catch(NullPointerException e)
       {
           System.err.println("The tail is empty");
       }
      
       return queueString;
    }
}
