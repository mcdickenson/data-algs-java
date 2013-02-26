
public class FloodRelief {
	private char[][] list;
	private int numRows; 
	private int numCols ;
	private int minRows = -1, minCols = -1;
	private char min;

	public int minimumPumps(String[] heights){
		numRows = heights.length;
		numCols = heights[0].length();
		list = new char[numRows][numCols];
		int pumps = 0;
		// turn into grid
		for(int r =0; r < numRows; r++){
			for(int c=0; c < numCols; c++){
				list[r][c] = heights[r].charAt(c);
			}
		}
		// recursively count pumps 
		while(detectLow()){
			recurse(min,minRows,minCols);
			pumps++;
		}
		return pumps;
	}

	public void recurse(char m, int row, int col){
		if(0 <= row && row < numRows && 0 <= col&& col < numCols){
			if(list[row][col]!='*'&&list[row][col]>=m){
				char n = list[row][col];
				list[row][col]='*';
				recurse(n,row+1,col);
				recurse(n,row-1,col);
				recurse(n,row,col+1);
				recurse(n,row,col-1);
			}
		}
	}

	public boolean detectLow(){
		int i = numRows * numCols;
		min = '{';
		for(int r =0; r < numRows; r++){
			for(int c=0; c < numCols; c++){
				if(list[r][c]=='*')i--;
				else if(list[r][c]<min){
					min=list[r][c];
					minRows = r;
					minCols = c;
				}
			}
		}
		if(i == 0)return false;
		return true;
	}
	
//	public static void main(String[] args){
//		
//		FloodRelief f = new FloodRelief();
//		String[] input1={
//				"ccccccccccc",
//				 "caaaaaaaaac",
//				 "caaaaaaaaac",
//				 "caazpppzaac",
//				 "caapdddpaac",
//				 "caapdddpaac",
//				 "caapdddpaac",
//				 "caazpppzaac",
//				 "caaaaaaaaac",
//				 "caaaaaaaaac",
//				 "ccccccccccc"
//		};
//		int test1 = f.minimumPumps(input1);
//		System.out.printf("Expected 2, got %d", test1);
//		System.out.println(); 
//	}
}