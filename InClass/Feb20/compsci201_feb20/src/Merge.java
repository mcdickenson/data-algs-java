import java.util.Arrays;

//import java.util.Arrays;


public class Merge {
	private int[] left;
	private int[] right; 
	private int[] helper;
	private int size; 
	private int middle; 
	
	public Merge(){
		
	}
	
	public int[] sort(int[] array){
		// recursive method
		
		size = array.length; 
		System.out.println(size); 
		if(size<=1){ ; }
		else{
			middle = size/2; 
			left = Arrays.copyOfRange(array, 0, middle);
			right = Arrays.copyOfRange(array, middle+1, size);
			left = sort(left);
			right = sort(right);
			helper = new int[size]; 
			array = merge(helper, left, right);
		}
		return array; 
	}
	
	private int[] merge(int[] array, int[] a1, int[] a2){
		//merge two already sorted lists
		while(array.length < a1.length + a2.length){
			int left = a1[0];
			int right = a2[0];
			if(left <= right){ array[array.length] = left; }
			else{ array[array.length]= right; } 
		}
		return array; 
	}
	
}
