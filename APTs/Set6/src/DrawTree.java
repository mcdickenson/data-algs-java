import java.util.ArrayList;
import java.util.HashMap;


public class DrawTree {
      public String[] draw(int[] parents, String[] names){
         int index_of_root = findRoot(parents, names);
         String root = names[index_of_root]; 
         HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
         map = recursiveDraw(root, parents, names, map);

         // turn map into output
         ArrayList<String> output = new ArrayList<String>();
         output = mapToDrawing("", root, 0, output, false, map);
         
         String[] out = output.toArray(new String[output.size()]);
         return out;
      }
      
      public ArrayList<String> mapToDrawing(String preface, String root, int depth,
    		  ArrayList<String> list, boolean sibling, 
    		  HashMap<String, ArrayList<String>> map){
    	  
    	  String node = preface + "+-" + root; 
    	  if(sibling){ preface = preface + "| "; }
    	  else{  preface = preface + "  "; }
    	  
//    	  System.out.println(node);
    	  list.add(node); 
    	  if(map.containsKey(root)){
    		  ArrayList<String> children = map.get(root);
    		  String lastChild = children.get(children.size()-1);
        	  if(!children.isEmpty()){
        		  for(String child : children){
        			  if(map.containsKey(child) & !child.equals(lastChild)){
        				  sibling = true; 
        			  }
        			  else{ sibling = false; } 
            		  list = mapToDrawing(preface, child, depth+1, list, sibling, map);
            	  }
        	  }
    	  }
 
    	  return list; 
      }
      
      public HashMap<String, ArrayList<String>> recursiveDraw(String root, 
    		  int[] parents, String[] names, 
    		  HashMap<String, ArrayList<String>> map){
    	  
    	  ArrayList<String> children = new ArrayList<String>(); 
    	  
    	  // find all values whose parent == root
    	  for(int i=0; i < names.length; i++){
    		  int parent = parents[i];
    		  if(parent!=-1){
    			  String name_of_parent = names[parent];
        		  if(name_of_parent.equals(root)){
        			  // add to list of children
        			  children.add(names[i]);
        		  }
    		  }
    		  
    	  }
    	  if(children.isEmpty()){
    		  return map; 
    	  }
    	  else{
    		  map.put(root, children);
    		  for(String child : children){
    			  map = recursiveDraw(child, parents, names, map);
    		  }
    		  return map;
    	  }
    	  
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
      
//      public static void main(String[] args){
//    	  DrawTree dt = new DrawTree();
//    	  
//    	  int[] test1parents = {-1,0,1,1,0,0,5,5};
//    	  String[] test1names = {"Root","SubB","LEAF1","LEAF2","LEAF3","SubA","LEAF4","LEAF5"};
//    	  String[] test1expected = {"+-Root",
//    			  "  +-SubB",
//    			  "  | +-LEAF1",
//    			  "  | +-LEAF2",
//    			  "  +-LEAF3",
//    			  "  +-SubA",
//    			  "    +-LEAF4",
//    			  "    +-LEAF5" };
//    	  String[] test1result = dt.draw(test1parents, test1names);
//    	  for(int j=0; j<test1expected.length; j++){
//    		  if(!test1expected[j].equals(test1result[j])){
//    			  System.out.println("expected " + test1expected[j] + " got " + test1result[j]);
//    		  }
//    	  }
//    	  
//    	  int[] test2parents = {1,2,3,4,5,6,-1};
//    	  String[] test2names = {"A","B","C","D","E","F","G"};
//    	  String[] test2expected = {"+-G",
//    			  "  +-F",
//    			  "    +-E",
//    			  "      +-D",
//    			  "        +-C",
//    			  "          +-B",
//    			  "            +-A" };
//    	  String[] test2result = dt.draw(test2parents, test2names);
//    	  for(int j=0; j<test2expected.length; j++){
//    		  if(!test2expected[j].equals(test2result[j])){
//    			  System.out.println("expected " + test2expected[j] + " got " + test2result[j]);
//    		  }
//    	  }
//    	  
//      }
}
