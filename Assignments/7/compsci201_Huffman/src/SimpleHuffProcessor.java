import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.PriorityQueue;
//import java.util.HashSet;

public class SimpleHuffProcessor implements IHuffProcessor {
    
    private HuffViewer myViewer;
    private TreeNode myRoot; 
    private HashMap<Integer, String> myMap; 
    private Integer mySize; 
    
    public int compress(InputStream in, OutputStream out, boolean force) throws IOException {
        throw new IOException("compress is not implemented");
        //return 0;
        // read in 8-bit chunks
        // for each chunk, qrite the encoding from the map
        // use a BitOutputStream 
    }


    public int preprocessCompress(InputStream in) throws IOException {
    	// create forest of nodes
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
        
        // turn forest into a single tree
        PriorityQueue<TreeNode> pq = new PriorityQueue<TreeNode>(forest.values()); 
        myRoot = qShrinker(pq); 
        
        //create map of ints to encodings
        myMap = new HashMap<Integer, String>(); 
        mySize=0; 
        encodePaths(myRoot, ""); 
        
        return myRoot.myWeight*8 - mySize; 
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
    
    public void encodePaths(TreeNode t, String path){
    	if(t.isLeaf()){
    		myMap.put(t.myValue, path); 
    		mySize += t.myWeight*path.length(); 
    		return; 
    	}
    	else{
    		encodePaths(t.myLeft, path + "0");
    		encodePaths(t.myRight, path + "1");
    	}
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
