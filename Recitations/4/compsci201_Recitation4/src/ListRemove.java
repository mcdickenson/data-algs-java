import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class ListRemove {
	ArrayList<String> list = new ArrayList<String>();

	public void fillList(String file) throws FileNotFoundException{
		list.clear();
		Scanner s = new Scanner(new FileInputStream(file));
		while(s.hasNext()){
			list.add(s.next());
		}
	}

	public void print(){
		System.out.println("The List");
		for (String s: list)
			System.out.print(s + " ");
		System.out.print("\n");
	}
	
	public void removeFromList(){
		for(int i=0; i<list.size(); i++){
			if(list.get(i).startsWith("a"))
				list.remove(i);
		}
	}
	
	public void removeFromListGood(){
		ArrayList<String> temp = new ArrayList<String>();
		for(int i=0; i<list.size(); i++){
			if(!(list.get(i).startsWith("a")))
				temp.add(list.get(i));
		}
		list = temp; 
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		ListRemove remove = new ListRemove();
		
		remove.fillList("fruit2.txt");
		remove.print();
		remove.removeFromListGood();
		remove.print();
	}
}
