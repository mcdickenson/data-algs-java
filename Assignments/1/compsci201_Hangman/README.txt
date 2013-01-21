This README contains information for Assignment 1 (Hangman) code submitted by Matt Dickenson for Duke CS 201, Spring 2013, taught by Tabitha Peck.

This project was begun on January 15, 2013, and completed on January 19, 2013. I spent approximately 15 hours on the assignment.

No other students were consulted during the course of this project. The only online resource consulted was http://homepages.shu.ac.uk/~acsdry/quizes/scrabble.htm for Scrabble values.

The code consists of 4 files in 2 main parts.

The first part of the project encompasses HangmanFileLoader.java and HangmanStats.java.
HangmanFileLoader loads an accompanying text file (lowerwords.txt) into memory. 
It also includes a method getRandomWord() that takes an int as input and returns a word of the given length from the file.
HangmanStats.java was written by Matt Dickenson to perform two tasks.
1A) It estimates the empirical distribution of words by length in the text file.
To accomplish this it iterates through a loop 10,000 times, each time sampling a random word at each length 4-20. 
If the word had not been sampled yet, it is added to a HashSet. Otherwise, it is not added. 
By this method we are able to approximate the number of unique words of each length.
1B) the code looks through all the words sampled at a given length (again, between 4 and 20) and finds the one that is worth the most Scrabble points.
It does this by storing the highest-scoring word seen so far as a variable. 
For the next word in the list, we get the combined score of each char in the word.
If the score of this word is higher than the best word seen so far, it replaces the previous high-scoring word in memory.
At the end of the function, the highest scoring word is printed along with its score.

The second part of the project includes HangmanExecuter.java and HangmanGame.java.
HangmanExecuter creates an instance of HangmanGame and runs its play() method.
HangmanGame is where the fun happens. 
A game is set up by asking the user for the number of guesses allowed and the length of the secret word.
Then, it gets a secret word of the desired length from the text file. 
An array of dashes ('-') is then created with a length equal to the secret word. This array stores letters guessed correctly during the game.
For the final part of setup, we create a HashSet of incorrect guesses so far, so that players are not punished for guessing a letter twice.

As long as the game has not been won and the number of guesses allowed has not been reached, the game runs as a loop.
At each iteration of the loop, the user guesses a letter. Input is protected against multi-letter strings or uppercase letters.
If the letter is in the secret word, all instances of that letter in the word are replaced in the guess array.
If the letter is not in the word, the number of guesses remaining is decremented by one.
The loop then checks whether the secret word has been guessed. If it has, the game ends with a congratulatory message.
Once the number of allowable guesses has been reached, we check whether the user won the game. If not, it prints a message revealing the secret word.