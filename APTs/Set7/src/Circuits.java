import java.util.PriorityQueue;

public class Circuits {
	
	public int howLong(String[] connects, String[] costs){
		 
		int[][] myGraph = new int[connects.length][connects.length];
		for(int i = 0; i < connects.length; i++){
			if(connects[i].length()>0){
				String[] adj = connects[i].split(" ");
				String[] w = costs[i].split(" ");
				for(int j = 0; j < adj.length; j++){
					myGraph[i][Integer.parseInt(adj[j])] = Integer.parseInt(w[j]);
				}
			}
		}
		
		int longestPath = 0;
		
		for(int[] row : myGraph){
			longestPath += rowMax(row); // greedy algorithm, not necessarily right
		}
		
		return longestPath;
	}
	
	public int rowMax(int[] row){
		int max = 0;
		for(int i=0; i<row.length; i++){
			if(row[i]>max){ max = row[i]; }
		}
		return max;
	}
	
	
//	public static void main(String[] args){
//		String[] dependencies = {"1 2", "2", ""};
//		String[] weights = {"5 3", "7", ""};
//		
//		Circuits c = new Circuits();
//		int result1 = c.howLong(dependencies, weights); 
//		System.out.printf("Expected 12, got %d", result1);
//	}
	
}
