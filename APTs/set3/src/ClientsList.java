import java.util.*;

public class ClientsList {
       public String[] dataCleanup(String[] names) {
            ArrayList<Name> list = new ArrayList<Name>();
    	   
            for(String s : names){
            	String[] n = s.split(" ");
            	if(n[0].contains(",")){
            		list.add(new Name(n[1], n[0].substring(0, n[0].length()-1))); 
            	}
            	else{
            		list.add(new Name(n[0], n[1])); 
            	}
            }
            
            Collections.sort(list); 
            
            String[] result = new String[list.size()];
            
            for(int i=0; i<list.size(); i++){
            	result[i] = (list.get(i)).toString();
            }
            
            return result; 
       }
       
       
       public class Name implements Comparable<Name>{
    	   
    	String myFirst;
    	String myLast; 
    	
    	public Name(String first, String last){
    		myFirst = first;
    		myLast = last; 
    	}

		@Override
		public String toString()
		{
			return myFirst + " " + myLast;
		}
		
		
		public int compareTo(Name arg0) {
			int lasts = (this.myLast).compareTo(arg0.myLast); 
			if (lasts==0){ // last names are same 
				int firsts = (this.myFirst).compareTo(arg0.myFirst);
				return firsts;
			}
			else{
				return lasts; 
			}
		}
    	   
       }
}
