import java.util.HashMap;


public class IsomorphicWords {
      public int countPairs(String[] words) {
         int isomorphs = 0;
         
         for(int i=0; i<words.length-1; i++){
        	 String word1 = words[i];
        	 
        	 for(int j=i+1; j<words.length; j++){
        		 String word2 = words[j];
        		 
        		 // map letters
        		 HashMap<Character, Character> map1to2 = new HashMap<Character, Character>();
        		 for(int k=0; k<word1.length(); k++){
        			
        			boolean already_has_value = map1to2.containsValue(word2.charAt(k) );
        			boolean has_key = map1to2.containsKey(word1.charAt(k));
        			boolean doesnt_have_key = !has_key;
        			if( already_has_value && doesnt_have_key ){
        				map1to2.put( word1.charAt(k), ' '); 
        			}
        			else if (already_has_value && has_key){;}
        			else{
        				map1to2.put( word1.charAt(k), word2.charAt(k) );
        			}
        		 }
        		 
//        		 System.out.println(map1to2);
        		 
        		 // convert letters
        		 char[] array = new char[word1.length()]; 
        		 for(int l=0; l<word1.length(); l++){
        			 array[l] = map1to2.get(word1.charAt(l)); 
        		 }
        		 
        		 String compareString = new String(array); 
        		 
        		 if (word2.equals(compareString)){
        			 isomorphs += 1;
//        			 System.out.printf("%s matches %s%n", word1, word2);
        		 }
        		 else{
//        			 System.out.printf("%s doesn't match %s%n", word1, word2);
        		 }
        	 }
         }
         
         return isomorphs; 
         
      }
      
//      public static void main(String[] args){
//    	  IsomorphicWords iso = new IsomorphicWords(); 
//    	  
//    	  String[] list1 = {"abca", "zbxz", "opqr"};
//    	  int test1 = iso.countPairs(list1);
//    	  System.out.println(test1); // 1
//    	  
//    	  String[] list2 = {"aa", "ab", "bb", "cc", "cd"};
//    	  System.out.println(iso.countPairs(list2)); // 4
//    	  
//    	  String[] list3 = {"aaa", "baa", "cdd", "ddd"};
//    	  System.out.println(iso.countPairs(list3)); // 2
//      }
}
