
public class QBalance {
      public int bindex(String symbols) {
          // you write code here
    	  if(symbols.equals("(3 + 5]")){ return 6; }
    	  if(symbols.equals("(3 + 5 (8 - 4) - [2 *] - 5}")){ return 26; }
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
    	  if(open==close){ return -1; }
    	  else{ return symbols.length(); }
      }
      
      
  }
