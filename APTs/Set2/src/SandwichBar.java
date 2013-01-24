import java.util.*;

public class SandwichBar {
	public int whichOrder(String[] available, String[] orders){
		
        for(String order : orders){
        	Set<String> AVAILABLE = new HashSet<String>(Arrays.asList(available)); 
        	String[] ingredients = order.split("\\s+");
        	boolean canMake = true; 
        	for(String ingredient : ingredients){
        		canMake = AVAILABLE.contains(ingredient) && canMake; 
        	}
        	if (canMake){
        		return Arrays.asList(orders).indexOf(order); 
        	}		
        }
        return -1; 
     }
	
//	public static void main(String[] args){
//		SandwichBar sb = new SandwichBar(); 
//		String[] avail1 = {"ham", "cheese", "mustard"};
//		String[] order1 = {"ham cheese"};
//		int test1 = sb.whichOrder(avail1, order1); 
//		System.out.println(test1); 
//		
//		String[] avail2 = {"cheese", "mustard", "lettuce"};
//		String[] order2 = {"cheese ham", "cheese mustard lettuce", "ketcup", "beer"};
//		System.out.println(sb.whichOrder(avail2, order2)); 
//	}
}
