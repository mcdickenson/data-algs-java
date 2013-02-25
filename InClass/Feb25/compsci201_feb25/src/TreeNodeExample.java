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
        // your code goes here
        // hint: base case...if the node is null, it does not contain the value
    	return false;
    }

    public int findMax() {
        return findMax(root);
    }
    
    // finds the largest value in the tree
    private int findMax(IntTreeNode current) {
    	return 0;
    }
   
    public static void main(String[] args) {
        TreeNodeExample tree = new TreeNodeExample(); // LINE 1
        tree.add(5);
        tree.add(7); 
        tree.add(2);
        tree.add(9);
        tree.add(6);
        System.out.println(tree);
        System.out.println("Height " + tree.computeHeight()); // should print 3
        System.out.println("Num nodes " + tree.countNodes()); // should print 5
        System.out.println("Contains 6 " + tree.containsNode(6)); // should print true
        System.out.println("Contains 0 " + tree.containsNode(0)); // should print false
        System.out.println("Max " + tree.findMax()); // should print 9
    }
}
