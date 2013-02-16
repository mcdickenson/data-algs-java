import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class WordMarkovModel extends AbstractModel {
	
	private String myString;
	private ArrayList<String> myStrings;
    private Random myRandom;
    private HashMap<WordNgram, ArrayList<WordNgram>> myMap; 
    public static final int DEFAULT_COUNT = 100; // default # random letters generated

    public WordMarkovModel() {
       
        myRandom = new Random(1234);
        myMap = new HashMap<WordNgram, ArrayList<WordNgram>>();
    }
	
	public void initialize(Scanner s) {
        double start = System.currentTimeMillis();
        int countChar = readChars(s);
        String[] words = myString.split("\\s+");
        int countWord = words.length;
        double end = System.currentTimeMillis();
        double time = (end - start) / 1000.0;
        super.messageViews("#read: " + countWord + " words in: " + time + " secs");
    }

    protected int readChars(Scanner s) {
        myString = s.useDelimiter("\\Z").next();
        s.close();      
        return myString.length();
    }
    
    /**
     * Generate N words using an order-K markov process where
     * the parameter is a String containing K and N separated by
     * whitespace with K first. If N is missing it defaults to some
     * value.
     */
    public void process(Object o) {
        String temp = (String) o;
        String[] nums = temp.split("\\s+");
        int k = Integer.parseInt(nums[0]);
        int numWords = DEFAULT_COUNT;
        if (nums.length > 1) {
            numWords = Integer.parseInt(nums[1]);
        }
        smart(k, numWords);
    }
    
    public void smart(int k, int numLetters) {
    	
    	if (myMap.size()==0){
    		myMap = buildMap(k);
    	}
    	else{
    		List<WordNgram> keys = new ArrayList<WordNgram>(myMap.keySet());
        	WordNgram first = keys.get(0);
        	if(first.numWords() !=k){
        		myMap = buildMap(k);
        	}
    	}
    	
    	// use a map to generate the markov string
    	int start = myRandom.nextInt(myString.length() - k + 1);
    	String str = myString.substring(start, start + k);
    	StringBuilder build = new StringBuilder();
    	
    	double stime = System.currentTimeMillis();
    	for(int i=0; i<numLetters; i++){
    		ArrayList<WordNgram> nextWords = myMap.get(str);
    		if(!(nextWords==null)){ // TODO: remove this line once it works 
    			int pick = myRandom.nextInt(nextWords.size());
        		WordNgram next = nextWords.get(pick);
        		build.append(next);
        		str = str.substring(1) + next;
    		}
    	}
    	double etime = System.currentTimeMillis();
        double time = (etime - stime) / 1000.0;
        this.messageViews("Time to generate: " + time);
    	this.notifyViews(build.toString());
    } 
    
    public HashMap<WordNgram, ArrayList<WordNgram>> buildMap(int k){
    	HashMap<WordNgram, ArrayList<WordNgram>> map = new HashMap<WordNgram, ArrayList<WordNgram>>();
    	String wrapAroundString = myString + myString.substring(0,k); 
    	ArrayList<Character> list = new ArrayList<Character>();
    	
    	for (int i = 0; i < myString.length(); i++) {
    		String kchar = wrapAroundString.substring(i, i+k);
    		if(map.containsKey(kchar)){ list = map.get(kchar); }
    		else{ list = new ArrayList<Character>(); }
    		Character next = wrapAroundString.charAt(i+k);
    		list.add(next);
    		map.put(kchar, list);
    	}
    		
    	return new HashMap<WordNgram, ArrayList<WordNgram>>(); 
    }

    //TODO: make the new map work
    //TODO: make WordNgram's instead of substrings 
}
