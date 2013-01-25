import java.util.*; 

public class RandomArray {
	// Exercise 2.8 from Weiss data structures book
	public int[] permute1(int n){
		int[] array = new int[n]; 
		for(int i=0; i<n; i++){
			Random random = new Random(); 
//			int rand = random.nextInt(n+1); 
			int rand = (int)(Math.random() * n) ;
			System.out.println(rand); 
			boolean inList = false; 
			
			for(int j=0; j<i; j++){
				inList = (array[j]==rand) || inList; 
			}
			
			if(inList){
				rand = (int)(Math.random() * n) ;
			}

			System.out.println("inserted"); 
			array[i] = rand; 
		}
		
		return array; 
	}
	
//	public int[] permute2(int n){
//		return 0; 
//	}
//	
	public int[] permute3(int n){
		int[] array = new int[n];
		for(int i=0;i<n;i++){
			array[i]=i+1;
		}
		for(int i = 1; i < n; i++ ){
            swapReferences( array[ i ], array[ randInt( 0, i ) ] );
		}
	}
	
	public static void main(String[] args){
		RandomArray ra = new RandomArray(); 
		
		int[] test1 = ra.permute1(5); 
		for(int permutation : test1){
			System.out.println(permutation); 
		}
//		System.out.println(test1); 
	}

}
