
public class StringLinkedList {
	Node myFront;
	int mySize;
	
	public class Node{
		String myData;
		Node myNext;
		
		public Node(String data, Node next){
			myData = data;
			myNext = next;
		}
	}
	
	public StringLinkedList(){
		myFront = null;
		mySize = 0;
	}
	
	public void add(String s){
		Node n = new Node(s, myFront);
		myFront = n;
	}
	
	public String remove(){
		String s = myFront.myData;
		myFront = myFront.myNext;
		return s;
	}
	
	public String toString(){
		return toString(myFront);
	}
	
	public String toString(Node cur){
		return cur.myData;
	}
	
	public static void main(String[] args){
		String[] input = {"Hello", "this", "is", "a", "linked", "list", "with", "recursion"};
		StringLinkedList list = new StringLinkedList();
		for(String s: input){
			list.add(s);
		}
		System.out.println(list.toString());
	}	
}
