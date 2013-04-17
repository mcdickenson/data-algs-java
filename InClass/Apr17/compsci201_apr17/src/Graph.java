import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class Graph {
	public int[][] myGraph;

	public Graph(String[] dependencies, String[] weights){
		myGraph = new int[dependencies.length][dependencies.length];
		for(int i = 0; i < dependencies.length; i++){
			String[] adj = dependencies[i].split(" ");
			String[] w = weights[i].split(" ");
			for(int j = 0; j < adj.length; j++){
				myGraph[i][Integer.parseInt(adj[j])] = Integer.parseInt(w[j]);
			}
		}
	}

	public void dijkstra(int start, int end){
		// create an array of vertices for your graph
		int[] vertices = myGraph[start]; 
		
		// create a priority queue that will hold all unvisited vertices
		PriorityQueue<GraphVertex> unvisited = new PriorityQueue<GraphVertex>(); 

		// initialize all of your graph vertices set the distance to 
		// 'start' to zero and the distance to all other vertices to infinity
		// add the GraphVertices to your priority queue and array
		ArrayList<GraphVertex> GraphVertices = new ArrayList<GraphVertex>(); 
		for(int v: vertices){
			GraphVertex newV = new GraphVertex(v);
			GraphVertices.add(newV);
			unvisited.add(newV); 
		}
		
		//TODO loop through you pq while it has vertices
//		while(unvisited.size()>0)
		
			
			//TODO get the unvisited vertex that is closest to 'start'
			// if this is 'end' you are done!
			
			//TODO loop through the adjacent verticies
			
				//TODO if an adjacent vertex has not been visited (i.e. still in your priority queue)
				
					//calculate the distance to the adjacent vertex through the current vertex
					
					//update if this distance is shorter then the current distance to that vertex
					//NOTE: any time you update a vertex you must remove and then add it back to 
					// your priority queue
					
		//TODO print out the total distance from 'start' to 'end'
	}

	public class GraphVertex implements Comparable<GraphVertex>{
		// instance variables
		int myName; 
		double myDistance; 

		// constructor should take the vertex name (an int) and set the distance to infinity
		public GraphVertex(int name){
			myName = name;
			myDistance = Double.POSITIVE_INFINITY; 
		}

		// setter method for distance
		public void setDistance(double dist){
			myDistance = dist; 
		}

		// getter method for the vertex name
		public int getName(){
			return myName; 
		}

		public int compareTo(GraphVertex arg0) {
			Double diff = myDistance - arg0.myDistance;
			return diff.intValue();
		}

	}

	public static void main(String[] args){
		String[] dependencies = {"1 2 3", "0 4 5", "0 6", "0 5", "1", "1 3", "2"};
		String[] weights = {"3 6 2", "3 4 6", "6 4", "2 5", "4", "6 5", "4"};
		Graph dijkstra = new Graph(dependencies, weights);
		dijkstra.dijkstra(2, 5);
	}
}
