package lai.forestFireSimulation;
/*
 * Khai Lai
 * COMP 2673 
 * Assignment 3- Forest Fire: Stack And Queue
 * Professor Mohammed Albow 
 * T.A Dalton Crutchfield and T.A Lombe Chileshe
 */
public class QueueArray<E> implements Queue<E>
{

	private int size;
	private int front;
	private E[] theQ;
	
	public QueueArray(int capacity)
	{
		size = 0;
		front = 0;
		theQ = (E[]) new Object[capacity];
	}
	
	public void enqueue(E v) 
	{
		if(size >= theQ.length)
		{
			throw new IllegalStateException("Queue is full");
		}
		
		theQ[(front + size) % theQ.length]  = v; // since theQ is circular, don't want to go out of bound if value of front is too large
		size++;
		
	}

	public E dequeue() 
	{
		if(size == 0)
		{
			throw new IllegalStateException("Queue is empty");
		}
		E temp = theQ[front];
		theQ[front] = null;
		front = (front + 1) % theQ.length; // move front to next item
		size--;
		return temp;
	}

	@Override
	public E front() {
		if(size == 0)
		{
			throw new IllegalStateException("Queue is empty");
		}		
		
		return theQ[front];
	}

	@Override
	public int size() 
	{
		return size;
	}

	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Queue: ");
		
		for(int i = 0; i < size; i++)
		{
			sb.append(theQ[(front+i) % theQ.length] + " ");
		}
		return sb.toString();
		
	}

}
