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
         numRows = picture.length; 
   	  	 numCols = picture[0].length(); 
    	  
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
    				  System.out.println(count);
    			  }
    		  }
    	  }
    	  
    	  return count; 
      }
      
      
      public char[][] regionalize(String[] picture){
    	  // create array of chars representing rows, columns
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
      
            
      public static void main(String[] args){
    	  NumberFill n = new NumberFill();
    	  String[] picture1 = {
    			  "..X.....",
    			  "..X..0..",
    			  "1.X.....",
    			  "..X.....",
    			  "........"};
    	  int test1 = n.gradient(picture1);
    	  System.out.printf("Got %d, expected %d", test1, 168);
    	  System.out.println(); 
    	  
    	  String[] picture2 = {
    			  "5.X.....",
    			  "..X..3..",
    			  "..X.....",
    			  "..X.....",
    			  "..X....."};
    	  int test2 = n.gradient(picture2);
    	  System.out.printf("Got %d, expected %d", test2, 130);
    	  System.out.println(); 
    	  
    	  String[] picture3 = {"......0"};
    	  int test3 = n.gradient(picture3);
    	  System.out.printf("Got %d, expected %d", test3, -21);
    	  System.out.println(); 
    	  
    	  String[] picture4 = {
    			  "........",
    			  "........",
    			  "........",
    			  "........"};
    	  int test4 = n.gradient(picture4);
    	  System.out.printf("Got %d, expected %d", test4, 0);
    	  System.out.println(); 
    	  
    	  String[] picture9 = {
    			  ".X....X", 
    			  "2X.0.0.", 
    			  ".XX..1.", 
    			  ".X.X3..", 
    			  "..X9..." };
    	  int test9 = n.gradient(picture9);
    	  System.out.printf("Got %d, expected %d", test9, 218);
    	  System.out.println();
    	  
    	  
      }
}
