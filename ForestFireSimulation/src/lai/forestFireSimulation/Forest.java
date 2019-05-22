package lai.forestFireSimulation;

import java.util.Stack;
/*
 * Khai Lai
 * COMP 2673 
 * Assignment 3- Forest Fire: Stack And Queue
 * Professor Mohammed Albow 
 * T.A Dalton Crutchfield and T.A Lombe Chileshe
 */
public class Forest 
{
	private TreePosition[][] forest;
	private int height;
	private int width;
	
	public Forest(int height, int width, double density)
	{
		if (density < 0 || density > 1)
		{
			throw new IllegalStateException("density must be a double between 0 and 1");
		}
		this.height = height;
		this.width = width;
		this.forest = new TreePosition[height][width];
		for (int r = 0; r < height; r++)
		{
			for (int c = 0; c < width; c++)
			{
				double chance = Math.random();
				if (chance <= density)
				{
					// tree at position
					forest[r][c] = new TreePosition(1, r, c);
				}
				else 
				{
					// no tree at position
					forest[r][c] = new TreePosition(0, r, c);
				}	
			}
		}
	}
	public String toString()
	{
		StringBuilder s = new StringBuilder("");
		for (int r = 0; r < height; r++)
		{
			for (int c = 0; c < width; c++)
			{
				s.append(forest[r][c].getValue() + " ");
			}
			s.append("\n");
		}
		return s.toString();	
	}
	
	public boolean depthFirstSearch()
	{
		// given a forest "f"
		// store positions of trees on fire
		Stack<TreePosition> cellsToExplore = new Stack<>();
		TreePosition currentPosition;
		// Set top row on fire
		for (int c = 0; c < forest[0].length; c++)
		{
			if (forest[0][c].treeStatus == 1) // only set fire on position with fire
			{
				cellsToExplore.push(forest[0][c]);
				forest[0][c].setTreeStatus(2); // set tree of fire
			}
		}
		// continue to light neighboring trees on fire
		while (!cellsToExplore.isEmpty())
		{
			currentPosition = cellsToExplore.pop();
			if (currentPosition.r == height - 1)
			{
				return true;
			}
			// add neighboring trees to cellsToExplore
			if (currentPosition.c + 1 < width && // check tree to the right first
					// make sure it is not out of bound
					forest[currentPosition.r][currentPosition.c + 1].getValue() == 1)
			{
				// add tree to the right to cellsToExplore
				cellsToExplore.push(forest[currentPosition.r][currentPosition.c + 1]);
				// lit tree to the right on fire
				forest[currentPosition.r][currentPosition.c + 1].setTreeStatus(2);
			}
			
			if (currentPosition.r + 1 < height && // check tree below 
					forest[currentPosition.r + 1][currentPosition.c].getValue() == 1)
			{
				// add tree below to cellsToExplore
				cellsToExplore.push(forest[currentPosition.r + 1][currentPosition.c]);
				// lit tree below on fire
				forest[currentPosition.r + 1][currentPosition.c].setTreeStatus(2);
			}
			
			if (currentPosition.c - 1 >= 0 && // check tree to the left 
					forest[currentPosition.r][currentPosition.c -1].getValue() == 1)
			{
				// add tree to the left to cellsToExplore
				cellsToExplore.push(forest[currentPosition.r][currentPosition.c - 1]);
				// lit tree to the left on fire
				forest[currentPosition.r][currentPosition.c - 1].setTreeStatus(2);
			}
		}
		return false;	
	}
	
	public boolean breadthFirstSearch()
	{
		// given a forest "f"
		// store positions of trees on fire
		QueueArray<TreePosition> cellsToExplore = new QueueArray<>(height*width);
		TreePosition currentPosition;
		// Set top row on fire
		for (int c = 0; c < forest[0].length; c++)
		{
			if (forest[0][c].treeStatus == 1) // only set fire on positions with trees
			{
				cellsToExplore.enqueue(forest[0][c]);
				forest[0][c].setTreeStatus(2); // set tree of fire
			}
		}
		// continue to light neighboring trees on fire
		while (!cellsToExplore.isEmpty())
		{
			currentPosition = cellsToExplore.dequeue();
			if (currentPosition.r == height - 1)
			{
				return true;
			}
			// add neighboring trees to cellsToExplore
			if (currentPosition.c + 1 < width && // check tree to the right first
					forest[currentPosition.r][currentPosition.c + 1].getValue() == 1)
			{
				cellsToExplore.enqueue(forest[currentPosition.r][currentPosition.c + 1]);
				forest[currentPosition.r][currentPosition.c + 1].setTreeStatus(2);
			}
			
			if (currentPosition.r + 1 < height && // check tree to the bottom 
					forest[currentPosition.r + 1][currentPosition.c].getValue() == 1)
			{
				cellsToExplore.enqueue(forest[currentPosition.r + 1][currentPosition.c]);
				forest[currentPosition.r + 1][currentPosition.c].setTreeStatus(2);
			}
			
			if (currentPosition.c - 1 >= 0 && // check tree to the left 
					forest[currentPosition.r][currentPosition.c -1].getValue() == 1)
			{
				cellsToExplore.enqueue(forest[currentPosition.r][currentPosition.c - 1]);
				forest[currentPosition.r][currentPosition.c - 1].setTreeStatus(2);
			}
		}
		return false;		
	}

	/* Private class TreePosition to keep track of tree's position and status */
	private class TreePosition
	{
		private int c;
		private int r;
		private int treeStatus;
		// Possible status for treeStatus:
		// 0 = no tree at that Position
		// 1 = Tree not on fire at Position
		// 2 = Tree on fire
		
		public TreePosition(int status, int r, int c)
		{
			this.r = r;
			this.c = c;
			this.treeStatus = status;
		}
		
		public void setTreeStatus(int status)
		{
			if (status < 0 || status > 2)
			{
				throw new IllegalStateException("Invalid Status, 0 = no tree, 1 = normal tree, 2 = tree on fire");
			}
			this.treeStatus = status;
		}
		public int getValue()
		{
			return treeStatus;
		}
		
		public String tostring()
		{
			return ("Position : (" + r + "," + c + ")" +  " | Status: " + treeStatus);
		}
	}
}
		
	




	
