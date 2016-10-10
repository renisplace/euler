import Annotations.*;

@problemDeff(
		number = 15,
		dateSolved = "10/3/16",
		deff = "Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, "
				+ "there are exactly 6 routes to the bottom right corner. Find the number of routes in a 20x20 grid",
		notes = ""
	)
public class Problem15 {
	protected long p;
	public long calculate(){
		
		// result for N=20: .. 137846528820
		// ran 1806236
		
		//grid height/width
		int N = 20; 
		p= 1;
		
		// if a node is (i,j) the next node in the path can only be (i,j+1) or (i+1,j)
		// the possible paths in the grid can be represented by a binary tree with root (1,1), first level (1,2) and (2,1) etc. .. all leafs are (N+1,N+1)
		// the number of paths increases when there is a split in the grid tree, for example (2,1) branches off to (2,2) and (3,1) when N>2
		numPaths(1,1,N+1);
		
		return p;
	}
	
	public void numPaths(int i, int j, int n){
		//System.out.println("(" + i + "," + j + ")");
		if (i==n && j==n){
			return;
		}
		if (i<n && j==n){
			//don't increase the number of paths, still on the same one
			numPaths(i+1,j,n);
		}
		if (i==n && j<n){
			//don't increase the number of paths, still on the same one
			numPaths(i,j+1,n);
		}
		if (i<n && j<n){
			//increase the number of paths, this is a split
			p++;
			
			//keep looking for splits to the left 
			numPaths(i+1,j,n);
			
			//keep looking for splits down
			numPaths(i,j+1,n);
		}
	}
		
}
