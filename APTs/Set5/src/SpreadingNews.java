import java.util.HashMap;

public class SpreadingNews {
	public int minTime(int[] supervisors) {
   	 
		int minutes=0;
		int CONSTANT = 192;
		HashMap<String, String> relationships = new HashMap<String, String>();
		String called = Character.toString((char) CONSTANT);
		String hasBeenCalled = called; 
		
		for(int i=1; i<supervisors.length; i++){
//			int bossInt = supervisors[i];
			String bString = Character.toString((char) (supervisors[i]+CONSTANT));
//			System.out.println(bString);
			String eString = Character.toString((char) (i+CONSTANT));
//			System.out.println(eString);
			// if it's already in there, get current string, append this one, put back
			if(relationships.containsKey(bString)){
				String current = relationships.get(bString);
				current = current + eString;
				relationships.put(bString, current);
			}
			// if not already in there, put this one in
			else{
				relationships.put(bString, eString);
			}
		}
//		System.out.println(relationships.size());
//		System.out.println(relationships.get("A"));
		
		//whileloop
		while(called.length()<supervisors.length & minutes<supervisors.length){
//			System.out.printf("minutes %d %n", minutes);
			
			//iterate over relationships.keySet
			for(String key: relationships.keySet()){
//				System.out.println("key "+key);
				
				if(hasBeenCalled.contains(key)){ //if that person has been called
					String values = relationships.get(key);

//					System.out.println("values "+values);
					//find which of their mapped values has the most values mapped to it
					int max = -1;
					int howManySubords;
					String hasMost = "";
					for(int j=0; j<values.length(); j++){
						String employee = values.substring(j,j+1);
						if(relationships.containsKey(employee)){
							String subords = relationships.get(employee);
							howManySubords = subords.length();
						}
						else{ howManySubords=0; }
						if(howManySubords>max){ 
							max = howManySubords;
							hasMost = employee; 
						}
					}
//					System.out.println("has most: "+hasMost);
					
					// remove hasMost from values
					if(!(hasMost.equals(""))){
						values = values.replaceAll(hasMost, "");
						relationships.put(key, values);
					}
					
//					System.out.println("values updated "+values);
					
					
					// add hasMost to called
					called = called + hasMost; 
//					System.out.println("called " + called);
					
					// if size of values is zero, remove this key from relationships
//					if(values.length()==0){
//						relationships.remove(key);
//					}
					
				}
			}
			minutes++;
			hasBeenCalled = called;
		}

		return minutes; 
    }
	

     
     public static void main(String[] args){
    	 SpreadingNews sn = new SpreadingNews();
    	 int[] test1 = {-1, 0, 0};
    	 int result1 = sn.minTime(test1);
    	 System.out.println(result1);
    	 
    	 int[] test2 = {-1, 0, 0, 2, 2};
    	 int result2 = sn.minTime(test2);
    	 System.out.println(result2);
     }

}
