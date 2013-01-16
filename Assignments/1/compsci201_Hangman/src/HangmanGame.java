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
	
	public int getGuessCount(){
		String guesses = readString("How many guesses?");
		// TODO: ensure valid input 0<guesses<99
		int count = Integer.parseInt(guesses);
		return count; 
	}
	
	public String getWord(){
		HangmanFileLoader data = new HangmanFileLoader();
		data.readFile("lowerwords.txt");
		String letters = readString("How many letters in guess word?");
		// TODO: ensure valid input 0<length<20
		int length = Integer.parseInt(letters);
		String word = data.getRandomWord(length);
		return word; 
	}
	
	/**
	 * Play one game of Hangman. This should prompt
	 * user for parameters and then play a complete game.
	 * You'll likely want to call other functions from this one. 
	 * The existing code may provide some helpful examples.
	 */
	public void play() {
		 
		 int guessCount = getGuessCount();
		 
		 String secretWord = getWord();
		 char[] correctGuessArray = new char[secretWord.length()];
		 for(int i = 0; i < secretWord.length(); i++){
			 correctGuessArray[i] = '_'; 
		 }
		 
		 ArrayList<Character> incorrectGuesses = new ArrayList<Character>();
		 
		 boolean gameWon = false;
		 while (!gameWon && guessCount>0){
			 String guess = readString("Guess a letter");
			 char guessedLetter = guess.charAt(0); //TODO: make lower case
			 
			 // replace spots where guessedLetter occurs in guessArray
			 // TODO: make this repeat 
			 int spot = secretWord.indexOf(guessedLetter);
			 if (spot >= 0){
				 correctGuessArray[spot] = secretWord.charAt(spot); 
				 spot = secretWord.indexOf(guessedLetter);
			 }
			 else {
				 incorrectGuesses.add(guessedLetter); 
				 
				 guessCount -= 1; 
			 }
			 
			 String currentWord = new String(correctGuessArray); 
			 
			 if(currentWord.equals(secretWord)) {
				 System.out.println("You guessed my word!");
				 gameWon = true;
				 break;
			 }

			 System.out.println(); 
			 System.out.print("Guesses so far: ");
			 for(char j : incorrectGuesses){
				 System.out.print(j); 
			 }
			 System.out.println(); 
			 System.out.printf("%d guesses remaining.\n", guessCount); 
			 System.out.println(currentWord);
			 
		 }

		 if (!gameWon) {
			 System.out.println("You lost, the secret word was " + secretWord);
		 }	 
	}
}
