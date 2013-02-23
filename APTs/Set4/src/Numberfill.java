import java.util.Stack;

public class NumberFill {
	  char[][] list; 
	  int numRows;
	  int numCols; 
	  int maxInCol; 
	  int maxInList; 
	  String numString = "012345689";
	  boolean isColor; 
	  Stack<Integer> counts;
	
      public int gradient(String[] picture) {
         counts = new Stack<Integer>();
    	  
    	  // turn picture into row-column array
    	  list = regionalize(picture);
    	  
    	  // sum the whole picture 
    	  
    	  int count = 0; 
    	  for(int i=0; i<numRows; i++){
    		  for(int j=0; j<numCols; j++){
    			  if(!(counts.isEmpty())){ counts.clear(); }
    			  isColor = false;  
    			  maxInCol = numCols+1;
    			  maxInList = 0;
    			  recurse(i,j);
    			  if(isColor){
    				  while(!counts.empty()){
    					  count += counts.pop() + maxInList - maxInCol; 
    				  }
    			  }
    		  }
    	  }
    	  
    	  return count; 
      }
      
      
      public char[][] regionalize(String[] picture){
    	  // create array of chars representing rows, columns
    	  numRows = picture.length; 
    	  numCols = picture[0].length(); 
    	  char[][] temp = new char[numRows][numCols];
    	  for(int i=0; i<numRows; i++){
    		  String row = picture[i]; 
    		  for(int j=0; j<numCols; j++){
    			  temp[i][j] = row.charAt(j);
    		  }
    	  }
    	  
    	  return temp; 
      }
      
      public void recurse(int row, int col){
    	  if(row<0 || row>=numRows){
    		  return; 
    	  }
    	  if(col<0 || col>= numCols){
    		  return; 
    	  }
    	  if(list[row][col]=='X'){
    		  // stop when you reach a barrier or one you've already counted
    		  return; 
    	  }
    	  else if(list[row][col]=='.'){
    		  //check all around blank spot
    		  list[row][col]='X'; 
    		  counts.push(col); 
    		  recurse(row-1, col);
    		  recurse(row+1, col);
    		  recurse(row, col-1);
    		  recurse(row, col+1); 
    	  }
    	  else if(numString.contains((list[row][col])+"")){
    		  isColor = true; 
    		  int num = numString.indexOf(list[row][col]);
    		  if(num>maxInList){
    			  maxInList = num;
    			  maxInCol = col; 
    		  }
    		  else if(num==maxInList){
    			  if(col<maxInCol){
    				  maxInCol = col; 
    			  }
    		  }
    		  list[row][col]='X'; 
    		  counts.push(col); 
    		  recurse(row-1, col);
    		  recurse(row+1, col);
    		  recurse(row, col-1);
    		  recurse(row, col+1); 
    	  }
      }
      
            
//      public static void main(String[] args){
//    	  NumberFill n = new NumberFill();
//    	  String[] picture = {
//    			  "..X.....",
//    			  "..X..0..",
//    			  "1.X.....",
//    			  "..X.....",
//    			  "........"};
//    	  int test1 = n.gradient(picture);
//    	  System.out.printf("Got %d, expected %d", test1, 168);
//    	  System.out.println(); 
//      }
}
