
public class DrawTree {
      public String[] draw(int[] parents, String[] names){
         String[] output = new String[parents.length];
//         for(int i=0; i<names.length; i++){
//        	 output[i] = ""; 
//         }
         int index_of_root = findRoot(parents, names);
         output[0] = "+-" + names[index_of_root]; 
         
         output = recursiveDraw(parents, names, output, index_of_root);
         return output;
      }
      
      public String[] recursiveDraw(int[] parents, String[] names, String[] out, int root){
    	  // find all values whose parent == root
    	  // add those names to the string array
    	  // get their subtrees
    	  
    	  return out;
      }
      
      public int findRoot(int[] parents, String[] names){
    	  int index_of_root=0; 
    	  for(int i=0; i < names.length; i++){
    		  int parent = parents[i];
    		  if(parent==-1){
    			  index_of_root=i;
    		  }
    	  }
    	  return index_of_root; 
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
