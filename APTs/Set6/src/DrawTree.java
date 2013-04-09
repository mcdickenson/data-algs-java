import java.util.*;

public class DrawTree {
      public String[] draw(int[] parents, String[] names){
         String[] output = new String[parents.length];
         for(int i=0; i<names.length; i++){
        	 output[i] = ""; 
         }
         output = loopDraw(parents, names, output);
         return output;
      }
      
//      public String[] recursiveDraw(int[] parents, String[] names, String[] out){
//    	  
//    	  ArrayList<Integer> sorted = Arrays.sort(parents); 
//    	  return out;
//      }
      
      public String[] loopDraw(int[] parents, String[] names, String[] out){
    	  for(int i=0; i < names.length; i++){
    		  int parent = parents[i];
    		  String name = names[i];
    		  if(parent==-1){
    			  out[0] = "+-" + name; 
    		  }
    		  else{
    			  int k=parent;
        		  String nextSpot = out[k];
        		  while(!nextSpot.equals("")){
        			  k++;
        			  nextSpot = out[k];
        		  }
        		  out[k] = "+-" + name;
    		  }
    		  
    	  }
    	  return out; 
      }
      
      public static void main(String[] args){
    	  DrawTree dt = new DrawTree();
    	  
    	  int[] test1parents = {-1,0,1,1,0,0,5,5};
    	  String[] test1names = {"Root","SubB","LEAF1","LEAF2","LEAF3","SubA","LEAF4","LEAF5"};
    	  String[] test1expected = {"+-Root",
    			  "  +-SubB",
    			  "  | +-LEAF1",
    			  "  | +-LEAF2",
    			  "  +-LEAF3",
    			  "  +-SubA",
    			  "    +-LEAF4",
    			  "    +-LEAF5" };
    	  String[] test1result = dt.draw(test1parents, test1names);
    	  System.out.println(test1expected.equals(test1result));
    	  
    	  int[] test2parents = {1,2,3,4,5,6,-1};
    	  String[] test2names = {"A","B","C","D","E","F","G"};
    	  String[] test2expected = {"+-G",
    			  "  +-F",
    			  "    +-E",
    			  "      +-D",
    			  "        +-C",
    			  "          +-B",
    			  "            +-A" };
    	  String[] test2result = dt.draw(test2parents, test2names);
    	  System.out.println(test2expected.equals(test2result));
    	  
      }
}
