import java.io.*;
import java.util.Scanner;

/**
 * You write code here to play a game of Hangman.
 * Some sample code provided at the start. You'll probably remove almost 
 * all of it (readString might stick around).
 * 
 * @author YOUR NAME HERE
 */

public class HangmanGame {

	// Used for reading data from the console.
	Scanner myInput;
	
	public HangmanGame() {
		// Set up our read-from-console.
		myInput = new Scanner(
				new BufferedReader(new InputStreamReader(System.in)));
	}
	
	
	/**
	 * Get a line from the user and return the line as a String.
	 * 
	 * @param prompt is printed as an instruction to the user
	 * @return entire line entered by the user
	 */
	public String readString(String prompt) {
		System.out.printf("%s ", prompt);
		String entered = myInput.nextLine();
		return entered;
	}
	
	/**
	 * Play one game of Hangman. This should prompt
	 * user for parameters and then play a complete game.
	 * You'll likely want to call other functions from this one. 
	 * The existing code may provide some helpful examples.
	 */
	public void play() {
		
		 HangmanFileLoader data = new HangmanFileLoader();
		 data.readFile("lowerwords.txt");
		 
		 String input = readString("How many guesses?");
		 int guessCount = Integer.parseInt(input);
		 
		 String secretWord = data.getRandomWord(4);
		 
		 System.out.println("4 letter secret word is " + secretWord);
		 System.out.println("6 letter secret word is " + data.getRandomWord(6));
		 System.out.println("10 letter secret word is " + data.getRandomWord(10));
		 
		 boolean gameWon = false;
		 for (int k = 0; k < guessCount; k += 1) {
			 String guess = readString("What's the secret word:");
			 if(guess.equals(secretWord)) {
				 System.out.println("You guessed my word!");
				 gameWon = true;
				 break;
			 } else {
				 // Note the difference between "print" and "println"!
				 System.out.print("Nope, ");
			 }
		 }
		 
		 if (!gameWon) {
			 System.out.println("you lost, secret word was " + secretWord);
		 }	 
	}
}
