public class TreeNodeExample {

    IntTreeNode root = null;

    public class IntTreeNode {
        public int myValue;
        public IntTreeNode myLeft; // holds smaller tree nodes
        public IntTreeNode myRight; // holds larger tree nodes
    
        public IntTreeNode(int val) { myValue = val; }
    }

    public void add(int newValue)
    {
        if(root == null)
            root = new IntTreeNode(newValue);
        else
            add(newValue, root);
    }
    
    // this add ensures that the node stays a binary search tree
    public void add(int newValue, IntTreeNode current) {
        if (newValue < current.myValue) {
            if (current.myLeft == null) {
                current.myLeft = new IntTreeNode(newValue);
            } else {
                add(newValue, current.myLeft);
            }
        } else {
            // newValue >= myValue
            if (current.myRight == null) {
                current.myRight = new IntTreeNode(newValue);
            } else {
                add(newValue, current.myRight);
            }
        }
    }

    
    public String toString()
    {
        return toString(root, "");
    }

    public String toString(IntTreeNode current, String level) {
        String leftString = "null";
        String rightString = "null";

        if (current.myLeft != null)
            leftString = toString(current.myLeft, level+"   ");
        if (current.myRight != null)
            rightString = toString(current.myRight, level+"   ");

        return current.myValue + "\n" + level +"L: " + leftString + "\n" + level + "R: " + rightString;
    }

    public int computeHeight()
    {
        return computeHeight(root);
    }
    
    private int computeHeight(IntTreeNode current) {
        if(current == null)
            return 0;
        int lResult = computeHeight(current.myLeft);
        int rResult = computeHeight(current.myRight);
        if(lResult > rResult) {
            return lResult + 1;
        } else {
            return rResult + 1;
        }
    }

    //return the number of nodes in the tree
    public int countNodes()
    {
        return countNodes(root);
    }
    
    public int countNodes(IntTreeNode current)
    {
        if(current == null) {
            return 0;
        }
        int lCount = countNodes(current.myLeft);
        int rCount = countNodes(current.myRight);
        
        // your code here
        return 1+lCount+rCount;
    }
    
    public boolean containsNode(int value) {
        return containsNode(value, root);
    }
    
    private boolean containsNode(int value, IntTreeNode current) {
    	if(current==null){ return false; }
    	if(value==current.myValue){ return true; }
    	else if(value<current.myValue){
    		return( containsNode(value, current.myLeft) );
    	}
    	else{ return( containsNode(value, current.myRight) ); }	    	
    }

    public int findMax() {
        return findMax(root);
    }
    
    // finds the largest value in the tree
    private int findMax(IntTreeNode current) {
    	if(current==null){ return 0; }
    	if(current.myRight==null){ return current.myValue; }
    	else{ 
    		int right = findMax(current.myRight); 
    		return right; 
    	}
    }
   
    public static void main(String[] args) {
        for(int j=4; j<15; j++){
        	TreeNodeExample tree = new TreeNodeExample();
        	double start = System.currentTimeMillis();
        	int nodes = (int) Math.pow(2, j);
        	for(int i=0; i<nodes; i++){
        		tree.add(i);
        	}
        	double end = System.currentTimeMillis();
        	double time = (end-start)/1000.0;
        	System.out.printf("Time: %f Height: %d Nodes: %d (2^%d)\n", time, tree.computeHeight(), nodes, j);
        }
    }
}
