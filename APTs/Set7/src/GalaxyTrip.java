import java.util.ArrayList;
//import java.util.BitSet;
//import java.util.BitSet.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class GalaxyTrip {
	public int[] possibleValues(String[] dependencies){
 	   
 	   // map visited nodes to their parent (or -1)
 	   HashMap<Integer, Integer> visited = new HashMap<Integer, Integer>();
 	   HashMap<Integer, Integer> graphSizes = new HashMap<Integer, Integer>(); 
 	   
 	   for(int current=0; current<dependencies.length; current++){
 		   String nodesConnected = dependencies[current];
 		   
 		   // visit all connections and map this node to size of its graph
 		   if(!visited.containsKey(current)){
 			   int numConnections = 1;
 			   
 			   for(int j=0; j<nodesConnected.length(); j++){
 				   String connection = nodesConnected.substring(j, j+1);
 				   if(!connection.equals(" ")){
 					   int node = Integer.parseInt(connection);
 					   visited.put(node, current);
 					   numConnections++;
 				   }
 			   }
 			   graphSizes.put(current, numConnections);
 		   }
 	   }
 	   
 	   int[] sizes = new int[graphSizes.keySet().size()];
 	   int j=0;
 	   for(int key : graphSizes.keySet()){
 		   int s = graphSizes.get(key);
 		   sizes[j] = s;
 		   j++;
 	   }
 	    
 	   TreeSet<Integer> sums = sumArray(sizes);
 	  
 	   int[] result = new int[sums.size()];
 	   int i=0;
 	   for(int s: sums){
 		   result[i] = s;
 		   i++;
// 		   System.out.println(s);
 	   }
 	   
 	   return result; 
    }
    
	public TreeSet<Integer> sumArray(int[] sizes){
		TreeSet<Integer> counts = new TreeSet<Integer>();
		
		// loop through possible windows
		for(int window=1; window<=sizes.length; window++){
			// loop through sizes
			for(int i=0; i<sizes.length-window+1; i++){
				int thisWindow = 0;
				for(int j=i; j<i+window; j++){
					thisWindow += sizes[j];
				}
				counts.add(thisWindow);
			}
		}
		
		return counts;
	}
       
//	public static void main(String[] args){
//		GalaxyTrip gt = new GalaxyTrip();
//
//		String[] d1 = {"1 2", "0", "0", ""};
//		int[] test1 = {1, 3, 4};
//		int[] result1 = gt.possibleValues(d1);
//		if(test1.length==result1.length){ System.out.println("test 1 passes");}
//		else{System.out.println("test 1 fails");}
//	}
}
