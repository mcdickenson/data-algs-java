public class CountAppearances {
     public int numberTimesAppear(int number, int digit) {
    	 String numString = Integer.toString(number);
    	 String digString = Integer.toString(digit);
    	 char digChar = digString.charAt(0);
    	 
    	 int digitAppearances = 0;
    	 
    	 for (int i = 0; i < numString.length(); i++){
     	    char letter = numString.charAt(i);        
     	    if(letter == digChar){
     	    	digitAppearances += 1;
     	    }
     	}
    	 
    	return digitAppearances;
     }
     
//     public static void main(String[] args){
//    	int test1 = 56854;
//    	int result1 = numberTimesAppear(test1, 5);
//    	System.out.println(result1);
//     }
   }
