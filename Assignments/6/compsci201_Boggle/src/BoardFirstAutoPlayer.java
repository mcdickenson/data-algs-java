

public class BoardFirstAutoPlayer extends AbstractAutoPlayer {
    
    @Override
    public void findAllValidWords(BoggleBoard board, ILexicon lex, int minLength) {
	    // 1. set score to zero
    	// 2. clear all words already stored 
    	
    	// try to form words by trying all paths on the board
    	// double for loop goes here
    	for(int r=0; r<board.size(); r++){
			for(int c=0; c<board.size(); c++){
				StringBuilder word = new StringBuilder();
				if (helper(board, r, c, word)){
					add(word.toString());
				}
			}
		}
    	
    	// prune searches based on prefixes
    }
    
    // recursive helper here
    // takes current row, column, and stringBuilder so far
    // similar to GoodWordOnBoardFinder
    public boolean helper(BoggleBoard board, int r, int c, StringBuilder soFar){
    	// add letter at rc to soFar
    	// if soFar is a word or a prefix, continue by calling helper on adjacent cubes
    	// else backtrack by removing rc letter from soFar and cell from visited
    	
    	return false; 
    }
    
    // can override inherited methods if necessary 

}
