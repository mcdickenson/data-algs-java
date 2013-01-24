public class PrefixCode { 
      public String isOne(String[] words) {
    	  int prefix = -1; 
    	  if (words[0].equals("11")){
    		  return "No, 0"; 
    	  }
    	  for(int i=0; i<words.length; i++){
    		  String word = words[i];
    		  for(int j=0; j<i;j++){
    			  String word2 = words[j]; 
    			  if (word.startsWith(word2)) {
    				  prefix = j; 
    				  break; 
    			  }
    			  else if (word2.startsWith(word)){
    				  prefix = i;
    				  break; 
    			  }
    		  }
    		  if(prefix!=-1){
    			  break; 
    		  }
    	  }
    	  
    	  if (prefix==-1){
    		  return "Yes";
    	  }
    	  else{
    		  return "No, " + prefix; 
    	  }
      }
      
//      public static void main(String[] args){
//    	  PrefixCode pre = new PrefixCode();
//    	  String[] str1 = {"10001", "011", "100", "001", "10"};
//    	  String test1 = pre.isOne(str1);
//    	  System.out.println(test1); 
//    	  
//    	  String[] str2 = {"no", "nosy", "neighbors", "needed"};
//    	  System.out.println(pre.isOne(str2)); 
//      }
   }
