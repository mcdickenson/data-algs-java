
public class QBalance {
      public int bindex(String symbols) {
          // you write code here
    	  int open = 0;
    	  int close = 0; 
    	  String opens = "{[(";
    	  String closes = ")]}";
    	  for(int i=0; i<symbols.length(); i++){
    		  String l = symbols.substring(i,i+1);
    		  if(opens.contains(l)){ open +=1; }
    		  else if(closes.contains(l)){ close +=1;}
    		  int dif = open-close;
    		  if(dif==-1){ return i; }
    			  
    	  }
    	  
    	  return open-close-1; 
      }
      
      
  }
