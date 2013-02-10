import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class MapMarkovModel {
	
	private String myString;
    private Random myRandom;
    public static final int DEFAULT_COUNT = 100; // default # random letters generated

    public MapMarkovModel() {
       
        myRandom = new Random(1234);
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
    	// TODO: use a map to generate the markov string
    } 
}
