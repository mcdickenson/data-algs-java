import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.HashSet;
import java.util.TreeSet;

public class SimpleHuffProcessor implements IHuffProcessor {
    
    private HuffViewer myViewer;
    private TreeNode myTree; 
    
    public int compress(InputStream in, OutputStream out, boolean force) throws IOException {
        throw new IOException("compress is not implemented");
        //return 0;
    }


    public int preprocessCompress(InputStream in) throws IOException {
    	HashMap<Integer, TreeNode> forest = new HashMap<Integer, TreeNode>(); 
    	BitInputStream binput = new BitInputStream(in);
        int next = 1;
        while(next > 0){
        	next = binput.read(); 
        	if(forest.containsKey(next)){
        		TreeNode node = forest.get(next);
        		node.myWeight++;
        		forest.put(next, node);
        	}
        	else{
        		TreeNode node = new TreeNode(next, 1); 
        		forest.put(next, node);
        	}
        }
        
        binput.close(); 
        
        myTree = recursiveShrinker(forest); 
        
        return myTree.depth(); // maybe compare depth of tree to its weight 
    }
    
    public TreeNode recursiveShrinker(HashMap<Integer, TreeNode> forest){
    	TreeNode tree; 
    	if(forest.size()==1){
    		tree = getSmallest(forest); 
    	}
    	else{
    		// TODO: create an array before this of nodes sorted by weight
    		// find two nodes of smallest weight
    		TreeNode smallest = getSmallest(forest); 
    		forest.remove(smallest.myValue);
    		TreeNode nextSmallest = getSmallest(forest); 
    		forest.remove(nextSmallest.myValue); 
    		
    		// combine them - not sure what to do about values 
    		TreeNode newNode = new TreeNode(smallest.myValue, nextSmallest.myWeight+smallest.myWeight, smallest, nextSmallest);
    		
    		forest.put(newNode.myValue, newNode); 
    		System.out.println(forest.size());
    		// recurse 
    		tree = recursiveShrinker(forest); 
    	}
    	return tree; 
    }
    
    public TreeNode getSmallest(HashMap<Integer, TreeNode> forest){
    	int minWeight = 1000000; 
    	TreeNode smallest = null; 
    	for(Integer i : forest.keySet()){ 
			TreeNode current = forest.get(i);
			if(current.myWeight < minWeight){
				smallest = current; 
				minWeight = current.myWeight; 
			}
		}
    	return smallest; 
    }

    public void setViewer(HuffViewer viewer) {
        myViewer = viewer;
    }

    public int uncompress(InputStream in, OutputStream out) throws IOException {
        throw new IOException("uncompress not implemented");
        //return 0;
    }
    
    private void showString(String s){
        myViewer.update(s);
    }

}
