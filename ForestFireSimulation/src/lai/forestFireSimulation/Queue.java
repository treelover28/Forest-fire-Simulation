package lai.forestFireSimulation;
/*
 * Khai Lai
 * COMP 2673 
 * Assignment 3- Forest Fire: Stack And Queue
 * Professor Mohammed Albow 
 * T.A Dalton Crutchfield and T.A Lombe Chileshe
 */
public interface Queue<E>
{
	public void enqueue(E v);
	public E dequeue();
	public E front();
	public int size();
	public boolean isEmpty();

}
