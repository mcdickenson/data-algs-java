
public class GridGame {
     public int winningMoves(String[] grid){
    	 int moves = countWins(grid);
    	 return moves;
     }
     
     public int countWins(String[] grid){
    	 int wins = 0;
    	 
    	 for(int i=0; i<4; i++){
    		 String row = grid[i];
    		 for(int j=0; j<4; j++){
    			 if(!hasX(i,j,grid)){ 
    				 if(safeToPlace(i,j,grid)){
    					 row = row.substring(0,j) + "X" + row.substring(j+1,4);
    					 grid[i] = row; 
    					 int opponentWins = countWins(grid);
    					 if(opponentWins==0){
    						 wins++;
    					 }
    					 row = row.substring(0,j) + "." + row.substring(j+1,4);
    					 grid[i] = row; 
    				 }
    			 }

    		 }
    	 }
    	 return wins; 
     }
     
     public boolean safeToPlace(int r, int c, String[] grid){
    	 boolean xAbove = hasX(r-1, c, grid);
    	 boolean xBelow = hasX(r+1, c, grid);
    	 boolean xLeft = hasX(r, c-1, grid);
    	 boolean xRight = hasX(r, c+1, grid);
    	 if(xAbove || xBelow || xLeft || xRight){
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


