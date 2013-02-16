import java.util.*;

/*
 * @author Matt Dickenson
 */

public class MapMarkovModel extends AbstractModel {
	
	private String myString;
    private Random myRandom;
    private HashMap<String, ArrayList<Character>> myMap; 
    public static final int DEFAULT_COUNT = 100; // default # random letters generated

    public MapMarkovModel() {
       
        myRandom = new Random(1234);
        myMap = new HashMap<String, ArrayList<Character>>(); 
    }

    /**
     * Create a new training text for this model based on the information read
     * from the scanner.
     * @param s is the source of information
     */
    public void initialize(Scanner s) {
        double start = System.currentTimeMillis();
        int count = readChars(s);
        double end = System.currentTimeMillis();
        double time = (end - start) / 1000.0;
        super.messageViews("#read: " + count + " chars in: " + time + " secs");
    }

    protected int readChars(Scanner s) {
        myString = s.useDelimiter("\\Z").next();
        s.close();      
        return myString.length();
    }
    
    /**
     * Generate N letters using an order-K markov process where
     * the parameter is a String containing K and N separated by
     * whitespace with K first. If N is missing it defaults to some
     * value.
     */
    public void process(Object o) {
        String temp = (String) o;
        String[] nums = temp.split("\\s+");
        int k = Integer.parseInt(nums[0]);
        int numLetters = DEFAULT_COUNT;
        if (nums.length > 1) {
            numLetters = Integer.parseInt(nums[1]);
        }
        smart(k, numLetters);
    }
  
    /**
     * Use a map to build the output string
     * @param k is the length of the n-gram
     * @param numLetters is the number of letters in output
     */
    public void smart(int k, int numLetters) {
    	
    	if (myMap.size()==0){
    		myMap = buildMap(k);
    	}
    	else{
    		List<String> keys = new ArrayList<String>(myMap.keySet());
        	String first = keys.get(0);
        	if(first.length()!=k){
        		myMap = buildMap(k);
        	}
    	}
    	
    	// use a map to generate the markov string
    	int start = myRandom.nextInt(myString.length() - k + 1);
    	String str = myString.substring(start, start + k);
    	StringBuilder build = new StringBuilder();
    	
    	double stime = System.currentTimeMillis();
    	for(int i=0; i<numLetters; i++){
    		ArrayList<Character> nextChars = myMap.get(str);
    		int pick = myRandom.nextInt(nextChars.size());
       		Character next = nextChars.get(pick);
       		build.append(next);
       		str = str.substring(1) + next;		
    	}
    	double etime = System.currentTimeMillis();
        double time = (etime - stime) / 1000.0;
        this.messageViews("Time to generate: " + time);
    	this.notifyViews(build.toString());
    } 
    
    /**
     * Build the map for smart()
     * @param k is the length of the n-grams
     * @return a map of strings to character arrays 
     */
    public HashMap<String, ArrayList<Character>> buildMap(int k){
    	HashMap<String, ArrayList<Character>> map = new HashMap<String, ArrayList<Character>>();
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
    		
    	return map; 
    }
}
