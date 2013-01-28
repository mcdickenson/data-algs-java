import java.util.ArrayList;
import java.util.Collections;

public class ThreeInts implements Comparable<ThreeInts>{

	private int myOne, myTwo, myThree;

	public ThreeInts(int one, int two, int three)
	{
		myOne = one;
		myTwo = two;
		myThree = three;
	}
	
	public static void main(String[] args) {
		ArrayList<ThreeInts> list = new ArrayList<ThreeInts>();
		
		System.out.println("Test 1: .equals()");
		ThreeInts a = new ThreeInts(5,5,5);
		ThreeInts b = new ThreeInts(5,5,5);
		
		if(a.equals(b))
			System.out.println("equal");
		else
			System.out.println("not equal");
		
		System.out.println("Test 2: .compareTo()");
		list.add(new ThreeInts(0,0,0));
		list.add(new ThreeInts(0,0,100));
		list.add(new ThreeInts(-5,0,7));
		list.add(new ThreeInts(85,-89,2));
		Collections.sort(list);
		System.out.println(list);
	}

	public String toString()
	{
		return "<" + myOne + "," + myTwo + "," + myThree + ">";
	}
	
	@Override
	public boolean equals(Object obj){
		if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        ThreeInts temp = (ThreeInts) obj; //cast object to ThreeInts type
        //your code goes here
        
        return false;
	}
	
	public int compareTo(ThreeInts arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
