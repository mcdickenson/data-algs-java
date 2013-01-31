import java.util.*;

public class TheBestName {
      public String[] sort(String[] names) {
    	  ArrayList<Name> list = new ArrayList<Name>();
    	  
    	  for(String n : names){
//    		  String n = names[i];
    		  Name tmp = new Name(n);
    		  list.add(tmp);
    	  }
          
    	  Collections.sort(list); 
    	  
    	  String[] result = new String[list.size()];
    	  for(int i=0; i<list.size(); i++){
    		  String name = (list.get(i)).toString();
    		  result[i] = name; 
    	  }
    	  
    	  return result;
      }
      
      public class Name implements Comparable<Name>{
    	  String myName;
    	  int myScore;
    	  
    	  public Name(String n){
    		  myName = n;
    		  String points = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26";
//            String letters ="a b c d e f g h i j k l m n o p q r s t u v w x y z";
    		  String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    		  String[] pointList = points.split(" ");
//            String[] letterList = letters.split(" ");
            
    		  HashMap<Character, Integer> letterPoints = new HashMap<Character, Integer>();
    		  for(int i=0; i< pointList.length; i++){
            	char letter = letters.charAt(i);
            	int value = Integer.parseInt(pointList[i]);
            	letterPoints.put(letter, value);
    		  }
    		  
    		  int p=0; 
    		  for(int j=0; j<n.length(); j++){
    			  char l = n.charAt(j); 
    			  p += letterPoints.get(l); 
    		  }
    		  
    		  myScore = p;
    	  }

		@Override
		public String toString(){
			return myName;
		}
		
		public int compareTo(Name arg0) {
			int score; 
			if (this.myName.equals("JOHN")){
				score = -1; 
			}
			else{
				score = -(this.myScore - arg0.myScore);
				if(score==0){
					score = (this.myName).compareTo(arg0.myName);
				}
				
			}
			return score;
		}
      }
      
      
   }
