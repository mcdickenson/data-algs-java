
public class GridGame {
     public int winningMoves(String[] grid){
    	 // count X's on board already--must be odd
    	 int occupiedCount = 0;
    	 int safeCount = 0;
    	 for(int i=0; i<4; i++){
    		 for(int j=0; j<4; j++){
    			 boolean occupied = hasX(i,j,grid);
    			 boolean safe = safeToPlace(i,j,grid);
    			 if(occupied){ occupiedCount++;}
    			 if(safe){ safeCount++;}
    		 }
    	 }
    	 if((occupiedCount%2)==1){ return 0; }
    	 else{ return 16 - safeCount++; } 
    	 
//    	 you can only win if there are an odd number of X's on the board already 
//    	 (i.e. the person who goes first loses). 
//    	 If there are an odd number, your wins is the number of safe, empty places, 
//    	 ie subtract the number of occupied and unsafe places from the total number of grid squares (16 in the APT)
//    	 
     }
     
     public int countWins(String[] grid){
    	 return 0; 
     }
     
     public boolean safeToPlace(int r, int c, String[] grid){
    	 boolean xAbove = hasX(r-1, c, grid);
    	 boolean xBelow = hasX(r+1, c, grid);
    	 boolean xLeft = hasX(r, c-1, grid);
    	 boolean xRight = hasX(r, c+1, grid);
    	 boolean xInThis = hasX(r, c, grid);
    	 if(xAbove || xBelow || xLeft || xRight || xInThis){
    		 return false;
    	 }
    	 else{ return true; }
     }
     
     public boolean hasX(int r, int c, String[] grid){
    	 if(r<0 || r>3){ return false;}
    	 if(c<0 || c>3){ return false;}
    	 String row = grid[r];
    	 char letter = row.charAt(c);
    	 return letter=='X'; 
     }
     
//     public static void main(String[] args){
//    	 GridGame gg = new GridGame();
//    	 String[] test1 = {"....", "....", ".X..", "...."};
//    	 int result1 = gg.winningMoves(test1);
//    	 System.out.println(result1);
//     }
}

//1. Loop over all possible locations on Grid Board
//2. If it is not an "X", determine whether it is safe to place an "X" in that grid square. Safe means not vertically or horizontally adjacent to another X.
//3. If safe, place an "X"
//
//The winner is the last one to place an "X" safely.  It is your turn and you want to know how many of the moves you could make guarantee you will win the game, assuming you play perfectly.
//
//Note: you can only win if there are an odd number of X's on the board already (i.e. the person who goes first loses). If there are an odd number, your wins is the number of safe places, ie subtract the number of occupied and unsafe places from the total number of grid squares (16 in the APT). 
//
//For `safeToPlace`, you first need to check whether the row and column given are inside your grid. Then, you just need to check whether there is an "X" in any of the four adjacent places.
//
//```
//grid[r][c] = 'X';
//int opponentWins = countWins();
//if (opponentWins == 0) ...
//grid[r][c] = '.'; // this is the backtracking step
