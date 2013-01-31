import java.util.*;

/**
 * JottoModel.java
 * @author ola, mac
 * 
 * Matt Dickenson
 * 
 * This is the base class for a Jotto model. The idea is that you (the 
 * student) will implement the stub methods that are currently marked 
 * TODO to create a program that plays Jotto. You'll likely need to add 
 * instance variables, and (probably) helper methods as well.
 * 
 ************************************************
 * A note on Model/View
 * --------------------
 * Like many of the assignments you'll see, this one comes with a pre-made 
 * graphical user interface (or "GUI", pronounced "gooey"). That's nice!
 * 
 * Writing code for GUIs is a pain, which is why we provide it. However, 
 * your code _will_ need to interact correctly with ours. To facilitate 
 * this, we use what's called a "Model-View" design. In short, the code is 
 * broken into two major pieces: one that stores the data and does the 
 * computation (the "Model") and another to do the interaction and 
 * visualization (the "View"). In this case, we've provided the View 
 * (it's in JottoViewer.java); feel free to read that code, but you won't 
 * need to edit it, or understand what it's doing, to complete this 
 * assignment.
 * 
 * Your job is to implement the Model, (the JottoModel class) 
 * which is in this file. There are several methods provided that deal
 * with interacting with the view; those you won't need to modify.
 * 
 * There are also several methods that you will need to modify. They are 
 * marked with a TODO below.
 * 
 * You may want to implement some private, helper methods that are called
 * in the code below to avoid duplicate code, that will depend on what 
 * you write.
 */

public class JottoModel {
	// The View. We store this so that we can call its methods, 
	// like "Show a message."
    private JottoViewer myView; 
    
    // The list of legal words.
    private ArrayList<String> myWordList;
    
    /*
     * TODO: Add any instance variables you need. I recommend storing
     * the guess you just made, and probably a Random object 
     * (which generates Random numbers). See PopularityContest.java for
     * an example of using a Random object. 
     */
    Random rand = new Random();
    String guess = new String(); 
    
    /**
     * Initialize the model appropriately. This is going to include 
     * initializing myWordList (which is the list of possible words), 
     * plus any instance variables you choose to add.
     * 
     * TODO: Add any necessary code to this method.
     */
    public JottoModel() {
    		// We do the variable we already have.
        myWordList = new ArrayList<String>();
    }

    /**
     * Associate a view with this model.
     * @param view is view that's notified when model
     * changes.
     * 
     * You don't need to modify this method.
     */
    public void addView(JottoViewer view) {
        myView = view;
    }

    /**
     * Display a dialog box. This can be used to tell the user that the 
     * game is over (for example), or to provide other messages. You 
     * don't need to modify this method, but you will use it!
     * 
     * (And yes, that's "modal" with an 'a', not a typo. A "modal" dialog
     * box is one where the user must respond to it by clicking on 
     * something.) This is probably what you're going to use to announce
     * the end of the game.
     * 
     * @param s is the string displayed in the modal dialog
     */
    private void showModalMessage(String s){
        myView.showModalInfo(s);
    }

    /**
     * Display a small message in the view's message area. Unlike 
     * showModalMessage, this doesn't interrupt anything.
     * 
     * You don't need to modify this method. You might use it to inform
     * the user of what they should be doing.
     * 
     * @param s is message displayed
     */
    private void messageViews(String s) {
        myView.showMessage(s);
    }
    
    /**
     * Communicate the guess to the view.
     * 
     * You don't need to modify this method, although you might want to.
     * 
     * You will need to use it! After you figure out what word to guess 
     * next, call this method with that word as an argument.
     * 
     * @param s is the guess
     */
    private void doGuess(String s){
        myView.processGuess(s);
    }

    /**
     * Read in words. 
     * 
     * You don't need to modify this method at all.
     * 
     * @param s is scanner that is source of words.
     */
    public void initialize(Scanner s) {
        myWordList.clear();
        while (s.hasNext()) {
            myWordList.add(s.next());
        }
        messageViews("Choose \"New Game\" from the menubar.");
    }

    /**
     * Process input from the user. The input is the
     * number of letters in common with the user's secret
     * word. This method does rudimentary analysis of the response for 
     * legality (like "Did they really type a number?") and then calls 
     * processResponse, which is where your code goes.
     * 
     * You don't need to modify this method at all.
     * 
     * @param o is the response from the user. This is a String
     * representing an int that's the number of letters in
     * common with last word guessed by computer. 
     */
    public void process(Object o) {
        String response = (String) o;
        if (response.length() == 0) {
            myView.badUserResponse("Not a number!");
            return;
        }
        try {
            int n = Integer.parseInt(response);
            if (n < 0 || n > 6) {
                myView.badUserResponse("Out of range: " + n);
                return;
            }
            processResponse(n);
        } catch (NumberFormatException e) {
            myView.badUserResponse("Not a number: " + response);
        }
    }

    /**
     * Make the view not respond to user input except choosing new game 
     * or quit (By calling the view's method that disables user input).
     * 
     * You don't need to modify this method at all.
     * 
     * You might want to call it when the game ends.
     */
    public void stopGame() {
        myView.setStopped();
    }
 
    /**
     * This method is where you do your work. The human player has told 
     * you how many letters overlap with your previous guess; that gets 
     * passed in as n. You must now generate a new guess and call doGuess 
     * with that value. Note that the current version is pretty naive: 
     * it always guesses "bagel", which (while a great word) isn't 
     * likely to do a good job of guessing their word. This method also 
     * needs to be aware of the game ending, and should display a modal 
     * dialog when that happens.
     * 
     * @param n is the number of letters in common with the
     * last computer-generated guess
     */
    public void processResponse(int n) {
    		// TODO: Make this actually play Jotto.
        doGuess("bagel");
    }
    
    
    /**
     * Start a new game -- set up whatever state you want, and generate
     * the first guess made by the computer.
     */
    public void newGame() {
    		// TODO: Implement this.
        doGuess("bagel");
    }
    
    /**
     * Extra credit! If the player selects the "Smarter AI" choice from 
     * the menu, the view calls this method. This method should set some 
     * instance variable that tells the rest of the code to do a better 
     * job of guessing.
     */
    public void playSmarter() {
    		// TODO: extra credit
    	doGuess("smart");
    }
    
    /**
     * Returns number of letters in common to a and b, ensuring
     * each common letter only counts once in total returned.
     * 
     * TODO: Implement this method! You're going to need it to actually
     * implement Jotto.
     * 
     * NOTE: This is the trickiest algorithmic part of this assignment.
     * 
     * @param a is one string being compared
     * @param b is other string being compared
     * @return number of letters in common to a and b
     */
    private int commonCount(String a, String b) {
    	    // TODO: Implement this method!
    		
    		/*
    		 * Some thoughts:
    		 * We suggest an algorithm kind of 
    		 * like this:
    		 * for each character in String a:
    		 *   if that character occurs in String b:
    		 *     remove that character from both a and b.
    		 *     increment a counter of matches.
    		 *     
    		 * Implementing that algorithm verbatim is tricky, for a 
    		 * couple of reasons, mostly having to do with your variables 
    		 * changing length while you iterate over them.
    		 * 
    		 * Here's a variation that will make things easier:
    		 * Construct two HashMap<Character, Integer> objects, one for 
    		 * each String, that store how many times each character appears.
    		 * Recall that Character is the "key type", and Integer is the 
    		 * "value type": that is, the .get method on the map takes in a 
    		 * character, and tells you the associated Integer. Recall also 
    		 * that Strings have a .charAt method that works like [] works on 
    		 * arrays, or .get works on ArrayLists. 
    		 * 
    		 * Suppose your maps are called map1 and map2. Then, your
    		 * algorithm will look something like this:
    		 * for (Character c : map1.keySet()) {
    		 *   if (map2.containsKey(c)) { 
    		 *     // An overlap! Maybe even a multiple overlap...
    		 *   } 
    		 * } 
    		 * 
    		 * Done this way, you won't even need to remove anything from 
    		 * your maps.
    		 */
    		// 0 is left in just so the code will compile. It's not the right
    	    // answer most of the time...
    		return 0;
    }
}
