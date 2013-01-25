
public class BigOh {
	// Exercise 2.7 from Weiss data structures book
	
		public int method271(int n){
			int sum = 0;
	        for(int i = 0; i < n; i++ )
	        	sum++;
	        return sum; 
		}
		
		public int method272(int n){
			int sum = 0;
	        for(int i = 0; i < n; i++ )
	            for(int j = 0; j < n; j++ )
	                sum++;
	        return sum; 
		}
		
		public int method273(int n){
			int sum = 0;
	        for(int i = 0; i < n; i++ )
	            for(int j = 0; j < n * n; j++ )
	                sum++;
	        return sum; 
		}
		
		public int method274(int n){
			int sum = 0;
		    for(int i = 0; i < n; i++ )
		        for(int j = 0; j < i; j++ )
		            sum++;
		    return sum; 
		}
		
		public int method275(int n){
			int sum=0;
			for(int i = 0; i < n; i++ )
				for(int j = 0; j < i * i; j++ )
					for(int k = 0; k < j; k++ )
						sum++;
			return sum; 
		}
		
		public int method276(int n){
			int sum=0;
			for(int i = 1; i < n; i++ )
			                   for(int j = 1; j < i * i; j++ )
			                      if( j % i == 0 )
			                          for(int k = 0; k < j; k++ )
			                              sum++;
			return sum; 
			
		}
		
		public static void main(String[] args){
			BigOh bo = new BigOh(); 
			
			// part one - big oh 
			int test1 = 1000;
			System.out.println(bo.method271(test1)); //O(N)
			System.out.println(bo.method272(test1)); //O(N^2)
			System.out.println(bo.method273(test1)); //O(N^3)
			System.out.println(bo.method274(test1)); //O(N log N)
			System.out.println(bo.method275(test1)); 
			System.out.println(bo.method276(test1)); //O(N^3 log N)
			
			// part two - actual running times 
			int n=1000;
			System.out.println();
			System.out.println(n);
			double start = System.currentTimeMillis();
			bo.method271(n);
			double end = System.currentTimeMillis();
			System.out.printf("%d: total time = %f\n", n, (end - start) / 1000);
			start = System.currentTimeMillis();
			bo.method272(n);
			end = System.currentTimeMillis();
			System.out.printf("%d: total time = %f\n", n, (end - start) / 1000);
			start = System.currentTimeMillis();
			bo.method273(n);
			end = System.currentTimeMillis();
			System.out.printf("%d: total time = %f\n", n, (end - start) / 1000);
			start = System.currentTimeMillis();
			bo.method274(n);
			end = System.currentTimeMillis();
			System.out.printf("%d: total time = %f\n", n, (end - start) / 1000);
			start = System.currentTimeMillis();
			bo.method275(n);
			end = System.currentTimeMillis();
			System.out.printf("%d: total time = %f\n", n, (end - start) / 1000);
			start = System.currentTimeMillis();
			bo.method276(n);
			end = System.currentTimeMillis();
			System.out.printf("%d: total time = %f\n", n, (end - start) / 1000);
			
//			n=10000;
//			System.out.println();
//			System.out.println(n);
//			start = System.currentTimeMillis();
//			bo.method271(n);
//			end = System.currentTimeMillis();
//			System.out.printf("%d: total time = %f\n", n, (end - start) / 1000);
//			start = System.currentTimeMillis();
//			bo.method272(n);
//			end = System.currentTimeMillis();
//			System.out.printf("%d: total time = %f\n", n, (end - start) / 1000);
//			start = System.currentTimeMillis();
//			bo.method273(n);
//			end = System.currentTimeMillis();
//			System.out.printf("%d: total time = %f\n", n, (end - start) / 1000);
//			start = System.currentTimeMillis();
//			bo.method274(n);
//			end = System.currentTimeMillis();
//			System.out.printf("%d: total time = %f\n", n, (end - start) / 1000);
//			start = System.currentTimeMillis();
//			bo.method275(n);
//			end = System.currentTimeMillis();
//			System.out.printf("%d: total time = %f\n", n, (end - start) / 1000);
//			start = System.currentTimeMillis();
//			bo.method276(n);
//			end = System.currentTimeMillis();
//			System.out.printf("%d: total time = %f\n", n, (end - start) / 1000);
			
		}

}
