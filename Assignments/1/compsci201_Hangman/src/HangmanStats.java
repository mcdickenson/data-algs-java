import java.util.*;

//  @author Matt Dickenson

public class HangmanStats {
	public static void main(String[] args) {
		HangmanFileLoader loader = new HangmanFileLoader();
		loader.readFile("lowerwords.txt");
		
//		1a: estimate distribution of word lengths
		ArrayList<HashSet<String>> myList = new ArrayList<HashSet<String>>();
		System.out.printf("list size %d\n", myList.size() );
		for(int i=0; i<17; i++){
			myList.add(new HashSet<String>());
		}
		for(int k=0; k < 10000; k++) {
			for(int j=0; j<17; j++){
				myList.get(j).add(loader.getRandomWord(j+4));
			}
		}
		for(int l=0; l<17; l++){
			System.out.printf("number of %d letter words: %d\n", l+4, myList.get(l).size() );
		}
		
		
//		1b: get highest-value scrabble word of a random length
		int maxVal = 0; 
		String bestWord = ""; 
		int length = (int)(Math.random() * 17);
		for(String word : myList.get(length) ){
			int tmpVal = 0; 
			for(int m=0; m<word.length(); m++){
				char letter = word.charAt(m);
				tmpVal += scrabbleVals(letter);
			}
			if(tmpVal>maxVal){ maxVal = tmpVal; bestWord = word;}
		}
		System.out.printf("best word of length %d is %s for %d points\n", 
				(length+4), bestWord, maxVal); 
	}
	
	public static int scrabbleVals(char letter){
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int[] score = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
//		values from http://homepages.shu.ac.uk/~acsdry/quizes/scrabble.htm
		int pos = alphabet.indexOf(letter);
		int result = score[pos]; 
		return result; 
	}
}
