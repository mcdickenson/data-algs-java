import java.util.Random;


public class MergeMain {

	public static void main(String[] args){
		int[] array = new int[20];
		
		Random rand = new Random();
		for(int i=0; i < array.length; i++){
			array[i] = rand.nextInt(100);
		}
		System.out.print("Original: ");
		for(int i: array){
			System.out.print(i + " ");
		}
		System.out.println();
		Merge m = new Merge();
		m.sort(array);
		System.out.print("Sorted  : ");
		for(int i: array){
			System.out.print(i + " ");
		}
		System.out.println();
		
		
	}
}