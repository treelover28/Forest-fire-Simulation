package lai.forestFireSimulation;
/*
 * Khai Lai
 * COMP 2673 
 * Assignment 3- Forest Fire: Stack And Queue
 * Professor Mohammed Albow 
 * T.A Dalton Crutchfield and T.A Lombe Chileshe
 */
public class Driver 
{
	public static void main(String[] args)
	{
		int count = 10;
		System.out.println(" \t\tDFS\t\tBFS");
		for (int trial = 0; trial < 5; trial++)
		{
			// reset sum for each trial
			long sumDFS = 0;
			long sumBFS = 0;
			for (int i = 0; i < count; i++)
			{
				long startDFS = System.currentTimeMillis();
				FireProbability.highestDensityDFS();
				long endDFS = System.currentTimeMillis();
				sumDFS += (endDFS - startDFS);	
				
				long startBFS = System.currentTimeMillis();
				FireProbability.highestDensityBFS();
				long endBFS = System.currentTimeMillis();
				sumBFS += (endBFS - startBFS);	
			}
			System.out.println("Trial " + (trial + 1) + ":\t" + (float) sumDFS/count + "\t\t" + (float) sumBFS/count );
		}
		/*
		 * Both DFS and BFS have very similar running times across all trials. 
		 * Sample run: 
					  		DFS			BFS
				Trial 1:	2758.2		2732.3
				Trial 2:	2970.3		2940.7
				Trial 3:	2691.3		2721.4
				Trial 4:	2736.9		2750.5
				Trial 5:	2681.2		2703.0


		 * In fact, their codes are technically the same, except one uses Stack and the other one uses Queue
		 * Both DFS and BFS have O(n) bound, the running time grows as the number of cells the algorithm needs to check grows
		 * meaning the running time depends on the size of the board
		 */
	}
}
