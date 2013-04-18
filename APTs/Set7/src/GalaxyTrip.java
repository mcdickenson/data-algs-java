import java.util.ArrayList;
//import java.util.BitSet;
//import java.util.BitSet.*;
import java.util.Collections;
import java.util.HashMap;

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
    	   
    	   int[] result = sumArray(sizes);  
    	   return result; 
       }
       
       public int[] sumArray(int[] input){
    	    int size = (int)(Math.pow(2.0, input.length)) - 1;
    	    int[] output = new int[size];
    	    for (int i = 1; i < output.length; i++) { // maybe leq

    	    	String iBinary = Integer.toBinaryString(i);
    	    	
    	    	System.out.print("i: ");
    	    	System.out.println(iBinary);
    	        int sum = 0;
    	        for (int j = 0; j < i; j++) { // maybe leq; maybe j<size
    	        	String jBinary = Integer.toBinaryString(j);
    	        	System.out.print("j: ");
    	        	System.out.println(jBinary);
    	        	
    	        	int index = 0;
//    	        	char jCurrent = jBinary.charAt(index);
//    	        	char iCurrent = iBinary.charAt(index);
    	        	
//    	            if (jCurrent!=iCurrent) {
    	        	if(true){
    	                sum += input[j];
    	            }
    	        }
    	        output[i-1] = sum;
    	        System.out.print("output: ");
    	        System.out.println(sum);
    	    }
    	    for(int o: output){
    	    	System.out.println(o);
    	    }
    	    return output;
       }      
       
       public int[] buildIntArray(ArrayList<Integer> integers) {
    	    int[] ints = new int[integers.size()];
    	    int i = 0;
    	    for (Integer n : integers) {
    	        ints[i++] = n;
    	    }
    	    return ints;
    	}
       
       public static void main(String[] args){
    	   GalaxyTrip gt = new GalaxyTrip();
    	   
    	   String[] d1 = {"1 2", "0", "0", ""};
    	   int[] test1 = {1, 3, 4};
    	   int[] result1 = gt.possibleValues(d1);
    	   if(test1.length==result1.length){ System.out.println("test 1 passes");}
    	   else{System.out.println("test 1 fails");}
       }
}
