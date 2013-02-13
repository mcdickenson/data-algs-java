import java.util.*;

public class StringStack {
	private List<String> myStrings = new ArrayList<String>();
	
	public StringStack(){
	}
	
	public String pop(){
		int length = myStrings.size();
		String last = myStrings.remove(length-1);
		return last; 
	}
	
	public void push(String s){
		this.myStrings.add(s);
	}
	
	public boolean isEmpty(){
		boolean empty = myStrings.size()==0;
		return empty; 
	}
	
	public int length(){
		return myStrings.size(); 
	}
	
}
