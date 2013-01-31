import java.util.*;

public class SortedFreqs {
      public int[] freqs(String[] data) {
        
    	// count words
    	HashMap<String, Integer> list = new HashMap<String, Integer>();
//    	HashSet<String> words = new HashSet<String>();
    	
    	for(String d: data){
    		if (list.containsKey(d)){
    			int i = list.get(d);
    			list.put(d, i+1);
    		}
    		else{
    			list.put(d, 1);
//    			words.add(d);
    		}
    	}
    	
    	List<String> list2 = new ArrayList<String>(list.keySet());
    	Collections.sort(list2); 
    	
    	int[] output = new int[list2.size()];
    	for(int i=0; i<list2.size(); i++){
    		String word = list2.get(i);
    		int wordCount = list.get(word);
    		output[i] = wordCount; 
    	}
    	
    	return output; 
      }
   }