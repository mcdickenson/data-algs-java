import java.util.*;

public class Anonymous {
      public int howMany(String[] headlines, String[] messages) {
    	  
    	  // count how many of each letter available
    	  HashMap<Character, Integer> lettersAvailable = countLetters(headlines);
//    	  System.out.println(lettersAvailable); 
    	  
    	  // see how many words we can make
    	  int wordsWeCanMake = 0; 
    	  for(String message : messages){
    		  String[] oneMessage = {message}; 
    		  HashMap<Character, Integer> lettersNeeded = countLetters(oneMessage);
    		  boolean canMakeMessage = true;
    		  Iterator it = lettersNeeded.entrySet().iterator(); 
    		  while (it.hasNext()){
    			  Map.Entry pairs = (Map.Entry)it.next();
    			  char key = (Character) pairs.getKey(); 
    			  if(!(key==' ')){
    				  int numNeeded = (Integer) pairs.getValue();
        			  if(lettersAvailable.containsKey(key)){
        				  int numAvailable = lettersAvailable.get(key); 
        				  canMakeMessage = (numNeeded <= numAvailable) && canMakeMessage;
        			  }
        			  else{
        				  canMakeMessage = false ; 
        				  break;
        			  }
    			  }
    			  
    		      it.remove();
    		  }
    		  if(canMakeMessage){
    			  wordsWeCanMake += 1; 
    		  }
    	  }
    	  return wordsWeCanMake; 
      }
      
      public HashMap<Character, Integer> countLetters(String[] words){
    	  HashMap<Character, Integer> counts = new HashMap<Character, Integer>();
    	  int currentCountOfLetter = 0;
    	  
    	  for(String word : words){  
    		  for(int i=0; i<word.length(); i++){
    			  char letter = Character.toLowerCase(word.charAt(i));
    			  if (counts.containsKey(letter)){
    				  currentCountOfLetter = counts.get(letter);
    				  currentCountOfLetter +=1; 
    			  }
    			  else {
    				  currentCountOfLetter = 1;
    			  }
    			  counts.put(letter, currentCountOfLetter); 
    		  }
    	  }
    	  
    	  return counts; 
      }
      
//      public static void main(String[] args){
//    	  Anonymous a = new Anonymous(); 
//    	  String[] h1 = {"Earthquake in San Francisco", "Burglary at musuem in Sweden", "Poverty"}; 
//    	  String[] m1 = {"Give me my money back", "I am the best coder", "TOPCODER"}; 
//    	  int test1 = a.howMany(h1, m1);
//    	  System.out.println(test1); // 2 
//    	  
//    	  String[] h2 = {"j "};
//    	  String[] m2 = {"hva w ", " IQHmks k FP jR yd "};
//    	  System.out.println(a.howMany(h2, m2)); // 0
//      }
}