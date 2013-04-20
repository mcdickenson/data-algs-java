import java.util.ArrayList;
//import java.util.BitSet;
//import java.util.BitSet.*;
import java.util.Collections;
import java.util.HashMap;

public class GalaxyTrip {
       public int[] possibleValues(String[] dependencies){
    	   
    	   // create adjacency matrix
    	   int[][] myGraph;
    	   myGraph = new int[dependencies.length][dependencies.length];
    	   for(int i = 0; i < dependencies.length; i++){
    		   if(dependencies[i].length()>0){
    			   String[] adj = dependencies[i].split(" ");

    			   for(int j = 0; j < adj.length; j++){

    				   myGraph[i][Integer.parseInt(adj[j])] = 1;
//    				   myGraph[Integer.parseInt(adj[j])][i] = 1;

    			   }
    		   }
    		   myGraph[i][i] = 1; 
   			}
    	   for(int[] row: myGraph){
    		   for(int c: row){
    			   System.out.print(c);
    			   System.out.print(",");
    		   }
    		   System.out.println();
    	   }
    	   
    	   int[] neighbors = new int[dependencies.length];
    	   for(int i=0; i<dependencies.length; i++){
    		   boolean[] visited = new boolean[dependencies.length];
    		   for(int j=0; j<dependencies.length; j++){
    			   visited[j] = false;
    		   }
    		   neighbors[i] = countNeighbors(i, visited, myGraph);
    	   }
    	   
    	   for(int n: neighbors){
    		   System.out.println(n);
    	   }
    		
    	   
    	   int[] result = {1, 2, 3};  
    	   return result; 
       }
          
       
       public int countNeighbors(int start, boolean[] visited, int[][] graph){
   		int dist = 0;
   		int max = 0;
   		visited[start] = true;
   		
   		int[] row = graph[start];
   		for(int i=0; i<row.length; i++){
   			if(graph[start][i]>0){
   				if(!visited[i]){
   					dist = row[i] + countNeighbors(i, visited, graph);
   				}
   				if(dist > max){
   					max = dist;
   				}
   			}
   		}
   		
   		visited[start] = false;
   		return max;
   	}
       
//       public int[] buildIntArray(ArrayList<Integer> integers) {
//    	    int[] ints = new int[integers.size()];
//    	    int i = 0;
//    	    for (Integer n : integers) {
//    	        ints[i++] = n;
//    	    }
//    	    return ints;
//    	}
       
       public static void main(String[] args){
    	   GalaxyTrip gt = new GalaxyTrip();
    	   
    	   String[] d1 = {"1 2", "0", "0", ""};
    	   int[] test1 = {1, 3, 4};
    	   int[] result1 = gt.possibleValues(d1);
//    	   if(test1.length==result1.length){ System.out.println("test 1 passes");}
//    	   else{System.out.println("test 1 fails");}
       }
}
