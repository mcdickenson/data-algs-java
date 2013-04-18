import java.util.ArrayList;
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
    	   
//    	   System.out.println(visited.keySet());
//    	   System.out.println(graphSizes.keySet());
    	   
//    	   ArrayList<Integer> sizes = new ArrayList<Integer>();
    	   int[] sizes = new int[graphSizes.keySet().size()];
    	   int j=0;
    	   for(int key : graphSizes.keySet()){
    		   int s = graphSizes.get(key);
//    		   sizes.add(s);
    		   sizes[j] = s;
    		   j++;
    	   }
//    	   for(int size: sizes){
//    		   System.out.println(size);
//    	   }
//    	   System.out.println(sizes);
    	   
    	   ArrayList<Integer> combo = new ArrayList<Integer>();
    	   combo = sumArray(sizes.length, sizes, combo);
    	   
    	   Collections.sort(combo);
    	   int[] result = buildIntArray(combo);
    	   for(int v : result){
    		   System.out.println(v);
    	   }

//    	   int[] result = {1, 2, 3};
    	   return result; 
       }
       
       public ArrayList<Integer> sumArray(int windowSize, int[] sizes, ArrayList<Integer> combo){
    	   System.out.print("window: ");
    	   System.out.println(windowSize);
    	   if(windowSize==1){
    		   for(int i=0; i<sizes.length; i++){
    			   int result = sizes[i];
    			   if(!combo.contains(result)){
    				   combo.add(result);
    			   }
    		   }
    		   System.out.print("size: ");
    		   System.out.println(combo.size());
    		   return combo;
    	   }
    	   else{
    		   ArrayList<Integer> tmp = sumArray(windowSize-1, sizes, combo);
    		   
    		   int upperlimit = tmp.size();
    		   for(int i=1; i<upperlimit; i++){
    			   int v1 = tmp.get(i-1);
    			   int v2 = tmp.get(i);
    			   int total = v1+v2;
    			   if(!tmp.contains(total)){
    				   tmp.add(total);
    			   }
    		   }
    		   System.out.print("size: ");
    		   System.out.println(tmp.size());
    		   return tmp;
    	   }
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
