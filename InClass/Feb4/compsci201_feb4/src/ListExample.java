import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class ListExample {
	
	public void addValues(List<String> list, String file) throws FileNotFoundException{
		Scanner s = new Scanner(new FileInputStream(file));
		while(s.hasNext()){
			list.add(s.next());
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		List<String> array = new ArrayList<String>();
		List<String> linked = new LinkedList<String>();
		
		ListExample example = new ListExample();
		double start = System.currentTimeMillis();
        example.addValues(array, "lowerwords.txt");
        double end = System.currentTimeMillis();
        System.out.printf("total time = %f\n", (end - start) / 1000);
        
		start = System.currentTimeMillis();
        example.addValues(linked, "lowerwords.txt");
        end = System.currentTimeMillis();
        System.out.printf("total time = %f\n", (end - start) / 1000);
        
        example.stackExample();
        System.out.println();
        example.queueExample(); 
		
	}
	
	public void stackExample(){
		Stack<String> q = new Stack<String>();
		q.push("comp ");
		q.push("sci ");
		q.push("is ");
		q.push("great!");
		while(!q.isEmpty())
			System.out.print(q.pop());
	}
	
	public void queueExample(){
		Queue<String> q = new LinkedList<String>();
		q.add("comp ");
		q.add("sci ");
		q.add("is ");
		q.add("great!");
		while(!q.isEmpty())
			System.out.print(q.remove());
	}
	
}
