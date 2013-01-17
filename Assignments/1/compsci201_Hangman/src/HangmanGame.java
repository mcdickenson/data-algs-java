import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * You write code here to play a game of Hangman.
 * Some sample code provided at the start. You'll probably remove almost 
 * all of it (readString might stick around).
 * 
 * @author Matt Dickenson
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
		System.out.printf("%s > ", prompt);
		String entered = myInput.nextLine();
		return entered;
	}
	
	// prompt user for a guess count between 1 and 99
	public int getGuessCount(){
		String guesses = readString("How many guesses?");
		int count = Integer.parseInt(guesses);
		if(count>99 || count<1){
			System.out.println("Please enter a number between 1 and 99.");
			count = getGuessCount(); 
		}
		return count; 
	}
	
	// get a word from our text file with a length between 2 and 20 
	public String getWord(){
		HangmanFileLoader data = new HangmanFileLoader();
		data.readFile("lowerwords.txt");
		String letters = readString("How many letters in guess word?");
		int length = Integer.parseInt(letters);
		String word = data.getRandomWord(length);
		if(length<2 || length>20){
			System.out.println("Please enter word length between 2 and 20."); 
			word = getWord(); 
		}
		return word; 
	}
	
	// make an array of dashes to hold the user's correct guesses
	public char[] makeDashArray(int size){
		char[] array = new char[size];
		for(int i = 0; i < size; i++){
			array[i] = '_';
		}
		return array; 
	}
	
	// give user information about the state of the game for their next turn 
	public void nextTurn(HashSet<Character> incorrectGuesses, int missCount, String currentWord){
		System.out.println(); 
		System.out.print("Incorrect guesses so far: ");
		for(char j : incorrectGuesses){
			System.out.print(j); 
		}
		System.out.println(); 
		System.out.printf("%d misses remaining.\n", missCount); 
		System.out.println(currentWord);
	}
	
	
	/**
	 * Play one game of Hangman. This should prompt
	 * user for parameters and then play a complete game.
	 * You'll likely want to call other functions from this one. 
	 * The existing code may provide some helpful examples.
	 */
	public void play() {
		 
		 int remainingMisses = getGuessCount();
		 String secretWord = getWord();
		 char[] correctGuessArray = makeDashArray(secretWord.length());
		 HashSet<Character> incorrectGuesses = new HashSet<Character>();
		 boolean gameWon = false;
		 
		 while (!gameWon && remainingMisses>0){
			 String guess = readString("Guess a letter");
			 char guessedLetter = Character.toLowerCase(guess.charAt(0)); 
			 
			 // replace spots where guessedLetter occurs in guessArray
			 int spot = secretWord.indexOf(guessedLetter);
			 if (spot >= 0){
				 while (spot >= 0){
					 correctGuessArray[spot] = secretWord.charAt(spot); 
					 spot = secretWord.indexOf(guessedLetter, spot+1);
				 }
			 }
			 else {
				 boolean newIncorrect = incorrectGuesses.add(guessedLetter); 
				 if(newIncorrect){ remainingMisses -= 1; }
			 }
			 
			 String currentWord = new String(correctGuessArray); 
			 
			 if(currentWord.equals(secretWord)) {
				 System.out.println("You guessed my word! '" + secretWord + "'");
				 gameWon = true;
				 break;
			 }
			 nextTurn(incorrectGuesses, remainingMisses, currentWord); 
		 }

		 if (!gameWon) {
			 System.out.println("You lost, the secret word was '" + secretWord + "'");
		 }	 
	}
}
