
public class BigOhPractice {
	public int numberOne(int n){ // O(1)
		return n;
	}

	public int numberTwo(int n){ // O(N)
		int answer = 1;
		for(int i = 0; i < n; i++)
			answer *= n;
		return answer;
	}

	public int numberThree(int n){ // O(N^2)
		int answer = 1;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				answer *= n;
		return answer;
	}

	public int numberFour(int n){ // O(N^2)
		int answer = 1;
		for(int i = 0; i < n; i++)
			answer *= n;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				answer *= n;
		return answer;
	}

	public int numberFive(int n){ // O(log N)
		int answer = 1;
		for(int i = 1; i <= n; i=i*2)
			answer *= n;
		return answer;
	}

	public int numberSix(int n){ // O(N log N)
		int answer = 1;
		for(int i = 1; i <= n; i=i*2)
			for(int j = 0; j < n; j++)
				answer *= n;
		return answer;
	}

	public int numberSeven(int n){ // O(N)
		if(numberTwo(n) > 10000){
			return n;
		}
		else
			return numberFive(n);
	}


	public static void main(String[] args){

		BigOhPractice big = new BigOhPractice();
		for(int i = 0; i < 10000000; i+=5000){
			double start = System.currentTimeMillis();
			big.numberOne(i);
			double end = System.currentTimeMillis();
			System.out.printf("%d: total time = %f\n", i, (end - start) / 1000);
		}
		
		int n = 1000000;
		double start = System.currentTimeMillis();
		big.numberOne(n);
		double end = System.currentTimeMillis();
		System.out.printf("%d: total time = %f\n", n, (end - start) / 1000);
		start = System.currentTimeMillis();
		big.numberTwo(n);
		end = System.currentTimeMillis();
		System.out.printf("%d: total time = %f\n", n, (end - start) / 1000);
		n = 1000; 
		start = System.currentTimeMillis();
		big.numberThree(n);
		end = System.currentTimeMillis();
		System.out.printf("%d: total time = %f\n", n, (end - start) / 1000);
		start = System.currentTimeMillis();
		big.numberFour(n);
		end = System.currentTimeMillis();
		System.out.printf("%d: total time = %f\n", n, (end - start) / 1000);
		n = 1000000;
		start = System.currentTimeMillis();
		big.numberFive(n);
		end = System.currentTimeMillis();
		System.out.printf("%d: total time = %f\n", n, (end - start) / 1000);
		start = System.currentTimeMillis();
		big.numberSix(n);
		end = System.currentTimeMillis();
		System.out.printf("%d: total time = %f\n", n, (end - start) / 1000);
		start = System.currentTimeMillis();
		big.numberSeven(n);
		end = System.currentTimeMillis();
		System.out.printf("%d: total time = %f\n", n, (end - start) / 1000);
		
	}

}
