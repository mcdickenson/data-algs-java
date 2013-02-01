import java.util.*;


// also useful for Jotto assignment
public class Common {
     public int count (String a, String b) {
    	 HashMap<Character, Integer> letters1 = countLetters(a);
    	 HashMap<Character, Integer> letters2 = countLetters(b);
    	 int common = 0;
    	 for (Character letter : letters1.keySet()) 
    	        if(letters2.containsKey(letter))
    	        	 common += Math.min(letters1.get(letter), letters2.get(letter));
    	 			
    	 
    	 return common; 
     }
     
     public HashMap<Character, Integer> countLetters(String a){
    	 HashMap<Character, Integer> letters = new HashMap<Character, Integer>();
    	 for(int i=0; i<a.length(); i++){
    		 char letter = a.charAt(i);
    		 if(letters.containsKey(letter)){
    			 int tmp = letters.get(letter);
    			 tmp += 1;
    			 letters.put(letter, tmp);
    		 }
    		 else{
    			 letters.put(letter, 1);
    		 }
    	 }
    	 return letters; 
     }
  }