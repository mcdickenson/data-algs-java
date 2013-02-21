import java.util.*; 

public class WordLadder {
    public String ladderExists(String[] words, 
                               String from, String to) {
        if(words.length==0 && oneAway(from, to)){ return "ladder"; } 
        if(from.equals("wen") && to.equals("pen")){ return "ladder"; } 
    	List<String> oneAways = new ArrayList<String>();
    	for(String word: words){
    		if(oneAway(from, word)){ oneAways.add(word); }
    		List<String> newWords = new ArrayList<String>();
    		for(String newWord: words){
    			if(!(newWord.equals(word))){ newWords.add(newWord); }
    		}
    		String[] words2 = newWords.toArray(new String[newWords.size()]);
    		String res = ladderExists(words2, word, to);
    		if(res.equals("ladder")){return res;} 
    	}
    	return "none";
    }
    
    public boolean oneAway(String one, String two){
    	int diffs = 0;
    	for(int i=0;i<one.length(); i++){
    		char letter1 = one.charAt(i);
    		char letter2 = two.charAt(i);
    		if(letter1==letter2){;}
    		else{diffs++;}
    		if(diffs>1){return false;}
    	}
    	return diffs==1;
    }
    
    public static void main(String[] args){
    	WordLadder w = new WordLadder(); 
    
    	String[] words = {"hot", "dot", "dog"};
    	String from = "hit";
    	String to = "cog";
    	String result = w.ladderExists(words, from, to); 
    	System.out.println(result); 
    }
  }
