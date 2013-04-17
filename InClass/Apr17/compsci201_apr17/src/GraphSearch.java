import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class GraphSearch {

	TreeMap<String, List<String>> myGraph = new TreeMap<String, List<String>>();

	public GraphSearch(String[] dependencies){
		int vertex = 0;
		for(String s : dependencies)
		{
			String sv = "" + vertex;
			vertex++;
			List<String> list = new ArrayList<String>();	
			if (s.equals("")) continue;           // no vertices, don't parse
			String[] a = s.split(" ");

			for (String nextv : a){
				list.add(nextv);
			}

			myGraph.put(sv, list);
		}
	}

	public void graphPathSum(String vertex, int target){
		Set<String> visited = new TreeSet<String>();
		if(dfs(vertex, visited, target)){
			System.out.print("Starting at " + vertex + ", a path that sums to " + target + ": ");
			for(String s: visited)
				System.out.print(s + " ");
			System.out.println();
		}
		else{
			System.out.println("Starting at " + vertex + ", there is no path that sums to " + target);
		}
	}

	private boolean dfs(String vertex, Set<String> visited, int target){
		// 3 base cases
		if(target==0){ return true; }
		if(target<0){ return false; }
		if(visited.contains(vertex)){ return false; }
		
		//visit your node
		visited.add(vertex); 
		
		//update your new target value
		target -= Integer.parseInt(vertex); 

		//for each adjacent vertex, perform a dfs
		List<String> adjacentVertices = myGraph.get(vertex); 
		for(String av: adjacentVertices){
			boolean found = dfs(av, visited, target);
			if(found){ return true; } // if you found the path, you are done
		}
		
		// if you did not find your path through this vertex, remove it from visited
		visited.remove(vertex); 
		
		// don't forget your return statement
		return false; 
	}


	public static void main(String[] args){
		String[] dependencies = {"1 2 3", "0 4 5", "0 6", "0 5", "1", "1 3", "2"};
		GraphSearch g = new GraphSearch(dependencies);
		g.graphPathSum("0", 9);
		g.graphPathSum("1", 10);
		g.graphPathSum("1", 5);
	}
}