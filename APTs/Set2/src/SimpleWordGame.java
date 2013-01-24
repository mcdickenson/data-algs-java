import java.util.*;

public class SimpleWordGame {
      public int points(String[] player, 
                        String[] dictionary) {
    	  HashSet<String> uniqueWords = new HashSet<String>(); 
    	  for(int i=0; i<player.length; i++){
    		  String word = player[i]; 
    		  uniqueWords.add(word); 
    	  }
    	  int points = 0;
    	  
    	  Iterator it = uniqueWords.iterator();
    	  
    	  while(it.hasNext()){
    		  String word = (String) it.next();
    		  System.out.println(word); 
    		  for(String s : dictionary){
    			  if (s.equals(word)){
    				  points += (word.length()*word.length()); 
    			  }
    		  }
    	  }
    	  
    	  return points; 
      }
      
//      public static void main(String[] args){
//    	  SimpleWordGame game = new SimpleWordGame(); 
//    	  String[] p1 = {"apple", "orange", "strawberry"}; 
//    	  String[] d1 = {"strawberry", "orange", "grapefruit", "watermelon"};
//    	  
//    	  int score1 = game.points(p1, d1); 
//    	  System.out.println(score1); 
//      }
  }