package lai.forestFireSimulation;
/*
 * Khai Lai
 * COMP 2673 
 * Assignment 3- Forest Fire: Stack And Queue
 * Professor Mohammed Albow 
 * T.A Dalton Crutchfield and T.A Lombe Chileshe
 */
public class FireProbability 
{
	public static float probabilityOfFireSpreadDFS(double density)
	{
		int fireSpreadCount = 0;
		// simulate
		for (int simulation = 0; simulation < 10000; simulation++)
		{
			Forest f = new Forest(20,20, density);
			if (f.depthFirstSearch())
			{
				fireSpreadCount++;
			}
			
		}
		return (float) (fireSpreadCount)/10000;	
	}
	
	public static float probabilityOfFireSpreadBFS(double density)
	{
		// use BFS to determine if fire spreads
		int fireSpreadCount = 0;
		// simulate
		for (int simulation = 0; simulation < 10000; simulation++)
		{
			Forest f = new Forest(20,20, density);
			if (f.breadthFirstSearch())
			{
				fireSpreadCount++;
			}
		}
		return (float) (fireSpreadCount)/10000;	
	}
	
	public static double highestDensityDFS()
	{
		double lowDensity = 0.0;
		double highDensity = 1.0;
		double density = 0; // arbitrary initialization
		
		for (int repetition = 0; repetition < 20; repetition++)
		{
			density = (lowDensity + highDensity)/2;
			// get probability of fire spreading in forests of 'density'
			double p = probabilityOfFireSpreadDFS(density);
			// check probability of fire spreading
			if (p > 0.5)
			{
				// low probability means we can increase density
				lowDensity = density;
			}
			else
			{
				// high probability means we should decrease density;
				highDensity = density;
			}
		}
		return density;
	}
	
	public static double highestDensityBFS()
	{
		double lowDensity = 0.0;
		double highDensity = 1.0;
		double density = 0; // arbitrary initialization
		for (int repetition = 0; repetition < 20; repetition++)
		{
			density = (lowDensity + highDensity)/2;
			
			// get probability of fire spreading in forests of 'density'
			double p = probabilityOfFireSpreadBFS(density);
			// check probability of fire spreading
			if (p > 0.5)
			{
				// low probability means we can increase density
				lowDensity = density;
			}
			else
			{
				// high probability means we should decrease density;
				highDensity = density;
			}
		}
		return density;
	}
}
