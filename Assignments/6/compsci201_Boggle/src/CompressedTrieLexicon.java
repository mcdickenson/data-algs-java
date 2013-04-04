import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

//import TrieLexicon.Node;


public class CompressedTrieLexicon extends TrieLexicon {
	
	public static class Node {
        String info;
        boolean isWord;
        
        Map<Character,Node> children;
        Node parent;

        Node(char ch, Node p) {
            info = ""+ch;
            isWord = false;
            children = new TreeMap<Character,Node>();
            parent = p;
        }
    }

    protected Node myRoot; // root of entire trie
    protected int mySize;

    public CompressedTrieLexicon() {
        myRoot = new Node('x', null);
        mySize = 0;
    }

    public int size() {
        return mySize;
    }

    @Override
    public void load(ArrayList<String> list) {
    	super.load(list);
    	compress();
    }
    
    public void compress(){
    	ArrayList<Node> leaves = new ArrayList<Node>();
    	leaves = getLeaves(myRoot, leaves);
  
    	for(Node n: leaves){
    		
    		boolean parentIsWordOrMultiple = n.parent.isWord || n.parent.children.size()>1;
    		while(!parentIsWordOrMultiple){
    			Node p = n.parent;
    			p.info = p.info + n.info; 
    			p.children.clear();
    			n = p; 
    			parentIsWordOrMultiple = n.parent.isWord || n.parent.children.size()>1;
    		}
    	}
    }
    
    public ArrayList<Node> getLeaves(Node root, ArrayList<Node> list){
    	if(root == null){ return null; }
    	if(oneWay(root)==0){ list.add(root); }

    	for(Node n : root.children.values()){
        	getLeaves(n, list);
        }
    	return list; 
    }

    // more code not shown
    public boolean add(String s) {
    	Node t = myRoot;

    	for (int k = 0; k < s.length(); k++) {

    		char ch = s.charAt(k);
    		Node child = t.children.get(ch);
    		if (child == null) {
    			child = new Node(ch, t);
    			t.children.put(ch,child);
    		}
    		t = child;
    	}

    	if (!t.isWord) {
    		t.isWord = true; // walked down path, mark this as a word
    		mySize++;
    		return true;
    	}
    	return false; // already in set
    }

    public Iterator<String> iterator() {
    	ArrayList<String> list = new ArrayList<String>();
    	StringBuilder str = new StringBuilder();
    	for(Node n : myRoot.children.values()) {
    		str.append(n.info);
    		fillUp(n,list,str);
    		str.deleteCharAt(str.length()-1);
    	}
    	return list.iterator();
    }

    protected void fillUp(Node root, ArrayList<String> list, StringBuilder str){
    	if (root.isWord){
    		list.add(str.toString());
    	}
    	for(Node n : root.children.values()) {
    		str.append(n.info);
    		fillUp(n,list,str);
    		str.delete(str.length()- n.info.length(), str.length());
    	}
    }

    public void load(Scanner s) {
    	while (s.hasNext()){
    		add(s.next());
    	}
    }

    public LexStatus wordStatus(StringBuilder s){
    	Node t = myRoot;
    	for (int k = 0; k < s.length(); k++) {
    		char ch = s.charAt(k);
    		t = t.children.get(ch);
    		if (t == null)
    			return LexStatus.NOT_WORD; // no path below? done
    	}
    	return t.isWord ? LexStatus.WORD : LexStatus.PREFIX; 
    }
    public LexStatus wordStatus(String s) {
    	return wordStatus(new StringBuilder(s));
    }

    public int oneWayCount(){
    	return oneWay(myRoot);
    }

    protected int oneWay(Node root){
    	int count = 0;
    	if (root == null) return 0;
    	if (root.children.keySet().size() == 1) count = 1;
    	for(Node n : root.children.values()){
    		count += oneWay(n);
    	}
    	return count;
    }
    public int nodeCount(){
    	return doCount(myRoot);
    }

    protected int doCount(Node root){
    	int count = 1; // count this node
    	if (root == null) return 0;
    	for(Node n : root.children.values()){
    		count += doCount(n);
    	}
    	return count;
    }
  }