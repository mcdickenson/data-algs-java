import java.util.ArrayList;
import java.util.List;



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
				List<BoardCell> list = new ArrayList<BoardCell>(); // may need to move this below
				if (helper(board, r, c, list, word, lex)){
					add(word.toString());
				}
			}
		}
    	
    	// prune searches based on prefixes
    }
    
    // recursive helper here
    public boolean helper(BoggleBoard board, int r, int c, 
    		List<BoardCell> list, StringBuilder soFar, ILexicon lex){
    	
    	if(r < 0 || c < 0 || r >= board.size() || c >= board.size() ){
			return false; // discontinue search 
		}
    	BoardCell cell = new BoardCell(r, c);
		if(list.contains(cell)){ return false; } // no duplicating cells
		
    	// add letter at rc to soFar
		String current = board.getFace(r, c);
		soFar.append(current);
		
    	// if soFar is a word or a prefix, continue by calling helper on adjacent cubes
		if(lex.wordStatus(soFar) != LexStatus.NOT_WORD){
			list.add(cell);
			int[] rdelta = {-1,-1,-1, 0, 0, 1, 1, 1};
			int[] cdelta = {-1, 0, 1,-1, 1,-1, 0, 1};
			for(int k=0; k < rdelta.length; k++){
			  if (helper(board, r+rdelta[k], c+cdelta[k], 
			    		list, soFar, lex)){ return true; }
			}			
			
			// backtracking step
			list.remove(cell);
			soFar.deleteCharAt(soFar.length()-current.length());
		}
		
    	return false; 
    }
    
    // can override inherited methods if necessary 
    
    

}
