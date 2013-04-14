import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.PriorityQueue;
//import java.util.HashSet;

public class SimpleHuffProcessor implements IHuffProcessor {
    
    private HuffViewer myViewer;
    private TreeNode myRoot; 
    
    public int compress(InputStream in, OutputStream out, boolean force) throws IOException {
        throw new IOException("compress is not implemented");
        //return 0;
        // read in 8-bit chunks
        // for each chunk, qrite the encoding from the map
        // use a BitOutputStream 
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
        
        PriorityQueue<TreeNode> pq = new PriorityQueue<TreeNode>(forest.values()); 
        myRoot = qShrinker(pq); 
        
        //TODO: create map of ints to encodings
        
        return myRoot.depth(); // maybe compare depth of tree to its weight 
    }
    
    public TreeNode qShrinker(PriorityQueue<TreeNode> q){
    	TreeNode tree; 
    	if(q.size()==1){
    		tree = q.poll(); 
    	}
    	else{
    		TreeNode smallest = q.remove();
    		TreeNode nextSmallest = q.remove();
    		TreeNode newNode = new TreeNode(smallest.myValue, nextSmallest.myWeight+smallest.myWeight, smallest, nextSmallest);
    		q.add(newNode); 
    		tree = qShrinker(q); 
    	}
    	return tree; 
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
