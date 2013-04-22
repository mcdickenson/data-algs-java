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
		GraphVertex[] vertices = new GraphVertex[myGraph.length];
		
		// create a priority queue that will hold all unvisited vertices
		PriorityQueue<GraphVertex> unvisited = new PriorityQueue<GraphVertex>(); 

		// initialize all of your graph vertices set the distance to 
		// 'start' to zero and the distance to all other vertices to infinity
		// add the GraphVertices to your priority queue and array
		for(int i=0; i<myGraph.length; i++){
			GraphVertex v = new GraphVertex(i);
			if(i==start){
				v.setDistance(0);
			}
			unvisited.add(v);
			vertices[i] = v; 
		}
		
		// loop through unvisited while it has vertices
		while(!unvisited.isEmpty()){
			GraphVertex current = unvisited.poll(); //get the unvisited vertex that is closest to 'start'
			int name = current.getName();
			if(name==end){ break; } // if this is 'end' you are done!
			for(int i=0; i<myGraph.length; i++){ // loop through the adjacent vertices
				int distance = myGraph[name][i];
				if(unvisited.contains(vertices[i])){ //if an adjacent vertex has not been visited 
					if(distance>0){ // current and i are neighbors
						//calculate the distance to the adjacent vertex through the current vertex
						int curDist = vertices[i].myDistance;
						int possibleDist = vertices[name].myDistance;
						//update if this distance is shorter then the current distance to that vertex
						if(possibleDist < curDist){
							vertices[i].setDistance(possibleDist);
							unvisited.remove(vertices[i]);
							unvisited.add(vertices[i]);
						}
					}
				}

			}
		}
					
		// print out the total distance from 'start' to 'end'
		System.out.printf("The shortest distance from %d to %d is %d", start, end, vertices[end].myDistance);
	}

	public class GraphVertex implements Comparable<GraphVertex>{
		// instance variables
		int myName; 
		int myDistance; 

		// constructor should take the vertex name (an int) and set the distance to infinity
		public GraphVertex(int name){
			myName = name;
			myDistance = Integer.MAX_VALUE; 
		}

		// setter method for distance
		public void setDistance(int dist){
			myDistance = dist; 
		}

		// getter method for the vertex name
		public int getName(){
			return myName; 
		}

		public int compareTo(GraphVertex arg0) {
			return myDistance - arg0.myDistance;
		}

	}
	
	public static void main(String[] args){
		String[] dependencies = {"1 2 3", "0 4 5", "0 6", "0 5", "1", "1 3", "2"};
		String[] weights = {"3 6 2", "3 4 6", "6 4", "2 5", "4", "6 5", "4"};
		Graph dijkstra = new Graph(dependencies, weights);
		dijkstra.dijkstra(2, 5);
	}

}
