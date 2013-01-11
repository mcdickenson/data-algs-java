
public class ArrayPractice {

	public static void main(String[] args) {
		ArrayPractice practice = new ArrayPractice();
		
		double[] dArray = practice.makeArray();
		for(int i=0; i < dArray.length; i++){
			System.out.println(i + " " + dArray[i]);
		}
	}
	
	public double[] makeArray(){
		double[] doubleArray = new double[50];
		
		for(int i=0; i < doubleArray.length; i++){
			doubleArray[i] = 20.5;
		}
		
		return doubleArray; 
	}

}
