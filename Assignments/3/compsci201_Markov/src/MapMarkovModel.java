import java.util.*;


public class MapMarkovModel extends AbstractModel {
	
	private String myString;
    private Random myRandom;
    private HashMap<String, ArrayList<String>> myMap; 
    public static final int DEFAULT_COUNT = 100; // default # random letters generated

    public MapMarkovModel() {
       
        myRandom = new Random(1234);
        myMap = new HashMap<String, ArrayList<String>>(); 
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
  
    
    public void smart(int k, int numLetters) {
    	
    	// check whether size of first key == k (if no: need new map)
    	List<String> keys = new ArrayList<String>(myMap.keySet());
    	String first = keys.get(0);
    	if (myMap.size() ==0 || first.length()!=k){
    		myMap = buildMap(k);
    	}
    	
    	// use a map to generate the markov string
    	int start = myRandom.nextInt(myString.length() - k + 1);
    	String str = myString.substring(start, start + k);
    	StringBuilder build = new StringBuilder();
    	
    	double stime = System.currentTimeMillis();
    	for(int i=0; i<numLetters; i+=k){
    		ArrayList<String> list = myMap.get(str);
    		int pick = myRandom.nextInt(list.size());
    		String next = list.get(pick);
    		build.append(next);
    		str = next;
    	}
    	double etime = System.currentTimeMillis();
        double time = (etime - stime) / 1000.0;
        this.messageViews("Time to generate: " + time);
    	this.notifyViews(build.toString());
    } 
    
    public HashMap<String, ArrayList<String>> buildMap(int k){
    	HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    	
    	String wrapAroundString = myString + myString.substring(0,k); 
    	
    	for (int i = 0; i < myString.length(); i++) {
    		ArrayList<String> list = new ArrayList<String>();
    		String kchar = wrapAroundString.substring(i, i+k);
    		String next = wrapAroundString.substring(i+1, k+1);
    		if(map.containsKey(kchar)){
    			list = map.get(kchar);
    			
    		}
    		list.add(next);
			map.put(kchar, list);
    	}
    	return new HashMap<String, ArrayList<String>>(); 
    }
}
