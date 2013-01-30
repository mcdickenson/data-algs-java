import java.util.ArrayList;
import java.util.Collections;


public class ComplexNumber implements Comparable<ComplexNumber>{
	private double myR, myI; 
	
	public ComplexNumber(double R, double I)
	{
		myR = R;
		myI = I;
	}
	
	public static void main(String[] args){
		ComplexNumber cn1 = new ComplexNumber(2, 1); 
		ComplexNumber cn2 = new ComplexNumber(2, 1); 
		
		if (cn1.equals(cn2))
			System.out.println("equal");
		else 
			System.out.println("not equal"); 
		
		ArrayList<ComplexNumber> list = new ArrayList<ComplexNumber>();
		System.out.println("Test 2: .compareTo()");
		list.add(new ComplexNumber(0,0));
		list.add(new ComplexNumber(0,100));
		list.add(new ComplexNumber(-5,7));
		list.add(new ComplexNumber(85,-89));
		Collections.sort(list);
		System.out.println(list);
	}
	
	public String toString()
	{
		return "<" + myR + "," + myI + ">";
	}
	
	@Override
	public boolean equals(Object obj){
		if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        ComplexNumber temp = (ComplexNumber) obj; //cast object to ThreeInts type
        
        //your code goes here
        if( (this.myR == temp.myR) &&
        		(this.myI == temp.myI) )
        	return true; 
        else     
        	return false;
	}
	
	public int compareTo(ComplexNumber arg0) {
		double magnitude1 = Math.sqrt(Math.pow(this.myR, 2) + Math.pow(this.myI, 2) ); 
		double magnitude2 = Math.sqrt(Math.pow(arg0.myR, 2) + Math.pow(arg0.myI, 2) ); 
		
		double sum = magnitude1 - magnitude2;
		if(sum==0)
			return 0;
		else if(sum>0)
			return 1;
		else
			return -1; 
	}
}
