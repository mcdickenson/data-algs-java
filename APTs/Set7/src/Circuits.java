import java.util.ArrayList;

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
		
//		for(int[] row : myGraph){
//			for(int col: row){
//				System.out.print(col);
//				System.out.print(",");
//			}
//			System.out.println("");
//		}
		
		
//		int[] longestPaths = new int[connects.length];
//		for(int i=0; i<connects.length; i++){
//			ArrayList<Integer> visited = new ArrayList<Integer>();
//			longestPaths[i] = longestFromMe(myGraph, i, 0, visited);
//		}
		
//		return rowMax(longestPaths);
		boolean[] visited = new boolean[connects.length];
		for(int i=0; i<connects.length; i++){
			visited[i] = false;
		}
		
		return longestPath(0, visited, myGraph);
//		return 0;
	}
	
	public int longestFromMe(int[][] graph, int start, int pathLength, ArrayList<Integer> visited){
		
		int[] row = graph[start];	
		
		if(maxCol(row)==-1) { return pathLength; }
		else{
			visited.add(start);
			int[] maxPaths = new int[row.length];
			for(int i=0; i<row.length; i++){
				
				if(!visited.contains(i)){
					maxPaths[i] = longestFromMe(graph, i, row[i], visited);
				}
				
			}
			pathLength += rowMax(maxPaths);
//			+row[maxCol(maxPaths)];
			
			return pathLength; 
		}
		
	}
	
	public int longestPath(int start, boolean[] visited, int[][] graph){
		int dist = 0;
		int max = 0;
		visited[start] = true;
		
		int[] row = graph[start];
		for(int i=0; i<row.length; i++){
			if(graph[start][i]>0){
				if(!visited[i]){
					dist = row[i] + longestPath(i, visited, graph);
				}
				if(dist > max){
					max = dist;
				}
			}
		}
		
		visited[start] = false;
		return max;
	}
	
	
	public int rowMax(int[] row){
		int max = 0;
		for(int i=0; i<row.length; i++){
			if(row[i]>max){ max = row[i]; }
		}
		return max;
	}
	
	public int maxCol(int[] row){
		int biggestCol = -1;
		int max = 0;
		for(int i=0; i<row.length; i++){
			if(row[i]>max){ biggestCol = i; }
		}
		return biggestCol;
	}
	
	
	public static void main(String[] args){
		String[] dependencies = {"1 2", "2", ""};
		String[] weights = {"5 3", "7", ""};
		
		Circuits c = new Circuits();
		int result1 = c.howLong(dependencies, weights); 
		System.out.printf("Expected 12, got %d", result1);
		
	}
	
}
