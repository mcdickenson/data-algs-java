import java.util.*;


public class Graph {
	
	TreeMap<String, List<String>> myGraph = new TreeMap<String, List<String>>();
	
	public Graph(String[] dependencies){
		int vertex = 0;
		for(String s : dependencies)
		{
			String sv = "" + vertex;
			vertex++;

			List<String> list = new ArrayList<String>();
			
			if (s.equals("")) continue;           // no vertices, don't parse
			String[] a = s.split(" ");

			for (String nextv : a)
			{
				list.add(nextv);
			}
			
			myGraph.put(sv, list);
		}
	}
	
	public void dfs(String vertex){
		Set<String> visited = new TreeSet<String>();
		dfs(vertex, visited);
		System.out.println();
	}
	
	private void dfs(String vertex, Set<String> visited){

	}
	
	public void bfs(String vertex){
		Queue<String> q = new LinkedList<String>();
		bfs(vertex, q);
	}
	
	private void bfs(String vertex, Queue<String> q){

	}
	
	public static void main(String[] args){
		String[] dependencies = {"1 2 3", "0 4 5", "0 6", "0 5", "1", "1 3", "2"};
		Graph g = new Graph(dependencies);
		g.dfs("0");
		g.bfs("0");
	}
}
